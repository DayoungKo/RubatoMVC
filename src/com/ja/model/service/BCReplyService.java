package com.ja.model.service;

import com.ja.model.dao.*;
import com.ja.model.dto.*;
import com.ja.model.vo.*;
import java.util.*;

public class BCReplyService 
{
	public ArrayList<BCReplyData> getBcReplyList(String bc_idx)
	{
		ArrayList<BCReplyData> bcReplyData = new ArrayList<>();
		ArrayList<BCReplyDTO> bcReplyList = new BCReplyDAO().selectBCReplyList(bc_idx);
		
		for(BCReplyDTO bcReplyDto:bcReplyList)
		{
			MemberDTO memberDto = new MemberDAO().selectByIdx(bcReplyDto.getM_idx());
			BoardContentDTO boardContentDto = new BoardContentDAO().getBoardByIdx(bc_idx);
			bcReplyData.add(new BCReplyData(bcReplyDto, boardContentDto, memberDto));
		}
		return bcReplyData;
	}
	
	public void writeReply(String bc_idx, String m_idx, String bc_reply_content)
	{
		new BCReplyDAO().insertBCReplyData(bc_idx, m_idx, bc_reply_content);
	}
	
	public void deleteReply(String bc_reply_idx)
	{
		new BCReplyDAO().deleteBCReplyData(bc_reply_idx);
	}
}
