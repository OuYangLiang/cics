package com.oyl.cics.impl.common.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public enum HttpUtil {
    inst;

    final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(10000)  // 连接超时时间，单位毫秒
            .setSocketTimeout(10000)   // 请求超时时间，单位毫秒
            .build();
    final CloseableHttpClient httpclient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();

        public static void main(String[] args) {

        String json = "{\n" +
                "    \"page\":1,\n" +
                "    \"pageSize\":10,\n" +
                "    \"employeeNamePrefix\":\"喻\"\n" +
                "}";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3Mjg0ODQyNjUsImlhdCI6MTcyODM5Nzg2NSwidXNlcm5hbWUiOiJveWwifQ.SyU3JVN6yUdN6j5bfXK543TnGksEi45F9WMeia3oRPU");

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println(inst.request("http://localhost:8080/employee/search", json, headers));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String request(String url, String content, Map<String, String> headers) throws IOException {
        HttpPost request = new HttpPost(url);
        if (null != headers) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.setHeader(entry.getKey(), entry.getValue());
            }
        }

        request.setEntity(new StringEntity(content, "UTF8"));

        try (CloseableHttpResponse response = httpclient.execute(request)) {

            if (response.getStatusLine().getStatusCode() != 200) {
                StringBuilder error = new StringBuilder();
                error.append("Error: Received HTTP status code:");
                error.append(response.getStatusLine().getStatusCode());

                if (null != response.getEntity()) {
                    error.append("\n");
                    error.append(EntityUtils.toString(response.getEntity(), "UTF8"));
                }

                throw new RuntimeException(error.toString());
            }

            return null == response.getEntity() ? "" : EntityUtils.toString(response.getEntity(), "UTF8");
        }
    }
}
