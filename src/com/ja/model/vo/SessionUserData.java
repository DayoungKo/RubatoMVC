package com.ja.model.vo;

public class SessionUserData 
{
	private String m_idx;
	private String m_id;
	private String m_nick;
	
	public SessionUserData(String m_idx, String m_id, String m_nick) {
		super();
		this.m_idx = m_idx;
		this.m_id = m_id;
		this.m_nick = m_nick;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
}
