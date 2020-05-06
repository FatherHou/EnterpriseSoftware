package lesson.j2ee.ex6;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import lesson.j2ee.ex6.controller.Tobeer;
import lesson.j2ee.ex6.model.Beer;
import lesson.j2ee.ex6.model.BeerList;

public class ShoppingCart extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

		//ȡ��Session����
		//���Session�����ڣ�Ϊ���λỰ�����˶���
		HttpSession session =req.getSession(true);
		Integer itemCount=(Integer)session.getAttribute("itemCount");
		//���session���µ�
		if (itemCount==null)
		itemCount=new Integer(0);

		PrintWriter out=res.getWriter();
		res.setContentType("text/html");

		//���մ����Ĳ���
		String[] itemsSelected;
		String itemName;
		itemsSelected=req.getParameterValues("item");
		if(itemsSelected !=null){
			for(int i=0;i<itemsSelected.length;i++){
				itemName=itemsSelected[i];
				System.out.println(itemName+"!");
				itemCount=new Integer(itemCount.intValue()+1);
				session.setAttribute("item"+itemCount,itemName);
				session.setAttribute("itemCount",itemCount);
			}
		}
		//hou
		int start=0;
		int count=50;
		List<Beer> beerList=Tobeer.list(start, count);
//		for(int j=0;j<beerList.size();j++){
//			System.out.println(beerList.get(j).getId()+" ");
//			System.out.println(beerList.get(j).getName()+" ");
//			System.out.println(beerList.get(j).getManufacturer()+" ");
//			System.out.println(beerList.get(j).getColor()+" ");
//		}
		
		//hou
		//hou
		int[] jishu = (int[]) session.getAttribute("jishu");
		if(jishu==null){
			jishu = new int[20];
			for(int j=0;j<beerList.size();j++){
				int jisuan=0;
				for(int i=0;i<itemsSelected.length;i++){
					if(beerList.get(j).getName().equals(itemsSelected[i])){
						jisuan++;
					}
				}
				jishu[j]=jisuan;
			}
//			System.out.println("hou");
		}
		else{
			for(int j=0;j<beerList.size();j++){
				for(int i=0;i<itemsSelected.length;i++){
					if(beerList.get(j).getName().equals(itemsSelected[i])){
						jishu[j]++;
					}
				}
			}
		}
//		System.out.println("hby1"+jishu.length);
//		System.out.println("hby2"+jishu);
		session.setAttribute("jishu", jishu);
//		for(int j=0;j<jishu.length;j++){
//			System.out.println(jishu[j]+" ");
//		}
		for(int j=0;j<beerList.size();j++){
			if(jishu[j]!=0){
				req.setAttribute("beer", beerList.get(j));
			}
		}
//		req.setAttribute("beerList", beerList);
		BeerList bearList=new BeerList(beerList);
		req.setAttribute("bearList", bearList);
		req.setAttribute("jishu", jishu);
		req.getRequestDispatcher("BuyBeer.jsp").forward(req, res);
		//hou
//		out.println("<html>");
//		out.println("<title>");
//		out.println("item list");
//		out.println("</title>");
//		out.println("<body><h4>Session List:</h4><hr><br><br>");
//		for(int i=1;i<=itemCount.intValue();i++){
//			System.out.println("hou");
//			out.println((String)session.getAttribute("item"+i)+"<hr>");
//		}
//		for(int j=0;j<beerList.size();j++){
//			if(jishu[j]!=0){
//				out.println("Id:"+beerList.get(j).getId()+"<br>");
//				out.println("Name:"+beerList.get(j).getName()+"<br>");
//				out.println("Manufacturer:"+beerList.get(j).getManufacturer()+"<br>");
//				out.println("Color:"+beerList.get(j).getColor()+"<br>");
//				out.println("Quantity:"+jishu[j]+"<hr>");
//			}
//		}
//		out.println("<c:import BuyBeer.jsp/>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
	}
}