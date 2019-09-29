<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>基本资料</title>
<link href="../lib/layui-v2.5.4/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui-v2.5.4/layui.all.js"></script>
<script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>
    <style>
        .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
    </style>
</head>
<body>
<form class="layui-form" lay-filter="myform" action="../Operator/update">
	<input type="hidden" name="id" >
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" lay-verify="required" lay-reqtext="管理账号不能为空" autocomplete="off" placeholder="请输入名称" class="layui-input">
      <tip>填写自己管理账号的名称。</tip>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input type="text" name="tel" lay-verify="required" lay-reqtext="手机不能为空" autocomplete="off" placeholder="请输入电话" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item" style="display:none;">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="text" name="pass"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">组别</label>
    <div class="layui-input-block">
      <select name="groupid" >
      </select>
    </div>
  </div>
   <div class="layui-form-item" style="display:none;">
    <label class="layui-form-label">权限</label>
    <div class="layui-input-block">
      <select name="power" >
      </select>
    </div>
  </div>
  <div class="layui-form-item" style="display:none;">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status">
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>
<script type="text/javascript">
	var id="${user.id}";
	var name="${user.name}";
	var groupid="${user.groupid}";
	var power="${user.power}";
	var status="${user.status}";
	
	
	layui.use(['form','layer'], function(){
		  var form = layui.form,
		  	layer = layui.layer;
		  form.on('submit(demo1)', function(data){
			 $.post($("form").attr("action"), data.field, function(json) {
				 /* location.href = "../index.html"; */
				 parent.layer.close(parent.layer.getFrameIndex(window.name));
				}, "json");
			    return false;
			  });
	});

	function init(){
		$.post("../Operator/edit",{id:id}, function(json) {
			render('myform', json);
			getarray("../Operator/getPowers","[name=power]",json.power);
			getlist("../Operator/getGroups","[name=groupid]",json.groupid);
			getarray("../Operator/getStatusname","[name=status]",json.status);
		},"json");
		
	}
	if(id.length>0){
		init();
	}else{
		getarray("../Operator/getPowers","[name=power]",0);
		getlist("../Operator/getGroups","[name=groupid]",0);
		getarray("../Operator/getStatusname","[name=status]",0);
	}
</script>
</body>
</html>