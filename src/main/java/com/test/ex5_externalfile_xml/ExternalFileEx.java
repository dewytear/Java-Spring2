package com.test.ex5_externalfile_xml;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExternalFileEx implements InitializingBean, DisposableBean{

	private String id;
	private String pwd;
	private String extId;
	private String extPwd;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() ȣ��");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() ȣ��");
	}

	//[region] setter, getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}

	public String getExtPwd() {
		return extPwd;
	}

	public void setExtPwd(String extPwd) {
		this.extPwd = extPwd;
	}


	//[end]

}
