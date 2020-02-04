package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.mapper.BBsDao;

import lombok.RequiredArgsConstructor;

@Service("bServiceV1")
@RequiredArgsConstructor
public class BBsServiceImplV1 implements BBsService {

	/*
	 * protected
	 * 상속받은 클래스에서만 접근가능하도록 한다.
	 * 
	 */
	protected final BBsDao bbsDao;
	
	@Override
	public List<BBsVO> selectAll() {
		// TODO Auto-generated method stub
		//return bbsDao.selectAll();
		return bbsDao.selectMain();
	}

	@Override
	public BBsVO findById(long bbs_id) {

		return bbsDao.findById(bbs_id);
	}

	@Override
	public List<BBsVO> findBySubjects(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBsVO> findByWriters(String writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBsVO> findBySubAndWriter(String subject, String writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(BBsVO bbsVO) {
		
		long bbs_id = bbsVO.getBbs_id();
		if(bbs_id > 0) {
			bbsDao.update(bbsVO);
		} else {
			bbsDao.insert(bbsVO);
		}
		
		
		return 0;
	}

	@Override
	public int delete(long bbs_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BBsVO reply(BBsVO bbsVO) {

		// 원래있던 PK를 부모의 값으로 세팅하고
		bbsVO.setBbs_p_id(bbsVO.getBbs_id());
		// PK를 0으로 하면서 답글이라는 것을 나타냄
		bbsVO.setBbs_id(0);
		String subject = "re : " + bbsVO.getBbs_subject();
		bbsVO.setBbs_subject(subject);
		bbsDao.insert(bbsVO);
		
		
		return null;
	}

}
