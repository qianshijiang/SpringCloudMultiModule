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
package com.micro.ribbon.client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * @FileName HelloARibbonController.java
 * @Description: 
 *
 * @Date 2017年8月29日 20:44:14
 * @author Li.Shangzhi
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClientRibbonApplication{
	private static final Logger logger = LoggerFactory.getLogger(ClientRibbonApplication.class);
	
    public static void main(String[] args){
        SpringApplication.run(ClientRibbonApplication.class, args);
        
        logger.info("====================启动成功!====================");
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
