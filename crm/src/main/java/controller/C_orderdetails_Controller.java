package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.C_orderdetails;
import entity.C_product;
import service.C_orderdetails_Service;
import service.C_product_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Orderdetails")
public class C_orderdetails_Controller{
	
	@Autowired
	C_orderdetails_Service service;
	@Autowired
	C_product_Service pservice;
	
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
	public @ResponseBody String update(C_orderdetails b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(C_orderdetails b) {
		service.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody C_orderdetails edit(int id){
		return service.getByid(id);
	}

	@RequestMapping("getProduct")
	public @ResponseBody List<C_product> getProduct(){
		return pservice.getAll();
	}
}
