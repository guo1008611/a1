package com.bawei.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.Stu;

public interface StuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);

	List<Map> list();

	int add(Stu s);

	Stu updateid(@Param("id")int id);

	int update(Stu s);

	int delid(@Param("id")int id);

	List<Map> selectList(String title);
}