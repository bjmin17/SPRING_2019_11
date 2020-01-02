package com.biz.todo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;

@Service("todoV3")
public class ToDoServiceV3 extends ToDoServiceV2 {

	@Override
	public ToDoList findBySeq(long tdSeq) {
		return toDao.findBySeq(tdSeq);
	}

	@Override
	public List<ToDoList> findBySubject(String tdSubject) {
		// TODO Auto-generated method stub
		return toDao.findBySubject(tdSubject);
	}

	@Override
	public int update(ToDoList toDoList) {
		return toDao.update(this.procToDoList(toDoList));
		
	}

	@Override
	public int insert(ToDoList toDoList) {
	
		return toDao.insert(this.procToDoList(toDoList));
	}
	
	protected ToDoList procToDoList(ToDoList toDoList) {
		String td_date = toDoList.getTd_date();
		String td_time = toDoList.getTd_time();
		String td_complete = toDoList.getTd_complete();
		String td_alarm = toDoList.getTd_alarm();
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		if(td_date == null || td_date.isEmpty()) td_date = sd.format(date);
		if(td_time == null || td_time.isEmpty()) td_time = st.format(date);
		if(td_alarm == null || td_alarm.isEmpty()) td_complete = "N";
		if(td_complete == null || td_complete.isEmpty()) td_alarm = "N";
		
		toDoList.setTd_date(td_date);
		toDoList.setTd_time(td_time);
		toDoList.setTd_alarm(td_alarm);
		toDoList.setTd_complete(td_complete);
		
		return toDoList;
	}

	
	
	
}
