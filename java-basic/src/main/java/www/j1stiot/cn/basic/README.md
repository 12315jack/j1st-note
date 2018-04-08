

java 基础：

1.常见名词解释？
    OOA: Object-Oriented Analysis-面向对象分析
    OOD: Object-Oriented Design-面向对象设计
    OOP: Object-Oriented Programming-面向对象编程
    OOT: Object-Oriented Testing-面向对象测试
    ORM: Object-Relational Mapping-对象关系映射
    SOA: Service-Oriented Architecture-面向服务的体系结构

2.Java支持的数据类型有哪些？
     1.基本数据类型：
        byte(1) 		short(2)		 int(4) 		long(8)
        float(4) 		double(8) 	 	 char(2) 		Boolean(true/false)

     2.自动装箱与拆箱/常用方法：
        Java提供8中基本类型的封装类型，分别为Byte、Short、Integer、Long、Float、Double、Character、Boolean
        数据级别由低到高为：（byte-short-char）-int-long-float-double

     3.类型转换问题：
        转换原则：
            低级到高级的自动类型转换；
            高级到低级的强制类型转换（会导致溢出或丢失精度）；
            byte，short，char之间不会互相转换，并且三者在计算时首先转换为int类型
                    小数常量默认为double类型， 整数常量默认为int类型；
                    char字符型与整形和浮点型做运算时，先获得字符型的ASCII码值然后进行计算


3.Java中方法重载、方法覆盖？
    1.方法重载：
	    方法重载发生在同一个类里面，是指有两个或者两个以上的方法，它们的方法名相同但是参数类型和个数不同，返回值可相同也可不同的方法，重载是一个类中多态性的表现

    2.方法覆盖：
        方法覆盖发生在子类与父类之间，是指子类定义的方法与父类具有相同的返回值类型、方法名和参数列表，这时父类方法将被覆盖；
        使用super可引用父类方法；
        子类方法的访问修饰符不能小于父类；（父类引用子类对象）；
        子类的异常要小于父类的异常；
        final private 修饰的方法不能被子类覆盖；
        方法覆盖与实现接口的方法原理很相似，覆盖父类方法，要求比较严格

4.Java基类是什么？有哪些方法？
	基类：Object
	常用方法：
            toString();	//将对象转换成string
            equals(); 	//Object比较引用地址值，子类如String类比较对象值
            native hashcode(); // hashcode值，每个对象值唯一
                    native clone();
            native notify()
            notifyAll()
            wait();
		…

5. String,StringBuffer, StringBuilder 的区别是什么？
    1.String是字符串常量，StringBuffer和StringBuilder都是字符串变量。后两者的字符内容可变，而前者创建后内容不可变。
    2.String不可变是因为在JDK中String类被声明为一个final类。
    3.StringBuffer是线程安全的，而StringBuilder是非线程安全的。
