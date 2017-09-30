<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
  <title>Cloud Music</title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/animate.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/font.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/app.css" type="text/css" />  
    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="bg-info dker">
  <section id="content" class="m-t-lg wrapper-md animated fadeInUp">    
    <div class="container aside-xl">
      <a class="navbar-brand block" href=""><span class="h1 font-bold">云音乐</span></a>
      <section class="m-b-lg">
        <header class="wrapper text-center">
          <strong>登录窗口</strong>
        </header>
        <form action="/tiremusic/manage/manageLoginContorller.do" method="post">
          <div class="form-group">
            <input name="manageusername" type="text" placeholder="username" class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="form-group">
             <input name="managepassword" type="password" placeholder="Password" class="form-control rounded input-lg text-center no-border">
          </div>
          <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">登录</span></button>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder">
      <p>
        <small>网页技术支持 Bootstrap<br>&copy; 2017</small>
		<small>技术实现 Eight-Wheeler<br>&copy; 2017</small>
      </p>
    </div>
  </footer>
  <!-- / footer -->
  <script src="<%=basepath %>/chahua/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="<%=basepath %>/chahua/js/bootstrap.js"></script>
  <!-- App -->
  <script src="<%=basepath %>/chahua/js/app.js"></script>  
  <script src="<%=basepath %>/chahua/js/slimscroll/jquery.slimscroll.min.js"></script>
  <script src="<%=basepath %>/chahua/js/app.plugin.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/demo.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>