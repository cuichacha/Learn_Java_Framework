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
        // 获取连接
        Connection connection = connectionFactory.newConnection();
        // 获取管道
        Channel channel = connection.createChannel();
        /*
            声明队列，第一个变量为队列名
            不需要声明交换机，因为工作模式，SimpleQueue使用默认交换机
         */
        channel.queueDeclare("simple_queue", true, false, false, null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

            }
        };
        // 消费请求，只需要队列名称，因为消费者与队列直接联系
        channel.basicConsume("simple_queue", true, defaultConsumer);
    }
}
