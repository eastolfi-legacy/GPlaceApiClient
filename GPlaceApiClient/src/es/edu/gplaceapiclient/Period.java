package es.edu.gplaceapiclient;

public class Period {
	private Integer open_day;
	private Integer open_time;
	private Integer close_day;
	private Integer close_time;
	
	public Integer getOpen_day() {
		return open_day;
	}
	public void setOpen_day(Integer open_day) {
		this.open_day = open_day;
	}
	public Integer getOpen_time() {
		return open_time;
	}
	public void setOpen_time(Integer open_time) {
		this.open_time = open_time;
	}
	public Integer getClose_day() {
		return close_day;
	}
	public void setClose_day(Integer close_day) {
		this.close_day = close_day;
	}
	public Integer getClose_time() {
		return close_time;
	}
	public void setClose_time(Integer close_time) {
		this.close_time = close_time;
	}
}
