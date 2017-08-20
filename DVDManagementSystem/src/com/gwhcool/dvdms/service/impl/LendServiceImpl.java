package com.gwhcool.dvdms.service.impl;

import java.util.Date;
import java.util.List;

import com.gwhcool.dvdms.dao.LendDao;
import com.gwhcool.dvdms.dao.impl.LendDaoImpl;
import com.gwhcool.dvdms.entity.Lend;
import com.gwhcool.dvdms.service.LendService;

public class LendServiceImpl implements LendService {

	private LendDao ld = new LendDaoImpl();

	@Override
	public List<Lend> getALLLend() {
		return ld.getALLLend();
	}

	@Override
	public List<Lend> getLendByDVDId(int id) {
		return ld.getLendByDVDId(id);
	}

	@Override
	public List<Lend> getLendByCustomId(int id) {
		return ld.getLendByCustomId(id);
	}

	@Override
	public boolean addLend(Lend lend) {
		lend.setLendtime(new Date());
		return ld.addLend(lend);
	}

	@Override
	public boolean deleteLend(Lend lend) {
		lend.setBacktime(new Date());
		return ld.deleteLend(lend);
	}

}
