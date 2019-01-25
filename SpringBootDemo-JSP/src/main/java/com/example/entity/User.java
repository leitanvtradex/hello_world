package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *@author<a href="mailto:lei.tan@vtradex.net">谭磊</a>
 *@since2019-01-22 21:57
 */


@Slf4j//等同于
@Getter
@Setter
public class User {
	
   private String name;
   private Integer age;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "username: "+name+"age:"+age;
	}
   //lombok底层使用字节码技术,ASM  帮你在内存中去修改字节码文件,生成getset方法
   //需要生成GetSet方法
	public static void main(String[] args) {
		User user =new User();
		user.setName("谭磊");
		user.setAge(20);
		log.info("AAA");
		System.out.println(user.toString());
		
	}
}
