package com.chinasofti.blc.tiremusic.mv.service;

import java.util.Date;
import java.util.List;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.util.ConditionUtil;
import com.chinasofti.blc.tiremusic.mv.dao.MvDao;
import com.chinasofti.blc.tiremusic.mv.entity.Mv;
/**
 * Mv服务类
 * @author Administrator
 *
 */
public class MvService {
	
	private MvDao mvDao =new MvDao();
	/**
	 * 查询并返回所有的MV
	 * @return
	 */
	
	public List<Mv> loadAllMv(String mvid,String mvname, String mvtext, String songid,String mvstate,String beginDate, String endDate,String mvpustate){
		String sql= "select * from mv";
		ConditionUtil cUtil= new ConditionUtil(sql);
		cUtil.appendLike(ConditionUtil.AND,"mvid",mvid);
		cUtil.appendLike(ConditionUtil.AND,"mvname",mvname);
		cUtil.appendLike(ConditionUtil.AND,"mvtext",mvtext);
		cUtil.appendLike(ConditionUtil.AND,"songid",songid);
		cUtil.appendLike(ConditionUtil.AND,"mvstate",mvstate);
		if (beginDate!=null&&!beginDate.equals("")) {
			cUtil.appendNoSmailler(ConditionUtil.AND,"releasetime","'"+beginDate+"'",1500-9-10);
		}
		if (endDate!=null&&!endDate.equals("")) {
			cUtil.appendNoBigger(ConditionUtil.AND,"releasetime","'"+endDate+"'",1990-9-28);
		}
		cUtil.appendLike(ConditionUtil.AND, "mvpustate", mvpustate);
		return mvDao.loadAllMv(cUtil.toString());
	}
	/**
	 * 查看所有已上架的MV
	 * @return
	 */
	public List<Mv> loadAllMvByState(){
		return mvDao.loadAllMvByState();
	}
	/**
	 * 上架MV
	 * @param mvid
	 * @return
	 */
	public boolean putMv(int mvid){
		return mvDao.putMv(mvid);
	}
	/**
	 * 下架MV
	 * @param mvid
	 * @return
	 */
	public boolean downMv(int mvid){
		return mvDao.downMv(mvid);
	}
	/**
	 * 根据歌曲id查询歌曲名称
	 * @param songid
	 * @return
	 */
	public String serachSongnameBysongid(int songid){
		return mvDao.serachSongnameBysongid(songid);
	}
	/**
	 * 查询所有的歌曲id
	 * @return
	 */
	public List<Song> searchAllSongid(){
		return mvDao.searchAllSongid();
	}
	/**
	 * 修改MV信息
	 * @param mvid
	 * @return
	 */
	public int updateMvInfo(String mvname,int songid,String mvtext,Date releasetime,int mvid){
		return mvDao.updateMvInfo(mvname, songid, mvtext, releasetime, mvid);
	}
	/**
	 * 增加MV
	 */
	public boolean addMv(String mvname,int Songid,String mvtext,Date releasetime,String location){
		return mvDao.addMv(mvname, Songid, mvtext, releasetime, location);
	}
	/**
	 * 审核MV
	 */
	public boolean auditingMv(int mvid){
		return mvDao.auditingMv(mvid);
	}
	/**
	 * 根据MVid查询MV地址
	 * @param songid
	 * @return
	 */
	public String loadMvById(int mvid){
		return mvDao.loadMvById(mvid);
	}
}
