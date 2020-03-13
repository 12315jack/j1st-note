package www.j1stiot.cn.concurrency.example.immutable;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.annoations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

@ThreadSafe
public class ImmutableExample2 {

    // logger
    private static final Logger log= LoggerFactory.getLogger(ImmutableExample2.class);

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
