package com.chinasofti.blc.tiremusic.music.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.blc.tiremusic.music.dao.SongerDao;
import com.chinasofti.blc.tiremusic.music.entity.Songer;

public class SongerService {

	private SongerDao songerDao = new SongerDao();
	/**
	 * 查询并返回所有歌手信息
	 * @return
	 */
	public List<Songer> queryAllSongers(){
		return songerDao.queryAllSongers();
	}
	
	/**
	 * 分页查询并返回所有歌手信息
	 * @return
	 */
	public Map<String,Object> queryAllSongersPage(int PageNum,int PageSize){
		List<Songer> list = songerDao.queryAllSongersPage(PageNum, PageSize);
		Map<String, Object> map = new HashMap<>();
		int total = songerDao.getSongerNum();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 添加新歌手
	 * @param songername
	 * @param songertext
	 * @return
	 */
	public int addNewSonger(String songername,String songertext){
		Songer songer =new Songer(0, songername, songertext, 1);
		return songerDao.addNewSonger(songer);
	}
	
	/**
	 * 修改歌手
	 * @param songername
	 * @param songertext
	 * @return
	 */
	public int changeSonger(int songerid,String songername,String songertext){
		Songer songer =new Songer(songerid, songername, songertext, 1);
		return songerDao.changeSonger(songer);
	}
	/**
	 * 删除歌手
	 * @param songerid
	 * @return
	 */
	public int deleteSonger(int songerid){
		return songerDao.deleteSonger(songerid);
	}
}
