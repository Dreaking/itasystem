package com.ita.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;


/**
 * <h3>编码设置过滤器</h3>
 * <p>过滤浏览器请求,设置字符编码为:UTF-8.</p>
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "ENCODING", value = "UTF-8") })
public class EncondingFilter implements Filter {

	private String ENCODING;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		//转码
		if ("GET".equals(req.getMethod())) {
			req = new EncondingWrapper(req, ENCODING);
		} else {
			req.setCharacterEncoding(ENCODING);
		}	
		
		
		

		
		chain.doFilter(req, response);
	}

	public void init(FilterConfig config) throws ServletException {
		ENCODING = config.getInitParameter("ENCODING");
	}
}
