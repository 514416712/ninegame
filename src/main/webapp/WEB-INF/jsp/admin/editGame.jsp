<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>编辑分类</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
            return true;
        });
    });

</script>

<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		 <li><a href="admin_game_list?cid=${g.category.id}">${g.category.name}</a></li>
        <li class="active">${g.name}</li>
        <li class="active">游戏属性编辑</li>
	</ol>

	<div class="panel panel-warning editDiv">
		<div class="panel-heading">编辑分类</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_game_update" >
				<table class="editTable">
				
					<tr>
						<td>游戏名称</td>
						<td><input id="name" name="name" type="text" value="${g.name}" 
							class="form-control"></td>
					</tr>
					<tr>
						<td>类型大小</td>
						<td><input id="size" name="size" type="text" value="${g.size}" 
							class="form-control"></td>
					</tr>
					<tr>
						<td>标题</td>
						<td><input id="introduce" name="introduce" type="text" value="${g.introduce}" 
							class="form-control"></td>
					</tr>
					
					<tr class="submitTR">
						<td colspan="2" align="center"><input type="hidden"
							name="cid" value="${g.category.id}">
							<button type="submit" class="btn btn-success">提 交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>