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
        // 获取连接
        Connection connection = connectionFactory.newConnection();
        // 获取管道
        Channel channel = connection.createChannel();
        /*
            声明队列，第一个变量为队列名
            不需要声明交换机，因为工作模式，SimpleQueue使用默认交换机
         */
        channel.queueDeclare("simple_queue", true, false, false, null);
        // 请求数据
        String message = "Hello";
        // 通过管道发布请求到队列，第一个变量为交换机名称，留空，因为工作模式，SimpleQueue使用默认交换机
        channel.basicPublish("", "simple_queue", null, message.getBytes());
        channel.close();
        connection.close();
    }
}
