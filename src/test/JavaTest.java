import com.answer.RunApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

/**
 * Created by liuf on 2022/11/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplication.class)
public class JavaTest {

    @Test
    public void test() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.peek(System.out::print).filter(x -> x > 5);
        stream.forEach(a -> {
            System.out.println(a);
        });
    }
}
