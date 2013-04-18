package es.edu.gplaceapiclient;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceBuilder {

	
	public static Place buildFromJson(Place original, JSONObject source) {
		try {
			if (source.has("id"))
				original.setId(source.getString("id"));
			if (source.has("icon"))
				original.setIcon(source.getString("icon"));
			if (source.has("name"))
				original.setName(source.getString("name"));
			if (source.has("vicinity"))
				original.setVicinity(source.getString("vicinity"));
			if (source.has("reference"))
				original.setReference(source.getString("reference"));
			if (source.has("rating"))
				original.setRating(Double.parseDouble(source.getString("rating")));
			if (source.has("types")) {
				JSONArray types = (JSONArray)source.get("types");
				ArrayList<String> lst = new ArrayList<String>();
				for (int i=0; i<types.length(); i++) {
					lst.add(types.get(i).toString());
				}
				original.setTypes(lst);
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
				original.setGeometry(geometry);
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
				original.setPhotos(photos);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return original;
	}
	
}
