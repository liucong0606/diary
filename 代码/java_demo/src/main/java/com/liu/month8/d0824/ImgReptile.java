package com.liu.month8.d0824;

import com.alibaba.druid.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author liucong
 * @ClassName: ImgReptile
 * @Description: 彼岸图库爬取大图
 * @date: 2020/8/24 9:13
 */
public class ImgReptile {
    // 首页地址
    private static String homeUrl = "http://pic.netbian.com";
    // 需要爬取的目标地址
    private static String targetUrl = "http://pic.netbian.com/4kdongman";
    // 存储每页的地址
    private static List<String> pageUrls = Collections.synchronizedList(new ArrayList<>());

    static {
        pageUrls.add(targetUrl);
    }

    /**
     * @Description: 开启爬虫
     * @auther: liucong
     * @date: 2020/8/24 9:27
     * @return:
     */
    private void start() {
        System.out.println("开始下载...");
        try {
            for (int i = 0; i < pageUrls.size(); i++) {
                System.out.println("正在下载第" + (i + 1) + "页图片...");
                // 获取每页的网页源代码
                Document doc = Jsoup.connect(pageUrls.get(i)).get();
                // 获取当前页的所有图片url
                List<String> imgUrls = getImgUrls(doc);
                // 将当前页的图片保存到本地
                saveImg(imgUrls, i + 1);
                // 获取下一页
                saveNextUrl(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取每页的图片url
     * @auther: liucong
     * @date: 2020/8/24 9:27
     * @return:
     */
    private List<String> getImgUrls(Document doc) {
        List<String> imgList = new ArrayList<>();
        // 每张图片的对应li
        Elements lis = doc.select(".slist").select("ul").select("li");
        lis.forEach(li -> {
            // href 是一个网址地址，跳转到大图的页面
            String href = homeUrl + li.select("a").attr("href");
            String imgUrl = getImgUrlByHref(href);
            imgList.add(imgUrl);
        });
        return imgList;
    }

    /**
     * @Description: 根据href获取大图
     * @auther: liucong
     * @date: 2020/8/24 9:38
     * @return:
     */
    private String getImgUrlByHref(String href) {
        String src = "";
        try {
            Document doc = Jsoup.connect(href).get();
            src = homeUrl + doc.select(".photo-pic").select("a").select("img").attr("src");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

    /**
     * @Description: 获取当前页的下一页url，并存进集合
     * @auther: liucong
     * @date: 2020/8/24 10:09
     * @return:
     */
    private void saveNextUrl(Document doc) {
        StringBuilder sb = new StringBuilder();
        Elements elements = doc.select(".page").select("a");
        elements.forEach(element -> {
            if (StringUtils.equals("下一页", element.text())) {
                String href = element.attr("href");
                sb.append(homeUrl + href);
            }
        });
        // 获取到下一页数据
        String next = sb.toString();
        if (!pageUrls.contains(next)) {
            if (!StringUtils.isEmpty(next)) {
                pageUrls.add(next);
            } else {
                System.out.println("完成下载...");
            }
        }
    }

    /**
     * @Description: 将图片持久化到本地
     * @auther: liucong
     * @date: 2020/8/24 9:28
     * @return:
     */
    private void saveImg(List<String> urls, int page) {
        urls.forEach(url -> {
            // 用时间戳来动态设置文件名
            String fileUrl = String.format("C:\\笔记\\%d\\img%d.jpg", page, new Date().getTime());
            CloseableHttpClient httpclient = HttpClients.createDefault();
            // 创建httpclient实例
            // 创建httpget实例
            HttpGet httpget = new HttpGet(url);
            try (
                    CloseableHttpResponse resp = httpclient.execute(httpget);
                    InputStream inputStream = resp.getEntity().getContent()
            ) {
                // 持久化到本地
                FileUtils.copyToFile(inputStream, new File(fileUrl));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @Description: 测试下载（入口函数）
     * @auther: liucong
     * @date: 2020/8/24 10:19
     * @return:
     */
    @Test
    public void test() {
        start();
    }
}
