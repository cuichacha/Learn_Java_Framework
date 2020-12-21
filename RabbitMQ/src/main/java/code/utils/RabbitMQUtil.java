package code.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtil {
    private RabbitMQUtil() {
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.134.2");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test1");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("password");
        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
