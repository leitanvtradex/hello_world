package com.example.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *@author<a href="mailto:lei.tan@vtradex.net">谭磊</a>
 *@since2019-01-15 22:27
 *全局捕获异常案例
 */
@RestController
public class ErrorController {

	@RequestMapping("/getUser")
	public String getUser(int i) {
		int j =1/i;
		return "success";
	}
	
	@RequestMapping("/getMember")
	public String getMember(String name,Integer age) {
		
		return "success";
	}
}
