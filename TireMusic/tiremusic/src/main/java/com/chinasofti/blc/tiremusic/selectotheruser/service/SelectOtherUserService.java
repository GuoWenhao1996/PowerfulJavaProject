package com.chinasofti.blc.tiremusic.selectotheruser.service;

import com.chinasofti.blc.tiremusic.selectotheruser.dao.SelectOtherDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectOtherUserService {
	private SelectOtherDao dao=new SelectOtherDao();
public JSONObject selectotherusers(int start,int pagesize,String searchname) {
	
	JSONObject otherusers=new JSONObject();
	otherusers.put("total", JSONArray.fromObject(dao.getotherusercount()));
	otherusers.put("rows", JSONArray.fromObject(dao.getotherusers(start, pagesize, searchname)));
	return otherusers;
	
}
}
