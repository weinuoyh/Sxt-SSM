<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="<%=path%>/css/index2.css" type="text/css"></link>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=path%>/js/ext-all.css" />
<title>基金列表</title>
<script type="text/javascript">
	$(function(){
	$("#uid").hide();
	$("#form1").hide();
	$("#form2").hide();
	var uid= "${username}";
	alert(uid);

		//查询
		$("#cx").click(function(){
	$("#form1").show();
	$("#form2").hide();
				$.ajax({
					type:"post",
					url:"<%=path%>/money/cx.do",
					data:{uid:uid},
					dataType:"json",
					success:function(list){
					$("#cx1").append("<tr><td>基金编号</td><td>基金名称</td><td>购买金额</td><td>操作</td></tr>");
					for ( var i in list) {
					$("#cx1").append("<tr><td>"+list[i].mid+"</td><td>"+list[i].mname+"</td><td>"+list[i].bcount+"</td><td><a class='cx1' id="+list[i].id+">【撤销】</a></td></tr>");

					}
					}

				});
		});
		//撤销
		$(".cx1").live("click",function(){

			var id=$(this).attr("id");
			alert(id);
			$.ajax({
					type:"post",
					url:"<%=path%>/money/cxjj.do",
					data:{id:id},
					dataType:"json",
					success:function(obj){
					if(obj){
						alert("撤销成功");
						location.reload();
						}
						else{

						alert("撤销失败");
						location.reload();
						}
					}

				});
		});
		//购买回显
		$(".gm").click(function(){
		$("#form2").show();
		$("#form1").hide();
		var mid=$(this).attr("id");

			$.ajax({
					type:"post",
					url:"<%=path%>/money/hx.do",
					data:{mid:mid},
					dataType:"json",
					success:function(obj){
					$("[name='mid']").val(obj.mid);
					$("[name='mname']").val(obj.mname);
					$("[name='scount']").val(obj.scount);

					}

				});
		});
		//购买
 	$("#qrgm").click(function(){



			$.ajax({
					type:"post",
					url:"<%=path%>/money/add.do",
					data:$("[name='form2']").serialize(),
					dataType:"json",
					success:function(obj){
					if(obj){
						alert("购买成功");
						location.reload();
					}else{

						alert("购买失败");
						location.reload();
					}

					}

				});
		});
	//返回列表
	$("#fhlb").click(function(){
	location.reload();
	});
	});


</script>

</head>

<body>
	<center>
	<span style="font-size: 16px">欢迎${user.uname}${user.uid}用户</span>       <a>注销</a>
		<table>
			<tr>
				<td>基金编号</td>
				<td>基金名称</td>

				<td><a id="cx">查询已购基金</a></td>
			</tr>
			<c:forEach items="${list}" var="l">
			<tr>
				<td>${l.mid}</td>
				<td>${l.mname}</td>

				<td><a id="${l.mid}" class="gm">【购买】</a></td>
			</tr>
			</c:forEach>
		</table>
	</center>
	<form id="form1">
		<table id="cx1">

		</table>
	</form>
	<form name="form2" id="form2">
		<table>
			<tr><td><input type="hidden" name="uid" value="${user.uid}"></td></tr>
			<tr><td>用户名</td><td><input type="text" name="uname" value="${user.uname}"></td></tr>
			<td><input type="hidden" name="mid" ></td></tr>
			<tr><td>基金名称</td><td><input type="text" name="mname" ></td></tr>
			<tr><td>剩余金额</td><td><input type="text" name="scount" value=""></td></tr>
			<tr><td>购买金额</td><td><input type="text" name="bcount" value=""></td></tr>
			<tr><td colspan="11"><input type="button"  value="确认购买" id="qrgm"><input type="button"  value="返回列表" id="fhlb"></td></tr>
		</table>

	</form>
</body>
</html>
