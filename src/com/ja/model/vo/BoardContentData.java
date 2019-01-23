package com.ja.model.vo;

import com.ja.model.dto.*;

public class BoardContentData 
{
	private BoardContentDTO boardContentDto;
	private MemberDTO memberDto;
	
	public BoardContentData(BoardContentDTO boardContentDto, MemberDTO memberDto) 
	{
		super();
		this.boardContentDto = boardContentDto;
		this.memberDto = memberDto;
	}

	public BoardContentDTO getBoardContentDto() {
		return boardContentDto;
	}

	public void setBoardContentDto(BoardContentDTO boardContentDto) {
		this.boardContentDto = boardContentDto;
	}

	public MemberDTO getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDTO memberDto) {
		this.memberDto = memberDto;
	}
}
