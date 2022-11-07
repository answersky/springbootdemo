import com.alibaba.fastjson.JSON;
import com.answer.RunApplication;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/9/27 15:56
 * @className: RedisTest
 * @packageName: PACKAGE_NAME
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void add() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("first_redis_key", "hello word jj");
    }

    @Test
    public void hash() {
        HashOperations valueOperations = redisTemplate.opsForHash();
        valueOperations.put("first_redis_hash_key", "key1", "value1");
    }

    @Test
    public void list() {
        ListOperations valueOperations = redisTemplate.opsForList();
        valueOperations.leftPush("first_redis_list_key", JSON.toJSONString(Lists.newArrayList(1, 2, 3)));
    }

    @Test
    public void get() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String value = (String) valueOperations.get("first_redis_key");
        System.out.println(value);
    }

    @Test
    public void del() {
        redisTemplate.delete("first_redis_key");
    }

}
