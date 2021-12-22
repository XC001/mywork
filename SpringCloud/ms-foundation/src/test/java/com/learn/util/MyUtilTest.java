package com.learn.util;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MyUtilTest {

    MyUtil myUtil;
    CloseableHttpAsyncClient closeableHttpAsyncClient;
    CloseableHttpClient closeableHttpClient;
    RestTemplate restTemplate;
    @Before
    public void setup() throws UnrecoverableKeyException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        myUtil = new MyUtil();
        Map configuration = new HashMap();
        configuration.put("keystore", "D:\\serverkeys");
        configuration.put("password", "test12");
        closeableHttpAsyncClient = myUtil.createAsyncHttpClient(configuration);
        closeableHttpClient = myUtil.createSyncHttpClient(configuration);
        restTemplate = myUtil.createRestTemplate(configuration);
    }

    @Test
    public void httpAyncClient() throws UnsupportedEncodingException, InterruptedException {
        closeableHttpAsyncClient.start();
        HttpPost httpUriRequest = new HttpPost("https://localhost:8082/user/1");
        httpUriRequest.setHeader("Content-type","application/json");
        httpUriRequest.setEntity(new StringEntity("1"));
        closeableHttpAsyncClient.execute(httpUriRequest, new FutureCallback<HttpResponse>(){

            @SneakyThrows
            @Override
            public void completed(HttpResponse response) {
                int statusCode = response.getStatusLine().getStatusCode();
                String reasonPhrase = response.getStatusLine().getReasonPhrase();
                if(statusCode==200){
                    log.info("success, message={}", IOUtils.toString(response.getEntity().getContent()));
                }
            }

            @Override
            public void failed(Exception ex) {
                log.error("failed, ",ex.getLocalizedMessage());
            }

            @Override
            public void cancelled() {
                log.warn("cancelled");
            }
        });
        Thread.sleep(400000);
    }

    @Test
    public void httpSyncClient() throws IOException, InterruptedException {
        HttpPost httpUriRequest = new HttpPost("https://localhost:8082/user/1");
        httpUriRequest.setHeader("Content-type","application/json");
        httpUriRequest.setEntity(new StringEntity("1"));
        CloseableHttpResponse response = closeableHttpClient.execute(httpUriRequest);
        if(response.getStatusLine().getStatusCode()==200) {
            System.out.println(IOUtils.toString(response.getEntity().getContent()));
        }
    }

    @Test
    public void restTemplate(){
        Map headers = new HashMap();
        headers.put("Content-type", "application/json");
        HttpEntity httpEntity = new HttpEntity(headers);
        String response = restTemplate.postForObject("http://localhost:8082/user/1", httpEntity, String.class);
        System.out.println(response);
    }
}
