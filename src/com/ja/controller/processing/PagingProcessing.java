package com.ja.controller.processing;

import com.ja.model.vo.*;

public class PagingProcessing 
{
	public PagingData setPaging(int allBoardListDataSize, String select_view_boardList_size, String now_page_check)
	{
		
		if(select_view_boardList_size == null) select_view_boardList_size ="15";
		int viewBoardListSize = Integer.parseInt(select_view_boardList_size);
		if(now_page_check == null) now_page_check = "1";
		int nowPageNum = Integer.parseInt(now_page_check);
		
		PagingData pagingData = new PagingData(allBoardListDataSize, viewBoardListSize, nowPageNum);
		
		return pagingData;
	}
}
