package com.chinasofti.blc.tiremusic.common.util;

import java.sql.Types;


/**
 * sql条件拼接 bate1.0
 * 
 * @author lsg、gwh
 * @version 1.1 对and、or拼接进行了改进
 *
 */
public class ConditionUtil {
	private StringBuilder sql;
	public static final int AND = 1;
	public static final int OR = 2;

	public ConditionUtil(String sql) {
		this.sql = new StringBuilder(sql);
		if (this.sql.indexOf("where")==-1) {
			this.sql.append(" where 1=1");
		}
	}

	/**
	 * 拼接大于
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 * @param type
	 *            字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendBiger(int logical, String field, String value, int type) {
		if (value == null || value.equals("")) {
			return;
		}
		appendLogical(logical);
		if (type == Types.VARCHAR || type == Types.CHAR || type == Types.DATE) {
			sql.append(field + ">'" + value + "'");
		} else {
			sql.append(field + ">" + value);
		}
	}

	/**
	 * 拼接小于条件
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 * @param type
	 *            字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendSmaller(int logical, String field, String value, int type) {
		if (value == null || value.equals("")) {
			return;
		}
		appendLogical(logical);
		if (type == Types.VARCHAR || type == Types.DATE || type == Types.CHAR) {
			sql.append(field + "<" + "'" + value + "'");
		} else {
			sql.append(field + "<" + value);
		}
	}

	/**
	 * 拼接大于等于条件
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 * @param type
	 *            字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendNoSmailler(int logical, String field, String value, int type) {
		if (value == null || value.equals("")) {
			return;
		}
		appendLogical(logical);
		if (type == Types.VARCHAR || type == Types.DATE || type == Types.CHAR) {
			sql.append(field + ">=" + "'" + value + "'");
		} else {
			sql.append(field + ">=" + value);
		}
	}

	/**
	 * 拼接分页条件
	 * 
	 * @param pageNum
	 * @param pageSize
	 */
	public void appendLimit(int pageNum, int pageSize) {
		sql.append(" limit " + (pageNum - 1) * pageSize + "," + pageSize);
	}

	/**
	 * 拼接小于等于条件
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 * @param type
	 *            字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendNoBigger(int logical, String field, String value, int type) {
		if (value == null || value.equals("")) {
			return;
		}
		appendLogical(logical);
		if (type == Types.VARCHAR || type == Types.DATE || type == Types.CHAR) {
			sql.append(field + "<=" + "'" + value + "'");
		} else {
			sql.append(field + "<=" + value);
		}
	}

	/**
	 * 拼接模糊查询条件
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 */
	public void appendLike(int logical, String field, String value) {
		appendLogical(logical);
		if (value != null && !value.equals("")) {
			sql.append(field + " like '%" + value + "%'");
		} else {
			sql.append(field + " like '%%'");
		}
	}

	/**
	 * 拼接相等条件
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 * @param type
	 *            字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendEquals(int logical, String field, String value, int type) {
		if (value == null || value.equals("")) {
			return;
		}
		appendLogical(logical);
		if (type == Types.VARCHAR || type == Types.DATE || type == Types.CHAR) {
			sql.append(field + "=" + "'" + value + "'");
		} else {
			sql.append(field + "=" + value);
		}
	}

	/**
	 * 拼接不相等条件
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 * @param field
	 *            要拼接的字段名称
	 * @param value
	 *            要拼接的值
	 * @param type
	 *            字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendNotEquals(int logical, String field, String value, int type) {
		if (value == null || value.equals("")) {
			return;
		}
		appendLogical(logical);
		if (type == Types.VARCHAR || type == Types.DATE || type == Types.CHAR) {
			sql.append(field + "!=" + "'" + value + "'");
		} else {
			sql.append(field + "!=" + value);
		}
	}

	/**
	 * 判断条件中添加and还是or
	 * 
	 * @param logical
	 *            逻辑标志(1=and、2=or)
	 */
	private void appendLogical(int logical) {
		if (logical == AND) {
			sql.append(" and ");
		} else if (logical == OR) {
			sql.append(" or ");
		}
	}

	@Override
	public String toString() {
		return sql.toString();
	}
}
