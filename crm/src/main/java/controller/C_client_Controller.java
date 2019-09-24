package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.C_client;
import entity.C_clienttype;
import entity.C_operator;
import entity.C_src;
import service.C_client_Service;
import service.C_clienttype_Service;
import service.C_operator_Service;
import service.C_src_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Client")
public class C_client_Controller {
	
	@Autowired
	C_client_Service service;
	@Autowired
	C_clienttype_Service cservice;
	@Autowired
	C_operator_Service oservice;
	@Autowired
	C_src_Service sservice;
	
	List<C_client> list = new ArrayList<C_client>();
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		if(txt!=null)
			where = " where C_client.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setData(service.getWhere(where, lim));
		info.setCount(service.getSize(where));
		return info;
	}
	
	//未分配
	@RequestMapping("table")
	public @ResponseBody ReturnInfo table(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "where C_client.name like '%%'";
		if(txt!=null)
			where = " where C_client.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setData(service.getTable(where, lim));
		info.setCount(service.getSize(where));
		return info;
	}
	
	//新分配
	@RequestMapping("table1")
	public @ResponseBody ReturnInfo table1(String txt,Integer page,Integer limit,HttpServletRequest request,HttpSession session) {
		ReturnInfo info = new ReturnInfo();
		C_operator user = (C_operator) session.getAttribute("user");
		System.out.println(user);
		String where = "where C_client.name like '%%' and C_client.operatorids like '%"+user.getId()+"%' and C_client.operatornames like '%"+user.getName()+"%'";
		if(txt!=null)
			where = " where C_client.name like '%"+txt+"%' and C_client.operatorids like '%"+user.getId()+"%' and C_client.operatornames like '%"+user.getName()+"%'";
		String lim = info.getLimit(page, limit);
		info.setData(service.getTable1(where, lim));
		info.setCount(service.getSize(where));
		return info;
	}
	
	//公共池
	@RequestMapping("table6")
	public @ResponseBody ReturnInfo table6(String txt,Integer page,Integer limit) {
			ReturnInfo info = new ReturnInfo();
			String where = "where C_client.name like '%%'";
			if(txt!=null)
				where = " where C_client.name like '%"+txt+"%'";
			String lim = info.getLimit(page, limit);
			info.setData(service.getTable6(where, lim));
			info.setCount(service.getSize(where));
			return info;
		}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		service.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(C_client b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(C_client b) {
		service.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody C_client edit(int id){
		return service.getByid(id);
	}
	
	@RequestMapping("getSexname")
	public @ResponseBody String[] getSexname(){
		return C_client.sexs;
	}
	@RequestMapping("getStatusname")
	public @ResponseBody String[] getStatusname(){
		return C_client.statuses;
	}
	@RequestMapping("getLinkname")
	public @ResponseBody String[] getLinkname(){
		return C_client.links;
	}
	@RequestMapping("getClientsname")
	public @ResponseBody String[] getClientsname(){
		return C_client.clients;
	}
	@RequestMapping("getPurposename")
	public @ResponseBody String[] getPurposename(){
		return C_client.purposes;
	}
	@RequestMapping("getAssessname")
	public @ResponseBody String[] getAssessname(){
		return C_client.assess;
	}
	@RequestMapping("getExecname")
	public @ResponseBody String[] getExecname(){
		return C_client.execs;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody  List<C_clienttype> getTypes(){
		return cservice.getAll();
	}
	@RequestMapping("getOperator")
	public @ResponseBody  List<C_operator> getOperator(){
		return oservice.getAll();
	}
	@RequestMapping("getSrc")
	public @ResponseBody  List<C_src> getSrc(){
		return sservice.getAll();
	}

}
