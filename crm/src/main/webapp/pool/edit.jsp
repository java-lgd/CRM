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
<script type="text/javascript" src="../js/table.js"></script>


<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>

<c:if test="${param.str!=null}">
	<form class="layui-form" lay-filter="myform" action="../Client/updata1">
 	<input type="hidden" name="str" value="${param.str}">
</c:if>
<c:if test="${param.id!=null}">
	<form class="layui-form" lay-filter="myform" action="../Client/updata">
 	<input type="hidden" name="str" value="${param.id}">
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
    	<input type="hidden" name="operatorids">
		<input type="text" name="operatornames" autocomplete="off" placeholder="请选择" class="layui-input" id="demo">   
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript" src="../js/lay-module/tableSelect/tableSelect.js"></script>
<script type="text/javascript">

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#test1',
	    trigger: 'click'
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

var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#demo',	//定义输入框input对象
	checkedKey: 'id' ,//表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'../Operator/index',
		height:200,
		cols: [[
			{type: "checkbox"},
			{field: 'id', width: 200, title: 'ID'},
            {field: 'name', width: 200, title: '姓名'},
            {field: 'tel', width: 180, title: '电话'},
            {field: 'groupname', width: 180, title: '组名'}
		]],
		parseData:function(res){
			return{

				"count":res.count,
				"code":res.code,
				"msg":res.msg,
				data:res.data
			}
		}
	},
	done: function (elem, data) {
	//选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
	//拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
	var NEWJSON = []
	var NEWJSON1 = []
	layui.each(data.data,function(index,item){
		NEWJSON.push(item.name)
		NEWJSON1.push(item.id)
	})
	elem.val(NEWJSON.join(","))
	$("[name=operatorids]").val(NEWJSON1.join(","));
	}
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
	getarray("../Client/getSexname","[name=sex]",-1);
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