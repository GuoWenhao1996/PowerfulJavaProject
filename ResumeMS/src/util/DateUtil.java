package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 转换日期工具类
 * 
 * @author gwh
 * @version 1.0
 */
public class DateUtil {

	/**
	 * 传入日期，传出指定格式
	 * 
	 * @param str
	 *            日期
	 * @return 指定格式的日期
	 */
	public static String changeDateFomat(String str) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年M月");
		if (str != null) {
			LocalDate localDate = LocalDate.parse(str);
			return localDate.format(dtf);
		} else {
			return "　";
		}
	}

}
