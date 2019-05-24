

java IO流：


1.下面哪个流类属于面向字符的输入流(  )

    A、BufferedWriter
    B、FileInputStream
    C、ObjectInputStream
    D、InputStreamReader

>>>>答案：D
解释：
    Java的IO操作中有面向字节(Byte)和面向字符(Character)两种方式。 
面向字节的操作为以8位为单位对二进制的数据进行操作，对数据不进行转换，这些类都是InputStream和OutputStream的子类。 
面向字符的操作为以字符为单位对数据进行操作，在读的时候将二进制数据转为字符，在写的时候将字符转为二进制数据，
这些类都是Reader和Writer的子类。


