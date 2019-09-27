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
                <form class="layui-form layui-form-pane" action="../Revisit/select">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">部门名称</label>
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

    </div>
</div>
<script src="../lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/my.js"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        var id="${param.clientid}";
        alert(id);
        table.render({
            elem: '#currentTableId',
            url: '../Revisit/select',
            cols: [[
                {type: "checkbox", width: 50, fixed: "left"},
                {field: 'clientname', width: 100, title: '客户姓名'},
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
            id:id,
            limit: 10,
            page: true
        });

        
        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    id: id
                }
            }, 'data');

            return false;
        });

      
    });
</script>
<script>

</script>

</body>
</html>