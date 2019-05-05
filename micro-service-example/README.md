# micro-server
模拟服务
#### micro-serverA


    spring.application.name=ServiceHelloA
    server.port=8201
    
    eureka.client.serviceUrl.defaultZone=http://lishangzhi:123456@localhost:8101/eureka

#### micro-serverB

	spring.application.name=ServiceHelloA
    server.port=8202
    
    eureka.client.serviceUrl.defaultZone=http://lishangzhi:123456@localhost:8101/eureka

同一应用服务，不同开放端口

启动工程,打开浏览器访问：
![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/095623_c6982049_1468963.png "micro-servicvea.png")
后端日志：
![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/095636_f27d3f63_1468963.png "micro-service.png")

