<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
$(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("name","分类名称"))
            return false;
       /*  if(!checkEmpty("categoryPic","分类图片"))
            return false;
        return true; */
    });
});
 
</script>
 
<title>分类管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>分类名称</th>
                    <th>添加游戏</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cs}" var="c">
                 
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                         
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>                  
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>
     
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     
     <!-- 页面跳转 -->
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
		
		<%@ include file="../include/admin/addpicture.jsp" %>
	
     
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>