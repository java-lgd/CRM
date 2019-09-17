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

<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" action="../Client/insert">
</c:if>

<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Client/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
     <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  <div class="layui-form-item">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input type="text" name="tel"  autocomplete="off" placeholder="请输入电话" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
      <input type="text" name="qq"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">email</label>
    <div class="layui-input-block">
      <input type="text" name="email"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">其他信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">联通状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="execstatus" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户类型</label>
    <div class="layui-input-block">
      <select name="clienttypeid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
		 <input type="text" name="operatorids"  autocomplete="off" placeholder="请输入密码" class="layui-input">   
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
			<select name="createoperatorid" >
     	 </select>  
     </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">创建时间</label>
    <div class="layui-input-block">
      <input type="text" name="createdate"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">来源</label>
    <div class="layui-input-block">
      <select name="srcid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">回访次数</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">

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
	$.post("../Client/edit",{id:id}, function(json) {
		render('myform', json);
		getarray("../Client/getSexname","[name=sex]",json.sex);
		getarray("../Client/getStatusname","[name=status]",json.status);
		getarray("../Client/getLinkname","[name=linkstatus]",json.linkstatus);
		getarray("../Client/getClientsname","[name=clientstatus]",json.clientstatus);
		getarray("../Client/getPurposename","[name=purposestatus]",json.purposestatus);
		getarray("../Client/getAssessname","[name=assessstatus]",json.assessstatus);
		getarray("../Client/getExecname","[name=execstatus]",json.execstatus);
		getlist("../Client/getTypes","[name=clienttypeid]",json.clienttypeid);
		getlist("../Client/getOperator","[name=createoperatorid]",json.createoperatorid);
		getlist("../Client/getSrc","[name=srcid]",json.srcid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Client/getStatusname","[name=status]",0);
	getarray("../Client/getLinkname","[name=linkstatus]",0);
	getarray("../Client/getClientsname","[name=clientstatus]",0);
	getarray("../Client/getPurposename","[name=purposestatus]",0);
	getarray("../Client/getAssessname","[name=assessstatus]",0);
	getarray("../Client/getExecname","[name=execstatus]",0);
	getlist("../Client/getTypes","[name=clienttypeid]",0);
	getlist("../Client/getOperator","[name=createoperatorid]",0);
	getlist("../Client/getSrc","[name=srcid]",0);
}

</script>
</body>
</html>