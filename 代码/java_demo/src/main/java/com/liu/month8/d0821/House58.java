package com.liu.month8.d0821;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @author liucong
 * @ClassName: House58
 * @Description:
 * @date: 2020/8/21 13:51
 */
@Data
@ToString
public class House58 {
    private String imgUrl;      // 图片地址
    private String title;       // 房源标题
    private String houseType;   // 房源类型
    private String address;     // 地址
    private String price;       // 价格
    private String distance;    // 距离地铁站多远（有可能为null）
    private String middleCompany;   // 中介公司
    private String publisher;   // 发布人
    private String area;        // 占地面积

    public House58() {
    }

    public House58(String imgUrl, String title, String houseType, String address, String price, String distance, String middleCompany, String publisher) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.houseType = houseType;
        this.address = address;
        this.price = price;
        this.distance = distance;
        this.middleCompany = middleCompany;
        this.publisher = publisher;
    }

    private String decode(String value) {
        String json = "{'閏':1,'麣':2,'驋':4,'龤':0,'鑶':5,'龥':8,'餼':6,'鸺':9,'齤':7,'龒':3}";
        Map map = JSON.parseObject(json, Map.class);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            String c = String.valueOf(ch);
            if (map.containsKey(c)) {
                c = String.valueOf(map.get(c));
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public void setImgUrl(String imgUrl) {
        imgUrl = decode(imgUrl);
        this.imgUrl = imgUrl;
    }

    public void setTitle(String title) {
        title = decode(title);
        this.title = title;
    }

    public void setHouseType(String houseType) {
        houseType = decode(houseType);
        this.houseType = houseType;
    }

    public void setAddress(String address) {
        address = decode(address);
        this.address = address;
    }

    public void setPrice(String price) {
        price = decode(price);
        this.price = price;
    }

    public void setDistance(String distance) {
        distance = decode(distance);
        this.distance = distance;
    }

    public void setMiddleCompany(String middleCompany) {
        middleCompany = decode(middleCompany);
        this.middleCompany = middleCompany;
    }

    public void setPublisher(String publisher) {
        publisher = decode(publisher);
        this.publisher = publisher;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getHouseType() {
        return houseType;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }

    public String getDistance() {
        return distance;
    }

    public String getMiddleCompany() {
        return middleCompany;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        area = decode(area);
        this.area = area;
    }
}
