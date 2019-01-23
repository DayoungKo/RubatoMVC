package com.ja.model.dto;

public class BoardContentDTO 
{
	private String bc_idx;
	private String m_idx;
	private String bc_title;
	private String bc_content;
	private String bc_attach_name;
	private String bc_attach_url;
	private String bc_look_count;
	private String bc_writedate;
	
	public BoardContentDTO(String bc_idx, String m_idx, String bc_title, String bc_content, String bc_attach_name,
			String bc_attach_url, String bc_look_count, String bc_writedate) {
		super();
		this.bc_idx = bc_idx;
		this.m_idx = m_idx;
		this.bc_title = bc_title;
		this.bc_content = bc_content;
		this.bc_attach_name = bc_attach_name;
		this.bc_attach_url = bc_attach_url;
		this.bc_look_count = bc_look_count;
		this.bc_writedate = bc_writedate;
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

	public String getBc_title() {
		return bc_title;
	}

	public void setBc_title(String bc_title) {
		this.bc_title = bc_title;
	}

	public String getBc_content() {
		return bc_content;
	}

	public void setBc_content(String bc_content) {
		this.bc_content = bc_content;
	}

	public String getBc_attach_name() {
		return bc_attach_name;
	}

	public void setBc_attach_name(String bc_attach_name) {
		this.bc_attach_name = bc_attach_name;
	}

	public String getBc_attach_url() {
		return bc_attach_url;
	}

	public void setBc_attach_url(String bc_attach_url) {
		this.bc_attach_url = bc_attach_url;
	}

	public String getBc_look_count() {
		return bc_look_count;
	}

	public void setBc_look_count(String bc_look_count) {
		this.bc_look_count = bc_look_count;
	}

	public String getBc_writedate() {
		return bc_writedate;
	}

	public void setBc_writedate(String bc_writedate) {
		this.bc_writedate = bc_writedate;
	}
}
