<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>博客 | 登录</title>
<jsp:include page="/common/css.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<form class="form-horizontal">
				  <div class="form-group">
				    <label for="username" class="col-sm-2 control-label">用户名：</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="username" placeholder="请输入用户名/邮箱/手机号">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-2 control-label">密码：</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="password" placeholder="请输入密码">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <div class="checkbox">
				        <label>
				          <input type="checkbox" id="rememberMe" checked> 记住我？
				        </label>
				      </div>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">登录</button>
				    </div>
				  </div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/common/javascript.jsp"></jsp:include>
</body>
</html>