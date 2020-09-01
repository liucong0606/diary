# Spring Cloud遇到的问题

## Eureka

### 问题①

描述：

Eureka启动失败

![01_Eureka启动错误1](C:\rep\diary\笔记\Error\img\01_Eureka启动错误1.png)



解决：

原来的依赖引入错误

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-netflix-eureka-server</artifactId>
</dependency>
```

改为：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```



### 问题②

描述：

```
com.netflix.discovery.shared.transport.TransportException: Cannot execute request on any known server
```



解决：

```
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://127.0.0.1:6001/eureka-server/
```



## Mybatis

### 问题①

描述

```
java.lang.IllegalStateException: Failed to load ApplicationContext
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'scopedTarget.dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.zaxxer.hikari.HikariDataSource]: Factory method 'dataSource' threw exception; nested exception is org.springframework.boot.autoconfigure.jdbc.DataSourceProperties$DataSourceBeanCreationException: Failed to determine a suitable driver class
Caused by: org.springframework.beans.BeanInstantiationException:
```



解决：

url 路径错误

```yml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql///changgou_goods?character=utf8
    username: root
    password: root
```

改成：

```yml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql:///changgou_goods?character=utf8
    username: root
    password: root
```



### 问题②

描述

```
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.liu.cloud.goods.dao.BrandDao.findAll
```



解决方案：1. 命名空间与接口全类名对应，2. 将mybatis的接口名称和映射文件名称保持一致。



## Spring MVC

### 问题①

描述：

![02_SpringMVC返回Json失败](C:\rep\diary\笔记\Error\img\02_SpringMVC返回Json失败.png)



解决：给实体类加上setter/getter方法，否则无法解析成json