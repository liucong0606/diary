package com.liu.month8.d0821;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liucong
 * @ClassName: House58Reptile
 * @Description:
 * @date: 2020/8/21 13:47
 */
public class House58Reptile {
    private static String firstUrl = "https://nj.58.com/chuzu/?utm_source=sem-baidu-pc&spm=105916147053.26840108921&PGTID=0d100000-000a-c354-a814-8b1bb4d14a87&ClickID=2";
    private static List<String> pageUrls = Collections.synchronizedList(new ArrayList<>());

    private House58Reptile() {
    }

    static {
        pageUrls.add(firstUrl);
    }

    /**
     * @Description: 爬取房源信息放置excel中
     * @auther: liucong
     * @date: 2020/8/21 13:50
     * @return:
     */
    public static void findHouse2Excel() {
        try {
            for (int i = 0; i < pageUrls.size(); i++) {
                Document doc = Jsoup.connect(pageUrls.get(i)).get();
                // 爬取每页信息放置集合
                List<House58> infoByPage = getInfoByPage(doc);
                // 写入每页信息进excel
                setInfo2Excel(infoByPage);
                // 获取下页url
                String nextPageUrl = getNextPageUrl(doc);
                if (!StringUtils.isEmpty(nextPageUrl))
                    pageUrls.add(nextPageUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 将信息写入Excel
     * @auther: liucong
     * @date: 2020/8/21 15:09
     * @return:
     */
    private static void setInfo2Excel(List<House58> infoByPage) {
        try (FileOutputStream os = new FileOutputStream("C://学习//房源信息.xlsx");
             XSSFWorkbook book = new XSSFWorkbook()) {
            Sheet sheet = book.createSheet();
            infoByPage.forEach(info -> {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(info.getTitle());
                row.createCell(1).setCellValue(info.getPrice());
                row.createCell(2).setCellValue(info.getArea());
                row.createCell(3).setCellValue(info.getHouseType());
                row.createCell(4).setCellValue(info.getAddress());
                row.createCell(5).setCellValue(info.getDistance());
                row.createCell(6).setCellValue(info.getImgUrl());
                row.createCell(7).setCellValue(info.getMiddleCompany());
                row.createCell(8).setCellValue(info.getPublisher());
            });

            book.write(os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<House58> getInfoByPage(Document doc) {
        List<House58> info = new ArrayList<>();
        Elements elements = doc.select(".house-cell");
        elements.forEach(element -> {
            String room = element.select(".des").select(".room").text();
            String[] types = room.split(" ");

            String[] addresses = element.select(".des").select(".infor").last().text().split(" ");
            String address = String.format("%s，%s", addresses[0], addresses[1]);
            String company = element.select(".des").select(".jjr").select(".jjr_par").select(".jjr_par_dp").attr("title");
            String publisher = element.select(".des").select(".jjr").select(".jjr_par").select(".listjjr").text();

            House58 h = new House58();
            h.setTitle(element.select(".des").select("h2").select(".strongbox").text());
            h.setImgUrl(element.select(".img-list").select("a").select("img").attr("src"));
            h.setPrice(element.select(".list-li-right").select(".money").select(".strongbox").text());
            h.setHouseType(types[0]);
            h.setArea(types[types.length - 1]);
            h.setAddress(address);
            h.setMiddleCompany(company);
            h.setPublisher(publisher);
            if (addresses.length > 2) {
                h.setDistance(addresses[2]);
            }
            info.add(h);
            System.out.println(h);
        });
        return info;
    }

    private static String getNextPageUrl(Document doc) {
        return "";
    }
}
