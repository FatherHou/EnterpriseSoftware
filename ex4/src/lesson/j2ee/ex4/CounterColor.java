
package lesson.j2ee.ex4;   
   
import java.io.IOException;   
import java.util.StringTokenizer;   
import javax.servlet.jsp.*;   
import javax.servlet.jsp.tagext.*;   
   
public class CounterColor extends SimpleTagSupport {   
    private String colorList = "";//设定一个属性集合
    public void doTag() throws JspException, IOException {   
        JspWriter out = getJspContext().getOut();   
        int countl=0,counta=0,countb=0; 
        StringTokenizer color=new StringTokenizer(colorList);   
        String temColor=null;   //建立临时字符串判断下一个元素的颜色
        while (color.hasMoreTokens()) {   
        	temColor=color.nextToken();
            if (temColor.equals("light")) {   
                countl++;   
            }   
            if (temColor.equals("amber")) {   
                counta++;   
            }   
            if (temColor.equals("brown")) {   
                countb++;   
            }   
        }
        if (countl != 0) {   
            out.print("light " + countl + "<hr>");   
        }   
        if (counta != 0) {   
            out.print("amber " + counta + "<hr>");   
        }   
        if (countb != 0) {   
            out.print("brown " + countb + "<hr>");   
        }   
    }

    public String getcolorList() {   
        return this.colorList;   
    }   
   
    public void setcolorList(String colorList) {   
        this.colorList=colorList;   
    }   
}