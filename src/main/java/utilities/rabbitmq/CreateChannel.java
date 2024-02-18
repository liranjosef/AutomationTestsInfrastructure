package utilities.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CreateChannel {

    public static Channel connectAndGetRabbitChannel(String rabbitUserName, String rabbitPassword, String rabbitVirtualHost, String rabbitHost,
                                                     int rabbitPortNumber){

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(rabbitUserName);
        factory.setPassword(rabbitPassword);
        factory.setVirtualHost(rabbitVirtualHost);
        factory.setHost(rabbitHost);
        factory.setPort(rabbitPortNumber);

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            return channel;
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
