package com.chinasofti.blc.tiremusic.statistics.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.statistics.dao.StatisticsAuditionDao;
import com.chinasofti.blc.tiremusic.statistics.dao.StatisticsDownDao;
import com.chinasofti.blc.tiremusic.statistics.dao.StatisticsUserDao;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionNum;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionSong;
import com.chinasofti.blc.tiremusic.statistics.entry.DownNum;
import com.chinasofti.blc.tiremusic.statistics.entry.DownSong;

/**
 * 统计服务层
 * @author ljp
 *
 */
public class Statisticssrvice {
	private StatisticsDownDao sd= new StatisticsDownDao();
	private StatisticsAuditionDao sa = new StatisticsAuditionDao();
	private StatisticsUserDao su = new StatisticsUserDao();
	/**
	 * 获取歌曲的下载量
	 * @return
	 */
	public List<DownNum> getDownNum(){
		return sd.getDownNum();
	}
	/**
	 * 分页返回歌曲下载量
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<DownNum> getDownNumPage(int pageNum,int pageSize){
		return sd.getDownNumPage(pageNum, pageSize);
	}
	/**
	 * 获取歌曲的试听量
	 * @return
	 */
	public List<AuditionNum> getAuditionNum(){
		return sa.getAuditionNum();
	}
	/**
	 * 分页返回歌曲试听量
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<AuditionNum> getAuditionNumPage(int pageNum,int pageSize){
		return sa.getAuditionNumPage(pageNum, pageSize);
	}
	/**
	 * 获取指定数量的下载量排行
	 * @param num
	 * @return
	 */
	public List<DownSong> getDownSong(int num){
		return sd.getDownList(num);
	}
	/**
	 * 获取指定数量的试听量排行
	 * @param num
	 * @return
	 */
	public List<AuditionSong> getAuditionSong(int num){
		return sa.getAuditionList(num);
	}
	/**
	 * 获取当前注册用户的数量
	 * @return
	 */
	public int getUserNum(){
		return su.getUserCount();
	}
}
