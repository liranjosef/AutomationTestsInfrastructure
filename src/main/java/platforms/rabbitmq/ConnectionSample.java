package platforms.rabbitmq;

import base.google.BaseGoogle;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import utilities.rabbitmq.CreateChannel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionSample extends BaseGoogle {

    public static void connectToRabbitMQ(){

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("");
        factory.setPassword("");
        factory.setVirtualHost("/");
        factory.setHost("");
        factory.setPort(1);

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            AMQP.Queue.DeclareOk response = channel.queueDeclarePassive("x");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    public static void publishMessageToQueue(){
        environment = "test";
        channel = CreateChannel.connectAndGetRabbitChannel("","","/","",1);

        for (int i=0; i<600; i++){
            String message = "x";
            try {
                channel.basicPublish("","queueName",null,message.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            channel.close();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }


}
