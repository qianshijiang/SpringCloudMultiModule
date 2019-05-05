# micro-service-ribbon
服务的注册与发现（ribbon）

###服务注册中心
Ribbon是Netflix发布的云中间层服务开源项目，主要功能是提供客户端负载均衡算法。Ribbon客户端组件提供一系列完善的配置项，如，连接超时，重试等。简单的说，Ribbon是一个客户端负载均衡器，我们可以在配置文件中列出load Balancer后面所有的机器，Ribbon会自动的帮助你基于某种规则(如简单轮询，随机连接等)去连接这些机器，我们也很容易使用Ribbon实现自定义的负载均衡算法。

	server.port=8764
	eureka.instance.hostname=localhost
	eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:8761/eureka/
	spring.application.name=micro-service-ribbon
架构实施如图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0825/173007_b65f49e9_1468963.png "img.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0825/173013_4f16d3a8_1468963.png "2279594-9f10b702188a129d.png")


1. 一个服务注册中心，eureka server,端口为8761
1. service-hi工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
1. sercvice-ribbon端口为8764,向服务注册中心注册
1. 当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；
