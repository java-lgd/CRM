package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.C_operator;
import entity.C_workgroup;
import service.C_operator_Service;
import service.C_workgroup_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Operator")
public class C_operator_Controller {
	
	@Autowired
	C_operator_Service service;
	@Autowired
	C_workgroup_Service gservice;
	
	@RequestMapping("login")
	public @ResponseBody String login(C_operator u,/*String code,*/ ModelMap m, HttpSession s) {
/*		String num = s.getAttribute("number").toString();
		if (!num.equalsIgnoreCase(code)) {
			System.out.println("验证码错误");
			return "{\"status\":0}";
		}
		C_operator u=new C_operator(tel,pass);*/
		System.out.println(u.getTel()+"--"+u.getPass());
		try {
//			SecurityUtils.getSubject().getSession().setTimeout(10000);
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getTel(),u.getPass()));
		}catch (Exception e) {
			System.out.println("用户错误");
			return "{\"status\":0}";
		} 
		System.out.println("登录成功");
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		if(txt!=null)
			where = " where C_operator.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setData(service.getWhere(where, lim));
		info.setCount(service.getSize(where));
		return info;
	}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		service.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(C_operator b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(C_operator b) {
		service.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody C_operator edit(int id){
		return service.getByid(id);
	}
	
	@RequestMapping("getPowers")
	public @ResponseBody String[] getPowers(){
		return C_operator.powers;
	}
	
	@RequestMapping("getStatusname")
	public @ResponseBody String[] getStatusname(){
		return C_operator.statuses;
	}
	
	@RequestMapping("getGroups")
	public @ResponseBody  List<C_workgroup> getGroups(){
		return gservice.getAll();
	}
}
