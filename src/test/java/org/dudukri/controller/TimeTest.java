package org.dudukri.controller;

import javax.inject.Inject;

import org.dudukri.domain.TimeLapseVO;
import org.dudukri.persistence.TimeLapseDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TimeTest {
	
	private static Logger logger= LoggerFactory.getLogger(TimeTest.class);

	@Inject
	public TimeLapseDAO dao;
	
	
	@Before
	public void setUp(){
		
	}

	@Test
	public void modi(){
		
		System.out.println("start");
		
		TimeLapseVO vo = new TimeLapseVO();
		
		vo.setTimeName("감자");
		vo.setTimeNo(1);
		
		logger.info("vo = " + vo.toString());
		
		dao.timeNameModify(vo);
		
		
	}
	
	@Test
	public void read(){
			
		logger.info("read = " + dao.read("aa"));
		
	}
	

}
