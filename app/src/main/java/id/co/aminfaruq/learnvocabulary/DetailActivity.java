package id.co.aminfaruq.learnvocabulary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgGambarDetail)
    ImageView imgGambarDetail;
    @BindView(R.id.txtIsiDetail)
    TextView txtIsiDetail;
    @BindView(R.id.txtDaftar)
    TextView txtDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //TODO mengubah textview dan image view dengan data dari halaman sebelumnya
        txtDaftar.setText(getIntent().getStringExtra("dv"));
        txtIsiDetail.setText(getIntent().getStringExtra("iv"));

        Glide.with(this).load(getIntent().getIntExtra("gv", 0)).into(imgGambarDetail);
    }
}
