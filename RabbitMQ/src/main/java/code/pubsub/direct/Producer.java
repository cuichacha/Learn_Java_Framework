package code.pubsub.direct;

import code.utils.RabbitMQUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitMQUtil.getConnection();
        // 获取管道
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare("direct_exchange", BuiltinExchangeType.DIRECT);
        // 声明队列
        channel.queueDeclare("direct_queue_insert", true, false, false, null);
        // 声明队列
        channel.queueDeclare("direct_queue_update", true, false, false, null);
        // 将队列与交换机绑定，队列在前，交换机在后，第三个参数为routing key，因为direct类型，需要routing key才知道与哪个队列绑定
        channel.queueBind("direct_queue_insert", "direct_exchange", "insert");
        // 将队列与交换机绑定，队列在前，交换机在后，第三个参数为routing key，因为direct类型，需要routing key才知道与哪个队列绑定
        channel.queueBind("direct_queue_update", "direct_exchange", "update");
        // 请求数据
        String message1 = "Routing Key 为 insert";
        // 请求数据
        String message2 = "Routing Key 为 update";
        // 发布数据，需要交换机名称，与routing key参数，数据从管道-->交换机，交换机需要routing key才知道，把数据发到哪个队列
        channel.basicPublish("direct_exchange", "insert", null, message1.getBytes());
        // 发布数据，需要交换机名称，与routing key参数，数据从管道-->交换机，交换机需要routing key才知道，把数据发到哪个队列
        channel.basicPublish("direct_exchange", "update", null, message2.getBytes());
        channel.close();
        connection.close();
    }
}
