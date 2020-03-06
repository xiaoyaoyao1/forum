## YY社区论坛项目
### 依赖
- Git
- Jdk
- Maven
- Mysql

[欢迎进入YY社区](http://47.115.174.44/)

### 步骤
- yum update
- yum install git
- yum install maven
- yum mkdir App
- cd App
- git clone https://github.com/xiaoyaoyao1/forum.git
- cd forum
- vim src/main/resources/application-production.properties
- mvn clean compile package
- nohup java -jar -Dspring.profiles.active=production target/forum-0.0.1-SNAPSHOT.jar &> nohup.txt
- vim src/main/resources/templates/navigation.html
- ps -ef | grep java
- kill -9 PID
#### 运行须知
修改applcation.properties信息，详情根据下方Github OAuth和OSS对象存储进行注册查看。
### 资料
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)<br/>
 [Spring 文档](https://spring.io/guides)<br/>
[Spring web](https://spring.io/guides/gs/serving-web-content/)<br/>
[bootstrap组件](https://v3.bootcss.com/components/)<br/>
[Markdown插件](http://editor.md.ipandao.com/)<br/>
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)<br/>
[阿里云OSS对象存储](https://www.aliyun.com/product/oss?spm=5176.12825654.eofdhaal5.13.33ff2c4a2s0tpU&aly_as=tDiOre-p)
### 工具
[git](https://git-scm.com/download)<br/>
[lombok](https://www.projectlombok.org/)<br/>
[octotree插件](https://www.octotree.io/)<br/>
[postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)<br/>
[momentJs插件](http://momentjs.cn/)<br/>
### 知识点
localStorage<br/>mybatisGenerator<br/>前后端分离方式<br/>java8新特性lamada<br/>Apache Commons Lang验证字符串<br/>
```bash
逆向工程生成代码：mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```



