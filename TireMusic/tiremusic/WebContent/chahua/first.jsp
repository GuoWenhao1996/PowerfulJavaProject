<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basepath = request.getContextPath();
	String lid=request.getParameter("lid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
</head>
<body>
<a href="#" class="pull-right text-muted m-t-lg" data-toggle="class:fa-spin" ><i class="icon-refresh i-lg  inline" id="refresh"></i></a>
   <h2 class="font-thin m-b">发现 <span class="musicbar animate inline m-l-sm" style="width:20px;height:20px">
     <span class="bar1 a1 bg-primary lter"></span>
     <span class="bar2 a2 bg-info lt"></span>
     <span class="bar3 a3 bg-success"></span>
     <span class="bar4 a4 bg-warning dk"></span>
     <span class="bar5 a5 bg-danger dker"></span>
   </span></h2>
   <div id="mydiv" class="row row-sm">
   <c:forEach items="${newsongs}" var="song">
     <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
       <div class="item">
         <div class="pos-rlt">
           <div class="item-overlay opacity r r-2x bg-black">
             <div class="text-info padder m-t-sm text-sm">
               <i class="fa fa-star"></i>
               <i class="fa fa-star"></i>
               <i class="fa fa-star"></i>
               <i class="fa fa-star"></i>
               <i class="fa fa-star-o text-muted"></i>
             </div>
             <div class="center text-center m-t-n">
               <a href="javascript:shiting('${song.songid}','${song.songname}','${song.songername}','${song.location}')"><i class="icon-control-play i-2x"></i></a>
             </div>
             <div class="bottom padder m-b-sm">
               <a href="#" class="pull-right">
                 <i class="fa fa-heart-o"></i>
               </a>
               <a href="javascript:addMusic(${song.songid})">
                 <i class="fa fa-plus-circle"></i>
               </a>
             </div>
           </div>
           <a href="#"><img src="images/p3.jpg" alt="" class="r r-2x img-full"></a>
         </div>
         <div class="padder-v">
           <a href="#" class="text-ellipsis">${song.songname}</a>
           <a href="#" class="text-ellipsis text-xs text-muted">${song.songername}</a>
         </div>
       </div>
     </div>
     </c:forEach>
     
   </div>
   <div class="row">
     <div class="col-md-5">
       <h3 class="font-thin">下载Top 4</h3>
       <div class="list-group bg-white list-group-lg no-bg auto" id="downlist">                          
         
       </div>
     </div>
   </div>
   <!-- 收藏歌曲模态框 -->
	<div class="modal fade" id="addMusicInSongListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">收藏歌单</h4>
	      </div>
	      <div class="modal-body" style="padding-left: 150px">
	     		<label id="songid" style="display: none"></label>
	     		<label>您想放到哪个歌单里?</label><br/>
	     		<select id="addMusicInSongList" style="width: 150px">

	     		</select>
	     		<label id="addMusicInSongListerr" style="color: red"></label>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" onclick="addMusicInSongList()">保存</button>
	      </div>
	    </div>
	  </div>
	</div> <!-- 收藏歌曲模态框结束 -->
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
  $(function () {
	  $.post("/tiremusic/Statistics/getDownTop.do",{"num":10},function(data){
		  for(var i = 1;i<=data.length;i++){
			  var obj1= "'"+data[i-1].songid+"'";
			  var obj2= "'"+data[i-1].songname+"'";
			  var obj3= "'"+data[i-1].songername+"'";
			  var obj4= "'"+data[i-1].location+"'";
				$("#downlist").append('<a  href="javascript:shiting('+obj1+','+obj2+','+obj3+','+obj4+')" class="list-group-item clearfix">'+
				           '<span class="pull-right h2 text-muted m-l">'+i+'</span>'+
				          ' <span class="pull-left thumb-sm avatar m-r">'+
				            ' <img src="<%=basepath %>/chahua/images/m0.jpg" alt="...">'+
				         '  </span>'+
				         '  <span class="clear">'+
				           '  <span>'+data[i-1].songname+'</span>'+
				           '  <small class="text-muted clear text-ellipsis">'+data[i-1].songername+'</small>'+
				         '  </span>'+
				       '  </a>')
			}
	  },"json");
	  $.post('/tiremusic/songaudition/lodaNewSongs.do',function(data){
		  for(var i=0;i<data.length;i++){
			  var obj1= "'"+data[i].songid+"'";
			  var obj2= "'"+data[i].songname+"'";
			  var obj3= "'"+data[i].songername+"'";
			  var obj4= "'"+data[i].location+"'";
			  $('#mydiv').append('<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">'+
				       '<div class="item">'+
				         '<div class="pos-rlt">'+
				           '<div class="item-overlay opacity r r-2x bg-black">'+
				            ' <div class="text-info padder m-t-sm text-sm">'+
				              ' <i class="fa fa-star"></i>'+
				              ' <i class="fa fa-star"></i>'+
				              ' <i class="fa fa-star"></i>'+
				              ' <i class="fa fa-star"></i>'+
				              ' <i class="fa fa-star-o text-muted"></i>'+
				            ' </div>'+
				            ' <div class="center text-center m-t-n">'+
				              ' <a href="javascript:shiting('+obj1+','+obj2+','+obj3+','+obj4+')"><i class="icon-control-play i-2x"></i></a>'+
				            ' </div>'+
				             '<div class="bottom padder m-b-sm">'+
				              ' <a href="#" class="pull-right">'+
				                 '<i class="fa fa-heart-o"></i>'+
				               '</a>'+
				               '<a href="javascript:addMusic('+data[i].songid+')">'+
				                ' <i class="fa fa-plus-circle"></i>'+
				              ' </a>'+
				            ' </div>'+
				          ' </div>'+
				          ' <a href="#"><img src="images/p3.jpg" alt="" class="r r-2x img-full"></a>'+
				        ' </div>'+
				         '<div class="padder-v">'+
				           '<a href="#" class="text-ellipsis">'+data[i].songname+'</a>'+
				           '<a href="#" class="text-ellipsis text-xs text-muted">'+data[i].songername+'</a>'+
				        ' </div>'+
				      ' </div>'+
				     '</div>');
		  }
	  },'json');
	
});
  //收藏歌单模态框
	function addMusic(sid,lid) {
		$.post("/tiremusic/songlist/showAllMusicList.do",function(data){
			$('#addMusicInSongList option').remove();
			for (var i = 0; i < data.length; i++) {
				$('#addMusicInSongList').append('<option value="'+data[i].songlistid+'">'+data[i].songlistname+'</option>');
			}
  		},"json");
		$('#songid').text(sid);
		$('#addMusicInSongListModal').modal('show');
	}

	//收藏歌曲
	function addMusicInSongList() {
		var sid=$('#songid').text();
		var lid=$('#addMusicInSongList').val();
		$.post("/tiremusic/songlist/addMusicToList.do",{lid:lid,sid:sid},function(data){
			if(data=="true"){
				$('#addMusicInSongListerr').text("");
				$('#songid').text("");
		  		$('#addMusicInSongListModal').modal('hide');
			}else{
				$('#addMusicInSongListerr').text(data);
			}
		},"text");   
	}
  
  </script>
</body>
</html>