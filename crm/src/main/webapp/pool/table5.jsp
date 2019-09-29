<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
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
                <form class="layui-form layui-form-pane" action="../Reserved/index">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input id="seach" type="text" name="name" autocomplete="off" class="layui-input">
                            </div>
			<label class="layui-form-label">活动时间</label>
				<div class="layui-input-inline">
						<input type="text" id="start_time" name="start_time" autocomplete="off" placeholder="请输入开始时间" class="layui-input">
				</div>
				<div class="layui-input-inline">
						<input type="text" id="end_time" name="end_time" autocomplete="off" placeholder="请输入结束时间" class="layui-input">
				</div>
			</div>
                        
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                        </div>
                    </div>
                </form>
            </div>
            
            
        </fieldset>

        <div class="layui-btn-group">
            <button class="layui-btn data-add-btn">批量操作</button>
        </div>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
			<a class="layui-btn layui-btn-xs data-count-edit" lay-event="info">客户信息</a>
			<a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit1">回访记录</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">转公共池</a>
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
            url: '../Reserved/table5',
            cols: [[
                {type: "checkbox", width: 50, fixed: "left"},
                {field: 'clientname', width: 120, title: '客户姓名'},
                {field: 'createdate', width: 120, title: '创建日期'},
                {field: 'operator', width: 120, title: '创建人'},
                {field: 'date', width: 120, title: '预约时间'},
                {field: 'execoperator', width: 100, title: '预约处理人'},
                {field: 'typename', width: 100, title: '预约类型'},
                {field: 'statusname', width: 100, title: '处理状态'},
                {field: 'execstatusname', width: 100, title: '执行状态'},
                {field: 'result', width: 100, title: '结果'},
                {title: '操作', minWidth: 300, templet: '#currentTableBar', fixed: "right", align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var txt = $('#seach');
            var start_time = $('#start_time');
            var end_time = $('#end_time');
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    txt: txt.val(),
                    start_time:start_time.val(),
                    end_time:end_time.val()
                }
            }, 'data');

            return false;
        });

        // 监听添加操作
        $(".data-add-btn").on("click", function () {
            openFrame("editor9.jsp");
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
            	openFrame('revisit-list.jsp?clientid='+data.clientid,"回访记录");
            } 
            if (obj.event === 'info') {
            	openFrame('customer_look.jsp?id='+data.clientid,"客户信息");
            }else if (obj.event === 'delete') {
            	openFrame('customer_fenpei2.jsp?id='+data.clientid,"转公共池");
            }
        });

    });
</script>
<script>

layui.use('laydate', function() {
	var laydate = layui.laydate;

	//常规用法
	laydate.render({
		elem : '#start_time'
	});
	laydate.render({
		elem : '#end_time'
	});
});
</script>

</body>
</html>