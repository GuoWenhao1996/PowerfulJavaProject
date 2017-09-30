package com.chinasofti.blc.tiremusic.auditingManage.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.auditingManage.entity.Auditing;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;

/**
 * 审核管理的dao 
 * @author ASUS
 * 歌曲状态：1代表通过，2代表不通过，0代表待审核
 */
public class AuditingManageDao {
	
	/**
	 * 查询出所有待审核的歌曲
	 * @return
	 */
	public List<Auditing> showAllAuditing(){
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			List<Auditing> list =  queryRunner.query(con, "select upload.uploadlistid as uploadlistid,song.songid as songid,songname,upload.uid as uploadid,`user`.uname as uploadname,upload.state as state from song,upload,`user`  where song.uploadlistid=upload.uploadlistid and upload.uid=`user`.uid and upload.state=0", new BeanListHandler<>(Auditing.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public List<Auditing> showAllAuditingPage(int pageNum,int pageSize){
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			List<Auditing> list =  queryRunner.query(con, "select upload.uploadlistid as uploadlistid,song.songid as songid,songname,upload.uid as uploadid,`user`.uname as uploadname,upload.state as state from song,upload,`user`  where song.uploadlistid=upload.uploadlistid and upload.uid=`user`.uid and upload.state=0 limit "+(pageNum-1)*pageSize+","+pageSize, new BeanListHandler<>(Auditing.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 上传歌曲的审核不通过
	 * @param uploadlistid
	 * @return
	 */
	public boolean updateAuditingStateNoAC(int uploadlistid) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			queryRunner.update(con, "update upload set state = 2 where uploadlistid = ?", uploadlistid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 上传歌曲的审核通过
	 * @param uploadlistid
	 * @return
	 */
	public boolean updateAuditingStateAC(int uploadlistid) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			con.setAutoCommit(false);
			queryRunner.update(con, "update upload set state = 1 where uploadlistid = ?", uploadlistid);
			queryRunner.update(con, "update song set songstate = 1 where uploadlistid = ?",uploadlistid);
			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
