

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
	    方法重载发生在同一个类里面，是指有两个或者两个以上的方法，它们的方法名相同但是参数类型和个数不同，返回值可相同也可不同的方法，重载
	    是一个类中多态性的表现

    2.方法覆盖：
        方法覆盖发生在子类与父类之间，是指子类定义的方法与父类具有相同的返回值类型、方法名和参数列表，这时父类方法将被覆盖；
        使用super可引用父类方法；
        子类方法的访问修饰符不能小于父类；（父类引用子类对象）；
        子类的异常要小于父类的异常；
        final private 修饰的方法不能被子类覆盖；
        方法覆盖与实现接口的方法原理很相似，覆盖父类方法，要求比较严格

4.Java基类是什么？有哪些方法？

	1.基类：Object
	2.常用方法：
        toString();	        //将对象转换成string
        equals(); 	        //Object比较引用地址值，子类如String类比较对象值
        native hashcode();  // hashcode值，每个对象值唯一
        native clone();
        native notify()
        notifyAll()
        wait();
		…

5. String,StringBuffer, StringBuilder 的区别是什么？

    1.String是字符串常量，StringBuffer和StringBuilder都是字符串变量。后两者的字符内容可变，而前者创建后内容不可变。
    2.String不可变是因为在JDK中String类被声明为一个final类。
    3.StringBuffer是线程安全的，而StringBuilder是非线程安全的。

6.请说明 equals() 和 hashCode() 的关系、何时会使用这两个方法？如何正确的Override这两个方法？

    1.equals值相等，则hashcode值一定相等
    2.hashcode值相等，equals值不一定相等
        如果只覆盖了equals而没有覆盖hashCode, 则两个不同的instance a和b虽然equals结果(业务逻辑上)相等,但却会有不同的hashcode,这样
        hashmap里面会同时存在a和b,而实际上我们需要hashmap里面只能保存其中一个,因为从业务逻辑方向看它们是相等的
    拓展知识：
    	关于覆盖和重载的区别，要求？
    解题要点：
        1.重载:
        方法重载发生在同一个类里面，是指有两个或者两个以上的方法，它们的方法名相同但是参数类型和个数不同，返回值可相同也可不同的方法，重载是一个类中多态性的表现
        2.覆盖：
        方法覆盖发生在子类与父类之间，是指子类定义的方法与父类具有相同的返回值类型、方法名和参数列表，这时父类方法将被覆盖；
        使用super可引用父类方法；
        子类方法的访问修饰符不能小于父类；（父类引用子类对象）；
        子类的异常要小于父类的异常；
        final private 修饰的方法不能被子类覆盖；
        方法覆盖与实现接口的方法原理很相似，覆盖父类方法，要求比较严格



7.请说明 final 关键字在不同地方的含义，并且说明下面这段代码是否正确。

    class Person {
        private String name;

        public Person (String s) {
            this.name = s;
        }

        public void setName(String s) {
            this.name = s;
        }
    }

    private void test (final Person p) {
        p.setName("test");
    }

    解答要点：
    1.代码有错误
    2.错误原因：test应该放到类Person体里面
    3.Final关键字的使用：
        1.final修饰的类不可被继承
        2.final 对于常量来说，只能被赋值一次，意味着值不能改变，例如 final int i=100。这个i的值永远都是100。
        3.final对于变量来说，只是标识这个引用值不可被改变；
    例如:本例子的final Person person,那么这个person引用一定是不能被改变的，但是应用对象的属性值是可以改变的
    形象的比喻：一个女子定义了一个final的老公，这个老公的职业和收入都是允许改变的，只是这个女人不会换老公而已。
        4.Sting就是一个被final修饰的类，我们只能用，不用继承
        5.注意final和finally的区别，final是修饰类或者变量，finally是在异常处理中使用，如：try{ }catch（）{}finally{}中，
          finally的作用一般用于必须处理的事情，如关闭连接


8.请说明什么是 checked exception

    解答要点：
    Java主要包含两大异常：
        checked异常和unchecked异常。
        checked和unchecked异常之间的区别是：
            1.Checked异常必须被显式地捕获或者传递，而unchecked异常则可以不必捕获或抛出。
            2. Checked异常继承java.lang.Exception类，Unchecked异常继承自java.lang.RuntimeException类。
            3. Unchecked异常一般在运行期间才能被检查出来，Checked在编译时就能确定，一般运行期异常不需要处理，Checked异常需要自己处理
            4.捕获异常的方式有：Try{}catch(Exception e){}finally{}，throws Ecxeption
            5.常见的Unchecked 异常：NullPointException, IllegalArgumentException/ClassCastException/OutOfMemoryException/NumberFormatException等等


9.请简要说明你所熟知的设计模式?

    Java设计模式：
        1.JAVA 有23中设计模式
        2.设计模式基本原则：
        开闭原则/接口隔离/里氏代换原则/合成复用…等
        常见：
        创建型：工厂模式/抽象工厂模式/单例模式/建造者模式/原型模式
        结构型：适配器模式/装饰器模式/代理模式/外观模式/桥接模式/组合模式/等
        行为型：策略模式/模板模式/观察着模式/迭代模式/等等。。。
        还有并发型和线程池模式。

