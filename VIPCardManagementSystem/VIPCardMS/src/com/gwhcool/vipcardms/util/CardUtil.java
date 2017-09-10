package com.gwhcool.vipcardms.util;

import java.time.LocalDate;

public class CardUtil {
	public static String getCardId(String lastID) {
		if (lastID.length()<12) {
			lastID = "200000000000";
		}
		String date = lastID.substring(0, 8);
		String index = lastID.substring(8);
		// 为新学生设置相应规则的id
		LocalDate ld = LocalDate.now();
		String nowdate = String.valueOf(ld.getYear());
		if (ld.getMonthValue() < 10) {
			nowdate += "0" + ld.getMonthValue();
		} else {
			nowdate += ld.getMonthValue();
		}
		if (ld.getDayOfMonth() < 10) {
			nowdate += "0" + ld.getDayOfMonth();
		} else {
			nowdate += ld.getDayOfMonth();
		}
		if (!date.equals(nowdate)) {
			index = "0001";
		} else {
			int ID = Integer.parseInt(index) + 1;
			if (ID > 999) {
				index = "" + ID;
			} else if (ID > 99) {
				index = "0" + ID;
			} else if (ID > 9) {
				index = "00" + ID;
			} else {
				index = "000" + ID;
			}
		}
		String newStudentID = nowdate + index;
		return newStudentID;
	}
}
