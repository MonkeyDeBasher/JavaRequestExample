package org.example;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.example.DTO.BookDTO;

public class MyJavaRequest extends AbstractJavaSamplerClient {
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        BookDTO book = new BookDTO();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setDescription("Description");
        book.setCategory("Category");
        book.setPrice(0);
        book.setUrlImg("image.jpg");
        Gson gson = new Gson();
        String jsonBody = gson.toJson(book);
        SampleResult result = new SampleResult();
        result.sampleStart();
            String response = sendPostRequest("http://localhost:8080/book", jsonBody);
        result.sampleEnd();
        result.setSuccessful(true);
        result.setResponseMessage("Request successful");
        result.setResponseData(response, null);
        return result;
    }

    private String sendPostRequest(String url, String body) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity responseEntity = response.getEntity();
                return EntityUtils.toString(responseEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during POST request";
        }
    }
}
