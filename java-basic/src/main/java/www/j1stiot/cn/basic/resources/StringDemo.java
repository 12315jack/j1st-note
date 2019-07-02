package www.j1stiot.cn.basic.resources;

/**
 * 对比 String StringBuffer StringBuilder
 * <p>
 * 分析源码
 */
public class StringDemo {

    /**
     * String 对象：
     * 1.类本身被 final 修饰，所以本身不可被继承也即意味着方法不可被覆盖重写
     * 2.其内部实现是个 final char[] 一旦对象生成后意味着 char[] 大小固定备课再被更改，所以 String 对象不可被更改
     * 3.String 对象是一个字符串常量
     */


    // for test
    public static void main(String[] args) {

        String str1 = "hello";
        StringBuffer stringBuffer = new StringBuffer("hello");
        StringBuilder stringBuilder = new StringBuilder("hello");

        // 对象地址值比较
        String str2 = new String("hello");

        System.out.println("地址值 str1 和 str2 是否相等：" + (str1 == str2));//false
        System.out.println("对象内容 str1 和 str2 是否相等：" + str1.equals(str2));//true

        System.out.println("hashcode str1 值：" + str1.hashCode());
        System.out.println("hashcode str2 值：" + str2.hashCode());

    }


}
