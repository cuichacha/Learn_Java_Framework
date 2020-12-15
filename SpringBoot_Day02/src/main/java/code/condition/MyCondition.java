package code.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        try {
//            Class<?> aClass = Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            return false;
//        }
//        return true;

        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        String[] values = (String[]) map.get("value");
        for (String value : values) {
            try {
                Class<?> aClass = Class.forName(value);
            } catch (ClassNotFoundException e) {
                return false;
            }
        }
        return true;
    }
}
