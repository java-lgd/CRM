package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.C_client;
import entity.C_revisit;
import service.C_client_Service;
import service.C_revisit_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Revisit")
public class C_revisit_Controller {
	
	@Autowired
	C_revisit_Service service;
	
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
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		service.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(C_revisit b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(C_revisit b) {
		service.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody C_revisit edit(int id){
		return service.getByid(id);
	}
	
	@RequestMapping("getLinkname")
	public @ResponseBody String[] getLinkname(){
		return C_revisit.links;
	}
	@RequestMapping("getClientsname")
	public @ResponseBody String[] getClientsname(){
		return C_revisit.clients;
	}
	@RequestMapping("getPurposename")
	public @ResponseBody String[] getPurposename(){
		return C_revisit.purposes;
	}
	@RequestMapping("getAssessname")
	public @ResponseBody String[] getAssessname(){
		return C_revisit.assess;
	}
	@RequestMapping("getExecname")
	public @ResponseBody String[] getExecname(){
		return C_revisit.execs;
	}
	@RequestMapping("getClient")
	public @ResponseBody  List<C_client> getClient(){
		return cservice.getAll();
	}
}
