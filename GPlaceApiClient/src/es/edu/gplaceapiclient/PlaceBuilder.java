package es.edu.gplaceapiclient;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceBuilder {

	
	public static Place buildFromJson(JSONObject source) {
		Place place = new Place();
		try {
			if (source.has("id"))
				place.setId(source.getString("id"));
			if (source.has("icon"))
				place.setIcon(source.getString("icon"));
			if (source.has("name"))
				place.setName(source.getString("name"));
			if (source.has("vicinity") || source.has("formatted_address")) {
				if (source.has("vicinity"))
					place.setVicinity(source.getString("vicinity"));
				else 
					place.setVicinity(source.getString("formatted_address"));
			}
			if (source.has("reference"))
				place.setReference(source.getString("reference"));
			if (source.has("rating"))
				place.setRating(source.getDouble("rating"));
			if (source.has("price_level"))
				place.setPrice_level(source.getInt("price_level"));
			if (source.has("types")) {
				JSONArray types = (JSONArray)source.get("types");
				ArrayList<String> lst = new ArrayList<String>();
				for (int i=0; i<types.length(); i++) {
					lst.add(types.get(i).toString());
				}
				place.setTypes(lst);
			}
			if (source.has("geometry")) {
				JSONObject jGeometry = source.getJSONObject("geometry");
				Geometry geometry = new Geometry();
				Location loc = new Location();
				if (jGeometry.has("viewport")) {
					Viewport viewport = new Viewport();
					JSONObject jViewPort = jGeometry.getJSONObject("viewport");
					if (jViewPort.has("northeast") && jViewPort.has("southwest")) {
						loc.setLatitude(jViewPort.getJSONObject("northeast").getDouble("lat"));
						loc.setLongitude(jViewPort.getJSONObject("northeast").getDouble("lng"));
						viewport.setNortheast(loc);
						loc.setLatitude(jViewPort.getJSONObject("southwest").getDouble("lat"));
						loc.setLongitude(jViewPort.getJSONObject("southwest").getDouble("lng"));
						viewport.setSouthwest(loc);
					}
				}
				if (jGeometry.has("location")) {
					loc.setLatitude(jGeometry.getJSONObject("location").getDouble("lat"));
					loc.setLongitude(jGeometry.getJSONObject("location").getDouble("lng"));
					geometry.setLocation(loc);
				}
				place.setGeometry(geometry);
			}
			if(source.has("photos")) {
				ArrayList<Photo> photos = new ArrayList<Photo>();
				JSONArray jPhotos = source.getJSONArray("photos");
				for (int i=0; i<jPhotos.length(); i++) {
					Photo photo = new Photo();
					JSONObject jPhoto = jPhotos.getJSONObject(i);
					if (jPhoto.has("height")) {
						photo.setHeight(Integer.valueOf(jPhoto.getString("height")));
					}
					if (jPhoto.has("width")) {
						photo.setWidth(Integer.valueOf(jPhoto.getString("width")));
					}
					if (jPhoto.has("photo_reference")) {
						photo.setPhoto_reference(jPhoto.getString("photo_reference"));
					}
					if (jPhoto.has("html_attributions")) {
						photo.setHtml_attributions(jPhoto.getJSONArray("html_attributions").get(0).toString());
					}
					photos.add(photo);
				}
				place.setPhotos(photos);
			}
			if (source.has("opening_hours")) {
				OpeningHour hours = new OpeningHour();
				JSONObject jHours = source.getJSONObject("opening_hours");
				if (jHours.has("open_now"))
					hours.setOpen_now(jHours.getBoolean("open_now"));
				place.setOpening_hours(hours);
			}
			if (source.has("events")) {
				JSONArray jEvents = source.getJSONArray("events");
				ArrayList<Event> events = new ArrayList<Event>();
				for (int i=0; i<jEvents.length(); i++) {
					JSONObject jEvent = jEvents.getJSONObject(i);
					Event event = new Event();
					if (jEvent.has("event_id"))
						event.setEvent_id(jEvent.getString("event_id"));
					if (jEvent.has("summary"))
						event.setSummary(jEvent.getString("summary"));
					if (jEvent.has("url"))
						event.setUrl("url");
					events.add(event);
				}
				place.setEvents(events);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return place;
	}
	
	
	public static PlaceDetail buildDetailFromJson(JSONObject source) {
		PlaceDetail placeDetail = new PlaceDetail();
		try {
			Place place = buildFromJson(source);
			placeDetail = buildPlaceDetailFromPlace(place);
			
			if (source.has("address_components")) {
				JSONArray jAddresses = source.getJSONArray("address_components");
				ArrayList<AddressComponent> addresses = new ArrayList<AddressComponent>();
				for (int i=0; i<jAddresses.length(); i++) {
					JSONObject jAddress = jAddresses.getJSONObject(i);
					AddressComponent address = new AddressComponent();
					if (jAddress.has("types")) {
						JSONArray jTypes = jAddress.getJSONArray("types");
						ArrayList<String> types = new ArrayList<String>();
						for (int j=0; j<jTypes.length(); j++) {
							types.add(jTypes.getString(j));
						}
						address.setTypes(types);
					}
					if (jAddress.has("long_name"))
						address.setLong_name(jAddress.getString("long_name"));
					if (jAddress.has("short_name"))
						address.setShort_name(jAddress.getString("short_name"));
					addresses.add(address);
				}
				placeDetail.setAddress_components(addresses);
			}
			if (source.has("formatted_address")) {
				placeDetail.setFormatted_address(source.getString("formatted_address"));
			}
			if (source.has("formatted_phone_number")) {
				placeDetail.setFormatted_phone_number(source.getString("formatted_phone_number"));
			}
			if (source.has("international_phone_number")) {
				placeDetail.setInternational_phone_number(source.getString("international_phone_number"));
			}
			if (source.has("reviews")) {
				JSONArray jReviews = source.getJSONArray("reviews");
				ArrayList<Review> reviews = new ArrayList<Review>();
				for (int i=0; i<jReviews.length(); i++) {
					JSONObject jReview = jReviews.getJSONObject(i);
					Review review = new Review();
					if (jReview.has("aspects")) {
						JSONArray jAspects = jReview.getJSONArray("aspects");
						ArrayList<Aspect> aspects = new ArrayList<Aspect>();
						for (int j=0; j<jAspects.length(); j++) {
							JSONObject jAspect = jAspects.getJSONObject(j);
							Aspect aspect = new Aspect();
							if (jAspect.has("rating"))
								aspect.setRating(jAspect.getInt("rating"));
							if (jAspect.has("type"))
								aspect.setType(jAspect.getString("type"));
							aspects.add(aspect);
						}
						review.setAspects(aspects);
					}
					if (jReview.has("author_name"))
						review.setAuthor_name(jReview.getString("author_name"));
					if (jReview.has("author_url"))
						review.setAuthor_url(jReview.getString("author_url"));
					if (jReview.has("text"))
						review.setText(jReview.getString("text"));
					if (jReview.has("time"))
						review.setTime(jReview.getLong("time"));
					reviews.add(review);
				}
				placeDetail.setReviews(reviews);
			}
			if (source.has("url")) {
				placeDetail.setUrl(source.getString("url"));
			}
			if (source.has("utc_offset")) {
				placeDetail.setUtc_offset(source.getInt("utc_offset"));
			}
			if (source.has("website")) {
				placeDetail.setWebsite(source.getString("website"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return placeDetail;
	}
	
	private static PlaceDetail buildPlaceDetailFromPlace(Place place) {
		PlaceDetail placeDetail = new PlaceDetail();
		
		placeDetail.setId(place.getId());
		placeDetail.setIcon(place.getIcon());
		placeDetail.setName(place.getName());
		placeDetail.setVicinity(place.getVicinity());
		placeDetail.setReference(place.getReference());
		placeDetail.setRating(place.getRating());
		placeDetail.setPrice_level(place.getPrice_level());
		placeDetail.setTypes(place.getTypes());
		placeDetail.setGeometry(place.getGeometry());
		placeDetail.setPhotos(place.getPhotos());
		placeDetail.setOpening_hours(place.getOpening_hours());
		placeDetail.setEvents(place.getEvents());
		
		return placeDetail;
	}
	
}
