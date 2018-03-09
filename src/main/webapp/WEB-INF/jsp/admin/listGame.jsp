<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
	$(function() {
		$("#addForm").submit(function() {
			if (!checkEmpty("name", "产品名称"))
				return false;
			if (!checkNumber("size", "类型大小"))
				return false;
			if (!checkNumber("introduce", "标题"))
				return false;
			if (!checkEmpty("gamePic", "游戏图片"))
				return false;
			return true;
		});
	});
</script>

<title>产品管理</title>

<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_game_list?cid=${c.id}">${c.name}</a></li>
		<li class="active">游戏管理</li>
	</ol>

	<div class="listDataTableDiv">
		<table
			class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th width="42px">ID</th>
					<th width="80px">图片</th>
					<th width="120px">游戏名称</th>
					<th width="120px">类型大小</th>
					<th width="500px">标题</th>
					<th width="80px">图片管理</th>
					<th width="80px">设置属性</th>
					<th width="42px">编辑</th>
					<th width="42px">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${gs}" var="g">
					<tr>
						<td>${g.id}</td>
						<td>
						<img height="40px" src="img/game/${g.id}.jpg">

						<td>${g.name}</td>
						<td>${g.size}</td>
						<td>${g.introduce}</td>
						<td><a href="admin_productImage_list?pid=${g.id}"><span
								class="glyphicon glyphicon-picture"></span></a></td>
						<td><a href="admin_propertyValue_edit?pid=${g.id}"><span
								class="glyphicon glyphicon-th-list"></span></a></td>

						<td><a href="admin_game_edit?id=${g.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a deleteLink="true" href="admin_game_delete?id=${g.id}"><span
								class="     glyphicon glyphicon-trash"></span></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp"%>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增游戏</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="admin_game_add"
				enctype="multipart/form-data">
				<table class="addTable">
				 <tr>
                     <td>游戏圖片</td>
                     <td>
                         <input id="gamePic" accept="image/*"
							type="file" name="image" />
                     </td>
                 </tr>
				
					<tr>
						<td>游戏名称</td>
						<td><input id="name" name="name" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>类型大小</td>
						<td><input id="size" name="size" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>标题</td>
						<td><input id="introduce" name="introduce" type="text"
							class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center"><input type="hidden"
							name="cid" value="${c.id}">
							<button type="submit" class="btn btn-success">提 交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>