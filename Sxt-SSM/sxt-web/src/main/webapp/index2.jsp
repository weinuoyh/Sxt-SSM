<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="/css/bootstrap-table.css" rel="stylesheet" type="text/css" media="screen"/>
    <script src="/css/bootstrap-table.js" type="text/javascript"></script>
    <![endif]-->
</head>
<body>
<h1>Hello, world!</h1>
<p class="page-title">上下文表格布局</p>
<img src="/image/logo.jpg" width="258" height="39" />

<button type="button" id="close" data-target="#ab" class="btn btn-primary" value="原始按钮">原始按钮</button>
<table class="table">
    <p>上下文表格布局</p>
    <thead>
    <tr>
        <th class="aaa" >产品</th>
        <th class="aaa" >付款日期</th>
        <th class="aaa" >状态</th></tr>
    </thead>
    <tbody>
    <tr class="active">
        <td>产品1</td>
        <td>23/11/2013</td>
        <td>待发货</td></tr>
    <tr class="success">
        <td>产品2</td>
        <td>10/11/2013</td>
        <td>发货中</td></tr>
    <tr class="warning">
        <td>产品3</td>
        <td>20/10/2013</td>
        <td>待确认</td></tr>
    <tr class="danger">
        <td>产品4</td>
        <td>20/10/2013</td>
        <td>已退货aaa</td></tr>
    </tbody>
</table>
<div class="well">
    <a href="#" id="example" class="btn btn-danger" rel="popover" data-content="It's so simple to create a tooltop for my website!" data-original-title="Twitter Bootstrap Popover">hover for popover</a>
</div>

<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>


    $(function(){
        $("#close").click(function(){
            var aaa = $("#close").val();
            alert(aaa)
        });
    });


</script>
</body>
</html>