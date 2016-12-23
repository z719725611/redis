package com.microblog.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String text;
	private String pic;
	private String video;
	private Date fdate;
	private Long source;
	private String sourcename;
	private String parse;// 点赞数
	private String relay;// 转发数
	private String fdateStr;



	public Blog() {
	}

	
	

	public Blog(Long id, String text, String pic, String video, Date fdate,
			Long source, String sourcename, String parse, String relay,
			String fdateStr) {
		super();
		this.id = id;
		this.text = text;
		this.pic = pic;
		this.video = video;
		this.fdate = fdate;
		this.source = source;
		this.sourcename = sourcename;
		this.parse = parse;
		this.relay = relay;
		this.fdateStr = fdateStr;
	}




	public Blog(Long id, String text, String pic, Date fdate, Long source,
			String parse, String relay) {
		this.id = id;
		this.text = text;
		this.pic = pic;
		this.fdate = fdate;
		this.source = source;
		this.parse = parse;
		this.relay = relay;
	}




	public Blog(Long id, String uid, String text, String pic, String video,
			Date fdate, Long source,String parse,String relay) {

		this.id = id;
		this.text = text;
		this.pic = pic;
		this.video = video;
		this.fdate = fdate;
		this.source = source;
		this.parse = parse;
		this.relay = relay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
		setFdateStr(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(this.fdate));
	}

	public Long getSource() {
		return source;
	}

	public void setSource(Long source) {
		this.source = source;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}


	public String getParse() {
		return parse;
	}

	public void setParse(String parse) {
		this.parse = parse;
	}
	
	
	public String getRelay() {
		return relay;
	}

	public void setRelay(String relay) {
		this.relay = relay;
	}
	
	public String getSourcename() {
		return sourcename;
	}



	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}




	@Override
	public String toString() {
		return "Blog [id=" + id + ", text=" + text + ", pic=" + pic
				+ ", video=" + video + ", fdate=" + fdate + ", source="
				+ source + ", sourcename=" + sourcename + ", parse=" + parse
				+ ", relay=" + relay + ", fdateStr=" + fdateStr +  "]";
	}

	public String getFdateStr() {
		return fdateStr;
	}

	public void setFdateStr(String fdateStr) {
		this.fdateStr = fdateStr;
	}
	
}
