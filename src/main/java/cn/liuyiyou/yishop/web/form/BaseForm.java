package cn.liuyiyou.yishop.web.form;

import cn.liuyiyou.yishop.common.util.web.context.WebContext;
import cn.liuyiyou.yishop.common.util.web.context.WebContextHolder;
import cn.liuyiyou.yishop.entity.Channel;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseForm {

	private int id;

	private Map<String, String> errors = new LinkedHashMap<String, String>();

	private Map<String, Channel> allChannel;

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public Map<String, String> getErrors() {
		return errors;
	}

	
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public void putError(String key, String val) {
		errors.put(key, val);
	}

	public void putErrors(Map<String, String> errors) {
		errors.putAll(errors);
	}

	public boolean hasError() {
		return errors.size() > 0;
	}

	public boolean hasError(String key) {
		return errors.containsKey(key);
	}

	
	public Map<String, Channel> getAllChannel() {
		return allChannel;
	}

	
	public void setAllChannel(Map<String, Channel> allChannel) {
		this.allChannel = allChannel;
	}

	public final long getNanoTime() {
		return System.nanoTime();
	}

	public final WebContext getWebContext() {
		WebContext webContext = WebContextHolder.get();
		return webContext == null ? new WebContext() : webContext;
	}

	public final String getRequestURI() {
		try {
			return URLDecoder.decode(getWebContext().getRequestURI(), "UTF-8");
		} catch (Exception e) {
			return getWebContext().getRequestURI();
		}

	}

	public final boolean isLogon() {
		return getWebContext().isLogon();
	}

}
