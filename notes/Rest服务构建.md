## Rest微服务构建

### 基本步骤

1. 建立模块
2. 改pom依赖
3. 写yml配置
4. 写主启动类
5. 编写业务
   1. 建表SQL
   2. entities
   3. dao
   4. service
   5. controller
6. 测试

## 实例1 创建简单的支付模块

项目地址： [cloud-provider-payment8001](../cloud-provider-payment8001) 

### 1. 创建模块

在父工程中创建一个子module，基本信息如下

```xml
    <parent>
        <artifactId>springcloud2020</artifactId>
        <groupId>com.sun</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-provider-payment8001</artifactId>
```

### 2. 编写pom依赖

具体pom依赖参见项目文档

### 3. 编写yml配置

### 4. 编写springboot主启动类

```java
@SpringBootApplication
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
```

### 5. 编写具体业务

第一步：创建sql表


```sql
CREATE TABLE `payment`(
`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT "ID",
`serial` VARCHAR(200) DEFAULT '',
PRIMARY KEY(`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
```

第二步：创建entities 和 Json 封装体

 [Payment.java](../cloud-provider-payment8001/src/main/java/com/sunxz/springcloud/entities/Payment.java) 

 [CommonResult.java](../cloud-provider-payment8001/src/main/java/com/sunxz/springcloud/entities/CommonResult.java) 

第三步：创建dao 和 Mapper

 [PaymentDao.java](../cloud-provider-payment8001/src/main/java/com/sunxz/springcloud/dao/PaymentDao.java) 

 [PaymentMapper.xml](../cloud-provider-payment8001/src/main/resources/mapper/PaymentMapper.xml) 

第四步： 创建service 层

 [service](../cloud-provider-payment8001/src/main/java/com/sunxz/springcloud/service) 

第五步：编写controller层

 [controller](../cloud-provider-payment8001/src/main/java/com/sunxz/springcloud/controller) 

### 6. 测试

可以使用psotman来进行请求测试

## 热部署

添加热部署依赖到工程

```java
<!--热部署-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

**父工程POM下** 添加插件

```xml
<build>
  <finalName>springcloud2020</finalName>
  <plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <version>${spring.boot.version}</version>
        <configuration>
            <fork>true</fork>
            <addResource>true</addResource>
        </configuration>
    </plugin>
  </plugins>
</build>
```

在idea中开启热部署选项

![截屏2020-07-06下午9.09.34](https://gitee.com/Sunxz007/PicStorage/raw/master/imgs/20200706211126.png)

更新reistry

![C3F166A3-6F73-4A5E-9FA6-471EF009FA7C_4_5005_c](https://gitee.com/Sunxz007/PicStorage/raw/master/imgs/20200706212017.jpeg)

CTRL+SHIFT + ALT + / ，打开上面的这个界面，选择 registry

主要是打开 compiler.aotomake.allow.when.app.running

![03421D8D-D81B-49AA-9A9F-60680A53FCEB_4_5005_c](https://gitee.com/Sunxz007/PicStorage/raw/master/imgs/20200706211850.jpeg)

最后重启idea

**建议：**使用手动热部署，节约内存和减少卡顿

## 消费者订单模块

