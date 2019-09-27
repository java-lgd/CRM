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
                <form class="layui-form layui-form-pane" action="../Client/table1">
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
        <script type="text/html" id="currentTableBar">
			<a class="layui-btn layui-btn-xs data-count-edit" lay-event="info">客户信息</a>
			<a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit1">记录回访</a>
        </script>
    </div>
</div>
<script src="../lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/my.js"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            height:350,
            url: '../Client/table1',
            cols: [[
                {type: "checkbox", width: 50, fixed: "left"},
                {field: 'name', width: 100, title: '姓名'},
                {field: 'sexname', width: 100, title: '性别'},
                {field: 'tel', width: 150, title: '电话'},
                {field: 'qq', width: 150, title: 'QQ'},
                {field: 'email', width: 150, title: 'email'},
                {field: 'srcname', width: 100, title: '来源'},
                {title: '操作', minWidth: 200, templet: '#currentTableBar', fixed: "right", align: "center"}
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
            openFrame("editor1.jsp");
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
            if (obj.event === 'edit1') {
            	openFrame('revisit-list.jsp?clientid='+data.id);
            }
            if (obj.event === 'info') {
            	openFrame('customer_look.jsp?id='+data.id);
            }else if (obj.event === 'delete') {
                myconfirm('是否删除？', function () {
                    $.post("../Client/delete", {id : data.id}, 
							function(json) {
								reload('currentTableId');
								layer.close(layer.index);
						}, "json");
                });
            }
        });

    });
</script>
</body>
</html>