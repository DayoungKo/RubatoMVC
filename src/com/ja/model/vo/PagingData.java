package com.ja.model.vo;

public class PagingData 
{
	private int allboardListSize;
	private int viewBoardListSize;
	private int totalPageSize;
	private int nowPageNum;
	private int firstViewContentNum;
	private int lastViewContentNum;
	
	public PagingData(int allBoardListSize, int viewBoardListSize, int nowPageNum)
	{
		this.allboardListSize = allBoardListSize;
		this.viewBoardListSize = viewBoardListSize;
		this.totalPageSize = allBoardListSize/viewBoardListSize + 1;
		this.nowPageNum = nowPageNum;
		//index Num
		this.firstViewContentNum = viewBoardListSize*(nowPageNum-1);
		this.lastViewContentNum = viewBoardListSize*nowPageNum-1;
	}

	public int getAllboardListSize() {
		return allboardListSize;
	}

	public int getViewBoardListSize() {
		return viewBoardListSize;
	}

	public int getTotalPageSize() {
		return totalPageSize;
	}

	public int getNowPageNum() {
		return nowPageNum;
	}

	public int getFirstViewContentNum() {
		return firstViewContentNum;
	}

	public int getLastViewContentNum() {
		return lastViewContentNum;
	}
}
