package utsman.kucingapes.recyclerviewlatihan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Detail extends AppCompatActivity {

    private List<Model> models = new ArrayList<>();
    private MyAdapter adapter;

    private Model model;

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final String title = getIntent().getStringExtra("title");
        final int id = 0;
        TextView textView = findViewById(R.id.title_detail);
        TextView tvId = findViewById(R.id.idDetail);

        tvId.setText(String.valueOf(id));
        textView.setText(title);

        adapter = new MyAdapter(models, this);
        final SharedPreference preference = new SharedPreference();

        final Button button = findViewById(R.id.liat);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*adapter.setFavo();*//*
                Model model = new Model(id, title, "favorit");
                preference.addFavorite(getApplicationContext(), model);
                Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();

            }
        });*/

        final SharedPreferences settings;
        settings = getApplicationContext().getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        final String jsonFavorites = settings.getString(FAVORITES, null);

        if (jsonFavorites != null && jsonFavorites.contains(title)) {
            button.setText("hilangkan");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*SharedPreferences.Editor editor = settings.edit();
                    String jsonFavoritesQ = jsonFavorites;

                    jsonFavoritesQ = jsonFavoritesQ.replace(String.valueOf(id), "")
                            .replace(title,"")
                            .replace("favorite", "");

                    editor.putString(FAVORITES, jsonFavoritesQ);
                    editor.apply();*/


                    String json = "{ favorite : favorite , id :2, title : title 3 },";
                    //String eks = "{favorite:y,id:"+id+",title:"+title+"}" ;
                    //String eks = "{"+"favorite"+:
                    //String eks = "{ "favorite ": "y ", "id ":0, "title ": "title 5 "}";
                    //String eks = "{ \"favorite \": \"y \", \"id \":0, \"title \": \"title 5 \"}";
                    String eks = "{\"favorite\":\"y\",\"id\":0,\"title\":\""+title+"\"}";
                    String ekskoma = "{\"favorite\":\"y\",\"id\":0,\"title\":\""+title+"\"},";


                    if (jsonFavorites.contains(eks)){
                        Toast.makeText(getApplicationContext(), "ada", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = settings.edit();
                        String jsonFavoritesQ = jsonFavorites;

                        jsonFavoritesQ = jsonFavoritesQ.replace(eks,"");

                        /*if (jsonFavoritesQ.contains(ekskoma)) {
                            jsonFavoritesQ = jsonFavoritesQ.replace(eks, "");
                            editor.putString(FAVORITES, jsonFavoritesQ);
                            editor.apply();
                        } else if (jsonFavoritesQ.contains(eks)){
                            editor.putString(FAVORITES, jsonFavoritesQ);
                            editor.apply();
                        }*/

                        editor.putString(FAVORITES, jsonFavoritesQ);
                        editor.apply();



                    } if (jsonFavorites.contains(ekskoma)) {
                        Toast.makeText(getApplicationContext(), "ada", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = settings.edit();
                        String jsonFavoritesQ = jsonFavorites;

                        jsonFavoritesQ = jsonFavoritesQ.replace(ekskoma,"");

                        editor.putString(FAVORITES, jsonFavoritesQ);
                        editor.apply();
                    }



                    //Toast.makeText(getApplicationContext(), jsonFavoritesQ, Toast.LENGTH_SHORT).show();



                    //Toast.makeText(getApplicationContext(), qq, Toast.LENGTH_SHORT).show();

                }
            });
        } else {
            button.setText("tambahkan");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Model model = new Model(id, title, "y");
                    preference.addFavorite(getApplicationContext(), model);
                    Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
