package com.liu.month8.d0817.jsoups;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author liucong
 * @ClassName: ZongHengUtils
 * @Description:
 * @date: 2020/8/17 14:09
 */
public class ZongHengUtils {
    private static List<String> urls = new ArrayList<>();

    private ZongHengUtils() {

    }

    public static String getTitle(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document.select(".title_txtbox").text();
    }

    public static List getText(String url) {
        List<String> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements select = document.select(".content");
            Elements p = select.select("p");
            p.stream().forEach(e -> {
                list.add(e.text().trim());
            });
            // System.out.println(select);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getNextUrl(String url) {
        String href = "";
        try {
            Document document = Jsoup.connect(url).get();
            href = document.select(".nextchapter").attr("href");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return href;
    }

    public static void reading(String url) {
        System.out.println(getTitle(url));
        getText(url).forEach(System.out::println);
        String nextUrl = getNextUrl(url);
        if (nextUrl.length() > 0 && !nextUrl.equals("javascript:void(0)")) {
            urls.add(nextUrl);
            System.out.println(nextUrl);
            System.out.println("\n\n");
            reading(nextUrl);
        }
    }
}
