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
package com.micro.feign.client.service;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @FileName EurekaServerApp.java
 * @Description: 
 *
 * @Date 2017年8月29日 21:09:41
 * @author Li.Shangzhi
 * @version 1.0
 */
@FeignClient(value = "SERVICEHELLOA")
public interface HelloAFeignService {

	@RequestMapping(value = "/HelloA",method = RequestMethod.GET)
    String visitHelloA(@RequestParam(value = "name") String name);

}
