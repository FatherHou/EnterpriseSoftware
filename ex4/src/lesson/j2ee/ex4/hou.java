package lesson.j2ee.ex4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
public class hou extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		List<String> beerList=new ArrayList<String>();
		beerList.add("Item1: The light beer of China");
		beerList.add("Item2: The amber beer of China");
		beerList.add("Item3: The beer of American");
		request.setAttribute("beerList",beerList);
		request.getRequestDispatcher("DisplayItem.jsp").forward(request, response);
	}
	
	
}
