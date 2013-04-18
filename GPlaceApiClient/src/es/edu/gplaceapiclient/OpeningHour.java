package es.edu.gplaceapiclient;

import java.util.ArrayList;

public class OpeningHour {
	private Boolean open_now;
	private ArrayList<Period> periods;
	
	public Boolean getOpen_now() {
		return open_now;
	}
	public void setOpen_now(Boolean open_now) {
		this.open_now = open_now;
	}
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	public void setPeriods(ArrayList<Period> periods) {
		this.periods = periods;
	}
}
