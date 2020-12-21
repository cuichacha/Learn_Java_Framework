package code.pubsub.direct;

import code.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerUpdate {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitMQUtil.getConnection();
        // 获取管道
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare("direct_exchange", BuiltinExchangeType.DIRECT);
        // 声明队列
        channel.queueDeclare("direct_queue_update", true, false, false, null);
        // 将队列与交换机绑定，队列在前，交换机在后，第三个参数为routing key，因为direct类型，需要routing key才知道与哪个队列绑定
        channel.queueBind("direct_queue_update", "direct_exchange", "update");
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(envelope.getDeliveryTag());
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
            }
        };
        // 消费数据，只需要队列名称
        channel.basicConsume("direct_queue_update", true, defaultConsumer);
    }
}
