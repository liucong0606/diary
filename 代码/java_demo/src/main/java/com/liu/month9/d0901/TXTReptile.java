package com.liu.month9.d0901;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author liucong
 * @ClassName: TXTReptile
 * @Description: 笔趣阁爬虫
 * @date: 2020/9/1 15:52
 */
public class TXTReptile {
    private String bookUrl = "C:\\学习\\重生之都市升仙.txt";
    private String homeUrl = "http://www.yuetutu.com";
    private static String firstUrl = "http://www.yuetutu.com/cbook_1720/1.html";
    private static Map<Integer, String> urls = new TreeMap<>();

    static {
        urls.put(0, firstUrl);
    }

    /**
     * @Description: 翻页下载
     * @auther: liucong
     * @date: 2020/9/1 17:07
     * @return:
     */
    private void download() throws IOException {
        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            Document doc = Jsoup.connect(url).get();
            String title = getTitle(doc);

            String content = getContent(doc);
            saveContent(title, content);

            System.out.println("正在下载：" + title);

            String nextUrl = getNextUrl(doc);
            if (!StringUtils.isEmpty(nextUrl))
                urls.put(i + 1, nextUrl);
            else
                System.out.println("下载完毕...");
        }
    }

    /**
     * @Description: 将内容写进文件
     * @auther: liucong
     * @date: 2020/9/1 17:07
     * @return:
     */
    private void saveContent(String title, String content) throws IOException {
        // 使用追加方式写进文件
        BufferedWriter bw = new BufferedWriter(new FileWriter(bookUrl, true));
        bw.write(title);
        bw.newLine();
        bw.write(content);
        bw.newLine();
        bw.flush();
        bw.close();
    }

    /**
     * @Description: 获取当页文本，并调整好文本的格式
     * @auther: liucong
     * @date: 2020/9/1 17:08
     * @return:
     */
    private String getContent(Document doc) {
        String html = doc.select("#content").html();
        html = html.replaceAll("<p>", "").replaceAll("<br>", "\n").replaceAll("</p>", "").replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;", "\t");
        Elements elements = doc.select("#content").select("p");
        for (Element element : elements) {
            String text = element.text();
            if (html.contains(text)) {
                html = html.replaceAll(text, "");
            }
        }
        html = html.replaceAll("\n \n \n\n", "");
        return html;
    }

    /**
     * @Description: 获取本章标题
     * @auther: liucong
     * @date: 2020/9/1 17:11
     * @return:
     */
    private String getTitle(Document doc) {
        return doc.select(".bookname").select("h1").text();
    }

    /**
     * @Description: 获取下一章地址
     * @auther: liucong
     * @date: 2020/9/1 17:12
     * @return:
     */
    private String getNextUrl(Document doc) {
        Elements elements = doc.select(".bottem2").select("a");
        String nextUrl = "";
        for (Element element : elements) {
            if (StringUtils.equals(element.text(), "下一章")) {
                nextUrl = homeUrl + element.attr("href");
                break;
            }
        }
        return nextUrl;
    }

    /**
     * @Description: 测试下载
     * @auther: liucong
     * @date: 2020/9/1 17:12
     * @return:
     */
    @Test
    public void test01() {
        try {
            download();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("下载超时...");
        }
    }
}
