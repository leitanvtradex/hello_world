package com.example.comtroller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *@author<a href="mailto:lei.tan@vtradex.net">谭磊</a>
 *@since2019-01-15 22:37
 *全局捕获异常案例
 *1,捕获返回json格式
 *2,捕获返回页面
 */
//修改测试2
@ControllerAdvice(basePackages="com.example.comtroller")
public class GlobalExceptionHandler {
	
	   @ResponseBody//返回json格式
	   //modelAndView  返回页面
	   @ExceptionHandler(RuntimeException.class)//拦截运行时异常
       public Map<String, Object> errorJson(){
		   //实际开发中,怎么将错误记录在日志中
		   Map<String, Object> map=new HashMap<String, Object>();
		   map.put("errorcode", "500");
		   map.put("errormessage", "系统错误");
    	   return map;
       }
}
