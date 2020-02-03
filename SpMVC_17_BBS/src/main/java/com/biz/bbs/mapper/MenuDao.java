package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.MenuVO;

@Mapper
public interface MenuDao {

	// many는 리스트(getSubMenu)가 쭉 나오면 1:N, 일대다의 관계를 나타냄
	
	// 자기자신을 self join 해서 p_id가 없는 친구들을 리스트로 나타내고
	// 그것을 이용해서 값을 뽑아냄
	// 부모 아이디와 자기가 가지고 있는 #{menu_id}를 맞춰봐서 해당되는 것만 가져오기
	// 댓글 달기를 위해 사용할 예정
	@Select("SELECT * FROM tbl_menu WHERE menu_p_id is null ORDER BY menu_id")
	@Results(value= {
			@Result(property = "menu_id", column="menu_id"),
			@Result(property = "drop_menus", column="menu_id",
					javaType = List.class,
					many=@Many(select="getSubMenu"))
	
	})
	public List<MenuVO> getAllMenu();
	
	
	@Select("SELECT * FROM tbl_menu WHERE menu_p_id = #{menu_id}")
	public List<MenuVO> getSubMenu(String menu_id);
	
	
	
	
	
}
