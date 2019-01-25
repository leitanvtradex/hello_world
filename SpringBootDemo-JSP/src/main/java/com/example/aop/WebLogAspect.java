package com.example.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.comtroller.JspController;

/**
 *
 *@author<a href="mailto:lei.tan@vtradex.net">谭磊</a>
 *@since2019-01-22 21:24
 */

@Aspect
@Component
public class WebLogAspect {
	 private  static  final Logger logger =LoggerFactory.getLogger(JspController.class);
	 
	 @Pointcut("execution(public * com.example.controller.*.*(..))")
	 public void weblog() {
		 
	 }
	 /**
	  * 使用Aop的前置通知
	  *tanlei
	  *2019年1月22日 
	  *
	  */
	 @Before("weblog()")
	 public  void deBefore(JoinPoint joinPoint) throws Throwable{
		 //接收到请求,记录请求内容
		 ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		 HttpServletRequest request=attributes.getRequest();
		 //记录下请求内容
		 logger.info("URL:"+request.getRequestURI().toString());
		 logger.info("HTTP_METHOD:"+request.getMethod());
		 logger.info("IP:"+request.getRemoteAddr());
		 Enumeration<String> enu=request.getParameterNames();
		 while(enu.hasMoreElements()) {
			 String name =(String)enu.nextElement();
			 logger.info("name:{},value:{}",name,request.getParameter(name));
		 }
	 }
	 //传统写在磁盘上有很大缺点,分布式情况  服务器集群呢?20台服务器,分布式日志收集
	 
	 /**
	  * 后置通知
	  *tanlei
	  *2019年1月22日 
	  *
	  */
	 @AfterReturning(returning="ret",pointcut="weblog()")
	 public void  doAfterReturning(Object ret)throws Throwable {
		 //处理完请求,返回内容
		 logger.info("Response:"+ret);
		 
	 }
	 
	 
}
