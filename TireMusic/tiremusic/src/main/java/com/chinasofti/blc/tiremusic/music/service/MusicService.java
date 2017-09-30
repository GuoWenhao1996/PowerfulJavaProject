package com.chinasofti.blc.tiremusic.music.service;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.blc.tiremusic.common.util.ConditionUtil;
import com.chinasofti.blc.tiremusic.music.dao.MusicDao;
import com.chinasofti.blc.tiremusic.music.entity.Music;

public class MusicService {

	private MusicDao musicDao =new MusicDao();
	/**
	 * 分页加载所有信息
	 * @param page
	 * @param row
	 * @return
	 */
//	public Map<String,Object> queryAllMusicsPage(int page,int row){
//		int total =musicDao.queryAllMusics().size();
//		List<Music> list= musicDao.queryAllMusicsPage(page, row);
//		Map<String, Object> map =new HashMap<>();
//		map.put("total", total);
//		map.put("rows", list);
//		return map;
//	}
	public Map<String,Object> queryAllMusicsPage(int page,int rows,String songname,String schoolid,String songerid,String albumid){
		//拼接sql
		String sql="select * from song";
		ConditionUtil cu = new ConditionUtil(sql);
		cu.appendLike(1, "songname", songname);
		cu.appendEquals(1, "schoolid", schoolid, Types.INTEGER);
		cu.appendEquals(1, "songerid", songerid, Types.INTEGER);
		cu.appendEquals(1, "albumid", albumid, Types.INTEGER);
		//查询数量
		int total =musicDao.queryAllMusics(cu.toString()).size();
		//System.out.println(total);
		//查询当前页面
		sql="select s.songid,s.songname,s.songerid,se.songername,a.albumid,a.albumname,s.schoolid,sc.schoolname,s.frontimg,s.songstate,s.location from song s join songer se on s.songerid= se.songerid join song_album sa on s.songid=sa.songid join album a on sa.albumid=a.albumid join school sc on s.schoolid=sc.schoolid ";
		cu=new ConditionUtil(sql);
		cu.appendLike(1, "s.songname", songname);
		cu.appendEquals(1, "s.schoolid", schoolid, Types.INTEGER);
		cu.appendEquals(1, "s.songerid", songerid, Types.INTEGER);
		cu.appendEquals(1, "a.albumid", albumid, Types.INTEGER);
		cu.appendLimit(page, rows);
		
		List<Music> list =musicDao.queryAllMusicsPage(cu.toString());
//		for (Music music : list) {
//			System.out.println(music);
//		}
		
		Map<String, Object> map =new HashMap<>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
//	/**
//	 * 加载所有music信息
//	 * @return
//	 */
//	public List<Music> queryAllMusics(){
//		return musicDao.queryAllMusics();
//	}
	/**
	 * 添加歌曲
	 * @param songid
	 * @param schoolid
	 * @param songerid
	 * @param songname
	 * @param frontimg
	 * @param songstate
	 * @param location
	 * @param albumid
	 * @return
	 */
	public int addMusic(int schoolid,int songerid,String songname,String frontimg,int songstate,String location,int albumid) {
		return musicDao.addMusic( schoolid, songerid, songname, frontimg, songstate, location, albumid);
	}
	/**
	 * 非物理删除歌曲 ，将歌曲状态改为0，在用户页面不显示
	 * @param songid
	 * @return
	 */
	public int deleteMusic(int songid) {
		return musicDao.deleteMusic(songid);
	}
	public int  editMusic(int songid,int songerid,int albumid,int schoolid,String songname,int songstate) {
		return musicDao.editMusic(songid, songerid, albumid, schoolid, songname,songstate);
	}
}
