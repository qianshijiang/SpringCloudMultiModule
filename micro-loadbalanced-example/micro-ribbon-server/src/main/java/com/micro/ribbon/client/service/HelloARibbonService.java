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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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

	    public String visitHelloA(String name) {
	        return restTemplate.getForObject("http://SERVICEHELLOA/HelloA?name="+name,String.class);
	    }

	}