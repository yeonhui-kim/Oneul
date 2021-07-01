package com.oneul.web.api.controller;
//package com.oneul.web.api.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//import javax.websocket.server.PathParam;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.newlecture.web.dao.NoticeDao;
//import com.newlecture.web.entity.Notice;
//import com.newlecture.web.service.NoticeService;
//
//@RestController("ApiNoticeController")
//@RequestMapping("api/notice/")
//public class FreeDiaryController { //noticeController
//	
//	@Autowired
//	private 서비스맹글고 service;	
//		
//	
//	@CrossOrigin("http://127.0.0.1:5500")
//	@RequestMapping("list")
//	public Map<String ,Object> list(@RequestParam( name = "p", defaultValue = "1") Integer page) {
//		Map<String, Object> map = new HashMap<>(); 
//		
//		List<다이어리여기다넣어지나?> list = service.getList(page);
//		int count =1;
//		map.put("list", list);
//		map.put("count", count);
//		
//
//		
//		return map;
//	}
//	
//	
//
//	
//	
//	@CrossOrigin("http://127.0.0.1:5500")
//	@RequestMapping("detail/{id}")
//	public Notice  detail(@PathVariable int id) {
//
//		
//		return service.get(id);
//	}
//	
//	// /admin/notice/detail
//	
//	//@RequestMapping(value ="reg", method = RequestMethod.GET)
//	@GetMapping("reg")
//	public ModelAndView reg(
//			@RequestParam(name = "f", defaultValue = "title") String field, 
//			@RequestParam(defaultValue = "0") Integer x, 
//			@RequestParam(defaultValue = "0") Integer y,/*, HttpServletRequest request*/
//			@CookieValue(name = "test", defaultValue = "hi") String test,			
//			MultipartFile file,
//			HttpServletResponse response
//			) {	
//		
////		if(너 로그인 했니?)
////			if(너 관리자니?)
////				return "redirect:error";
//		
//		if(test.equals("hi")) {
//		   	Cookie cookie = new Cookie("test", "hello");
//		   	cookie.setMaxAge(10*24*60*60);
//		   	cookie.setPath("/");
//		   	response.addCookie(cookie);
//		   	
//		   	//   /admin/notice/*
//		   	//   /admin/notice/aa/bb/list
//		   	//   /notice/list
//	   	}
//		
//		// 1. Servlet API를 이용한 방법
//		//String x_ = request.getParameter("x");
//		//String y_ = request.getParameter("y");
//		
//		// 2. 파라미터 이름으로 자동 입력
////		int x = 0;
////		
////		if(x != null && x.) // 널인지 아닌지..
////			x = Integer.parseInt(x);				
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("admin.notice.reg");
//		// /upload/lecture/12/.....
//		
//		
//		
//		return mv;
//		
//		//return String.format("x_:%s, y_:%s", x_, y_) + "<br>" + String.format("x:%s, y:%s", x, y);
//		//return String.format("x:%d, y:%d, result:%d, field:%s, test cookie:%s, uid:%s, id : %d", x, y, x+y, field, test, uid, id);
//	}
//	
//	//@RequestMapping(value ="reg", method = RequestMethod.POST)
//	@PostMapping("reg")
//	public String reg(
//			String title,
//			String content) {
//		
//		Notice notice = new Notice();
//		notice.setTitle(title);
//		notice.setContent(content);
//		notice.setWriterId("newlec");
//		
//		service.insert(notice);
//		//service.insert(title, content);
//		
//		return "redirect:list";
//	}
//		
//	
//	@GetMapping("edit")
//	public String edit(int id, Model model) {
//		
//		Notice notice = service.get(id);
//		model.addAttribute("notice", notice);
//		
//		//int[] ids = {23,40,45};
////		List<Notice> list = noticeDao.getListIn(new int[]{23,40,45});
////		model.addAttribute(list);
//		
//		return "admin.notice.edit";
//	}
//	
//	@PostMapping("edit")
//	public String edit(Notice notice) {
//						
//		service.update(notice);
//		
//		return "redirect:detail?id="+notice.getId();
//	}
//	
//	@RequestMapping("del")
//	public String del(int id) {
//		
//		service.delete(id);
//		
//		return "redirect:list";
//	}
//	
//	
//}
