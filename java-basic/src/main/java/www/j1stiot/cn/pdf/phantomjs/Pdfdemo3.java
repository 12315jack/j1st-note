package www.j1stiot.cn.pdf.phantomjs;

public class Pdfdemo3 {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //String result = Html2pdfUtil.parseHtml2Pdf("https://www.echartsjs.com/zh/feature.html");
        String result = Html2pdfUtil.parseHtml2Pdf("http://www.360doc.com/content/18/0904/19/25944647_783893127.shtml");
        long all = System.currentTimeMillis()- start;
        System.out.println("pdf生成地址:"+result+",用时:"+all/1000+"秒");
    }

}

