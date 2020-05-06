package lesson.j2ee.ex4;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CounterTag2 extends SimpleTagSupport{
	
	private static int counter = 1;
	
	public void doTag()throws JspException{
		try{
		    JspWriter out = getJspContext().getOut();      
		    out.print(counter);
		    setCounter();
		} catch (java.io.IOException e) {
		    throw new JspTagException(e.getMessage());
		}
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public void setCounter()
	{
		counter++;
	}
}