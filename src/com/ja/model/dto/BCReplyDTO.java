package com.ja.model.dto;

public class BCReplyDTO 
{
	private String bc_reply_idx;
	private String bc_idx;
	private String m_idx;
	private String bc_reply_content;
	private String bc_reply_writedate;
	
	public BCReplyDTO(String bc_reply_idx, String bc_idx, String m_idx, String bc_reply_content,
			String bc_reply_writedate) {
		super();
		this.bc_reply_idx = bc_reply_idx;
		this.bc_idx = bc_idx;
		this.m_idx = m_idx;
		this.bc_reply_content = bc_reply_content;
		this.bc_reply_writedate = bc_reply_writedate;
	}

	public String getBc_reply_idx() {
		return bc_reply_idx;
	}

	public void setBc_reply_idx(String bc_reply_idx) {
		this.bc_reply_idx = bc_reply_idx;
	}

	public String getBc_idx() {
		return bc_idx;
	}

	public void setBc_idx(String bc_idx) {
		this.bc_idx = bc_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getBc_reply_content() {
		return bc_reply_content;
	}

	public void setBc_reply_content(String bc_reply_content) {
		this.bc_reply_content = bc_reply_content;
	}

	public String getBc_reply_writedate() {
		return bc_reply_writedate;
	}

	public void setBc_reply_writedate(String bc_reply_writedate) {
		this.bc_reply_writedate = bc_reply_writedate;
	}
}
