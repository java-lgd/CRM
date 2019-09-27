package controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.fabric.xmlrpc.base.Data;

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
@Scope(scopeName = "session")
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
	
	@RequestMapping("list") //文件上传后的对象集合返回显示
	@ResponseBody
	public ReturnInfo list() {
		return new ReturnInfo(list);
	}
	
	@RequestMapping("save")//选择新客户写入数据库
	@ResponseBody
	public String save(String ids) {
		System.out.println(ids);
		for(int i=0;i<list.size();i++) {
			String id=","+list.get(i).getId()+",";
			if(ids.indexOf(id)<0)  continue;
			service.insert(list.get(i));
			list.get(i).setUploadstatus(1);
		}
		return "{\"status\":1}";
	}

	@RequestMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,HttpSession session) {
		list = new Vector<C_client>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
		C_operator user = (C_operator) session.getAttribute("user");
		try {
			InputStream input = file.getInputStream();
			Workbook wb = new HSSFWorkbook(input);
			Sheet sheet = wb.getSheetAt(0);
			int rowNum = sheet.getLastRowNum() + 1;
			for (int i = 1; i < rowNum; i++) {
				C_client t = new C_client();
				Row row = sheet.getRow(i);

				// 容器名称
				Cell containerCell = row.getCell(0);
				String val = containerCell.getStringCellValue();
				Cell containerCell1 = row.getCell(1);
				int val1 = (int) containerCell1.getNumericCellValue();
				Cell containerCell2 = row.getCell(2);
				String val2 = containerCell2.getStringCellValue();
				Cell containerCell3 = row.getCell(3);
				String val3 = containerCell3.getStringCellValue();
				Cell containerCell4 = row.getCell(4);
				String val4 = containerCell4.getStringCellValue();
				Cell containerCell5 = row.getCell(5);
				String val5 = containerCell5.getStringCellValue();
				Cell containerCell6 = row.getCell(6);
				int val6 = (int) containerCell6.getNumericCellValue();
				Cell containerCell7 = row.getCell(7);
				int val7 = (int) containerCell7.getNumericCellValue();
				t.setName(val);
				t.setSex(val1);
				t.setTel(val2);
				t.setQq(val3);
				t.setEmail(val4);
				t.setInfos(val5);
				t.setClienttypeid(val6);
				t.setSrcid(val7);
				t.setId(i-1);
				t.setCreatedate(date);
				t.setCreateoperatorid(user.getId());
				t.setCount(0);
				list.add(t);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit,HttpSession session) {
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
			String where = "where C_client.name like '%%' ";
			if(txt!=null)
				where = " where C_client.name like '%"+txt+"%' ";
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
	
	@RequestMapping("update1")
	public @ResponseBody String update1(String str,String operatorids,String operatornames) {
		String[] strs=str.split(",");
		int[] ints = new int[strs.length];
		for(int i=0;i<strs.length;i++){
		     ints[i] = Integer.parseInt(strs[i]);
		}
		for(int i=0;i<ints.length;i++) {
			service.update1(ints[i],operatorids,operatornames);
		}
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
