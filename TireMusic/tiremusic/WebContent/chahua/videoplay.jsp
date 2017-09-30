<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
	String mname=request.getParameter("mvname");
	String mvimg=request.getParameter("mvimg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Could Music</title>
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%=basepath %>/chahua/js/jPlayer/jplayer.flat.css" type="text/css" />
<link rel="stylesheet" href="<%=basepath %>/chahua/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="<%=basepath %>/chahua/css/animate.css" type="text/css" />
<link rel="stylesheet" href="<%=basepath %>/chahua/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="<%=basepath %>/chahua/css/simple-line-icons.css" type="text/css" />
<link rel="stylesheet" href="<%=basepath %>/chahua/css/font.css" type="text/css" />
<link rel="stylesheet" href="<%=basepath %>/chahua/css/app.css" type="text/css" />  
</head>
<body>
<!-- video player -->
  <div id="jp_container_1">
    <div class="jp-type-single pos-rlt">
      <div id="jplayer_1" class="jp-jplayer jp-video">
      
      </div>
      <div class="jp-gui">
        <div class="jp-video-play">
          <a class="fa fa-5x text-white fa-play-circle"></a>
        </div>
        <div class="jp-interface bg-info padder">
          <div class="jp-controls">
            <div>
              <a class="jp-play"><i class="icon-control-play i-2x"></i></a>
              <a class="jp-pause hid"><i class="icon-control-pause i-2x"></i></a>
            </div>
            <div class="jp-progress">
              <div class="jp-seek-bar dker">
                <div class="jp-play-bar dk">
                </div>
                <div class="jp-title text-lt">
                  <ul>
                    <li></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="hidden-xs hidden-sm jp-current-time text-xs text-muted"></div>
            <div class="hidden-xs hidden-sm jp-duration text-xs text-muted"></div>
            <div class="hidden-xs hidden-sm">
              <a class="jp-mute" title="mute"><i class="icon-volume-2"></i></a>
              <a class="jp-unmute hid" title="unmute"><i class="icon-volume-off"></i></a>
            </div>
            <div class="hidden-xs hidden-sm jp-volume">
              <div class="jp-volume-bar dk">
                <div class="jp-volume-bar-value lter">
                </div>
              </div>
            </div>
            <div>
              <a class="jp-full-screen" title="full screen"><i class="fa fa-expand"></i></a>
              <a class="jp-restore-screen" title="restore screen"><i class="fa fa-compress text-lt"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
   <script src="<%=basepath %>/chahua/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="<%=basepath %>/chahua/js/bootstrap.js"></script>
  <!-- App -->
  <script src="<%=basepath %>/chahua/js/app.js"></script>  
  <script src="<%=basepath %>/chahua/js/slimscroll/jquery.slimscroll.min.js"></script>
  <script src="<%=basepath %>/chahua/js/app.plugin.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript">
  $("#jplayer_1").jPlayer({
	    ready: function () {
	      $(this).jPlayer("setMedia", {
	        title: '<%=mname%>',
	        m4v: "/tiremusic/mv/IWantYoutoKnow.mp4",
	        ogv: "/tiremusic/mv/IWantYoutoKnow.mp4",
	       //地址
	        webmv: "/tiremusic/mv/IWantYoutoKnow.mp4",
	       //图片
	        poster:"/img/m42.jpg",
	      });
	    },
	    swfPath: "js",
	    supplied: "webmv, ogv, m4v",
	    size: {
	      width: "100%",
	      height: "auto",
	      cssClass: "jp-video-360p"
	    },
	    globalVolume: true,
	    smoothPlayBar: true,
	    keyEnabled: true
	  });

  </script>
</body>
</html>