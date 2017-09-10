package com.gwhcool.vipcardms.service;

import java.util.Date;
import java.util.List;

import com.gwhcool.vipcardms.dao.MoneyDao;
import com.gwhcool.vipcardms.dao.UserDao;
import com.gwhcool.vipcardms.entity.Addlog;
import com.gwhcool.vipcardms.entity.Costlog;

/**
 * 余额服务层
 * 
 * @author gwh
 *
 */
public class MoneyService {
	MoneyDao moneyDao = new MoneyDao();
	UserDao userDao = new UserDao();

	/**
	 * 修改余额并插入充值记录
	 * 
	 * @param uid
	 * @param money
	 * @return
	 */
	public boolean addmoney(int uid, String money, String count) {
		Addlog log = new Addlog(new Date(), Double.parseDouble(money), uid);
		boolean flag1 = moneyDao.addmoney(uid, Double.parseDouble(money), Integer.parseInt(count));
		int usercount = userDao.getUserByUid(uid).getCount();
		int type = 0;
		if (usercount == 0) {
			type = 1;
		} else if (usercount < 100) {
			type = 2;
		} else if (usercount < 1000) {
			type = 3;
		} else if (usercount < 10000) {
			type = 4;
		} else if (usercount < 100000) {
			type = 5;
		} else {
			type = 6;
		}
		boolean flag2 = moneyDao.updateCardtype(uid, type);
		boolean flag3 = moneyDao.insertLog(log);
		return flag1 && flag2 && flag3;
	}

	/**
	 * 查询某用户的充值记录
	 * 
	 * @param uid
	 * @return
	 */
	public List<Addlog> queryAddLogByUid(int uid) {
		return moneyDao.queryAddLogByUid(uid);
	}

	/**
	 * 查询所有人充值记录
	 * 
	 * @return
	 */
	public List<Addlog> queryAllAddLog() {
		return moneyDao.queryAllAddLog();
	}

	/**
	 * 修改余额并插入消费记录
	 * 
	 * @param uid
	 * @param money
	 * @return
	 */
	public boolean costmoney(int uid, String descrip, String money, String count) {
		Costlog log = new Costlog(new Date(), Double.parseDouble(money), descrip, uid);
		boolean flag1 = moneyDao.addmoney(uid, -Double.parseDouble(money), Integer.parseInt(count));
		int usercount = userDao.getUserByUid(uid).getCount();
		int type = 0;
		if (usercount == 0) {
			type = 1;
		} else if (usercount < 100) {
			type = 2;
		} else if (usercount < 1000) {
			type = 3;
		} else if (usercount < 10000) {
			type = 4;
		} else if (usercount < 100000) {
			type = 5;
		} else {
			type = 6;
		}
		boolean flag2 = moneyDao.updateCardtype(uid, type);
		boolean flag3 = moneyDao.insertLog(log);
		return flag1 && flag2 && flag3;
	}

	/**
	 * 查询某用户的充值记录
	 * 
	 * @param uid
	 * @return
	 */
	public List<Costlog> queryCostLogByUid(int uid) {
		return moneyDao.queryCostLogByUid(uid);
	}

	/**
	 * 查询所有人充值记录
	 * 
	 * @return
	 */
	public List<Costlog> queryAllCostLog() {
		return moneyDao.queryAllCostLog();
	}

}
