### Spring Cloud Confing  服务配置中心

在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。在spring cloud config 组件中，分两个角色，一是config server，二是config client。


##### 结构流程图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0901/152258_7e7709b9_1468963.png "g-config.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0831/221212_1eec4e8d_1468963.png "config.png")

#### 远程Git仓库

    ############################################################################
    ######################配置中心 >> 远程Git GitHub仓库 #########################
    ############################################################################
    
    
    spring.application.name=ConfigServer
    server.port=8401
    
    #配置git仓库地址
    spring.cloud.config.server.git.uri=https://github.com/lishangzhi/SpringCloud-Config
    #配置仓库路径
    spring.cloud.config.server.git.searchPaths=respo
    #配置仓库的分支
    spring.cloud.config.label=master
    #访问git仓库的用户名
    spring.cloud.config.server.git.username=your username
    #访问git仓库的用户密码
    spring.cloud.config.server.git.password=your password

    
    ############################################################################
    ######################配置中心 >> 远程Git osChina仓库#########################
    ############################################################################

    
    spring.application.name=config-server
    server.port=8401
    
    #配置git仓库地址
    spring.cloud.config.server.git.uri=https://git.oschina.net/lishangzhi2012/spring-cloud-config
    #配置仓库路径
    spring.cloud.config.server.git.searchPaths=respo
    #配置仓库的分支
    spring.cloud.config.label=master
    #访问git仓库的用户名
    spring.cloud.config.server.git.username=your username
    #访问git仓库的用户密码
    spring.cloud.config.server.git.password=your password






- 
- http请求地址和资源文件映射如下:
- 
- /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.properties


#### 本地配置

    ############################################################################
    ######################config-client   ######################################
    ############################################################################
    
    spring.application.name=config-client
    spring.cloud.config.label=master
    spring.cloud.config.profile=dev
    spring.cloud.config.uri=http://localhost:8401
    
    server.port=8402
    spring.cloud.bootstrap.enabled=false


![输入图片说明](https://git.oschina.net/uploads/images/2017/0831/221843_a6671b78_1468963.png "config-1.png")











