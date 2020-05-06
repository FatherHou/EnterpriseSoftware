package lesson.j2ee.ex6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lesson.j2ee.ex6.model.BeerExpert;

public class DisplayItem extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			String c = request.getParameter("color");
			BeerExpert be = new BeerExpert();
			String rootpath = getServletContext().getRealPath("/");
			List result = be.getBrands(rootpath, c);
//			int[] jishu=new int[20];
//			request.setAttribute("jishu", jishu);
			request.setAttribute("styles", result);
			RequestDispatcher view =request.getRequestDispatcher("DisplayItem.jsp");
			view.forward(request, response);
		}

}
