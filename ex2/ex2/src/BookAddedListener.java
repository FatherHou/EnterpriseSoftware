

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class BookAddedListener
 *
 */
public class BookAddedListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name=event.getName();
		Object value=event.getValue();
		System.out.println("Attribute added:"+name+":"+value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name=event.getName();
		Object value=event.getValue();
		System.out.println("Attribute removed:"+name+":"+value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name=event.getName();
		Object value=event.getValue();
		int value2=Integer.parseInt(String.valueOf(value));
		System.out.println("Attribute replaced:"+name+":"+value2);
	}


}
