package utsman.kucingapes.recyclerviewlatihan;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";


    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<Model> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.apply();
    }

    public void addFavorite(Context context, Model model) {
        ArrayList<Model> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<>();
        favorites.add(model);
        saveFavorites(context, favorites);
    }

    public void rFavorites(Context context, List<Model> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        //editor.putString(FAVORITES, js);

        editor.apply();
    }

    public void removeFavorite(Context context, Model model) {
        /*ArrayList<Model> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(model);
            saveFavorites(context, favorites);
        }*/

        /*ArrayList<Model> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<>();
        favorites.remove(model);
        saveFavorites(context, favorites);*/

        List<Model> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<>();
        favorites.add(model);
        rFavorites(context, favorites);
    }

    public ArrayList<Model> getFavorites(Context context) {
        SharedPreferences settings;
        List<Model> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Model[] favoriteItems = gson.fromJson(jsonFavorites,
                    Model[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<>(favorites);
        } else
            return null;

        return (ArrayList<Model>) favorites;
    }
}
