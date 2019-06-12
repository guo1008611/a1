package com.bawei.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.entity.Stu;
import com.bawei.mapper.StuMapper;

@Service
public class MainService {
	
	@Autowired
	private StuMapper sm;

	public List<Map> list() {
		// TODO Auto-generated method stub
		return sm.list();
	}

	public int add(Stu s) {
		// TODO Auto-generated method stub
		return sm.add(s);
	}

	public Stu updateid(int id) {
		// TODO Auto-generated method stub
		return sm.updateid(id);
	}

	public int update(Stu s) {
		// TODO Auto-generated method stub
		return sm.update(s);
	}

	public int delid(int id) {
		// TODO Auto-generated method stub
		return sm.delid(id);
	}

	public List<Map> selectList(String title) {
		// TODO Auto-generated method stub
		return sm.selectList(title);
	}


	
}
