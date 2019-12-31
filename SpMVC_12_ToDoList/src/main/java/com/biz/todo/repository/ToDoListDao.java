package com.biz.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.todo.domain.ToDoList;

public interface ToDoListDao {

	public List<ToDoList> selectAll();
	
	public int insert(ToDoList todoList);
	public int update(ToDoList todoList);
	public int delete(long td_Seq);

	public int complete(@Param("tdSeq") long td_Seq, @Param("tdComplete") String tdComplete);

	public int alarm(@Param("tdSeq") long tdSeq, @Param("tdAlarm") String tdAlarm);
	
	
}
