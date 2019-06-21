package www.j1stiot.cn.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;
import www.j1stiot.cn.concurrency.annoations.NotThreadSafe;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

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
