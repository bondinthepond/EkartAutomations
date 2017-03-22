package Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by aditya.mullela on 13/02/17.
 */
public class MessageClient {

    public void makeCall(String restBusMessageId, String payload) {

        try {

            // pre prod - 10.85.42.201/b2b/warehouses/mum_bndi/inventory/reserve
            //para - http://10.85.39.94:8080/b2b/warehouses/blr_wfld/inventory/reserve
            String url = "http://10.85.42.201/b2b/warehouses/mum_bndi/inventory/reserve";

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);


            post.setHeader("X-EKART-CLIENT", "ff");
            post.setHeader("X_RESTBUS_MESSAGE_ID", restBusMessageId);
            post.setHeader("Content-Type", "application/json");

            System.out.println("\nPayload being used" + payload);
            StringEntity se = new StringEntity(payload);
            post.setEntity(se);

            HttpResponse response = httpClient.execute(post);
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + post.getEntity());
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            OutputProcessor processor = new OutputProcessor();
            processor.processOutput(result.toString());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
