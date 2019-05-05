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
package com.micro.ribbon.client.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * @FileName HelloARibbonService.java
 * @Description: 
 *
 * @Date 2017年8月29日 20:44:14
 * @author Li.Shangzhi
 * @version 1.0
 */
@Service
public class HelloARibbonService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * @Title: visitHelloA 
	 * @Description: @HystrixCommand 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
	 * @param name
	 * @return 
	 * @author Li.Shangzhi
	 * @date 2017年8月30日 20:40:40
	 */
	@HystrixCommand(fallbackMethod = "ServerError")
	public String visitHelloA(String name) {
		return restTemplate.getForObject("http://SERVICEHELLOA/HelloA?name="+name,String.class);
	}

	
	/**
	 * @Title: ServerError 
	 * @Description:熔断器指定了fallbackMethod熔断方法
	 * @param name
	 * @return 
	 * @author Li.Shangzhi
	 * @date 2017年8月30日 20:41:15
	 */
	public String ServerError(String name) {
        return "Hi,"+name+",sorry,error!";
    }


}