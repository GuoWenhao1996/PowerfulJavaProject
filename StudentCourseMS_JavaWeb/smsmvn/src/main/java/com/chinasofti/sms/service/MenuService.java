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
	 * 查询所有父级菜单
	 * 
	 * @return
	 */
	public List<Menu> queryAllParentMenus() {
		List<Menu> menus = menudao.queryAllMenus("%%");
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

	/**
	 * 添加菜单
	 * 
	 * @param name
	 * @param url
	 * @param pid
	 * @return
	 */
	public boolean addMenu(String name, String url, String pid) {
		return menudao.addMenu(name, url, Integer.parseInt(pid));
	}

	/**
	 * 删除菜单
	 * 
	 * @param mids
	 * @return
	 */
	public boolean deleteMenu(String mids) {
		String midStrs[] = mids.split(",");
		int[] mid = new int[midStrs.length];
		for (int i = 0; i < mid.length; i++) {
			mid[i] = Integer.parseInt(midStrs[i]);
		}
		return menudao.deleteMenu(mid);
	}

	/**
	 * 修改菜单
	 * 
	 * @param mid
	 * @param name
	 * @param url
	 * @param pid
	 * @return
	 */
	public boolean editMenu(String mid, String name, String url, String pid) {
		return menudao.editMenu(Integer.parseInt(mid), name, url, Integer.parseInt(pid));
	}
}
