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
 * 2017年9月4日    Li.Shangzhi         Create the class
 * http://www.jimilab.com/
*/
package com.micro.zipkin.server.samples;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @FileName ZipkinApplication.java
 * @Description: 
 *
 * @Date 2017年9月4日 10:15:26
 * @author Li.Shangzhi
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class SamplesApplication{
    
	private static final Logger logger = LoggerFactory.getLogger(SamplesApplication.class);
	
    public static void main(String[] args){
        SpringApplication.run(SamplesApplication.class, args);
        
        logger.info("====================启动成功!====================");
    }
    
    
    /**
     * @Title: home 
     * @Description:zipkin-serverA 模拟接口
     * @return 
     * @author Li.Shangzhi
     * @date 2017年9月4日 13:43:40
     */
    @RequestMapping("/zipkinserverB")
    public String home(){
    	logger.info("zipkinserverA is being called");
        return "this is zipkin-serverB";
    }

    /**
     * @Title: info 
     * @Description:调用zipkin-serverB 模拟接口 服务互调(检测链路是否被监控)
     * 				不接入注册中心,直接采取IP+端口+服务名调用
     * @return 
     * @author Li.Shangzhi
     * @date 2017年9月4日 13:43:43
     */
    @RequestMapping("/serverB")
    public String zipkin(){
    	logger.info("zipkin is being called");
        return restTemplate.getForObject("http://localhost:8502/zipkinserverA",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
}
