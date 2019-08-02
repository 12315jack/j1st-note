package www.j1stiot.cn.io.stream.resources;

import java.io.File;

/**
 * java File 文件类的操作
 *
 */
public class FileClassDemo {


    /**
     * java.io.File用于表示文件目录
     *
     * File 类只用于表示文件（目录）的信息（名称/大小等），不能用于文件内容的访问
     */

    //File类基本API操作
    public static void main(String[] args){

        File file=new File("ddr4");
        if(!file.exists()){
            file.mkdir();
        }else{
            file.delete();
        }

    }

}
