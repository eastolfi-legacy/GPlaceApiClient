package es.edu.gplaceapiclient;

public class Event {
	private String event_id;
	private Long start_time;
	private String summary;		//No validada por Google, peligrosa
	private String url;
//	Date d = new Date(1308670980000L);
//	SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy,HH:mm");
//	f.setTimeZone(TimeZone.getTimeZone("GMT");
//	String s = f.format(d);
	
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public Long getStart_time() {
		return start_time;
	}
	public void setStart_time(Long start_time) {
		this.start_time = start_time;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
