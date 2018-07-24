package com.example.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@SpringBootApplication
public class JenkinsApplication {
	public static void main(String[] args) {
		SpringApplication.run(JenkinsApplication.class, args);
	}

	/**
	 * 测试环境变量
	 */
	@RequestMapping("/GetVar")
	@ResponseBody
	public String getVar(){
		String one = System.getenv("one");
		if(one==null||"".equals(one)){
			one="没有找到one值";
		}
		return "one的变量值:"+one;
	}

	/**
	 * 提供给netCore调用
	 * @return
	 */
	@RequestMapping("/GetString")
	@ResponseBody
	public String getStr(){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "java调用结果：" + LocalDateTime.now().format(fmt);
	}

	/**
	 * 请求netCore,获取返回值
	 * @return
	 */
	@RequestMapping("/GetNet")
	@ResponseBody
	public String getNet(){
		return "请求netCore结果：" + new RestTemplate().getForObject("Http://netcore",String.class);
	}

}
