package www.j1stiot.cn.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test {

    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        //1、生成一个PDF
        //Step 1—Create a Document.
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream("t1-PDF.pdf"));
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        document.add(new Paragraph("Hello World"));
        //Step 5—Close the Document.
        document.close();

        //2、页面大小,页面背景色,页边空白,Title,Author,Subject,Keywords
        //页面大小
        Rectangle rect = new Rectangle(PageSize.B5.rotate());
        //页面背景色
        rect.setBackgroundColor(BaseColor.ORANGE);

        Document doc = new Document(rect);
        FileOutputStream out= new FileOutputStream("t2-PDF.pdf");
        PdfWriter writer = PdfWriter.getInstance(doc, out);

        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);

        //文档属性
        doc.addTitle("Title@sample");
        doc.addAuthor("Author@rensanning");
        doc.addSubject("Subject@iText sample");
        doc.addKeywords("Keywords@iText");
        doc.addCreator("Creator@iText");
        //页边空白
        doc.setMargins(10, 20, 30, 40);
        doc.open();
        doc.add(new Paragraph("Hello World"));
        doc.close();

    }


}
