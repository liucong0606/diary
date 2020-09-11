package com.liu.month8.d0817.jsoups;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liucong
 * @ClassName: ImgReptile
 * @Description:
 * @date: 2020/8/17 15:07
 */
public class ImgReptile {
    // 彼岸图库首页
    private static String homeUrl = "http://www.netbian.com";
    // 需要遍历获取图片的每页url
    private static List<String> urls = new ArrayList<>();

    static {
        // 将首页放入list的第 1 页
        urls.add(homeUrl);
    }

    // 私有构造
    private ImgReptile() {

    }

    /**
     * @Description: 获取每页的所有主内容的图片url
     * @auther: liucong
     * @date: 2020/8/17 16:19
     * @return:
     */
    private static List<String> getImgUrlsByPage(int page) {
        List<String> imgUrls = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(urls.get(page)).get();
            Elements lis = doc.select(".list").select("ul").select("li");
            lis.forEach(li -> {
                imgUrls.add(li.select("a").select("img").attr("src"));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgUrls;
    }

    /**
     * @Description: 获取下一页的 url
     * @auther: liucong
     * @date: 2020/8/17 16:18
     * @return:
     */
    private static String getNextPageUrl(int page) {
        String nextUrl = null;
        try {
            Document doc = Jsoup.connect(urls.get(page)).get();
            nextUrl = homeUrl + doc.select(".prev").attr("href");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nextUrl;
    }

    /**
     * @Description: 下载
     * @auther: liucong
     * @date: 2020/8/17 16:18
     * @return:
     */
    public static void download() {
        for (int i = 0; i < urls.size(); i++) {
            final int page = i;
            // 获取每页的图片url
            List<String> imgUrlsByPage = getImgUrlsByPage(i);
            imgUrlsByPage.forEach(imgUrl -> {
                String fileUrl = String.format("C:\\笔记\\%d\\img%d.jpg", page, new Date().getTime());
                saveImg(imgUrl, fileUrl);
            });
            System.out.println();
            // 获取下页的url
            String nextPageUrl = getNextPageUrl(i);
            if (nextPageUrl != null)
                urls.add(nextPageUrl);
        }
    }

    /**
     * @Description: 保存图片到本地
     * @auther: liucong
     * @date: 2020/8/17 16:19
     * @return:
     */
    private static void saveImg(String imgUrl, String fileUrl) {
        // 创建httpclient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpget实例
        HttpGet httpget = new HttpGet(imgUrl);
        try (
                CloseableHttpResponse resp = httpclient.execute(httpget);
                InputStream inputStream = resp.getEntity().getContent()
        ) {
            FileUtils.copyToFile(inputStream, new File(fileUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
