package id.co.aminfaruq.learnvocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;


import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleVocabulary extends AppCompatActivity {

    @BindView(R.id.MyRecycle)
    RecyclerView MyRecycle;

    //TODO membuat variable array untuk menampung data
    String daftar[];
    String isi[];
    int gambar[] = {R.drawable.kartun,R.drawable.jalan,R.drawable.mall};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_vocabulary);
        ButterKnife.bind(this);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        daftar = getResources().getStringArray(R.array.daftar);
        isi = getResources().getStringArray(R.array.isi);

        //TODO membuat object untuk adapter agar bisa digunakan dan mengisi parameter yang di butuhkan
        AdapterVocabulary adapter = new AdapterVocabulary(this,gambar,daftar,isi);

        //TODO menseting recycle view

        MyRecycle.setHasFixedSize(true);
        MyRecycle.setLayoutManager(new LinearLayoutManager(this));
        MyRecycle.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_profile:
                intent = new Intent(this,Profile.class);
                startActivity(intent);
                break;

            case R.id.action_about:
                intent = new Intent(this,About.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);


    }
}
