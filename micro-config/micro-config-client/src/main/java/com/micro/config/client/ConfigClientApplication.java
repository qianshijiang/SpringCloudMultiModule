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
package com.micro.config.client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName ServiceHelloAController.java
 * @Description: 
 *
 * @Date 2017年8月29日 20:48:49
 * @author Li.Shangzhi
 * @version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ConfigClientApplication{
	private static final Logger logger = LoggerFactory.getLogger(ConfigClientApplication.class);
	
    public static void main(String[] args){
    	SpringApplication.run(ConfigClientApplication.class, args);
        logger.info("====================启动成功!====================");
    } 
    
    
    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/configHi")
    public String hi(){
        return foo;
    }

}
