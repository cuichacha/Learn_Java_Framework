import code.HelloApplication;
import code.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@org.springframework.boot.test.context.SpringBootTest(classes = HelloApplication.class)
public class SpringBootTest {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        System.out.println("啦啦啦");
    }

    @Test
    public void test2() {
        System.out.println(userService.findAll());
    }

    @Test
    public void test3() {
        redisTemplate.boundValueOps("name").set("123");
    }

    @Test
    public void test4() {
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void test5() {
        redisTemplate.delete("name");
    }
}
