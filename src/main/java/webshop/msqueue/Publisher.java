package webshop.msqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class Publisher {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, InterruptedException {
        
    	ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://guest:guest@localhost");
        factory.setConnectionTimeout(300000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("my-queue", true, false, false, null);

        int count = 0;
        JsonObjectBuilder job = Json.createObjectBuilder();

        while (count < 5000) {
			job.add("paymentid", 1);
			job.add("betalingid", 1);
			job.add("status", "afgehandeld");
			job.add("bedrag", 21.00);
			
			String jobstring = job.build().toString();

            channel.basicPublish("", "my-queue", null, jobstring.getBytes());
            count++;
            System.out.println("Published message: " + jobstring);

            Thread.sleep(5000);
        }
    }
}
