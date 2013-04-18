package es.edu.gplaceapiclient;

import java.util.ArrayList;

public class Review {
	private ArrayList<Aspect> aspects;
	private String author_name;
	private String author_url;
	private String text;
	private Long time;
	
	public ArrayList<Aspect> getAspects() {
		return aspects;
	}
	public void setAspects(ArrayList<Aspect> aspects) {
		this.aspects = aspects;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthor_url() {
		return author_url;
	}
	public void setAuthor_url(String author_url) {
		this.author_url = author_url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
}
