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
<form class="layui-form" lay-filter="myform" action="../Orderdetails/insert">
</c:if>

<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Orderdetails/update">
<input type="hidden" name="id" >
</c:if>
	<div class="layui-form-item">
   	 <label class="layui-form-label">合同ID</label>
   	 <div class="layui-input-block">
    	  <input type="text" name="orderid"  autocomplete="off" placeholder="请输入" class="layui-input">
  	  </div>
 	 </div>
  <div class="layui-form-item">
    <label class="layui-form-label">产品名称</label>
    <div class="layui-input-block">
      <select name="productid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">数量</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">折扣</label>
    <div class="layui-input-block">
      <input type="text" name="desc"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注信息</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入" class="layui-input">
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
	$.post("../Orderdetails/edit",{id:id}, function(json) {
		render('myform', json);
		getlist("../Orderdetails/getProduct","[name=productid]",json.productid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getlist("../Orderdetails/getProduct","[name=productid]",0);
}

</script>
</body>
</html>