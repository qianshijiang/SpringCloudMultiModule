# SpringCloudMultiModule

## SpringCloud 快速搭建微服务  springCloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等，下面进行个服务分部搭建源码与测试案例，此项目初于学习，有待深入了解！

##目标微服务系统
![输入图片说明](https://git.oschina.net/uploads/images/2017/0831/101823_6a084f42_1468963.png "lct.png")

## 组织结构

	springcloud-microservice
	├── micro-eureka-server -- Netflix Eureka服务注册中心      [端口 8101]
	| 
	├── micro-service-example -- 服务消费(模拟服务)
	|	├── micro-serviceA -- 服务消费A[端口 8201] 
	|	├── micro-serviceB -- 服务消费B[端口 8202] 
	|
    |———micro-loadbalanced-example --服务分发（负载均衡）  
	|	├── micro-ribbon-server --服务分发（rest+ribbon） [端口 8301] 	
	|	|── micro-feign-server  --服务分发（feign）       [端口 8302] 
	|
	|── micro-hystrix-example -- 服务分发（负载均衡)[断路器\服务消费+（Hystrix)+(Hystrix 仪表盘)]
   	|	├── micro-ribbon-hystrix -- (ribbon+hystrix)  [端口 8311] 
	|	├── micro-feign-hystrix  -- (feign+hystrix)   [端口 8312]
    |
    |── micro-route-zuul  --路由网关(zuul)            [端口 8401] 
    |
    |── micro-config  --  分布式配置中心（高可用的分布式配置中心）(Spring Cloud Config)
	|	├── micro-config-client --配置中心服务端Config Server [端口 8401] 	
	|	|── micro-config-server --配置中心服务端Config Client [端口 8402] 
	|
	|── micro-sleuth-samples  --   服务链路追踪(Spring Cloud Sleuth)
	|	├── micro-server-zipkin  --zipkin数据收集中心  [端口 8501] 	
	|	|── micro-zipkin-serverA --模拟暴露服务A [端口 8502] 
	|	|── micro-zipkin-serverB --模拟暴露服务B [端口 8503] 
    |
	|── micro-eureka-server-cluster  --高可用的服务注册中心 (micro-eureka-server-cluster 多分配置)
	|	|── eureka-server-cluster --Eureka注册中心 [端口 8111] 
	|	|── eureka-server-cluster --Eureka注册中心 [端口 8112] 



#### 更新记录： 
- 2017年8月24日 23:45:15    迁移GitHub和阿里存储结构迁移（目前只在oschina上更新开放）
- 2017年8月25日 22:45:15    搭建基本结构加入Netflix Eureka 服务注册中心
- 2017年8月26日 15:20:14    Eureka源码解析，服务注册、续约 、获取、下线、剔除~
- 2017年8月28日 23:03:04    接入模拟服务，Netflix Ribbon实现客服端负载均衡
- 2017年8月29日 01:15:46    路由网关(Netflix Zuul)，鉴权，接口流控
- 2017年8月30日 23:30:02    分布式配置中心(Spring Cloud Config)，Git远程仓库配置，版本问题spring-cloud 老版本Brixton.SR4版本已升级到 Dalston.SR2  
- 2017年9月1日 20:56:02    高可用的分布式配置中心在micro-config节点上进行修改，将配置客户端和服务端都配置到注册中心统一管理服务
- 2017年9月2日 16:51:12    分布式服务追踪收集
- 2017年9月4日 22:17:30    高可用的服务注册中心（感觉针对服务应用价值不大,服务案例已完善仅供学习参考）


## 开发目录视图
#### 迭代更新
![输入图片说明](https://git.oschina.net/uploads/images/2017/0831/220011_39c8d15a_1468963.png "Hystrix-Dev.png")


### 模块清单

- ### [ Netflix Eureka服务注册中心](http://git.oschina.net/lishangzhi2012/springcloud-microservice/blob/master/micro-eureka-server/README.md "micro-eureka-server")
- ### [服务消费 (模拟服务)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-service-example)
- ### [服务分发（负载均衡）](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-loadbalanced-example)
- ### [服务分发（负载均衡)[断路器\服务消费+（Hystrix)+(Hystrix 仪表盘)]](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-hystrix-example)
- ### [路由网关(zuul)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-route-zuul)
- ### [分布式配置中心(Spring Cloud Config)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-config)
- ###  [分布式配置中心(高可用的分布式配置中心(Spring Cloud Config))](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-config)
- ###  [消息总线(Spring Cloud Bus)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-config)
- ###  [服务链路追踪(Spring Cloud Sleuth)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-sleuth-samples)
- ###  [高可用的服务注册中心](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-eureka-server-cluster)

<br>

### 配置中心 
- 远程Git GitHub仓库 [配置中心](https://github.com/lishangzhi/SpringCloud-Config)  https://github.com/lishangzhi/SpringCloud-Config
-  远程Git osChina仓库[配置中心](https://git.oschina.net/lishangzhi2012/spring-cloud-config) https://git.oschina.net/lishangzhi2012/spring-cloud-config   
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0831/161943_d5cc8fb8_1468963.png "git.png")
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0901/104054_9cb6ca1d_1468963.png "git.png")


### 已完成模块简介(参考官网给出的图加以理解)
- **#服务发现——Netflix Eureka**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/165340_44d3d98a_1468963.png "Netflix Eureka.png")
- **#客服端负载均衡——Netflix Ribbon**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/165539_d48d8dd2_1468963.png "Netflix Ribbon.png")
- **#断路器——Netflix Hystrix**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/170046_2f0fb128_1468963.png "Netflix Hystrix.png")
- **#服务网关——Netflix Zuul **
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/212842_53dc6eda_1468963.png "zuul.png")



<br>
### 中文官网
[Spring Cloud中文网-官方文档中文版](https://springcloud.cc/)

### 整体进度与计划
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/182728_6705a185_1468963.png "SpringCloud.png")
<br>
<br>
### 持续更新！！！