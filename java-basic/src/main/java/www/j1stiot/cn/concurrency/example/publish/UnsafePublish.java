package www.j1stiot.cn.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.annoations.NotThreadSafe;

import java.util.Arrays;

@NotThreadSafe
public class UnsafePublish {

    //Logger
    private static final Logger log = LoggerFactory.getLogger(UnsafePublish.class);

    private String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }

    public String[] getStates() {
        return states;
    }
}
