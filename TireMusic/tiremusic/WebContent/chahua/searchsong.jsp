<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
</head>
<body>
<section class="w-f-md">
  <section class="hbox stretch bg-black dker">
    <!-- side content -->

    <!-- 这里是歌单里的歌曲列表 -->
    <ul id="songlistUL" class="list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto">
		<c:forEach items="${list1}" var="l">
			<li class="list-group-item">
			<div class="pull-right m-l">
				<a href="javascript:down(${l.songid})" class="m-r-sm"><i class="icon-cloud-download"></i></a>
				<a href="javascript:addMusic(${l.songid})" ><i class="icon-plus"></i></a>
			</div>
				<a href="javascript:shiting('${l.songid}','${l.songname}','${l.songername}','${l.location}')" class="jp-play-me m-r-sm pull-left"><i class="icon-control-play text"></i>
				</a>
			<div class="clear text-ellipsis"><span>${l.songname}</span>
			<span class="text-muted">------${l.songername}</span>
			</div>
			</li>
		</c:forEach>
    </ul>
    <!-- / side content -->
  </section>
</section>
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

function down(obj){
		var songid=obj;
		$.post("/tiremusic/download/downloadmusic.do",{"songid":songid},function(data){
			
		})
	}

</script>
</body>
</html>