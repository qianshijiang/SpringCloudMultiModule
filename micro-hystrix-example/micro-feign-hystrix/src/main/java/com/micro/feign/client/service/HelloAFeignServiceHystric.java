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
 * 2017年8月30日    Li.Shangzhi         Create the class
 * http://www.jimilab.com/
*/

package com.micro.feign.client.service;
import org.springframework.stereotype.Component;

/**
 * @FileName HelloAFeignServiceHystric.java
 * @Description: 
 *
 * @Date 2017年8月30日 下午2:20:56
 * @author Li.Shangzhi
 * @version 1.0
 */
@Component
public class HelloAFeignServiceHystric implements HelloAFeignService {

	@Override
	public String visitHelloA(String name) {
		
		return "sorry "+name;
	}

}
