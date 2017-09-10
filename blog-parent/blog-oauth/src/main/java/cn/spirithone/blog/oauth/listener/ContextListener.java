package cn.spirithone.blog.oauth.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根
	}

	/**
	 * 监听ServletContext创建启动事件 此处方法中可以设置应用全局变量，加载一些配置等操作
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		// 设置全局变量ctx 存储web项目的项目名
		servletContext.setAttribute("ctx", servletContext.getContextPath());
		// 设置全局变量res 存储静态资源存放路径
		servletContext.setAttribute("res", servletContext.getContextPath() + "/theme/theme-default");
	}
}
