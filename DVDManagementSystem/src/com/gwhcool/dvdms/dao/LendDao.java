package com.gwhcool.dvdms.dao;

import java.util.List;

import com.gwhcool.dvdms.entity.Lend;

/**
 * 借阅操作dao层接口
 * 
 * @author gwh
 * @since 1.5
 */
public interface LendDao {
	/**
	 * 查询出数据库中所有的借阅记录
	 * 
	 * @return lend集合
	 */
	public List<Lend> getALLLend();

	/**
	 * 根据DVDId查询记录
	 * 
	 * @return 只有一项内容的lend集合
	 */
	public List<Lend> getLendByDVDId(int id);

	/**
	 * 根据customId查询记录
	 * 
	 * @return 只有一项内容的lend集合
	 */
	public List<Lend> getLendByCustomId(int id);

	/**
	 * 新增借阅
	 * 
	 * @param lend
	 *            增加的lend对象
	 * @return 增加成功返回true
	 */
	public boolean addLend(Lend lend);

	/**
	 * 归还借阅
	 * 
	 * @param lend
	 *            归还的lend对象
	 * @return 归还成功返回true
	 */
	public boolean deleteLend(Lend lend);

}
