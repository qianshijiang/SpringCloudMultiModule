# 服务链路追踪(Spring Cloud Sleuth)
###   服务链路
本文的案例主要有三个工程组成:一个micro-server-zipkin,它的主要作用使用ZipkinServer 的功能，收集调用数据，并展示；一个micro-zipkin-serverA,对外暴露zipkinserverA接口；一个micro-zipkin-serverB,对外暴露zipkinserverB接口；这两个service可以相互调用；并且只有调用了，micro-server-zipkin才会收集数据的，这就是为什么叫服务追踪了。

### 结构图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/152944_2e553cc9_1468963.png "sleuth-1.png")


### 结果视图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/153007_666099d4_1468963.png "sleuth-2.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/153014_224d46b8_1468963.png "sleuth-3.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/153020_50159da4_1468963.png "sleuth-4.png")







