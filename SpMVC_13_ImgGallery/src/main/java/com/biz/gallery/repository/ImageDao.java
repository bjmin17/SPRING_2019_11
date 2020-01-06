package com.biz.gallery.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.gallery.domain.ImageVO;

public interface ImageDao {

	@Select("SELECT * FROM tbl_gallery")
	public List<ImageVO> selectAll();
	
	// 아래 있는 insert 문이 다 수행된 다음에 SELECT를 실행해서 다시 Dao로 return을 해라
	// 이럴 경우 keyColumn이 의미가 있음
//	@SelectKey(keyProperty = "img_seq",keyColumn = "img_seq",
//			resultType = Long.class,statement = "SELECT * FROM tbl_gallery WHERE img_seq = #{img_Seq}",
//			before = false)
	
	// keyProperty와 이름이 같다면 keyColumn은 생략 가능
	@SelectKey(keyProperty = "img_seq",keyColumn = "img_seq",
			resultType = Long.class,statement = "SELECT SEQ_GALLERY.NEXTVAL FROM DUAL",
			before = true)
	@InsertProvider(type=ImageSQL.class,method="insert_sql")
	public int insert(ImageVO imageVO);

	@Select("SELECT * FROM tbl_gallery WHERE img_seq = #{img_seq}")
	public ImageVO findBySeq(String img_seq);

	@UpdateProvider(type=ImageSQL.class,method="update_sql")
	public int update(ImageVO imageVO);

	@Delete("DELETE FROM tbl_gallery WHERE img_seq = #{img_seq}")
	public int delete(String img_seq);
	
	
}
