package code.simplequeue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
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
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

            }
        };
        channel.basicConsume("simple_queue", true, defaultConsumer);
    }
}
