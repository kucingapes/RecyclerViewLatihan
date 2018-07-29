package utsman.kucingapes.recyclerviewlatihan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Favorit extends AppCompatActivity {

    private List<Model> models = new ArrayList<>();
    private MyAdapter adapter;

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SharedPreference preference = new SharedPreference();
        models = preference.getFavorites(this);

        if (models == null) {
            models = new ArrayList<>();
        }*/

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*List<Model> filterList = filter(models, "favorite");
        adapter.setFilterSearch(filterList);*/
        //adapter.notifyDataSetChanged();

        final SharedPreferences settings;
        settings = getApplicationContext().getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        String jsonFavorites = settings.getString(FAVORITES, null);

        String brokenjson = ",]";
        String fixjson = "]";

        if (jsonFavorites != null) {
            if (jsonFavorites.contains(brokenjson)) {
                SharedPreferences.Editor editor = settings.edit();
                jsonFavorites = jsonFavorites.replace(brokenjson, fixjson);
                editor.putString(FAVORITES, jsonFavorites);
                editor.apply();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        SharedPreference preference = new SharedPreference();
                        models = preference.getFavorites(getApplicationContext());

                        if (models == null) {
                            models = new ArrayList<>();
                        }
                        adapter = new MyAdapter(models, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }
                }, 1000);

            } else {
                SharedPreference preference = new SharedPreference();
                models = preference.getFavorites(this);

                if (models == null) {
                    models = new ArrayList<>();
                }

                adapter = new MyAdapter(models, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }
        }

    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                recreate();
            }
        }
    }*/

    /*private List<Model> filter(List<Model> models, String query) {
        query = query.toLowerCase();
        final List<Model> filteredModelList = new ArrayList<>();
        for (Model model : models) {
            final String text = String.valueOf(model.getFavorite()).toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }*/
}
