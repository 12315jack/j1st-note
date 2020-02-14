package www.j1stiot.cn.pdf.itext;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;


/**
 * 生成带表格和图片的demo
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
//        //1、创建流对象
//        PdfWriter pdfWriter=new PdfWriter(new File("你的pdf位置\\2.pdf"));
//
//        //2、创建文档对象
//        PdfDocument pdfDocument=new PdfDocument(pdfWriter);
//
//        //3、创建内容文档对象
//
//        Document document=new Document(pdfDocument);
//
//
//        PdfFont font= PdfFontFactory.createFont("STSongStd-Light","UniGB-UCS2-H",true);
//
//        Table table=new Table(new float[]{20,20,20,20});
//        table.setWidth(UnitValue.createPercentValue(100));
//        //创建表头
//        Cell head=new Cell(1,4); //一行四列
//        head.add(new Paragraph("JOB TITLE")).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.ORANGE);
//
//        Cell cell1=new Cell();
//        cell1.add("one");
//        Cell cell2=new Cell();
//        cell2.add("two");
//        Cell cell3=new Cell();
//        cell3.add("three");
//        Cell cell4=new Cell();
//        cell4.add("four");
//
//        table.addCell(cell1);
//        table.addCell(cell2);
//        table.addCell(cell3);
//        table.addCell(cell4);
//
//
//        for (int i = 0; i < 16; i++) {
//            Cell cell=new Cell();
//            cell.add(new Paragraph(i+" "));
//            table.addCell(cell);
//        }
//
//        Cell teshucell=new Cell(2,1);
//        teshucell.setBackgroundColor(Color.GREEN);
//        table.addCell(teshucell);
//
//        for (int i = 0; i < 6; i++) {
//            Cell cell=new Cell();
//            cell.add(new Paragraph(i+" ").setBackgroundColor(Color.PINK));
//            table.addCell(cell);
//        }
//
//        //加入表格
//        table.addHeaderCell(head);
//        //加入图片
//        Image image=new Image(ImageDataFactory.create("你的图片位置\\2.jpg"));
//        document.add(image);
//
//
//        document.add(table);
//
//        document.close();
//
//        System.out.println("ok!!!");


    }

}
