package code.workqueue;

import code.utils.RabbitMQUtil;
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
        /*
            声明队列，第一个变量为队列名
            不需要声明交换机，因为工作模式，WorkQueue使用默认交换机
         */
        channel.queueDeclare("work_queue", true, false, false, null);
        for (int i = 0; i < 10; i++) {
            // 请求数据
            String message = "Hello" + i;
            // 通过管道发布请求到队列，第一个变量为交换机名称，留空，因为工作模式，WorkQueue使用默认交换机
            channel.basicPublish("", "work_queue", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
