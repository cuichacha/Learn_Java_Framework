package code;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuratorTest {

    private CuratorFramework client;

//    @Test
    @Before
    public void testConnect() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10 );
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.134.2:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy)
                .namespace("Test")
                .build();

        client.start();
    }

    @Test
    public void testCreate1() throws Exception {
        String path = client.create().forPath("/test1");
        System.out.println(path);
    }

    @Test
    public void testCreate2() throws Exception {
        String path = client.create().forPath("/test1", "hello".getBytes());
        System.out.println(path);
    }

    @Test
    public void testCreate3() throws Exception {
        String path = client.create().forPath("/test2");
        System.out.println(path);
    }

    @Test
    public void testCreate4() throws Exception {
        String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/test3");
        System.out.println(path);
    }

    @Test
    public void testCreate5() throws Exception {
        String path = client.create().creatingParentsIfNeeded().forPath("/test4/lalala/dududu");
        System.out.println(path);
    }

    @Test
    public void testGet1() throws Exception {
        byte[] bytes = client.getData().forPath("/test1");
        System.out.println(new String(bytes));
    }

    @Test
    public void testGet2() throws Exception {
        List<String> strings = client.getChildren().forPath("/");
        System.out.println(strings);
    }



    @After
    public void close() {
        if (client != null) {
            client.close();
        }
    }
}
