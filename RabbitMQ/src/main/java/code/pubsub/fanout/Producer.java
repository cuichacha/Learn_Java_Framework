package code.pubsub.fanout;

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
        // 声明交换机，参数为交换机名称，与交换机类型
        channel.exchangeDeclare("fanout_exchange", BuiltinExchangeType.FANOUT);
        // 声明队列
        channel.queueDeclare("fanout_queue_1", true, false, false, null);
        // 声明队列
        channel.queueDeclare("fanout_queue_2", true, false, false, null);
        // 将队列与交换机绑定，队列在前，交换机在后，不需要routing key参数，留空，因为fanout类型，默认分发请求到所有绑定的队列
        channel.queueBind("fanout_queue_1", "fanout_exchange", "");
        // 将队列与交换机绑定，队列在前，交换机在后，不需要routing key参数，留空，因为fanout类型，默认分发请求到所有绑定的队列
        channel.queueBind("fanout_queue_2", "fanout_exchange", "");
        for (int i = 0; i < 10; i++) {
            // 请求数据
            String message = "Hello" + i;
            // 管道发布数据，第一个参数为交换机名称，第二个routing key留空
            channel.basicPublish("fanout_exchange", "", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
