<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/31 0031
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="../includes/headerAndAside.jsp" />
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
            <div class="col-xs-12">
                <c:if test="${baseResult != null}">
                    <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            ${baseResult.message}
                    </div>
                </c:if>
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">${user.userid == 0 ? "新增":"修改"}用户</h3>
                </div>
                <!-- /.box-header -->

                <!-- form start -->
                <form:form cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="user">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱</label>
                            <input type="hidden" value="${user.userid}" name="userid" />
                            <div class="col-sm-10">
                                <form:input path="email" cssClass="form-control" placeholder="请输入邮箱" style="width: 280px;"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">姓名</label>

                            <div class="col-sm-10">
                                <form:input path="username" cssClass="form-control" placeholder="请输入姓名" style="width: 280px;"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-10">
                                <form:password path="password" cssClass="form-control" placeholder="密码" style="width: 280px;"></form:password>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                        <button type="submit" class="btn btn-info pull-right">保存</button>
                    </div>
                    <!-- /.box-footer -->
                </form:form>
            </div>
            </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/foot.jsp" />
</body>
</html>
