package www.j1stiot.cn.basic.resources;

public class BasicDataTypeDemo {

    public static void main(String[] args){

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false

        //short s1 = 1;
        //s1 = s1 + 1;
        //short s1 = 1;
        //s1 += 1;
        Integer f11 =new Integer(100);
        Integer f12 =new Integer(100);
        System.out.println(f11 == f12);//false

        byte aa=127;
        aa+=5;
        System.out.println("byte+5="+aa);

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false

        int i = 0;
        for (i++; i++ < 10; i++) ;
        System.out.println(++i);

    }

}
