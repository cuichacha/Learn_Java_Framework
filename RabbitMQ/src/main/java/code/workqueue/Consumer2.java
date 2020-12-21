package code.workqueue;

import code.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitMQUtil.getConnection();
        // 获取管道
        Channel channel = connection.createChannel();
        /*
            声明队列，第一个变量为队列名
            不需要声明交换机，因为工作模式，WorkQueue使用默认交换机
         */
        channel.queueDeclare("work_queue", true, false, false, null);
        // 明确管道每次发送的请求数量
        channel.basicQos(1);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
                System.out.println(envelope.getDeliveryTag());
                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 消费请求，只需要队列名称，因为消费者与队列直接联系
        channel.basicConsume("work_queue", true, defaultConsumer);
    }
}
