package com.chinasofti.blc.tiremusic.mv.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.mv.entity.Mv;
/**
 * MV操作类
 * @author Administrator
 *
 */
public class MvDao {
	/**
	 * 查询并返回所有的MV
	 * @return
	 */
	public List<Mv> loadAllMv(){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
		List<Mv> list =queryRunner.query(connection,"select * from mv where mvpustate=1",new BeanListHandler<>(Mv.class));
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 根据sql语句查询并返回所有的MV
	 * @return
	 */
	public List<Mv> loadAllMv(String sql){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
		List<Mv> list =queryRunner.query(connection,sql,new BeanListHandler<>(Mv.class));
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 查询所有通过审核且上架的MV
	 * @return
	 */
	public List<Mv> loadAllMvByState(){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
		List<Mv> list =queryRunner.query(connection,"select * from mv where mvpustate=1 and mvstate=1",new BeanListHandler<>(Mv.class));
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 上架MV
	 * @return
	 */
	public boolean putMv(int mvid){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		boolean result=false;
		try {
			
			queryRunner.update(connection, "update mv set mvstate='1' where mvid=?",mvid);
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 下架MV
	 * @param mvid
	 * @return
	 */
	public boolean downMv(int mvid){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		boolean result=false;
		try {
			queryRunner.update(connection, "update mv set mvstate='0' where mvid=?",mvid);
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 根据歌曲id查询歌曲名称
	 * @param mvid
	 * @return
	 */
	public String serachSongnameBysongid(int songid){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
			
			String songnam =queryRunner.query(connection, "select songname from song where songid=?", new ScalarHandler<>(),songid);
			return songnam;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 查询所有歌曲id
	 * @return
	 */
	public List<Song> searchAllSongid(){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
		List<Song> list =queryRunner.query(connection,"select songid from song",new BeanListHandler<>(Song.class));
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 更新MV信息
	 * @param mvid
	 * @return
	 */
	public int updateMvInfo(String mvname,int songid,String mvtext,Date releasetime,int mvid){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
			queryRunner.update(connection, "update mv set mvname=?,songid=?,mvtext=?,releasetime=? where mvid=?",mvname,songid,mvtext,releasetime,mvid);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	/**
	 * 增加MV
	 */
	public boolean addMv(String mvname,int Songid,String mvtext,Date releasetime,String location){
		Connection connection = DBUtil.getConnection();
		QueryRunner qRunner=new QueryRunner();
		boolean result=false;
		try {
			qRunner.insert(connection, "insert into mv(mvname,songid,mvtext,releasetime,frontimg,location,mvpustate,mvstate) values(?,?,?,?,?,?,0,0)",new ScalarHandler<Integer>(),mvname,Songid,mvtext,releasetime,"http://localhost:8080/img/m42.jpg",location);
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 审核MV
	 * @param mvname
	 * @param songid
	 * @param mvtext
	 * @param releasetime
	 * @param mvid
	 * @return
	 */
	public boolean auditingMv(int mvid){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		boolean result=false;
		try {
			queryRunner.update(connection, "update mv set mvpustate=1 where mvid=?",mvid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 根据MVID查新MV地址
	 * @return
	 */
	public String loadMvById(int mvid){
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner =new QueryRunner();
		try {
			String location=queryRunner.query(connection,"select location from mv where mvid=?", new ScalarHandler<>(),mvid);
			System.out.println(location);
			return location;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
