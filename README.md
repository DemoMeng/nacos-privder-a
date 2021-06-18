# Nacos 客户端 nacos-provider-a：服务提供方





#SpringBoot、SpringCloud、SpringCloudAlibaba三者版本兼容参考：
![版本兼容](images/springboot-cloud-alibaba三者对应版本.jpg)



#dockerfile-maven-plugin 本地打包项目成镜像并推送到镜像仓库

    1.打包配置pom
    2.编写Dockerfile文件
    3.运行该插件的机器上定义DOCKER_HOST环境变量，配置访问Docker的URL， 
      如：export DOCKER_HOST=tcp://localhost:2375
      上面的例子，是在Linux环境下定义的DOCKER_HOST环境变量，因为Docker安装在本机上，因此使用localhost。如果你的Docker运行环境不在本机，
      请使用Docker所在机器的IP。2375是为Docker开启的远程访问API的端口，如果你开启的是其他端口，请使用具体的端口。如果你的Docker没有开启远程访问API，请自行Google开启。
    4.配置鉴权，在maven的setting.xml中新加一个server节点配置鉴权：
        <server>
          <id>registry.cn-hangzhou.aliyuncs.com</id>
          <username>xxxx</username>
          <password>xxxx</password>
          <configuration>
            <email>xxxx</email>
          </configuration>
        </server>

![img.png](images/docker打包镜像鉴权配置.png)

    5.执行打包构建： mvn clean package -DskipTests -Pdev
  
    注意：Dockerfile需要和pom文件平级

![img.png](images/docker打包整体配置.png)
