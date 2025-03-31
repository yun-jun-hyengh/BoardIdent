package com.example.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private EntityManager entityManager;
	
	@GetMapping("/boardfile")
	public String boardList(Model model) { // 여기 한번 수정 
		String sql = " SELECT idx, title, content, writer, regdate, "
				+ " case when fileName IS NOT NULL then 'Y' ELSE 'N' "
				+ " END as file_existence "
				+ " FROM tbl_board ORDER BY idx DESC ";
		
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> resultList = query.getResultList();
		List<Map<String, Object>> boardList = new ArrayList<>();
		
		for(Object[] row : resultList) {
			Map<String, Object> map = new HashMap<>();
			map.put("idx", row[0]);
			map.put("title", row[1]);
			map.put("content", row[2]);
			map.put("writer", row[3]);
			map.put("regdate", row[4]);
			map.put("file_existence", row[5]);
			boardList.add(map);
		}
		model.addAttribute("boardList", boardList);
		return "board/boardlist"; // 현재 board디렉토리에 boardlist라는 jsp 파일이 존재함 111467
	}
}
