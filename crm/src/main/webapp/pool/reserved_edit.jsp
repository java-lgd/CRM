<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../lib/layui-v2.5.4/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui-v2.5.4/layui.all.js"></script>
<script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/my.js"></script>

<title></title>
</head>
<body>
	<style>
.layui-input {
	width: 200px;
}
</style>

		<form class="layui-form" lay-filter="myform"
			action="../Reserved/insert">

		<div class="layui-form-item" style="display:none;">
		<label class="layui-form-label">回访ID</label>
		<div class="layui-input-block">
			<input type="text" name="revisitid" autocomplete="off"
				readonly="readonly" class="layui-input" value="${param.revisitid}">
		</div>
		</div>

		<div class="layui-form-item">
		<div class="layui-inline">
   
			<label class="layui-form-label">客户姓名</label>
			<div class="layui-input-block">
				<select name="clientid" disabled="disabled">
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">创建日期</label>
			<div class="layui-input-block">
				<input type="text" name="createdate" readonly="readonly" class="layui-input" id="test1"
					placeholder="yyyy-MM-dd">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">创建人</label>
			<div class="layui-input-block">
				<select name="operatorid" disabled="disabled">
				</select>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">预约时间</label>
			<div class="layui-input-block">
				<input type="text" name="date" class="layui-input" id="test2"
					placeholder="yyyy-MM-dd">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">预约处理人</label>
			<div class="layui-input-block">
				<select name="execoperatorid">
				</select>
			</div>
		</div>

		<div class="layui-inline">
			<label class="layui-form-label">预约类型</label>
			<div class="layui-input-block">
				<select name="type">
				</select>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">处理状态</label>
			<div class="layui-input-block">
				<select name="status">
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">执行状态</label>
			<div class="layui-input-block">
				<select name="execstatus">
				</select>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">结果</label>
			<div class="layui-input-block">
				<textarea type="text" name="result" autocomplete="off"
					placeholder="请输入" class="layui-textarea"></textarea>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
			</div>
		</div>
		</form>

		<script type="text/javascript">
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//常规用法
				laydate.render({
					elem : '#test1'
				});
				laydate.render({
					elem : '#test2'
				});
			});
			var clientid = "${param.clientid}";
			layui.use([ 'form', ], function() {
				var form = layui.form;
				form.on('submit(demo1)', function(data) {
					$.post($("form").attr("action"), data.field,
							function(json) {
								closeFrame();
								parent.fresh('demo');
							}, "json");
					return false;
				});
			});

			if (clientid.length > 0) {
				getarray("../Reserved/getTypes", "[name=type]", 0);
				getarray("../Reserved/getStatus", "[name=status]", 0);
				getarray("../Reserved/getExecstatus", "[name=execstatus]", 0);
				getlist("../Reserved/getClient", "[name=clientid]", clientid);
				getlist("../Reserved/getOperator", "[name=operatorid]", 0);
				getlist("../Reserved/getExecoperator", "[name=execoperatorid]",
						0);
			} 
		</script>
</body>
</html>