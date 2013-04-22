package es.edu.gplaceapiclient;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceSearch {
	public final static String FORMAT_JSON = "json";
//	public final static String FORMAT_XML = "xml";
	private final static String uriBase = "https://maps.googleapis.com/maps/api/place/";
	private final static String searchPlace = "search";
	private final static String searchPlaceByName = "textsearch";
	private final static String searchPlaceDetail = "details";
	private String API_KEY, format;
	
	String REF_TMP = "CoQBdQAAALldZo1VONna6IKcYtlHR9b9gpsgyaTqyAUdWmjtJAYblyHny1IynZzL4EA09iUHApq1tv8ndRsDUbhHRuAYSb0un3062oXQtJZw5rZ3PId4yE0oXExThJYD7S-kBGr_O9QgjKpED8GYvJzhfErcfNDhzqBn4m71Pp0pwWdBkLFmEhCorJnBROLDJbUycy-SB1LwGhTm87PHCTQPRBJYiSQMAB37qEU2hA";
	
	public PlaceSearch(String userKey, String format) {
		this.API_KEY = userKey;
		this.format = format;
	}
	
	public ArrayList<Place> searchPlacesByLocation(Location location, int radius, boolean sensor) {
		String uri = uriBase + searchPlace + "/" + format + "?";
		uri += "location=" + location.getLatitude() + "," + location.getLongitude() + "&";
		uri += "radius=" + radius + "&";
		uri += "sensor=" + sensor + "&";
		uri += "key=" + API_KEY;
		
		ArrayList<Place> places = performSearch(uri);
		
		return places;
	}
	
	public ArrayList<Place> searchPlacesByName(String query, boolean sensor) {
		String uri = uriBase + searchPlaceByName + "/" + format + "?";
		uri += "query=" + query + "&";
		uri += "type=establishment&";	//TIPO HARDCODEADO
		uri += "sensor=" + sensor + "&";
		uri += "key=" + API_KEY;
		
		ArrayList<Place> places = performSearch(uri);
		
		return places;
	}
	
	public PlaceDetail searchPlaceDetail(String reference, boolean sensor) {
		String uri = uriBase + searchPlaceDetail + "/" + format + "?";
		uri += "reference=" + reference + "&";
		uri += "sensor=" + sensor + "&";
		uri += "key=" + API_KEY;
		
		PlaceDetail placeDetail = performSearchDetail(uri);
		
		return placeDetail;
	}
	
	private ArrayList<Place> performSearch(String uri) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(uri);
			HttpResponse response = client.execute(get);
			String entity = EntityUtils.toString(response.getEntity());
			ArrayList<Place> places = placeToJson(entity);
			
			return places;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private PlaceDetail performSearchDetail(String uri) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(uri);
			HttpResponse response = client.execute(get);
			String entity = EntityUtils.toString(response.getEntity());
			PlaceDetail placeDetail = placeDetailToJson(entity);
			
			return placeDetail;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<Place> placeToJson(String entity) {
		ArrayList<Place> places = new ArrayList<Place>();
		try {
			JSONObject jObject = new JSONObject(entity);
			
			if (jObject.has("status")) {
				//TODO Manejo del estado devuelto
			}
			if (jObject.has("html_attributions") && jObject.getJSONArray("html_attributions").length() > 0) {
				//TODO Manejo de las html_attributions
			}
			
			JSONArray jArray = jObject.getJSONArray("results");
	
			for (int i=0; i<jArray.length(); i++) {
				JSONObject json = jArray.getJSONObject(i);
				Place place = PlaceBuilder.buildFromJson(json);
				
				places.add(place);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return places;
	}
	
	private PlaceDetail placeDetailToJson(String entity) {
		PlaceDetail placeDetail = new PlaceDetail();
		
		try {
			JSONObject jObject = new JSONObject(entity);
			
			if (jObject.has("status")) {
				//TODO Manejo del estado devuelto
			}
			if (jObject.has("html_attributions") && jObject.getJSONArray("html_attributions").length() > 0) {
				//TODO Manejo de las html_attributions
			}
			
			JSONObject json = jObject.getJSONObject("result");
			placeDetail = PlaceBuilder.buildDetailFromJson(json);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return placeDetail;
	}
	
}
