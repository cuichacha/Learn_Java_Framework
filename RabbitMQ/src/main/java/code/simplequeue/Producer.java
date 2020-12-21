package code.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.134.2");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test1");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("password");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("simple_queue", true, false, false, null);
        String message = "Hello";
        channel.basicPublish("", "simple_queue", null, message.getBytes());
        channel.close();
        connection.close();
    }
}
