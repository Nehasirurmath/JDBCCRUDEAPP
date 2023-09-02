package com.csi.service;

import com.scsi.dao.Dao;
import com.scsi.dao.DaoImpl;

public class ServiceImpl implements Service{
	Dao dao=new DaoImpl();

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		dao.insert();
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		dao.show();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		dao.update();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		dao.delete();
	}

}
