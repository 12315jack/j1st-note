package www.j1stiot.cn.io.stream.resources;

import java.io.RandomAccessFile;

/**
 * java提供的对文件操作的类
 *  可以随机访问文件，读和写
 */
public class FileRandomAccessDemo {

    //RandomAccessFile
    public static void main(String[] args){

        //RandomAccessFile可随机访问文件
        try  {

            RandomAccessFile randomAccessFile = new RandomAccessFile("test", "rw");


        }catch (Exception e){

        }

    }
}
