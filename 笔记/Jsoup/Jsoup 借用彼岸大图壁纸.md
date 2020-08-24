# Jsoup 借用彼岸大图壁纸

## 前言

此处是我学习爬虫的一个小Demo，我愿意把我的技术和大家一起分享，如果哪里有什么不对的，还请评论告知。因为我是第一次使用Java技术栈来做爬虫，可能有些代码不够友好，请多担待。

因彼岸高清图片需要会员，本案例准备爬取大图，而不是缩略图。

**（如有涉嫌侵犯网站的利益，请与我沟通）**



## 引入 `Maven` 坐标

```xml
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.11.3</version>
</dependency>
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.5</version>
</dependency>
<!-- 文件下载 -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.5</version>
</dependency>
```



## 初始化成员属性

**静态代码块** 作用于将 目标地址 放到 页面集合 中。

`首页` 作用：用于后面对图片以及下一页地址的前缀拼接。

```java
// 首页地址
private static String homeUrl = "http://pic.netbian.com";
// 需要爬取的目标地址
private static String targetUrl = "http://pic.netbian.com/4kdongman";
// 存储每页的地址
private static List<String> pageUrls = Collections.synchronizedList(new ArrayList<>());

static {
    pageUrls.add(targetUrl);
}
```



## 开始爬虫

使用 **普通循环** 的作用是为了在边遍历的时候边添加 `url` 进 页面集合 。

使用 `Jsoup` 解析网页，获取网页源代码。

1. 获取网页源代码
2. 获取本页所有图片
3. 将图片持久化到本地
4. 获取下一页放入页面集合中

```java
/**
  * @Description: 开启爬虫
  * Aauther: liucong
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
```



## 获取每页的大图网页

此处要注意一点，`li` 下面的 `img` 不是我们想要的图片，此处是缩略图；

我们需要的是 `li` 下面 `a` 链接跳转后页面的大图。

`select` 作用是查找到该选择器选择的标签集合；

`attr` 作用是获取该标签的某个属性。

```java
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
```

网页源代码：

![彼岸图库的xpath解析](\img\彼岸图库的xpath解析.png)



## 获取大图的url

大图网页是一个新的网页，需要 `Jsoup` 再次进行解析。

```java
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
```



## 保存图片

`try() {}` 格式里，小括号里定义的流不管有没有异常，都会自动结束流。

```java
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
```



## 获取下一页url

使用 `StringBuilder` 的作用是：Lambda 表达式引用外面的对象，不能改变其地址，但是我们可以将数据存进对象。

```java
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
```



## 完整代码

```java
/**
 * @author liucong
 * @ClassName: ImgReptile
 * @Description:
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
```



## 学到的知识

1. `Jsoup` 的 **链式** 获取标签不如 `xpath` 简洁，但是阅读性不错；
2. `Lambda` 表达式不能引用外面的基本数据变量，只能使用常量；
3. `Lambda` 表达式引用外面的对象，不能改变其地址指向，但是可以操作里面数据；
4. `try(创建流){} catch` 处理关闭流在 **JDK1.8** 之后进行了优化，小括号里定义的流会自动关闭。