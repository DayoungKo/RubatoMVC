package com.ja.model.vo;

import com.ja.model.dto.*;

public class BCReplyData 
{
	private BCReplyDTO bcReplyDto;
	private BoardContentDTO boardContentDto;
	private MemberDTO memberDto;
	
	public BCReplyData(BCReplyDTO bcReplyDto, BoardContentDTO boardContentDto, MemberDTO memberDto) {
		super();
		this.bcReplyDto = bcReplyDto;
		this.boardContentDto = boardContentDto;
		this.memberDto = memberDto;
	}

	public BCReplyDTO getBcReplyDto() {
		return bcReplyDto;
	}

	public void setBcReplyDto(BCReplyDTO bcReplyDto) {
		this.bcReplyDto = bcReplyDto;
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
