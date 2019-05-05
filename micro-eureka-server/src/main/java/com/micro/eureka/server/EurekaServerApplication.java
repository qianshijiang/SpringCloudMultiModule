/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2017.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2017年8月29日    Li.Shangzhi         Create the class
 * http://www.jimilab.com/
*/
package com.micro.eureka.server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @FileName EurekaServerApp.java
 * @Description: 
 *
 * @Date 2017年8月29日 下午7:44:06
 * @author Li.Shangzhi
 * @version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication{
	private static final Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);
	
	/**
	 * @Title: main 
	 * @Description:程序入口
	 * @param args 
	 * @author Li.Shangzhi
	 * @date 2017年8月29日 下午7:43:31
	 */
    public static void main(String[] args){
    	
        SpringApplication.run(EurekaServerApplication.class, args);
        
        logger.info("====================启动成功!====================");
        
    }
    
}
