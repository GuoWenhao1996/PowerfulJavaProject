package com.chinasofti.sms.test;

import java.sql.Types;

import com.chinasofti.sms.util.ConditionUtil;

public class TestConditionUtil {
	public static void main(String[] args) {
		String sql = "select * from tb where a=b";
		ConditionUtil co = new ConditionUtil(sql);
		co.appendBiger(ConditionUtil.AND, "s_no", "123123", Types.VARCHAR);
		co.appendBiger(ConditionUtil.OR, "s_no", "123123", Types.VARCHAR);
		co.appendLike(ConditionUtil.AND, "s_no", "");
		co.appendLike(ConditionUtil.OR, "s_no", "123123");
		System.out.println(co.toString());
	}
}
