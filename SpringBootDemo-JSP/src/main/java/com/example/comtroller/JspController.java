package com.example.comtroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *@author<a href="mailto:lei.tan@vtradex.net">谭磊</a>
 *@since2019-01-15 21:58
 *这是jsp整合springboot
 */

@Controller
public class JspController {
    @RequestMapping("/jspindex")
	 public String index() {
		
		
		return "index";
	}
}
