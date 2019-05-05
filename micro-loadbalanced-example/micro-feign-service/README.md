# micro-fegin-client

[micro-ribbon-client](https://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-ribbon-client)讲述了如何通过RestTemplate+Ribbon去消费服务，下面主要是如何通过Feign去消费服务实现

##Feign简介
Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。

    简而言之：
    
    1. Feign 采用的是基于接口的注解
    1. Feign 整合了ribbon


