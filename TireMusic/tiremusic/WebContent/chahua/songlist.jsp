<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
	String lid=request.getParameter("lid");  
	String lname=request.getParameter("lname");
	String uid=request.getSession().getAttribute("uid")+"";
%>
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
              <!-- <span class="pull-right text-sm">101,400 <br>Followers</span> -->
              <span class="h2 font-thin" id="lname"><%=lname %><label id="lid" style="display: none"><%=lid %></label></span>
            </div>
            <img class="img-full" src="images/m43.jpg" alt="...">
          </div>
          <!-- 这里是歌单里的歌曲列表 -->
          <ul id="songlistUL" class="list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto">

          </ul>
        </section>
      </section>
    </aside>
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
    <!-- / side content -->
    <section class="col-sm-4 no-padder bg">
      <section class="vbox">
        <section class="scrollable hover">
      	  <!-- 评论列表 -->
          <ul id="commentListUL" class="list-group list-group-lg no-bg auto m-b-none m-t-n-xxs">
            
          </ul>
        </section>
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
  function parseNum(num) {
		if (num < 10) {
			return "0" + num;
		}
		return num;
	}

	function getDate(obj) {
		return 1900 + obj.year + "-" + parseNum(obj.month + 1) + "-"
				+ parseNum(obj.date) + " " + parseNum(obj.hours) + ":"
				+ parseNum(obj.minutes) + ":" + parseNum(obj.seconds);
	}
  //加载歌曲信息
  function loadMusicInfo() {
		var lid=$('#lid').text();
  		$.post("/tiremusic/songlist/showAllMusicByListId.do",{lid:lid},function(data){
			$('#songlistUL li').remove();
  			for (var i = 0; i < data.length; i++) {
  				var obj1= "'"+data[i].songid+"'";
	 			var obj2= "'"+data[i].songname+"'";
	 			var obj3= "'"+data[i].songername+"'";
	 			var obj4= "'"+data[i].location+"'";
				$('#songlistUL').append('<li onclick="showComment('+data[i].songid+')" class="list-group-item"><div class="pull-right m-l"><a href="javascript:down('+data[i].songid+')" class="m-r-sm"><i class="icon-cloud-download"></i></a><a href="javascript:addMusic('+data[i].songid+','+lid+')"><i class="icon-plus"></i></a><a href="javascript:removeMusic('+data[i].songid+','+lid+')"><i class="icon-trash"></i></a></div><a href="javascript:shiting('+obj1+','+obj2+','+obj3+','+obj4+');" class="jp-play-me m-r-sm pull-left"><i class="icon-control-play text"></i><i class="icon-control-pause text-active"></i></a><div class="clear text-ellipsis"><span>'+data[i].songname+'</span><span class="text-muted">------'+data[i].songername+'</span></div></li>');
			}
  		},"json");
  		$.post("/tiremusic/songlist/showAllMusicList.do",function(data){
			$('#addMusicInSongList option').remove();
			for (var i = 0; i < data.length; i++) {
				$('#addMusicInSongList').append('<option value="'+data[i].songlistid+'">'+data[i].songlistname+'</option>');
			}
  		},"json");
	}
  	//收藏歌单模态框
  	function addMusic(sid,lid) {  		
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
				loadMusicInfo();
  		  		$('#addMusicInSongListModal').modal('hide');
  			}else{
				$('#addMusicInSongListerr').text(data);
  			}
  		},"text");   
	}
	//从歌单中移除歌曲
  	function removeMusic(sid,lid) {
  		$.post("/tiremusic/songlist/deleteMusicInList.do",{lid:lid,sid:sid},function(data){
  			if(data=="true"){
  				loadMusicInfo();
  			}else{
  			}
  		},"text"); 
	}
	
  	//展示评论
	function showComment(sid) {
  		$.post("/tiremusic/comment/showDiscussList.do",{sid:sid},function(data){
			$('#commentListUL li').remove();
			$('#commentListUL').append('<li class="list-group-item clearfix"><a href="javascript:addComment('+sid+')" class="jp-play-me pull-right m-t-sm m-l text-md"><i class="icon-paper-plane"></i></a><a href="#" class="pull-left thumb-sm m-r"><img src="images/m17.jpg" alt="..."></a><a class="clear" href="#"><span class="block text-ellipsis">请在此处填写您对此歌曲的评价</span><textarea onkeydown="clearErr()" rows="3" cols="45" style="resize: none;background-color: #3D474D" id="commentVal"></textarea><br/><label id="addCommenterr" style="color: red"></label></a></li>');
  			for (var i = 0; i < data.length; i++) {
  				if(data[i].uid==<%=uid%>)
					$('#commentListUL').append('<li class="list-group-item clearfix"><a href="javascript:deleteComent('+data[i].commentid+','+sid+')" class="jp-play-me pull-right m-t-sm m-l text-md"><i class="icon-trash"></i></a><a href="#" class="pull-left thumb-sm m-r"><img src="'+data[i].avatar+'" alt="头像" style="width:40px;height:40px;"></a><a class="clear" href="#"><span class="block text-ellipsis">'+data[i].uname+'<small class="text-muted" style="margin-left: 5px ">'+getDate(data[i].commenttime)+'</small></span><small class="text-muted">'+data[i].commentcontent+'</small></a></li>');
  				else
					$('#commentListUL').append('<li class="list-group-item clearfix"><a href="#" class="pull-left thumb-sm m-r"><img src="'+data[i].avatar+'" alt="头像" style="width:40px;height:40px;"></a><a class="clear" href="#"><span class="block text-ellipsis">'+data[i].uname+'<small class="text-muted" style="margin-left: 5px ">'+getDate(data[i].commenttime)+'</small></span><small class="text-muted">'+data[i].commentcontent+'</small></a></li>');
			}
  		},"json");
	}
  	//添加评论
	function addComment(sid) {
		var content=$('#commentVal').val();
		$.post("/tiremusic/comment/addDiscuss.do",{sid:sid,content:content},function(data){
  			if(data=="true"){
				$('#addCommenterr').text("");
				$('#commentVal').val("");
				showComment(sid);
  			}else{
				$('#addCommenterr').text(data);
  			}
  		},"text");  
	}
  	//删除评价
  	function deleteComent(cid,sid) {
		$.post("/tiremusic/comment/deleteDiscuss.do",{cid:cid},function(data){
  			if(data=="true"){
				showComment(sid);
  			}else{
  			}
  		},"text");
	}
  	//清空评价错误信息
	function clearErr() {
		$('#addCommenterr').text("");
	}	
  	
	$(function() {
		loadMusicInfo();
	});
	
	function down(obj){
  		var songid=obj;
  		$.post("/tiremusic/download/downloadmusic.do",{"songid":songid},function(data){
  			
  		})
  	}
	
  </script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>