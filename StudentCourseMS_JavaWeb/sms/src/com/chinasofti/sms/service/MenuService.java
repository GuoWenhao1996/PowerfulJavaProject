package com.chinasofti.sms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.sms.dao.MenuDao;
import com.chinasofti.sms.entity.Menu;

/**
 * 菜单服务层
 * 
 * @author guowh
 *
 */
public class MenuService {
	MenuDao menudao = new MenuDao();

	/**
	 * 根据用户类型查询所有的菜单
	 * 
	 * @param type
	 *            用户类型
	 * @return 菜单集合
	 */
	public List<Menu> queryAllMenuByUserType(int type) {
		List<Menu> menus = menudao.queryAllMenuByRid(type);
		if (menus == null || menus.size() == 0) {
			return null;
		}
		// 找到主菜单
		List<Menu> parentMenus = new ArrayList<>();
		for (Menu menu : menus) {
			if (menu.getParentid() == 0) {
				parentMenus.add(menu);
			}
		}
		// 为主菜单添加子菜单
		for (Menu parent : parentMenus) {
			for (Menu child : menus) {
				if (child.getParentid() == parent.getMid()) {
					parent.getChildren().add(child);
				}
			}
		}
		return parentMenus;
	}

	/**
	 * 为easyUI分页提供total和rows
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> loadMenusPage(int pageNum, int pageSize, String name) {
		if (name == null) {
			name = "%%";
		} else {
			name = "%" + name + "%";
		}
		int total = menudao.queryAllMenus(name).size();
		List<Menu> rows = menudao.queryAllMenusPage(pageNum, pageSize, name);
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", rows);
		return map;
	}
}
