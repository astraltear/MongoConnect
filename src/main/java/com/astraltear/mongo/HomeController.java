package com.astraltear.mongo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MongoDAO mongoDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		TestVO testVO = new TestVO();
		
		testVO.setName("È«±æµ¿");
		testVO.setJob("³îÀÚ");
		testVO.setInfo1("1¹ø Á¤º¸!!!!");
		testVO.setInfo2("Á¤º¸ 2¹øÀº ¹¹³Ä???");
		
		mongoDAO.insertTestVO(testVO);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
