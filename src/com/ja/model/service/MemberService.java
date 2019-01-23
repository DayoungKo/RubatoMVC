package com.ja.model.service;

import com.ja.model.vo.*;
import com.ja.model.dao.*;
import com.ja.model.dto.*;

public class MemberService 
{
	public SessionUserData login(String id, String pw)
	{
		SessionUserData sessionUserData = null;
		
		MemberDTO userData = new MemberDAO().selectById(id);
		
		if(userData !=null && userData.getM_pw().equals(pw)) 
		{
			sessionUserData = new SessionUserData(userData.getM_idx(), userData.getM_id(), userData.getM_nick());
		}
		return sessionUserData;
	}
	
	public void joinMember(String id, String pw, String nick, String phone)
	{
		new MemberDAO().insert(id, pw, nick, phone);
	}
}
