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
package com.micro.service.client.web;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @FileName ServiceHelloAController.java
 * @Description: 
 *
 * @Date 2017年8月29日 20:48:34
 * @author Li.Shangzhi
 * @version 1.0
 */
@RestController
public class ServiceHelloAController {

    @Value("${server.port}")
    String port;
    
    @RequestMapping("/HelloA")
    public String sayHelloA(@RequestParam String name) {
    	return "["+name+"@"+port+"], "+new Date();
    }
    
}