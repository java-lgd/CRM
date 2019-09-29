<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

	<script type="text/html" id="currentTableBar">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs" lay-event="reserved">添加预约</a>
	</script>
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container">
			<input type="hidden" name="clientid">
			<button class="layui-btn layui-btn-sm" lay-event="search">刷新</button>
    		<button class="layui-btn layui-btn-sm" lay-event="add">添加回访</button>
 		 </div>
	</script>
    </div>
</div>
<script src="../lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/my.js"></script>
<script>

	var clientid = "${param.clientid}";
	
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url : '../Revisit/select?clientid='+clientid,
            toolbar : '#toolbarDemo',
            height:450,
            cols: [[
                {field: 'clientname', width: 100, title: '客户姓名'},
                {field: 'date', width: 100, title: '时间'},
                {field: 'linkname', width: 100, title: '联通状态'},
                {field: 'clientsname', width: 100, title: '客户状态'},
                {field: 'purposename', width: 100, title: '意向状态'},
                {field: 'assessname', width: 100, title: '评估状态'},
                {field: 'execname', width: 100, title: '处理状态'},
                {field: 'askinfo', width: 100, title: '询问状况'},
                {field: 'followinfo', width: 100, title: '跟进措施'},
                {field: 'probleminfo', width: 100, title: '客户顾虑'},
                {field: 'status', width: 100, title: '状态'},
                {field: 'comments', width: 100, title: '备注'},
                {title: '操作', minWidth: 150, templet: '#currentTableBar', fixed: "right", align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var txt = $('#seach');
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    txt: txt.val()
                }
            }, 'data');
            return false;
        });

        // 监听添加操作
        $(".data-add-btn").on("click", function () {
            openFrame("editor8.jsp");
        });

        // 监听删除操作
        $(".data-delete-btn").on("click", function () {
            var checkStatus = table.checkStatus('currentTableId')
                , data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
            	openFrame('revisit_edit.jsp?id='+data.id);
            }
            if(obj.event === 'reserved') { ///lay-event 属性
            	openFrame('reserved_edit.jsp?revisitid=' + data.id+'&clientid=' + data.clientid +'&clientname=' + data.clientname,"添加预约");
			} 
        });
        
        table.on('toolbar(currentTableFilter)', function(obj) {
			var data = obj.data;
			if (obj.event === 'search') {
				reload('currentTableId', {});
			}
			if (obj.event === 'add') {
            	openFrame("revisit_add.jsp?clientid="+clientid,"添加回访");
            }
		});

    });
</script>
<script>

</script>

</body>
</html>