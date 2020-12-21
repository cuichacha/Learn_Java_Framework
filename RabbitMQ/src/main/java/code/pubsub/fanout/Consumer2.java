package code.pubsub.fanout;

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
        // 声明交换机，参数为交换机名称，与交换机类型
        channel.exchangeDeclare("fanout_exchange", BuiltinExchangeType.FANOUT);
        // 声明队列
        channel.queueDeclare("fanout_queue_2", true, false, false, null);
        // 将队列与交换机绑定，队列在前，交换机在后，不需要routing key参数，留空，因为fanout类型，默认分发请求到所有绑定的队列
        channel.queueBind("fanout_queue_2", "fanout_exchange", "");
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(envelope.getDeliveryTag());
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
            }
        };
        // 消费数据，只需要队列名称
        channel.basicConsume("fanout_queue_2", true, defaultConsumer);
    }
}
