package code;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CuratorWatcherTest {
    private CuratorFramework client;

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
    public void testNodeCache() throws Exception {
//        NodeCache nodeCache = new NodeCache(client, "/Test", false);
//        nodeCache.getListenable().addListener(new NodeCacheListener() {
//            @Override
//            public void nodeChanged() throws Exception {
//                System.out.println("啦啦啦");
//                ChildData currentData = nodeCache.getCurrentData();
//            }
//        });

//        CuratorCacheBuilder builder = CuratorCache.builder(client, "/");
//        CuratorCache build = builder.build();
//        build.listenable().addListener(new CuratorCacheListener() {
//            @Override
//            public void event(Type type, ChildData childData, ChildData childData1) {
//                System.out.println(type);
//                System.out.println(childData);
////                System.out.println(childData1);
//                System.out.println(Arrays.toString(childData.getData()));
////                System.out.println(Arrays.toString(childData1.getData()));
//                System.out.println("啦啦啦");
//            }
//        });
//        build.start();

        CuratorCache build = CuratorCache.builder(client, "/").build();
        build.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData childData, ChildData childData1) {
                System.out.println(type);
                System.out.println(childData);
                System.out.println(Arrays.toString(childData.getData()));
            }
        });

        build.start();

//        nodeCache.start();
        while (true) {}
    }


    @After
    public void close() {
        if (client != null) {
            client.close();
        }
    }
}
