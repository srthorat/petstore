package io.swagger.petstore.utils;
import org.json.JSONArray;
import org.json.JSONObject;
public class Utils {

    private static final String DEFAULT_STRING = "string";

    public static String createPetJsonBody(long petID, String name, String status, int tagID, String tagName) {
        JSONObject petJson = new JSONObject();
        petJson.put("id", petID);

        JSONObject category = new JSONObject();
        category.put("id", tagID);
        category.put("name", DEFAULT_STRING);

        petJson.put("category", category);
        petJson.put("name", name);

        JSONArray photoUrls = new JSONArray();
        photoUrls.put(DEFAULT_STRING);
        petJson.put("photoUrls", photoUrls);

        JSONArray tags = new JSONArray();
        JSONObject tagObject = new JSONObject();
        tagObject.put("id", tagID);
        tagObject.put("name", tagName);
        tags.put(tagObject);

        petJson.put("tags", tags);
        petJson.put("status", status);

        return petJson.toString();
    }
}
