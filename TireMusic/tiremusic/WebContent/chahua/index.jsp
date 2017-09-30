<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String basepath = request.getContextPath();
	
%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
  <title>Cloud Musik</title>
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
  <style>
 #seform{
  margin-left: 100px;
  margin-top: 10px;
  }
  </style>
</head>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">   
    <script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
<body class="">
<script type="text/javascript">

 $('#db').dialog({    
	    title: '上传歌曲',    
	    width: 400,    
	    height:240,    
	    closed: true,     
	    modal: true,
	    closable:true
});
 function up(){
	 $('#db').dialog('open');
 }
 $(function(){
		$.post('/tiremusic/uploadmusic/selectschool.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#seform select[name="schoolid"]').append('<option value="'+data[i].schoolid+'">'+data[i].schoolname+'</option>');
			}
		},'json') 
	})


	$(function(){
		$.post('/tiremusic/uploadmusic/selectsonger.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#seform select[name="songerid"]').append('<option value="'+data[i].songerid+'">'+data[i].songername+'</option>');
			}
		},'json') 
	})
	
	
</script>
  <section class="vbox">
    <header class="bg-white-only header header-md navbar navbar-fixed-top-xs">
      <div class="navbar-header aside bg-info nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="icon-list"></i>
        </a>
        <a href="<%=basepath %>/chahua/index.jsp" class="navbar-brand text-lt">
          <i class="icon-earphones"></i>
          <img src="<%=basepath %>/chahua/images/logo.png" alt="." class="hide">
          <span class="hidden-nav-xs m-l-sm">音乐改变生活</span>
        </a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
          <i class="icon-settings"></i>
        </a>
      </div>      <ul class="nav navbar-nav hidden-xs">
        <li>
          <a href="#nav,.navbar-header" data-toggle="class:nav-xs,nav-xs" class="text-muted">
            <i class="fa fa-indent text"></i>
            <i class="fa fa-dedent text-active"></i>
          </a>
        </li>
      </ul>
      <form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs" role="search">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-btn">
              <a href="javascript:changeIframeUrl('<%=basepath %>/chahua/searchsong.jsp')" target="centerIframe"><button onclick="search()" type="button" class="btn btn-sm bg-white btn-icon rounded"><i class="fa fa-search"></i></button></a>
            </span>
            <div>
            <input id="songname" type="text" class="form-control input-sm no-border rounded" placeholder="请输入歌曲...">
            <input id="songername" style="position: absolute; left: 160px; top: 0px;" type="text" class="form-control input-sm no-border rounded" placeholder="请输入歌手...">
            <select id="school" style="width: 125px; position: absolute; left: 320px; top: 5px;">
            	<option value="0">---请选择流派---</option>
            	
            </select>
            </div>
          </div>
        </div>
      </form>
      <div class="navbar-right ">
      	<a href="<%=basepath %>/chahua/signin.jsp"><span id="myspan" style="display:bolck; position: relative; top:15px; right:15px;">未登录</span></a>
        <ul id="myul" class="nav navbar-nav m-n hidden-xs nav-user user" style="display:none;">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle bg clear" data-toggle="dropdown">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="${user.avatar}" alt="...">
              </span>
              ${user.uname}<b class="caret"></b>
            </a>
            <ul class="dropdown-menu animated fadeInRight">            
              <li>
                <a href="<%=basepath %>/chahua/updateinfo.jsp">个人信息</a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="<%=basepath %>/chahua/signin.jsp" data-toggle="ajaxModal" >切换账号</a>
              </li>
			  <li>
                <a href="javascript:logout();" >登出</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>      
    </header>
    <section>
      <section class="hbox stretch">
        <!-- .aside -->
        <aside class="bg-black dk nav-xs aside hidden-print" id="nav">          
          <section class="vbox">
            <section class="w-f-md scrollable">
              <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="10px" data-railOpacity="0.2">
                


                <!-- nav -->                 
                <nav class="nav-primary hidden-xs">
                  <ul class="nav bg clearfix">
                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                      Cloud Music
                    </li>
                    <li>
                      <a href="javascript:changeIframeUrl('<%=basepath %>/chahua/first.jsp')" target="centerIframe">
                        <i class="icon-music-tone-alt icon text-info"></i>
                        <span class="font-bold">最新的</span>
                      </a>
                    </li>
                    <li>
                      <a href="javascript:changeIframeUrl('<%=basepath %>/chahua/listen.jsp')" target="centerIframe">
                        <i class="icon-list icon  text-info-dker"></i>
                        <span class="font-bold">音乐列表</span>
                      </a>
                    </li>
                    <li>
                      <a href="javascript:changeIframeUrl('<%=basepath %>/chahua/video.jsp')" target="centerIframe" data-target="#content" data-el="#bjax-el" data-replace="true">
                        <i class="icon-social-youtube icon  text-primary"></i>
                        <span class="font-bold">MV</span>
                      </a>
                    </li>
                    <li class="m-b hidden-nav-xs"></li>
                  </ul>
                  <ul class="nav" data-ride="collapse">
                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                      私有操作
                    </li>
                    <li >
                      <a href="<%=basepath %>/chahua/signin.jsp" class="auto">
                        <span class="pull-right text-muted">
                          <i class="fa fa-angle-left text"></i>
                          <i class="fa fa-angle-down text-active"></i>
                        </span>
                        <i class="icon-grid icon">
                        </i>
                        <span>登录</span>
                      </a>
                    </li>
                    <li id="shangchuan" style="display:none;">
                      <a href="#" >
                        <span class="pull-right text-muted">
                          <i class="fa fa-angle-left text"></i>
                          <i class="fa fa-angle-down text-active"></i>
                        </span>
                        <i class="icon-action-redo">
                        </i>
                        <span  data-toggle="modal" data-target="#myModal">上传</span>
                      </a>
                    </li>
                  </ul>
                  <!--上传歌曲模态框  -->
						  	<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
						  	<div class="modal-dialog" role="document">
					    	<div class="modal-content">
					     	 <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h5 class="modal-title">上传</h5>
					      </div>
					      <div class="modal-body">
					        <form id="seform" method="post" enctype="multipart/form-data" action="/tiremusic/uploadmusic/uploadmusic.do">   
					    <div>   
					        <label for=" songname">歌曲名字:</label>   
					        <input class="easyui-validatebox" type="text" name="songname" data-options="required:true" />   
					    </div>
					    
					     <div>   
					        <label>歌手名字:</label>   
					        <select name="songerid">
					         <option value="-1">--请选择--</option>
					        </select>  
					    </div> 
					         
					    <div>   
					        <label>流派名字:</label>   
					        <select name="schoolid">
					         <option value="-1">--请选择--</option> 
					        </select>  
					    </div>
					    
					    <div>   
					        <label for="song">选择歌曲:</label> 
					        <input class="easyui-validatebox" type="file" name="file"/>   
					    </div> 
					    <div class="modal-footer">
					    <button type="submit" class="btn btn-primary">上传</button>
					        
					        
					      </div>    
					 </form> 
					      </div>
					      
					    </div>
					  </div>
					</div>
                  <!-- 上传歌曲模态框结束 -->
                  
                  
                  
                  
                  <!-- 添加歌单模态框 -->
					<div class="modal fade" id="addSongListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">创建新歌单</h4>
					      </div>
					      <div class="modal-body" style="padding-left: 150px">
					     		<label>歌单名称：</label><br/>
					     		<input id="newsonglistname" style="width: 250px" placeholder="为您的歌单取个个性的名字"/>
					     		<label id="newsonglistnameerr" style="color: red"></label>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					        <button type="button" class="btn btn-primary" onclick="addSongList()">保存</button>
					      </div>
					    </div>
					  </div>
					</div> <!-- 添加歌单模态框结束 -->
					<!-- 删除歌单模态框 -->
					<div class="modal fade" id="deleteSongListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">删除歌单</h4>
					      </div>
					      <div class="modal-body" style="padding-left: 150px">
					     		<label>请选择要删除的歌单：</label><br/>
					     		<select id="deleteSongList" style="width: 150px">
				                    <c:forEach items="${requestScope.songlist}" var="songlist">
				                    	<option value="${songlist.songlistid}">${songlist.songlistname}</option>
				                    </c:forEach>
					     		</select>
					     		<label id="deleteSongListerr" style="color: red"></label>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					        <button type="button" class="btn btn-danger" onclick="deleteSongList()">删除</button>
					      </div>
					    </div>
					  </div>
					</div> <!-- 删除歌单模态框结束 -->
					<!-- 修改歌单模态框 -->
					<div class="modal fade" id="updateSongListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">修改歌单</h4>
					      </div>
					      <div class="modal-body" style="padding-left: 150px">
					     		<label>请选择要修改的歌单：</label><br/>
					     		<select id="updateSongList" style="width: 150px" onchange="showCom()">
				                    <c:forEach items="${requestScope.songlist}" var="songlist">
				                    	<option value="${songlist.songlistid}">${songlist.songlistname}</option>
				                    </c:forEach>
					     		</select><br/><br/><br/>
					     		<label style="display: none" id="updatesonglistnamelabel">新名称：</label><br/>
					     		<input style="display: none;width: 250px" id="updatesonglistname" placeholder="为您的歌单取个个性的名字"/>
					     		<label id="updateSongListerr" style="color: red"></label>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					        <button id="updateSongListBtn"  style="display: none" type="button" class="btn btn-info" onclick="updateSongList()">保存</button>
					      </div>
					    </div>
					  </div>
					</div> <!-- 修改歌单模态框结束 -->
					
                  
                  <ul class="nav text-sm"  id="allSongList">
                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                      <span class="pull-right">
						<a href="#" data-toggle="modal" data-target="#updateSongListModal"><i class="icon-pencil i-lg"></i></a>
						<a href="#" data-toggle="modal" data-target="#addSongListModal"><i class="icon-plus i-lg"></i></a>
                        <a href="#" data-toggle="modal" data-target="#deleteSongListModal"><i class="icon-trash i-lg"></i></a>
					  </span>
                      我的歌单
                    </li>
                    <c:forEach items="${requestScope.songlist}" var="songlist">
	                    <li>
	                   		<a href="javascript:changeIframeUrl('<%=basepath %>/chahua/songlist.jsp?lid=${songlist.songlistid}&lname=${songlist.songlistname}')">
	                        	<i class="icon-music-tone icon"></i>
	                       		<span>${songlist.songlistname}</span>
	                     	</a>
	                    </li>
                    </c:forEach>
                  </ul>
                </nav>
                <!-- / nav -->
              </div>
            </section>
            <footer class="footer hidden-xs no-padder text-center-nav-xs">
              <div class="bg hidden-xs ">
                  <div class="dropdown dropup wrapper-sm clearfix">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <span class="thumb-sm avatar pull-left m-l-xs">                        
                        <img src="<%=basepath %>/chahua/images/a3.png" class="dker" alt="...">
                        <i class="on b-black"></i>
                      </span>
                      <span class="hidden-nav-xs clear">
                        <span class="block m-l">
                          <strong class="font-bold text-lt">八轮车</strong> 
                          <b class="caret"></b>
                        </span>
                        <span class="text-muted text-xs block m-l">开发小组</span>
                      </span>
                    </a>
                  </div>
                </div>            </footer>
          </section>
        </aside>
        <!-- /.aside -->
        <section id="content">
          <section class="hbox stretch">
            <section>
              <section class="vbox">
              <section class="scrollable padder-lg w-f-md" id="bjax-target">
                   <iframe src="<%=basepath %>/chahua/first.jsp" id="centerIframe" name="centerIframe" width="100%" height="100%" frameborder="no" >
 					
 					</iframe>
 			  </section>
                <footer class="footer bg-dark">
                  <div id="jp_container_N">
                    <div class="jp-type-playlist">
                      <div id="jplayer_N" class="jp-jplayer hide"></div>
                      <div class="jp-gui">
                        <div class="jp-video-play hide">
                          <a class="jp-video-play-icon">play</a>
                        </div>
                        <div class="jp-interface">
                          <div class="jp-controls">
                            <div><a class="jp-previous"><i class="icon-control-rewind i-lg"></i></a></div>
                            <div>
                              <a href="javascript:show();" class="jp-play"><i class="icon-control-play i-2x"></i></a>
                              <a class="jp-pause hid"><i class="icon-control-pause i-2x"></i></a>
                            </div>
                            <div><a class="jp-next"><i class="icon-control-forward i-lg"></i></a></div>
                            <div class="hide"><a class="jp-stop"><i class="fa fa-stop"></i></a></div>
                            <div onclick="reload()"><a class="" data-toggle="dropdown" data-target="#playlist"><i class="icon-list"></i></a></div>
                            <div class="jp-progress hidden-xs">
                              <div class="jp-seek-bar dk">
                                <div class="jp-play-bar bg-info">
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
                                <div class="jp-volume-bar-value lter"></div>
                              </div>
                            </div>
                            <div>
                              <a class="jp-shuffle" title="shuffle"><i class="icon-shuffle text-muted"></i></a>
                              <a class="jp-shuffle-off hid" title="shuffle off"><i class="icon-shuffle text-lt"></i></a>
                            </div>
                            <div>
                              <a class="jp-repeat" title="repeat"><i class="icon-loop text-muted"></i></a>
                              <a class="jp-repeat-off hid" title="repeat off"><i class="icon-loop text-lt"></i></a>
                            </div>
                            <div class="hide">
                              <a class="jp-full-screen" title="full screen"><i class="fa fa-expand"></i></a>
                              <a class="jp-restore-screen" title="restore screen"><i class="fa fa-compress text-lt"></i></a>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="jp-playlist dropup" id="playlist">
                        <ul id="myplaylistul" class="dropdown-menu aside-xl dker">
                          <!-- The method Playlist.displayPlaylist() uses this unordered list -->
                          <!-- <li class="list-group-item"></li>
                          <c:forEach items="${songs}" var="s">
                             <li>
                             	<div><a href="javascript:;" class="jp-playlist-item-remove">×</a>
                             	<a href="javascript:;" class="jp-playlist-item" tabindex="1">${s.songname}<span class="jp-artist">by ${s.songername}</span></a>
                             	</div>
                             </li>
                           </c:forEach> -->
                        </ul>
                      </div>
                      <div class="jp-no-solution hide">
                        <span>Update Required</span>
                        To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                      </div>
                    </div>
                  </div>
                </footer>
              </section>
            </section>
            <!-- side content -->
            <aside class="aside-md bg-light dk" id="sidebar">
              <section class="vbox animated fadeInRight">
                <section class="w-f-md scrollable hover">
                  <h4 class="font-thin m-l-md m-t">我的关注</h4>
                  <ul class="list-group no-bg no-borders auto m-t-n-xxs">
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a1.png" alt="..." class="img-circle">
                        <i class="on b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Chris Fox</a></div>
                        <small class="text-muted">New York</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a2.png" alt="...">
                        <i class="on b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Amanda Conlan</a></div>
                        <small class="text-muted">France</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a3.png" alt="...">
                        <i class="busy b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Dan Doorack</a></div>
                        <small class="text-muted">Hamburg</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a4.png" alt="...">
                        <i class="away b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Lauren Taylor</a></div>
                        <small class="text-muted">London</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a5.png" alt="..." class="img-circle">
                        <i class="on b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Chris Fox</a></div>
                        <small class="text-muted">Milan</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a6.png" alt="...">
                        <i class="on b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Amanda Conlan</a></div>
                        <small class="text-muted">Copenhagen</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a7.png" alt="...">
                        <i class="busy b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Dan Doorack</a></div>
                        <small class="text-muted">Barcelona</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a8.png" alt="...">
                        <i class="away b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Lauren Taylor</a></div>
                        <small class="text-muted">Tokyo</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a9.png" alt="..." class="img-circle">
                        <i class="on b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Chris Fox</a></div>
                        <small class="text-muted">UK</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a1.png" alt="...">
                        <i class="on b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Amanda Conlan</a></div>
                        <small class="text-muted">Africa</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a2.png" alt="...">
                        <i class="busy b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Dan Doorack</a></div>
                        <small class="text-muted">Paris</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <span class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
                        <img src="<%=basepath %>/chahua/images/a3.png" alt="...">
                        <i class="away b-light right sm"></i>
                      </span>
                      <div class="clear">
                        <div><a href="#">Lauren Taylor</a></div>
                        <small class="text-muted">Brussels</small>
                      </div>
                    </li>
                  </ul>
                </section>
                <footer class="footer footer-md bg-black">
                  <form class="" role="search">
                    <div class="form-group clearfix m-b-none">
                      <div class="input-group m-t m-b">
                        <span class="input-group-btn">
                         <a href="javascript:"> <button type="submit" class="btn btn-sm bg-empty text-muted btn-icon"><i class="fa fa-search"></i></button></a>
                        </span>
                        <input type="text" class="form-control input-sm text-white bg-empty b-b b-dark no-border" placeholder="查找好友...">
                      </div>
                    </div>
                  </form>
                </footer>
              </section>              
            </aside>
            <!-- / side content -->
          </section>
          <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
        </section>
      </section>
    </section>    
  </section>
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
  <script type="text/javascript">
  	$(function(){
  		$.post("/tiremusic/songaudition/loginSongs.do",function(data){
  			for(var i=0;i<data.length;i++){
  				$('#myplaylistul').append('<li>'+
                     	'<div><a href="javascript:;" class="jp-playlist-item-remove">×</a>'+
                     	'<a href="javascript:;" class="jp-playlist-item" tabindex="1">'+data[i].songname+'<span class="jp-artist">by '+data[i].songername+'</span></a>'+
                     	'</div>'+
                     '</li>');
  			}
  		},'json');
  		$.post("/tiremusic/school/loadAllSchools.do",function(data){
  			for(var i=0;i<data.length;i++){
  				$('#school').append('<option value="'+data[i].schoolid+'">'+data[i].schoolname+'</option>');
  			}
  		},'json');
  		$.post("/tiremusic/songaudition/showUploadLogo.do",function(data){
  			if(data=='true'){
  				$('#myspan').css('display','none');
  				$('#shangchuan').css('display','block');
  				$('#myul').css('display','block');
  			}else{
  				
  			}
  		},'text');
  	});
  	function reload(){
  		$('#myplaylistul').find('li').remove();
  		$.post("/tiremusic/songaudition/showSong.do",function(data){
  			for(var i=0;i<data.length;i++){
  				$('#myplaylistul').append('<li>'+
                     	'<div><a href="javascript:;" class="jp-playlist-item-remove">×</a>'+
                     	'<a href="javascript:;" class="jp-playlist-item" tabindex="1">'+data[i].songname+'<span class="jp-artist">by '+data[i].songername+'</span></a>'+
                     	'</div>'+
                     '</li>');
  			}
  		},'json');
  	}
  	function changeIframeUrl(url) {
		$('#centerIframe').attr("src",url);
	}
  	function search(){
  		var songname = $('#songname').val();
  		var songername = $('#songername').val();
  		var schoolid = $('#school').val();
  		$.post('/tiremusic/songsearch/songSearch.do',{songname:songname,songername:songername,schoolid:schoolid},function(data){
  			
  		},'json');
  	}
  	
   
  //展示歌单
  	function showSongList() {
  		$.post("/tiremusic/songlist/showAllMusicList.do",function(data){
			$('#allSongList li:not(:eq(0))').remove();
			$('#deleteSongList option').remove();
			$('#updateSongList option').remove();
			for (var i = 0; i < data.length; i++) {
				var url="'/tiremusic/chahua/songlist.jsp?lid="+data[i].songlistid+"&lname="+data[i].songlistname+"'";
				$('#allSongList').append('<li><a href="javascript:changeIframeUrl('+url+')"><i class="icon-music-tone icon"></i><span>'+data[i].songlistname+'</span></a></li>');
				$('#deleteSongList').append('<option value="'+data[i].songlistid+'">'+data[i].songlistname+'</option>');
				$('#updateSongList').append('<option value="'+data[i].songlistid+'">'+data[i].songlistname+'</option>');
			}
  		},"json");
	}
  	//添加歌单
  	function addSongList() {
  		var name=$('#newsonglistname').val();
  		$.post("/tiremusic/songlist/addMusicList.do",{name:name},function(data){
  			if(data=="true"){
				$('#newsonglistname').val("");
				$('#newsonglistnameerr').text("");
				showSongList();
  		  		$('#addSongListModal').modal('hide');
  			}else{
				$('#newsonglistnameerr').text(data);
  			}
  		},"text");
	}
  	//删除歌单
  	function deleteSongList() {
  		var lid=$('#deleteSongList').val();
  		$.post("/tiremusic/songlist/deleteMusicList.do",{listId:lid},function(data){
  			if(data=="true"){
				$('#deleteSongListerr').text("");
				showSongList();
  		  		$('#deleteSongListModal').modal('hide');
  			}else{
				$('#deleteSongListerr').text("服务器异常，请稍后再试！");
  			}
  		},"text");  		
	}
  	//显示修改模态框上的组件
  	function showCom() {
  		var name=$('#updateSongList').find("option:selected").text();
  		$('#updatesonglistnamelabel').css('display',''); 
  		$('#updatesonglistname').css('display','');
  		$('#updateSongListBtn').css('display','');
  		$('#updatesonglistname').val(name);
	}
  	//修改歌单
  	function updateSongList() {
  		var lid=$('#updateSongList').val();
  		var name=$('#updatesonglistname').val();
  		$.post("/tiremusic/songlist/updateMusicList.do",{listId:lid,name:name},function(data){
  			if(data=="true"){
  		  		$('#updatesonglistnamelabel').css('display','none'); 
  		  		$('#updatesonglistname').css('display','none');
  		  		$('#updateSongListBtn').css('display','none');
  		  		$('#updatesonglistname').val('');
				$('#updateSongListerr').text('');
				showSongList();
  		  		$('#updateSongListModal').modal('hide');
  			}else{
				$('#updateSongListerr').text(data);
  			}
  		},"text");  		
	}

  
  	$(function(){
		$.post('/tiremusic/uploadmusic/selectschool.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#seform select[name="schoolid"]').append('<option value="'+data[i].schoolid+'">'+data[i].schoolname+'</option>');
			}
		},'json');
		$.post('/tiremusic/uploadmusic/selectsonger.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#seform select[name="songerid"]').append('<option value="'+data[i].songerid+'">'+data[i].songername+'</option>');
			}
		},'json');
	});
  	
  	function logout(){
  		$.post('/tiremusic/user/logOut.do',function(data){
  			if(data=='true'){
  				location.href = '<%=basepath %>/chahua/index.jsp';
  			}else{
  				
  			}
  		},'text');
  	}

  	
  </script>
</body>
</html>