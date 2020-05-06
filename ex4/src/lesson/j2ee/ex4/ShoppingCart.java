package lesson.j2ee.ex4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

		//ȡ��Session����
		//���Session�����ڣ�Ϊ���λỰ�����˶���
		HttpSession session =req.getSession(true);
		Integer itemCount=(Integer)session.getAttribute("itemCount");
		//���session���µ�
		if (itemCount==null)
			itemCount=new Integer(0);

		res.setContentType("text/html");

		//���մ����Ĳ���
		String[] itemsSelected;
		List<String> hou = new ArrayList<String>();
		String itemName;
		itemsSelected=req.getParameterValues("item");

		if(itemsSelected !=null){
			for(int i=0;i<itemsSelected.length;i++){
				itemName=itemsSelected[i];
				System.out.println(itemName);
				itemCount=new Integer(itemCount.intValue()+1);
				//�������Ŀ
				session.setAttribute("item"+itemCount,itemName);
				//����Ŀ
				session.setAttribute("itemCount",itemCount);
			}
		}
		for(int i=1;i<=itemCount.intValue();i++){
			hou.add((String) session.getAttribute("item"+i));
		}
		req.setAttribute("hou", hou);
		req.getRequestDispatcher("ShowCart.jsp").forward(req, res);
	}
}