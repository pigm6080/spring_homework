package org.zerock.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	@Test
	public void testService() {
		log.info(service);
		assertNotNull(service);
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새로작성하는글");
		boardVO.setContent("새로 작성하는 내용");
		boardVO.setWriter("newbie");
		
		
		
		service.register(boardVO);
	}
	
	@Test
	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	@Test
	public void testDelete() {
		//게시물번호를 먼저 확인하고 테스트
		log.info("remove : " + service.remove(2L));
	}
	@Test
	public void testUpdate() {
		//게시물번호를 먼저 확인하고 테스트
		BoardVO boardVO = service.get(2L);
		
		if(boardVO == null) {
			return;
		}
		boardVO.setTitle("제목을 수정한다");
		log.info("Modify 수정완료 : " + service.modify(boardVO));
	}
}
