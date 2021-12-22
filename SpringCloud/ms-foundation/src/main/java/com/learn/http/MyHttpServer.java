package com.learn.http;

import com.sun.net.httpserver.*;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;

public class MyHttpServer {
    public static void main(String[] args) throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, KeyManagementException, IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, UnrecoverableKeyException, KeyManagementException {
        //http实现
        HttpServer http = HttpServer.create(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8989),0);
        http.createContext("/web", new MyHttpServer().new MyHandler());
        http.setExecutor(null);
        http.start();
        //https实现
        HttpsServer https = HttpsServer.create(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8787), 0);
        https.createContext("/web", new MyHttpServer().new MyHandler());
        https.setExecutor(null);
        KeyStore ks = KeyStore.getInstance("JKS");   //建立证书库
        ks.load(new FileInputStream("D:\\serverkeys"), "test12".toCharArray());  //载入证书
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");  //建立一个密钥管理工厂
        kmf.init(ks, "test12".toCharArray());  //初始工厂
        SSLContext sslContext = SSLContext.getInstance("SSLv3");  //建立证书实体
        sslContext.init(kmf.getKeyManagers(), null, null);   //初始化证书
        HttpsConfigurator httpsConfigurator = new HttpsConfigurator(sslContext);
        https.setHttpsConfigurator(httpsConfigurator);
        https.start();
    }
    class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String protocol = exchange.getProtocol();
            String method    = exchange.getRequestMethod();
            String url = exchange.getRequestURI().toString();
            String query     = exchange.getRequestURI().getQuery();

            InputStream request  =exchange.getRequestBody();
            OutputStream response = exchange.getResponseBody();

            InetSocketAddress address = exchange.getRemoteAddress();
            String host = address.getHostName();
            String port = String.valueOf(address.getPort());

            StringBuilder sb = new StringBuilder();
            sb.append("<meta http-equiv='charset' content='text/html;charset=gb2312'>");
            sb.append("<p>协议：%s</p>");
            sb.append("<p>提交方式：%s</p>");
            sb.append("<p>URL：%s</p>");
            sb.append("<p>参数列表：%s</p>");
            sb.append("<p>主机名：：%s</p>");
            sb.append("<p>端口号：%s</p>");
            String content = String.format(sb.toString(), protocol,method,url,query,host,port);
            System.out.println(content);

            byte[] contentBin = content.getBytes();
            exchange.sendResponseHeaders(200, contentBin.length);
            response.write(contentBin);
            response.flush();
            response.close();
        }
    }
}
