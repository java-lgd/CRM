<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
</head>
<body>
	<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layuimini-search">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="../Client/table">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input id="seach" type="text" name="name" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

<table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
<script type="text/html" id="currentTable">
        <div class="layui-btn-group">
            <button class="layui-btn layui-btn-sm data-add-btn">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="import">批量导入</button>
			<button class="layui-btn layui-btn-sm enjoy" lay-event="enjoy">批量分配</button>
        </div>
</script>
        
        <script type="text/html" id="currentTableBar">
			<a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit1">修改</a>
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">分配</a>
        </script>
    </div>
</div>
<script src="../lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/my.js"></script>
<script>
    layui.use(['form', 'table','upload'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;
        var upload = layui.upload;
        
        table.render({
            elem: '#currentTableId',
            height:350,
            url: '../Client/table',
            toolbar:'#currentTable',
            cols: [[
                {type: "checkbox", width: 50, fixed: "left"},
                {field: 'name', width: 100, title: '姓名'},
                {field: 'sexname', width: 100, title: '性别'},
                {field: 'tel', width: 100, title: '电话'},
                {field: 'qq', width: 100, title: 'QQ'},
                {field: 'email', width: 100, title: 'email'},
                {field: 'infos', width: 100, title: '其他信息'},
                {field: 'linkname', width: 100, title: '联通状态'},
                {field: 'clientsname', width: 100, title: '客户状态'},
                {field: 'purposename', width: 100, title: '意向状态'},
                {field: 'assessname', width: 100, title: '评估状态'},
                {field: 'execname', width: 100, title: '处理状态'},
                {field: 'statusname', width: 100, title: '状态'},
                {field: 'clientname', width: 100, title: '客户类型'},
                {field: 'operatornames', width: 100, title: '处理人'},
                {field: 'operatorname', width: 100, title: '创建人'},
                {field: 'createdate', width: 100, title: '创建时间'},
                {field: 'srcid', width: 100, title: '来源'},
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
            openFrame("customer_add.jsp");
        });

        table.on('toolbar(currentTableFilter)', function(obj) {
			var data = obj.data;
			if (obj.event === 'enjoy') {
				var checkStatus = table.checkStatus("currentTableId");
				var str="";
				for(var i=0;i<checkStatus.data.length;i++){
					str+=checkStatus.data[i].id+","	
				}
				openFrame('edit.jsp?str='+str);
			}
			if (obj.event === 'import') {
            	openFrame('clientimport.html');
            }
		});
        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
        	
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data; 
            if (obj.event === 'edit') {
            	openFrame('customer_fenpei.jsp?id='+data.id);
            }if (obj.event === 'edit1') {
            	openFrame('customer_editor.jsp?id='+data.id);
            }
           
        });
        
    });
   
</script>
</body>
</html>