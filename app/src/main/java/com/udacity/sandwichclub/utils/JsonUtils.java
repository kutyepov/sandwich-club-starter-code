package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.*;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String stringifiedJSON) {
        try {
            JSONObject json = new JSONObject(stringifiedJSON);
            JSONObject name = json.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            String placeOfOrigin = json.getString("placeOfOrigin");
            String description = json.getString("description");
            String image = json.getString("image");
            JSONArray ingredients = json.getJSONArray("ingredients");

            return new Sandwich(
                    mainName,
                    jsonArrayToListOfStrings(alsoKnownAs),
                    placeOfOrigin,
                    description,
                    image,
                    jsonArrayToListOfStrings(ingredients)
            );

        } catch (JSONException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private static List<String> jsonArrayToListOfStrings(JSONArray arr) throws JSONException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            list.add(arr.getString(i));
        }

        return list;
    }
}
