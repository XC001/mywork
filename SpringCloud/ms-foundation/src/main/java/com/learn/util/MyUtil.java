package com.learn.util;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.ssl.PrivateKeyStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Map;

public class MyUtil {
    private static final String PROXY_HOST_CONFIG_KEY = "proxy.host";
    private static final String PROXY_PORT_CONFIG_KEY = "proxy.port";
    private static final String PROXY_SCHEME_CONFIG_KEY = "proxy.scheme";
    private static final String PROXY_URI_QUERY_OVERRIDE = "proxy.uriQueryOverride";
    private static final String CONFIG_KEY_MAX_CONNECTIONS = "maxConnections";
    private static final int DEFAULT_MAX_CONNECTIONS = 200;
    private static final String CONFIG_KEY_MAX_PER_ROUTE_CONNECTIONS = "maxConnectionsPerRoute";
    private static final int DEFAULT_MAX_PER_ROUTE_CONNECTIONS = 20;

    public CloseableHttpAsyncClient createAsyncHttpClient(Map<String, Object> configuration) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        SSLContextBuilder sslContextBuilder = SSLContexts.custom();
        if(configuration.get("keystore")!=null) {
            KeyStore ks = KeyStore.getInstance("JKS");
            final char[] password = ((String) configuration.get("password")).toCharArray();
            try (InputStream is = getResourceAsStream((String)configuration.get("keystore"))) {
                ks.load(is, password);
            }
            if (configuration.get("alias") != null) {
                PrivateKeyStrategy privateKeyStrategy = (map, socket) -> (String) configuration.get("alias");
                sslContextBuilder.loadKeyMaterial(ks, password, privateKeyStrategy);
            } else {
                sslContextBuilder.loadKeyMaterial(ks, password);
            }
        }
        sslContextBuilder.loadTrustMaterial(null, (chain, authType) -> true);

        SSLContext sslContext = sslContextBuilder.build();
        HttpAsyncClientBuilder builder = HttpAsyncClients.custom();

        builder.setRedirectStrategy(new LaxRedirectStrategy());

        String[] supportedCiphers = configuration.get("supportedCipher")!=null
                ? ((String)configuration.get("supportedCipher")).split(",") : null;

        String[] supportedProtocols = configuration.get("supportedProtocol")!=null
                ? ((String)configuration.get("supportedProtocol")).split(",") : null;

        SSLIOSessionStrategy sslioSessionStrategy = new SSLIOSessionStrategy(sslContext, supportedProtocols,
                supportedCiphers,new NoopHostnameVerifier());
        RegistryBuilder<SchemeIOSessionStrategy> rb = RegistryBuilder.create();
        rb.register("https", sslioSessionStrategy).register("http", NoopIOSessionStrategy.INSTANCE);
        PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(
                new DefaultConnectingIOReactor(IOReactorConfig.DEFAULT), rb.build()
        );

        cm.setMaxTotal(configuration.get(CONFIG_KEY_MAX_CONNECTIONS)==null ? DEFAULT_MAX_CONNECTIONS: Integer.parseInt((String)configuration.get(CONFIG_KEY_MAX_CONNECTIONS)));
        cm.setDefaultMaxPerRoute(configuration.get(CONFIG_KEY_MAX_PER_ROUTE_CONNECTIONS)==null ? DEFAULT_MAX_PER_ROUTE_CONNECTIONS:Integer.parseInt((String)configuration.get(CONFIG_KEY_MAX_PER_ROUTE_CONNECTIONS)));
        return builder.setConnectionManager(cm).build();
    }

    public CloseableHttpClient createSyncHttpClient(Map<String, Object> configuration) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        SSLContextBuilder sslContextBuilder = SSLContexts.custom();
        if(configuration.get("keystore")!=null) {
            KeyStore ks = KeyStore.getInstance("JKS");
            final char[] password = ((String) configuration.get("password")).toCharArray();
            try (InputStream is = getResourceAsStream((String)configuration.get("keystore"))) {
                ks.load(is, password);
            }
            if (configuration.get("alias") != null) {
                PrivateKeyStrategy privateKeyStrategy = (map, socket) -> (String) configuration.get("alias");
                sslContextBuilder.loadKeyMaterial(ks, password, privateKeyStrategy);
            } else {
                sslContextBuilder.loadKeyMaterial(ks, password);
            }
        }
        sslContextBuilder.loadTrustMaterial(null, (chain, authType) -> true);

        SSLContext sslContext = sslContextBuilder.build();
        HttpClientBuilder builder = HttpClients.custom();

        builder.setRedirectStrategy(new LaxRedirectStrategy());

        String[] supportedCiphers = configuration.get("supportedCipher")!=null
                ? ((String)configuration.get("supportedCipher")).split(",") : null;

        String[] supportedProtocols = configuration.get("supportedProtocol")!=null
                ? ((String)configuration.get("supportedProtocol")).split(",") : null;

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, supportedProtocols,
                supportedCiphers,new NoopHostnameVerifier());
        RegistryBuilder<ConnectionSocketFactory> rb = RegistryBuilder.create();
        rb.register("https", sslConnectionSocketFactory).register("http", PlainConnectionSocketFactory.INSTANCE);
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(rb.build());

        cm.setMaxTotal(configuration.get(CONFIG_KEY_MAX_CONNECTIONS)==null ? DEFAULT_MAX_CONNECTIONS: Integer.parseInt((String)configuration.get(CONFIG_KEY_MAX_CONNECTIONS)));
        cm.setDefaultMaxPerRoute(configuration.get(CONFIG_KEY_MAX_PER_ROUTE_CONNECTIONS)==null ? DEFAULT_MAX_PER_ROUTE_CONNECTIONS:Integer.parseInt((String)configuration.get(CONFIG_KEY_MAX_PER_ROUTE_CONNECTIONS)));
        return builder.setConnectionManager(cm).build();
    }

    public RestTemplate createRestTemplate(Map<String, Object> configuratiton) throws UnrecoverableKeyException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        HttpClient httpClient = createSyncHttpClient(configuratiton);
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }

    public static InputStream getResourceAsStream(String resource) throws FileNotFoundException {
        if(resource.startsWith("classpath:")){
            String path = resource.substring("classpath:".length());
            return MyUtil.class.getClassLoader().getResourceAsStream(path);
        }else{
            return new FileInputStream(ResourceUtils.getFile(resource));
        }
    }
}
