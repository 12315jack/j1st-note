package www.j1stiot.cn.basic.resources;

/**
 * for循环demo
 */
public class ForDemo {

    public static void changeStr(String str) {
        str = "welcome";
    }

    static boolean foo(char c) {

        System.out.println("获取的字符串为：" + c);
        return true;
    }

    public static void main(String[] args) {

        String str = "1234";
        changeStr(str);
        System.out.println("输出的字符串为：" + str);

        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }


    }

}
