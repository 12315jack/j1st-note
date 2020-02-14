package www.j1stiot.cn.pdf.phantomjs;

public class Pdfdemo3 {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //String result = Html2pdfUtil.parseHtml2Pdf("https://www.echartsjs.com/zh/feature.html");
        String result = Html2pdfUtil.parseHtml2Pdf("https://my.oschina.net/u/3789577/blog/3157949");
        long all = System.currentTimeMillis()- start;
        System.out.println("pdf生成地址:"+result+",用时:"+all/1000+"秒");
    }

}

