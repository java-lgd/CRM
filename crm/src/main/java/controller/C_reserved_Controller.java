package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.C_client;
import entity.C_clienttype;
import entity.C_operator;
import entity.C_reserved;
import service.C_client_Service;
import service.C_operator_Service;
import service.C_reserved_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Reserved")
public class C_reserved_Controller {
	
	@Autowired
	C_reserved_Service service;
	@Autowired
	C_client_Service cservice;
	@Autowired
	C_operator_Service oservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
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
	public @ResponseBody String update(C_reserved b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(C_reserved b) {
		service.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody C_reserved edit(int id){
		return service.getByid(id);
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody String[] getTypes(){
		return C_reserved.types;
	}
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus(){
		return C_reserved.statuses;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus(){
		return C_reserved.execstatuses;
	}
	
	@RequestMapping("getClient")
	public @ResponseBody  List<C_client> getClient(){
		return cservice.getAll();
	}
	@RequestMapping("getOperator")
	public @ResponseBody  List<C_operator> getOperator(){
		return oservice.getAll();
	}
	@RequestMapping("getExecoperator")
	public @ResponseBody  List<C_operator> getExecoperator(){
		return oservice.getAll();
	}

}
