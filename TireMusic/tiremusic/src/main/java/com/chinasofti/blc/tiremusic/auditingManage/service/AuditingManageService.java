package com.chinasofti.blc.tiremusic.auditingManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.blc.tiremusic.auditingManage.dao.AuditingManageDao;
import com.chinasofti.blc.tiremusic.auditingManage.entity.Auditing;

/**
 * 审核管理 service
 * @author ASUS
 *
 */
public class AuditingManageService {
	AuditingManageDao auditingManageDao = new AuditingManageDao();
	
	/**
	 * 分页查询待显示的文件
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> loadAuditingPage(int pageNum, int pageSize){
		Map<String, Object> map = new HashMap<>();
		int total = auditingManageDao.showAllAuditing().size();
		List<Auditing> list = auditingManageDao.showAllAuditingPage(pageNum, pageSize);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 显示所有待审核的文件
	 * @return
	 */
	public List<Auditing> showAllAuditing(){
		return auditingManageDao.showAllAuditing();
	}
	
	/**
	 * 上传歌曲的审核不通过
	 * @param uploadlistid
	 * @return
	 */
	public boolean updateAuditingStateNoAC(int uploadlistid) {
		
		return auditingManageDao.updateAuditingStateNoAC(uploadlistid);
	}
	/**
	 * 上传歌曲的审核通过
	 * @param uploadlistid
	 * @return
	 */
	public boolean updateAuditingStateAC(int uploadlistid) {
		
		return auditingManageDao.updateAuditingStateAC(uploadlistid);
	}
}
