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
<form class="layui-form" lay-filter="myform" action="../Order/insert">
</c:if>

<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Order/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <select name="clientid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">创建时间</label>
    <div class="layui-input-block">
    <input type="text" name="createdate" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">业绩时间</label>
    <div class="layui-input-block">
    <input type="text" name="compdate" class="layui-input" id="test2" placeholder="yyyy-MM-dd">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">合同时间</label>
    <div class="layui-input-block">
    <input type="text" name="orderdate" class="layui-input" id="test3" placeholder="yyyy-MM-dd">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">起始时间</label>
    <div class="layui-input-block">
    <input type="text" name="startdate" class="layui-input" id="test4" placeholder="yyyy-MM-dd">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">截止时间</label>
    <div class="layui-input-block">
    <input type="text" name="enddate" class="layui-input" id="test5" placeholder="yyyy-MM-dd">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">操作员</label>
    <div class="layui-input-block">
      <select name="operatorid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="info"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">文件</label>
    <div class="layui-input-block">
      <input type="text" name="files"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">业绩人员</label>
    <div class="layui-input-block">
    	<input type="hidden" name="compoperatorids">
		<input type="text" name="compoperatornames" readonly="readonly" autocomplete="off" placeholder="请输入" class="layui-input" id="demo">   
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">业绩权重</label>
    <div class="layui-input-block">
      <input type="text" name="compweight"  autocomplete="off" placeholder="请输入" class="layui-input">
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
    <label class="layui-form-label">总金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
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

<script type="text/javascript" src="../js/lay-module/tableSelect/tableSelect.js"></script>
<script type="text/javascript">

var id="${param.id}";

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#test1',
	    trigger: 'click'
	  });
	  
	  laydate.render({
		elem: '#test2',
	    trigger: 'click'
	  });
	  
	  laydate.render({
		elem: '#test3',
	    trigger: 'click'
	  });
	  laydate.render({
		elem: '#test4',
	    trigger: 'click'
	  });
	  laydate.render({
		elem: '#test5',
	    trigger: 'click'
	  });
});

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
	$("[name=compoperatorids]").val(NEWJSON1.join(","));
	}
});

function init(){
	$.post("../Order/edit",{id:id}, function(json) {
		render('myform', json);
		getarray("../Order/getStatusname","[name=status]",json.status);
		getlist("../Order/getOperator","[name=operatorid]",json.operatorid);
		getlist("../Order/getClient","[name=clientid]",json.clientid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Order/getStatusname","[name=status]",0);
	getlist("../Order/getOperator","[name=operatorid]",0);
	getlist("../Order/getClient","[name=clientid]",0);
}

</script>
</body>
</html>