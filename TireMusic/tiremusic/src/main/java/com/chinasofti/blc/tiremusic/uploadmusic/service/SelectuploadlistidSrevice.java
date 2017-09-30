package com.chinasofti.blc.tiremusic.uploadmusic.service;

import com.chinasofti.blc.tiremusic.uploadmusic.dao.Selectuploadlistid;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Uploadlist;

public class SelectuploadlistidSrevice {
	private Selectuploadlistid selectuploadlistid=new Selectuploadlistid();
	public Uploadlist selectuploadid() {
		return selectuploadlistid.selectuploadid();
	}
}
