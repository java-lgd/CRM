package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import entity.C_client;
import entity.C_operator;
import entity.C_order;
import service.C_client_Service;
import service.C_operator_Service;
import service.C_order_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Order")
public class C_order_Controller {
	
	@Autowired
	C_order_Service service;
	@Autowired
	C_operator_Service oservice;
	@Autowired
	C_client_Service cservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		String lim = info.getLimit(page, limit);
		info.setData(service.getWhere(where, lim));
		info.setCount(service.getSize(where));
		return info;
	}
	
	@RequestMapping("table4")
	public @ResponseBody ReturnInfo table4(Integer page,Integer limit,HttpServletRequest request,HttpSession session) {
		ReturnInfo info = new ReturnInfo();
		C_operator user = (C_operator) session.getAttribute("user");
		System.out.println(user.getName());
//		C_operator user = (C_operator) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(true).getAttribute("User");
//		System.out.println(user);
		String where = " WHERE C_order.status=1 and C_order.compoperatornames like '%"+user.getName()+"%' and C_order.compoperatorids like '%"+user.getId()+"%'";
		String lim = info.getLimit(page, limit);
		info.setData(service.getTable4(where,lim));
		info.setCount(service.getSize(where));
		return info;
	}
	
	
	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
  
		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"\\upload";
		System.out.println(path);
		file.transferTo(new File(path,nname));
		return "\\upload\\"+nname;
	}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		service.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(C_order b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(C_order b) {
		service.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody C_order edit(int id){
		return service.getByid(id);
	}
	
	@RequestMapping("getStatusname")
	public @ResponseBody String[] getStatusname(){
		return C_order.statuses;
	}

	@RequestMapping("getOperator")
	public @ResponseBody  List<C_operator> getOperator(){
		return oservice.getAll();
	}
	@RequestMapping("getClient")
	public @ResponseBody  List<C_client> getClient(){
		return cservice.getAll();
	}
}
