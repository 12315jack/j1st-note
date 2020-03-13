package www.j1stiot.cn.io.stream.resources;

import java.io.UnsupportedEncodingException;

/**
 * 文件编码问题
 */
public class EncodeDemo {

    public static void main(String[] args) throws Exception {
        String s="慕课ABC";

        //默认编码 UTF-8 系统默认编码
        byte[] byte1=s.getBytes();
        for(byte b:byte1){
            //把字节转换int以十六进制方式显示
            System.out.print(Integer.toHexString(b & 0xff) +"");
        }
        System.out.println();

        //GBK编码
        byte[] byte2=s.getBytes("GBK");
        for(byte b:byte2){
            //把字节转换int以十六进制方式显示
            System.out.print(Integer.toHexString(b & 0xff) +" ");
        }

        //java双字节编码 utf-16be
        byte[] byte3=s.getBytes("utf-16be");
        for(byte b:byte3){
            //把字节转换int以十六进制方式显示
            System.out.print(Integer.toHexString(b & 0xff) +" ");
        }

    }

}
