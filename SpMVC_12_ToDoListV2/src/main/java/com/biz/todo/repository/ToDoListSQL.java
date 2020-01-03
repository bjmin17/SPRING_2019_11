package com.biz.todo.repository;

import org.apache.ibatis.jdbc.SQL;

import com.biz.todo.domain.ToDoList;

public class ToDoListSQL {

	public final static String complete_sql = "UPDATE tbl_todoList "
			+ " SET td_complete = DECODE(td_complete,'Y','N','Y') "
			+ " WHERE td_Seq = #{td_seq,jdbcType=VARCHAR} ";
	
	// 아래에서처럼 객체를 이용하는게 아닌, 익명클래스 이용
	// SQL 클래스의 builder 패턴
	// 동적쿼리로 요리를 하고 싶으면 매개변수 첨가하고 값을 받아서
	// if문으로 요리하기, 대신 final로 받아야한다.
	public String insert_sql(final ToDoList toDoList) {
		// 익명(무명)클래스 builder 패턴방식
		return new SQL() {{
			
			INSERT_INTO("tbl_todolist");
			
//			INTO_COLUMNS("td_seq").INTO_VALUES("#{td_seq}");
			
			INTO_COLUMNS("TD_SEQ");
			INTO_COLUMNS("TD_DATE");
			INTO_COLUMNS("TD_TIME");
			INTO_COLUMNS("TD_SUBJECT");
			INTO_COLUMNS("TD_TEXT");
			INTO_COLUMNS("TD_FLAG");
			INTO_COLUMNS("TD_COMPLETE");
			INTO_COLUMNS("TD_ALARM");
			
			
			INTO_VALUES("SEQ_TODO.NEXTVAL");
			INTO_VALUES("#{td_date,jdbcType=VARCHAR}");
			INTO_VALUES("#{td_time,jdbcType=VARCHAR}");
			INTO_VALUES("#{td_subject,jdbcType=VARCHAR}");
			INTO_VALUES("#{td_text,jdbcType=VARCHAR}");
			INTO_VALUES("#{td_flag,jdbcType=VARCHAR}");
			INTO_VALUES("#{td_complete,jdbcType=VARCHAR}");
			INTO_VALUES("#{td_alarm,jdbcType=VARCHAR}");
		}}.toString();
	}
	
	/*
	 * SQL class
	 * mybatis 3.4(3.5) 이상에서 사용되는 동적 쿼리를 지원하는 클래스
	 */
	public String alarm_sql() {
		
		SQL sql = new SQL();
		sql.UPDATE("tbl_todoList");
		sql.WHERE("td_seq = #{td_seq,jdbcType=VARCHAR}");
		sql.SET("td_alarm = DECODE(td_alarm,'Y','N','Y')");
		
		return sql.toString();
		
	}
	
	public String update_sql() {
		
		return new SQL() {{
			
			UPDATE("tbl_todolist");
			WHERE("td_seq = #{td_seq,jdbcType=VARCHAR}");
			
			SET("td_date = #{td_date,jdbcType=VARCHAR}");
			SET("td_time = #{td_time,jdbcType=VARCHAR}");
			SET("td_subject = #{td_subject,jdbcType=VARCHAR}");
			SET("td_text = #{td_text,jdbcType=VARCHAR}");
			SET("td_flag = #{td_flag,jdbcType=VARCHAR}");
			SET("td_complete = #{td_complete,jdbcType=VARCHAR}");
			SET("td_alarm = #{td_alarm,jdbcType=VARCHAR}");

			
		}}.toString();
		
	}
	
}