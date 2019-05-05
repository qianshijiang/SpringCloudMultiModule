# micro-hystix-server 

在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

##Hystri
Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。 在微服务架构中，一个请求需要调用多个服务是非常常见的
<br>
######Netflix的创造了一个调用的库Hystrix实现了断路器图案。在微服务架构中，通常有多层服务调用。

![图1.微服务图](https://springcloud.cc/images/HystrixGraph.png)

###较低级别的服务中的服务故障可能导致用户级联故障。当对特定服务的呼叫达到一定阈值时（Hystrix中的默认值为5秒，20次故障），电路打开，不进行通话。在错误和开路的情况下，开发人员可以提供后备。
![图2.微服务图](https://springcloud.cc/images/HystrixFallback.png)
<br>
######开放式电路会停止级联故障，并允许不必要的或失败的服务时间来愈合。回退可以是另一个Hystrix受保护的调用，静态数据或一个正常的空值。回退可能被链接，所以第一个回退使得一些其他业务电话又回到静态数据。

![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/161407_6994371d_1468963.png "Hystrix-D.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/161412_a3b17677_1468963.png "Hystrix-B.png")


>这里有深入理解：https://segmentfault.com/a/1190000005988895
>

##总结
通过使用Hystrix,我们能方便的防止雪崩效应, 同时使系统具有自动降级和自动恢复服务的效果.


