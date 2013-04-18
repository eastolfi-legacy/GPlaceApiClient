package es.edu.gplaceapiclient;

import java.util.ArrayList;

public class Place {
	private ArrayList<Event> events;
	private String icon;
	private String id;
	private Geometry geometry;
	private String name;
	private ArrayList<OpeningHour> opening_hours;
	private Double rating;
	private String reference;
	private ArrayList<String> types;
	private String vicinity;
	private ArrayList<Photo> photos;
	private String html_attributions;
	private Integer price_level;
	
	
	/************ GETTERS & SETTERS *************/
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<OpeningHour> getOpening_hours() {
		return opening_hours;
	}
	public void setOpening_hours(ArrayList<OpeningHour> opening_hours) {
		this.opening_hours = opening_hours;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public ArrayList<String> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	public ArrayList<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}
	public String getHtml_attributions() {
		return html_attributions;
	}
	public void setHtml_attributions(String html_attributions) {
		this.html_attributions = html_attributions;
	}
	public Integer getPrice_level() {
		return price_level;
	}
	public void setPrice_level(Integer price_level) {
		this.price_level = price_level;
	}
}
