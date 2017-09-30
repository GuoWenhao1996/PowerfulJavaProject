<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <aside class="col-sm-5 no-padder" id="sidebar">
      <section class="vbox animated fadeInUp">
        <section class="scrollable">
          <div class="m-t-n-xxs item pos-rlt">
            <div class="top text-right">
              <span class="musicbar animate bg-success bg-empty inline m-r-lg m-t" style="width:25px;height:30px">
                <span class="bar1 a3 lter"></span>
                <span class="bar2 a5 lt"></span>
                <span class="bar3 a1 bg"></span>
                <span class="bar4 a4 dk"></span>
                <span class="bar5 a2 dker"></span>
              </span>
            </div>
            <div class="bottom gd bg-info wrapper-lg">
              <span class="pull-right text-sm">1 <br>关注</span>
              <span class="h2 font-thin">音乐试听TOP榜</span>
            </div>
            <img class="img-full" src="images/m44.jpg" alt="...">
          </div>
          <ul class="list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto" id="list">
          </ul>
        </section>
      </section>
    </aside>
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
  	$(function() {
		$.post("/tiremusic/Statistics/getAuditionTop.do",{"num":10},function(data){
			//alert(data.length);
			for(var i = 1;i<=data.length;i++){
				var obj1= "'"+data[i-1].songid+"'";
			    var obj2= "'"+data[i-1].songname+"'";
			    var obj3= "'"+data[i-1].songername+"'";
			    var obj4= "'"+data[i-1].location+"'";
				$("#list").append('<li class="list-group-item"> '+
			              '<div class="pull-right m-l">'+
			                '<a href="javascript:down('+data[i-1].songid+')" class="m-r-sm"><i class="icon-cloud-download"></i></a>'+
			                '<a href="javascript:addMusic('+data[i-1].songid+')" ><i class="icon-plus"></i></a>'+
			              '</div>'+
			              '<a href="javascript:shiting('+obj1+','+obj2+','+obj3+','+obj4+')" class="jp-play-me m-r-sm pull-left">'+
			               ' <i class="icon-control-play text"></i>'+
			               ' <i class="icon-control-pause text-active"></i>'+
			              '</a>'+
			             ' <div class="clear text-ellipsis" id="8">'+
			              '  <span>'+data[i-1].songname+'</span>'+
			               ' <span class="text-muted">-------'+data[i-1].songername+'</span>'+
			              '</div>'+
			            '</li>')
			}
		},"json");	
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

  	function down(obj){
  		var songid=obj;
  		$.post("/tiremusic/download/downloadmusic.do",{"songid":songid},function(data){
  			
  		})
  	}
  	
  </script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>