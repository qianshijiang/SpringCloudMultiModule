# micro-eureka-server
服务的注册与发现（Eureka）

###服务注册中心
Spring Cloud Netflix的Eureka ,eureka是一个服务注册和发现模块

eureka是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳（因此可以在内存中完成），在默认情况下erureka server也是一个eureka client ,必须要指定一个 server。eureka server的配置文件

    server.port=8888
    eureka.instance.hostname=localhost
    eureka.client.registerWithEureka=false
    eureka.client.fetchRegistry=false
    eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
    spring.application.name=cloud-eureka-server
    #renew频率，向Eureka服务发送renew信息，默认30秒
    eureka.instance.leaseRenewalIntervalInSeconds=10
    #服务失效时间，Eureka多长时间没收到服务的renew操作，就剔除该服务，默认90秒
    eureka.instance.leaseExpirationDurationInSeconds=15

启动工程,打开浏览器访问：
![输入图片说明](https://git.oschina.net/uploads/images/2017/0824/185326_e93e273e_1468963.png "eureka-server.png")
后端日志：
![输入图片说明](https://git.oschina.net/uploads/images/2017/0824/185355_f63c4ce8_1468963.png "success.png")