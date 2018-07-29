package utsman.kucingapes.recyclerviewlatihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Model> models = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyAdapter(models, this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        addData();

        findViewById(R.id.favAc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Favorit.class));
            }
        });
    }

    private void addData() {
        Model model = new Model(0,"title 1", "no");
        models.add(model);
        model = new Model(1, "title 2", "no");
        models.add(model);
        model = new Model(2, "title 3", "no");
        models.add(model);
        model = new Model(3, "title 4", "no");
        models.add(model);
        model = new Model(4, "title 5", "no");
        models.add(model);
        adapter.notifyDataSetChanged();
    }
}
