package www.j1stiot.cn.jvm.resources;

/**
 * 虚拟机中的常量池问题
 */
public class ConstantPool {


    public static void main(String[] args) {

//        String s = new String("1");
//        String ss=s.intern();
//        //false
//        System.out.println("s==ss:"+(s==ss));
//        String s2 = "1";
//        //false
//        System.out.println("s==s2:"+(s == s2));
//        //true
//        System.out.println("ss==s2:"+(ss == s2));
//        //比较的是对象的值 true
//        System.out.println("s.value==ss.value:"+(s.equals(s2)));
//
//
//        String s3 = new String("1") + new String("1");
//        //将"11"加入到字符串常量池
//        s3.intern();
//        String s4 = "11";
//        System.out.println("s3==s4:"+(s3 == s4));
//
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println("str1.常量池中引用地址==str:"+(str1.intern() == str1));
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println("str2.常量池中引用地址==str2:"+(str2.intern() == str2));

//        String s1 = new String("hello");
//        String intern1 = s1.intern();
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//
//        String s3 = new String("hello") + new String("hello");
//        String intern3 = s3.intern();
//        String s4 = "hellohello";
//        System.out.println(s3 == s4);
//        String a = new String("ab");
//        String b = new String("ab");
//        String c = "ab";
//        String d = "a" + "b";
//        String e = "b";
//        String f = "a" + e;
//
//        System.out.println(a == b);
//        System.out.println(b.intern() == a);
//        System.out.println(b.intern() == c);
//        System.out.println(b.intern() == d);
//        System.out.println(b.intern() == f);
//        System.out.println(b.intern() == a.intern());

//        String str1="abc";
//        String str2=new String("abc");
//        System.out.println(str1==str2);
//        System.out.println(str1==str2.intern());

        String str1 = "aaa";
        //解析：str1指向方法区；

        String str2 = "bbb";
        //解析： str2 指向方法区

        //String str3 = "aaabbb";
        //解析：str3指向方法区

//        String str4 = str1 + str2;
//        //解析：此行代码上边已经说过原理。str4指向堆区
//
//        String str5 = "aaa" + "bbb";
//        //解析：该行代码重点说明一下，jvm对其有优化处理，也就是在编译阶段就会将这两个字符串常量进行拼接，也就是"aaabbb";所以他是在方法区中的；’
//
//        System.out.println(str3 == str4); // false
//        //解析：很明显 为false， 一个指向堆 一个指向方法区
//
//        System.out.println(str3 == str4.intern()); // true
//
//        String str4=new String("aaa")+new String("bbb");
//        String str5=str4.intern();
//        String str3="aaabbb";
//        System.out.println(str3 == str4); //false
//        System.out.println(str3 == str4.intern()); //true
//        System.out.println(str3 == str5); //true
//        System.out.println(str4 == str5); //false

        String s1 = new String("helloworld");
        String s2 = "helloworld";
        String intern1 = s1.intern();
        System.out.println(s1 == s2);//false

        String s3 = new String("helloyeah");
        String intern3 = s3.intern();
        String s4 = "helloyeah";
        System.out.println(s3 == s4);//false

        String s5 = new String("hello") + new String("yeah");
        String intern5 = s5.intern();
        String s6 = "helloyeah";
        System.out.println(s5 == s6);//false

        String s7 = new String("hello") + new String("yeah0");
        String intern7 = s7.intern();
        String s8 = "helloyeah0";
        System.out.println(s7 == s8);//true
    }

}
