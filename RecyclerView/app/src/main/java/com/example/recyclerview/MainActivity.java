package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> names;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = this.getallname();/*lo intaciamos*/
        recyclerView = findViewById(R.id.recycler);
        layoutManager =  new LinearLayoutManager(this);

        adaptador = new myadapter(names, R.layout.recyclerview_item, new myadapter.OnItemClickListener() {
            @Override
            public void onItemclick(String nombre, int posicion) {
                Toast.makeText(MainActivity.this, nombre+" - "+posicion, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptador);
    }

    private List<String>getallname(){
        return new ArrayList<String>(){{
           add("Marco");
           add("Pedor");
           add("JUAN");
           add("NACHO");
           add("Luis");
        }};
    }
}