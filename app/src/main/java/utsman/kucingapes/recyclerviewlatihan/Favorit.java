package utsman.kucingapes.recyclerviewlatihan;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Favorit extends AppCompatActivity {

    private List<Model> models = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreference preference = new SharedPreference();
        models = preference.getFavorites(this);

        if (models == null) {
            models = new ArrayList<>();
        }

        adapter = new MyAdapter(models, this);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*List<Model> filterList = filter(models, "favorite");
        adapter.setFilterSearch(filterList);*/
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

    }

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
