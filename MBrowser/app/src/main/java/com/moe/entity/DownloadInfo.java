package com.moe.entity;

public class DownloadInfo
{
	private int no;
	private int id;
	private long start,current,end;

	public void setNo(int no)
	{
		this.no=no;
	}

	
	public void setTaskId(int url)
	{
		this.id=url;
	}

	public int getNo()
	{
		// TODO: Implement this method
		return no;
	}

	public int getTaskId()
	{
		// TODO: Implement this method
		return id;
	}
	 

	

	

	public void setStart(long start)
	{
		this.start = start;
	}

	public long getStart()
	{
		return start;
	}

	public void setCurrent(long current)
	{
		this.current = current;
	}

	public long getCurrent()
	{
		return current;
	}

	public void setEnd(long end)
	{
		this.end = end;
	}

	public long getEnd()
	{
		return end;
	}

	
}
