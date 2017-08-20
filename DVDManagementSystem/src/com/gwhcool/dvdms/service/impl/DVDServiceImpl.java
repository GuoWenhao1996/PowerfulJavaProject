package com.gwhcool.dvdms.service.impl;

import java.util.Date;
import java.util.List;

import com.gwhcool.dvdms.dao.DVDDao;
import com.gwhcool.dvdms.dao.impl.DVDDaoImpl;
import com.gwhcool.dvdms.entity.DVD;
import com.gwhcool.dvdms.service.DVDService;

/**
 * dvd 业务层实现类
 * 
 * @author gwh
 * @since 1.2
 */
public class DVDServiceImpl implements DVDService {

	private DVDDao dd = new DVDDaoImpl();

	@Override
	public List<DVD> getALLDVD() {
		return dd.getALLDVD();
	}

	@Override
	public List<DVD> getDVDByid(int id) {
		return dd.getDVDByid(id);
	}

	@Override
	public List<DVD> getDVDByName(String name) {
		return dd.getDVDByName(name);
	}

	@Override
	public boolean addDvd(DVD dvd) {
		return dd.addDvd(dvd);
	}

	@Override
	public boolean deleteDvd(DVD dvd) {
		dvd.setState("已下架");
		dvd.setUndertime(new Date());
		return dd.deleteDvd(dvd);
	}
}
