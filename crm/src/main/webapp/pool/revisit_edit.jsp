<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../lib/layui-v2.5.4/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui-v2.5.4/layui.all.js"></script>
<script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>

<form class="layui-form" lay-filter="myform" action="../Revisit/update">
	<input type="hidden" name="id" value="${param.id}">
     <div class="layui-form-item">
     <div class="layui-inline">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <select name="clientid" disabled="disabled">
      </select>
    </div>
    </div>
    
    <div class="layui-inline">
			<label class="layui-form-label">日期</label>
			<div class="layui-input-block">
				<input type="text" name="date" class="layui-input" id="test1"
					placeholder="yyyy-MM-dd">
			</div>
		</div>
  
   <div class="layui-inline">
    <label class="layui-form-label">联通状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatus" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatus" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="execstatus">
      </select>
    </div>
  </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">询问状况</label>
    <div class="layui-input-block">
		 <textarea type="text" name="askinfo"  autocomplete="off" placeholder="请输入" class="layui-textarea"> </textarea>  
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">跟进措施</label>
    <div class="layui-input-block">
		 <textarea type="text" name="followinfo"  autocomplete="off" placeholder="请输入" class="layui-textarea">   </textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户顾虑</label>
    <div class="layui-input-block">
     <textarea type="text" name="probleminfo" autocomplete="off" placeholder="请输入" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
    <select name="status" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <textarea type="text" name="comments"   autocomplete="off" placeholder="请输入" class="layui-textarea"></textarea>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	  });
});

var id="${param.id}";

layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    return false;
		  });
});

function init(){
	$.post("../Revisit/edit",{id:id}, function(json) {
		render('myform', json);
		getarray("../Revisit/getLinkname","[name=linkstatus]",json.linkstatus);
		getarray("../Revisit/getClientsname","[name=clientstatus]",json.clientstatus);
		getarray("../Revisit/getPurposename","[name=purposestatus]",json.purposestatus);
		getarray("../Revisit/getAssessname","[name=assessstatus]",json.assessstatus);
		getarray("../Revisit/getExecname","[name=execstatus]",json.execstatus);
		getlist("../Revisit/getClient","[name=clientid]",json.clientid);
		getlist("../Revisit/getStatusname","[name=status]",json.status);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Revisit/getLinkname","[name=linkstatus]",0);
	getarray("../Revisit/getClientsname","[name=clientstatus]",0);
	getarray("../Revisit/getPurposename","[name=purposestatus]",0);
	getarray("../Revisit/getAssessname","[name=assessstatus]",0);
	getarray("../Revisit/getExecname","[name=execstatus]",0);
	getlist("../Revisit/getClient","[name=clientid]",clientid);
	getlist("../Revisit/getStatusname","[name=status]",0);
}

</script>
</body>
</html>