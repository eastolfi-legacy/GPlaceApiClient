package es.edu.gplaceapiclient;

import java.util.ArrayList;

public class PlaceDetail {
	private ArrayList<AddressComponents> address_components;
	private ArrayList<Event> events;
	private String formatted_address;
	private String formatted_phone_number;
	
	/************ GETTERS & SETTERS ***************/
	public ArrayList<AddressComponents> getAddress_components() {
		return address_components;
	}
	public void setAddress_components(
			ArrayList<AddressComponents> address_components) {
		this.address_components = address_components;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public String getFormatted_phone_number() {
		return formatted_phone_number;
	}
	public void setFormatted_phone_number(String formatted_phone_number) {
		this.formatted_phone_number = formatted_phone_number;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
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
	public String getInternational_phone_number() {
		return international_phone_number;
	}
	public void setInternational_phone_number(String international_phone_number) {
		this.international_phone_number = international_phone_number;
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
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	public ArrayList<String> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUtc_offset() {
		return utc_offset;
	}
	public void setUtc_offset(Integer utc_offset) {
		this.utc_offset = utc_offset;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private Geometry geometry;
	private String icon;
	private String id;
	private String international_phone_number;
	private String name;
	private ArrayList<OpeningHour> opening_hours;
	private Double rating;
	private String reference;
	private ArrayList<Review> reviews;
	private ArrayList<String> types;
	private String url;
	private Integer utc_offset;
	private String vicinity;
	private String website;
}
