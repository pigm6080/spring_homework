package org.zerock.mapper;

import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		log.info(mapper.getClass().getName());
		log.info(mapper.getList());
	}
	
	@Test
	public void testInsert() {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새로작성하는글");
		boardVO.setContent("새로 작성하는 내용");
		boardVO.setWriter("newbie");
		mapper.insert(boardVO);
		
		log.info(boardVO);
	
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새로작성하는글");
		boardVO.setContent("새로 작성하는 내용");
		boardVO.setWriter("newbie");
		mapper.insertSelectKey(boardVO);
		
		log.info(boardVO);
	
	}
	
	@Test
	public void testRead() {
		BoardVO boardVO = mapper.read(5L);
		
		log.info(boardVO);
	}
	
	@Test
	public void testDelete() {
		
		log.info("DELETE COUNT:" + mapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(1L);
		board.setTitle("수정된제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		mapper.update(board);
		
	}
	
	@Test
	public void testpageing() {
		Criteria criteria = new Criteria();
		
		criteria.setPageNum(1);
		criteria.setAmount(10);
		
		List<BoardVO> list  = mapper.getListWithPaging(criteria);
		
		list.forEach(BoardVO -> log.info(BoardVO));
	}
}
