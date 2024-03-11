package org.zerock.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class boardDAOTest {
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("새로운글넣는다..");
		board.setContent("새로운 글 넣는다.");
		board.setWriter("user112");
		dao.create(board);
	}
	@Test
	public void testRead() throws Exception {
		log.info(dao.read(1).toString());
	}
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된글입니다.");
		board.setContent (" 수정테스트" );
		dao.update(board);
	}
	@Test
	public void testDelete() throws Exception{
		dao.delete((long) 1);
	}

}
