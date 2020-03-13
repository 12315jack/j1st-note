package www.j1stiot.cn.concurrency.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.annoations.NotThreadSafe;
import www.j1stiot.cn.concurrency.example.hystrix.HystrixController2;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    // logger
    private static final Logger logger = LoggerFactory.getLogger(ImmutableExample1.class);

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        map = Maps.newHashMap();
        map.put(1, 3);
        logger.info("{}", map.get(1));
    }

    private void test(final int a) {
//        a = 1;
    }
}
