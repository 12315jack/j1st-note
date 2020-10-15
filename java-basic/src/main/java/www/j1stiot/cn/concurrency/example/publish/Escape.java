package www.j1stiot.cn.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.annoations.NotRecommend;
import www.j1stiot.cn.concurrency.annoations.NotThreadSafe;
import www.j1stiot.cn.concurrency.example.concurrent.CopyOnWriteArraySetExample;

@NotThreadSafe
@NotRecommend
public class Escape {

    //Logger
    private static final Logger log = LoggerFactory.getLogger(Escape.class);

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    public static void main(String[] args) {
        new Escape();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }
}
