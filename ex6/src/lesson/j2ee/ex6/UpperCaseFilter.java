package lesson.j2ee.ex6;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * ������ı�ת���ɴ�д�Ĺ�����
 */
public class UpperCaseFilter
        implements Filter
{
    protected FilterConfig config;
    public void init(FilterConfig config)
        throws ServletException
    {
        this.config = config;
    }
    public void destroy()
    {
    }
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
        throws ServletException, IOException
    {
        ServletResponse newResponse = response;
        if (request instanceof HttpServletRequest)
        {
            newResponse = new CharResponseWrapper(
                    (HttpServletResponse) response);
        }
        // ִ��doFilter������ע��˴���Ӧ�����Ѿ��仯
        chain.doFilter(request, newResponse);
        //����ִ����Ӧ����
        if (newResponse instanceof CharResponseWrapper)
        {
           
            String text = newResponse.toString();
            if (text != null)
            {
                text = text.toUpperCase();
                // ����������ݴ�����������������ؿͻ���
                response.getWriter().write(text);
            }
        }
    }
}
