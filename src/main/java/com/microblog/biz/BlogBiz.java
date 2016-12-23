package com.microblog.biz;

public interface BlogBiz {

	//点赞
	public String parse(Long id,int uid);
	//转发
	public String relay(Long id,int uid);

}
