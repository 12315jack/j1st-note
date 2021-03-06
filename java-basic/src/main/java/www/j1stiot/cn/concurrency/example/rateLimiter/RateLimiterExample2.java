package www.j1stiot.cn.concurrency.example.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.example.publish.UnsafePublish;

import java.util.concurrent.TimeUnit;

public class RateLimiterExample2 {

    //Logger
    private static final Logger log = LoggerFactory.getLogger(RateLimiterExample2.class);

    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) throws Exception {

        for (int index = 0; index < 100; index++) {
            rateLimiter.acquire();
            handle(index);
        }
    }

    private static void handle(int i) {
        log.info("{}", i);
    }
}
