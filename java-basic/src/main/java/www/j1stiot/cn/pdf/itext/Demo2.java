package www.j1stiot.cn.pdf.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.*;
import java.util.Base64;

@Component
public class Demo2 {


    /**
     * 导出PDF start
     */
    @RequestMapping("exportPDF")
    public void exportPDF(HttpServletRequest request, HttpServletResponse response, String base64Info) throws Exception {

        String urlAdress =request.getSession().getServletContext().getRealPath("/");   //获取项目web根目录  如要保存在项目里exportFilePath=urlAdress
        String newFileName;
        String num = String.valueOf(System.currentTimeMillis());
        newFileName = "xx" + num + ".pdf";
        String newPngName = newFileName.replaceFirst(".pdf", ".png");
        String exportFilePath = "d:/export";
        base64Info = base64Info.replaceAll(" ", "+");
        String[] arr = base64Info.split("base64,");
        byte[] buffer;
        try {
            buffer = Base64.getDecoder().decode(arr[1]);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        OutputStream output = null;
        try {
            output = new FileOutputStream(new File(exportFilePath+newPngName));//生成png文件
            output.write(buffer);
            output.flush();
            output.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Pdf(exportFilePath+newPngName,exportFilePath+newFileName);
        File f = new File(exportFilePath+newPngName);
        if(f.exists()){
            f.delete();
        }

        File file = new File("d:/export"+num+".pdf");
        Desktop.getDesktop().open(file);                                                                         //文件自动打开预览

           /*   如要下载到本地 执行下面代码。（提交方式不能用ajax，否则不报错不弹出下载框。）

　　　　String urlss=urlAdress+num+".pdf";  //下载文件地址
　　　　String path=urlss;
　　　　File file = new File(path);// path是根据日志路径和文件名拼接出来的
　　　　String filename = file.getName();// 获取日志文件名称
　　　　InputStream fis = new BufferedInputStream(new FileInputStream(path));
　　　　byte[] buffers = new byte[fis.available()];
　　　　fis.read(buffers);
　　　　fis.close();
　　　　response.reset();
　　　　// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
　　　　response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
　　　　response.addHeader("Content-Length", "" + file.length());
　　　　OutputStream os = new BufferedOutputStream(response.getOutputStream());
　　　　response.setContentType("application/octet-stream");
　　　　os.write(buffers);// 输出文件
　　　　os.flush();
　　　　os.close();

　　*/
        response.sendRedirect(request.getContextPath()+"/platform/report/alertReport/list.htm");

    }

    //通过png文件来生成pdf文件
    public File Pdf(String imagePath, String mOutputPdfFileName) throws Exception {
        //建立com.lowagie.text.Document对象的实例。(A4纸,左右上下边距)
        Document document = new Document(PageSize.A4, 10, 10, 20, 20);
        //add Chinese font 需要 下载远东字体包iTextAsian.jar
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 10, Font.NORMAL);
        //Font fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.GREEN);
        try {
            //建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
            PdfWriter.getInstance(document, new FileOutputStream(mOutputPdfFileName));
            //打开文档。
            document.addTitle("标题");
            document.open();
            document.newPage();
            Image png = Image.getInstance(imagePath);
            float heigth = png.getHeight();
            float width = png.getWidth();
            int percent = this.getPercent2(heigth, width);
            png.setAlignment(Image.MIDDLE);
            png.setAlignment(Image.TEXTWRAP);
            png.scalePercent(percent + 3);
            png.setAlignment(Image.MIDDLE);   //图片居中显示
            document.add(new Paragraph("zzzzzzzzzzzz"));
            document.add(new Paragraph("Hello World"));
            document.add(png);
            document.add(new Paragraph("zzzzzzzzzzzz"));
            document.add(new Paragraph("Hello World"));
            //添加表格 start
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(90);     //表格宽度比  默认为80
            Paragraph p=new Paragraph("表头",FontChinese);
            PdfPCell cell = new PdfPCell(p);   //表头
            cell.setMinimumHeight(23f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setColspan(6);              //合并6列
            cell.setBackgroundColor(new BaseColor(235, 235, 235));
            table.addCell(cell);

            PdfPCell cell2 = new PdfPCell(new Paragraph("1列",FontChinese));  //中文要放在Paragraph()里面才会显示出来
            PdfPCell cell3 = new PdfPCell(new Paragraph("2列",FontChinese));
            PdfPCell cell4 = new PdfPCell(new Paragraph("3列",FontChinese));
            PdfPCell cell5 = new PdfPCell(new Paragraph("4列",FontChinese));
            PdfPCell cell6 = new PdfPCell(new Paragraph("5列",FontChinese));
            PdfPCell cell7 = new PdfPCell(new Paragraph("6列",FontChinese));
            cell2.setBackgroundColor(new BaseColor(0xebebeb));
            cell3.setBackgroundColor(new BaseColor(235, 235, 235));
            cell4.setBackgroundColor(new BaseColor(235, 235, 235));
            cell5.setBackgroundColor(new BaseColor(235, 235, 235));
            cell6.setBackgroundColor(new BaseColor(235, 235, 235));
            cell7.setBackgroundColor(new BaseColor(235, 235, 235));
            table.addCell(cell2);table.addCell(cell3);
            table.addCell(cell4);table.addCell(cell5);
            table.addCell(cell6);table.addCell(cell7);
            //增加每行列数
            for(int i=0;i<5;i++){
                table.addCell("1.1我");
                table.addCell("1.1");
                table.addCell("2.1");
                table.addCell("1.2");
                table.addCell("2.2");
                table.addCell("cell test1");
            }
            //cell.setRowspan(2);  //合并行
            //cell.setColspan(2);    //合并列
            document.add(table);
            //添加表格 end
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File mOutputPdfFile = new File(mOutputPdfFileName);
        if (!mOutputPdfFile.exists()) {
            mOutputPdfFile.deleteOnExit();
            return null;
        }
        return mOutputPdfFile;
    }
    //统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的
    private int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }
    /**
     * 导出PDF end
     */

}
