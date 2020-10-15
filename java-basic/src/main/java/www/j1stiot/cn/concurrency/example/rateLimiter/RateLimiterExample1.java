package www.j1stiot.cn.concurrency.example.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class RateLimiterExample1 {


    /**
     * 应用限流：
     *      令牌桶算法实现 google goava RateLimter
     *      限制每秒请求次数
     */
    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) throws Exception {

        for (int index = 0; index < 100; index++) {
            if (rateLimiter.tryAcquire()) {
                handle(index);
            }

        }
    }

    private static void handle(int i) {
        System.out.print("{}"+i);
    }
}
