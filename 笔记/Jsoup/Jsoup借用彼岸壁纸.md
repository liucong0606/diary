# Jsoup借用彼岸壁纸

## 前言

此处是我学习爬虫的一个小Demo，我愿意把我的技术和大家一起分享，如果哪里有什么不对的，还请评论告知。因为我是第一次使用Java技术栈来做爬虫，可能有些代码不够友好，请多担待。

**（如有涉嫌侵犯图片网站的利益，请与我沟通）**



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

**静态代码块** 作用于将首页 `url` 放到 `urls` 中。

**私有构造** 作用是让此类不能产生对象， 因为我打算直接调用静态方法用来加载下载图片。

```java
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
```



## 遍历下载

使用 **普通循环** 的作用是为了在边遍历的时候边添加 `url` 进 `urls` 。

for 循环中 **final修饰的int** 作用：Lambda表达式只能接收常量。

1. 把每页图片url收集放到 `imgUrlsByPage` 变量；
2. 使用 saveImg() 方法把图片存到本地；
3. 本页图片读取完毕就读取 `下一页` 按钮的 `url` ，将它放置 `urls` 中。

```java
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
        // 获取下页的url
        String nextPageUrl = getNextPageUrl(i);
        if (nextPageUrl != null)
            urls.add(nextPageUrl);
    }
}
```



## 获取每页的图片url

使用 `Jsoup` 解析网页，获取图片的url。

`select` 作用是查找到该选择器选择的标签集合。

`attr` 作用是获取该标签的某个属性。

```java
/**
  * @Description: 获取每页的所有主内容的图片url
  * @auther: liucong
  * @date: 2020/8/17 16:19
  * @return:
  */
private static List<String> getImgUrlsByPage(int page) {
    // 存储本页所有图片url
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
```

网页源代码：

![彼岸图库的xpath解析](\img\彼岸图库的xpath解析.png)



## 保存图片

`try() {}` 格式里，小括号里定义的流不管有没有异常，都会自动结束流。

```java
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
        // 将url获取的流输出到本地路径的文件
        FileUtils.copyToFile(inputStream, new File(fileUrl));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```



## 获取下一页的url

```java
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
```



## 完整代码

```java
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
```



## 学到的知识

1. `Jsoup` 的 **链式** 获取标签不如 `xpath` 简洁，但是阅读性不错；
2. Lambda表达式不能引用外面的变量，只能使用常量；
3.  `try{} catch` 处理关闭流在 **JDK1.8** 之后进行了优化，小括号里定义的流会自动关闭。