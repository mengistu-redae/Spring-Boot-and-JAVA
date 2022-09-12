package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/* 
		//the old style of receiving and sending data from and to client
		@RequestMapping("home")
		public String home(HttpServletRequest req) {
			
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			
			//to see if data is received from client
			//use this request URL: http://localhost:8080/home?firstName=Mengistu&lastName=Redae&address=AddisAbaba
			System.out.println("Hi... " + firstName + " " + lastName); 
			
			//send data to client (view or JSP in this case)
			
			//METHOD-1: using request attribute		
			req.setAttribute("fullName", firstName + " " + lastName);
			
			//METHOD-2: using session
			HttpSession session = req.getSession();
			session.setAttribute("address", address);
			
			return "home";
		}
	*/
	
	//use this request URL: http://localhost:8080/home?firstName=Mengistu&lastName=Redae&address=AddisAbaba
	@RequestMapping("home")
	public ModelAndView home( @RequestParam("firstName") String firstName, 
						@RequestParam("lastName") String lastName, 
					@RequestParam("address") String address) 
	{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("firstName", firstName);
		mv.addObject("address", address);
		mv.addObject("lastName", lastName);
		
		mv.setViewName("home");
		
		return mv;
	}

	//use this request URL: http://localhost:8080/alienHome?aid=1&aname=Mengistu&lang=Java
	@RequestMapping("alienHome")
	public ModelAndView alienHome(Alien alien) 
	{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("alienObject", alien);
		
		mv.setViewName("alienHome");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
