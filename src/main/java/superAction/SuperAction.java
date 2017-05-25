package superAction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public class SuperAction implements ServletContextAware,ServletRequestAware,ServletResponseAware {
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected ServletContext application;
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletContext(ServletContext application) {
		this.application = application;
	}

}
