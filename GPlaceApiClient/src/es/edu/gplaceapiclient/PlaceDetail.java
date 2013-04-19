package es.edu.gplaceapiclient;

import java.util.ArrayList;

public class PlaceDetail extends Place {
	private ArrayList<AddressComponent> address_components;
	private String formatted_address;
	private String formatted_phone_number;
	private String international_phone_number;
	private ArrayList<Review> reviews;
	private String url;
	private Integer utc_offset;
	private String website;
	

	/************ GETTERS & SETTERS ***************/
	/**
	 * @return the address_components
	 */
	public ArrayList<AddressComponent> getAddress_components() {
		return address_components;
	}
	/**
	 * @param address_components the address_components to set
	 */
	public void setAddress_components(
			ArrayList<AddressComponent> address_components) {
		this.address_components = address_components;
	}
	/**
	 * @return the formatted_address
	 */
	public String getFormatted_address() {
		return formatted_address;
	}
	/**
	 * @param formatted_address the formatted_address to set
	 */
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	/**
	 * @return the formatted_phone_number
	 */
	public String getFormatted_phone_number() {
		return formatted_phone_number;
	}
	/**
	 * @param formatted_phone_number the formatted_phone_number to set
	 */
	public void setFormatted_phone_number(String formatted_phone_number) {
		this.formatted_phone_number = formatted_phone_number;
	}
	/**
	 * @return the international_phone_number
	 */
	public String getInternational_phone_number() {
		return international_phone_number;
	}
	/**
	 * @param international_phone_number the international_phone_number to set
	 */
	public void setInternational_phone_number(String international_phone_number) {
		this.international_phone_number = international_phone_number;
	}
	/**
	 * @return the reviews
	 */
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the utc_offset
	 */
	public Integer getUtc_offset() {
		return utc_offset;
	}
	/**
	 * @param utc_offset the utc_offset to set
	 */
	public void setUtc_offset(Integer utc_offset) {
		this.utc_offset = utc_offset;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
}
