package com.chinasofti.sms.service;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.sms.dao.PowerDao;
import com.chinasofti.sms.entity.Menu;
import com.chinasofti.sms.entity.MenuVo;

/**
 * 权限业务层
 * 
 * @author guowh
 *
 */
public class PowerService {
	PowerDao powerDao = new PowerDao();

	/**
	 * 根据角色id查询出权限列表
	 * 
	 * @param rid
	 * @return
	 */
	public List<MenuVo> queryPowerByRid(int rid) {
		List<MenuVo> menus = powerDao.queryPowerByRid(rid);
		if (menus == null || menus.size() == 0) {
			return null;
		}
		// 找到主菜单
		List<MenuVo> parentMenus = new ArrayList<>();
		for (MenuVo menu : menus) {
			if (menu.getParentid() == 0) {
				parentMenus.add(menu);
			}
		}
		// 为主菜单添加子菜单
		for (MenuVo parent : parentMenus) {
			for (MenuVo child : menus) {
				if (child.getParentid() == parent.getId()) {
					parent.getChildren().add(child);
				}
			}
		}
		return parentMenus;
	}

	/**
	 * 为指定角色赋予指定权限
	 * 
	 * @param rid
	 * @param mids
	 * @return
	 */
	public boolean updatePower(int rid, String mids) {
		String midStrs[] = mids.split(",");
		int[] mid = new int[midStrs.length];
		for (int i = 0; i < mid.length; i++) {
			mid[i] = Integer.parseInt(midStrs[i]);
		}
		return powerDao.updatePower(rid, mid);
	}
}
