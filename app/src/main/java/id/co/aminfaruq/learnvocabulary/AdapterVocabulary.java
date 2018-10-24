package id.co.aminfaruq.learnvocabulary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterVocabulary extends RecyclerView.Adapter<AdapterVocabulary.ViewHolder> {
    //TODO membuat variable untuk menampung data ke parameter
    Context context;
    int[] gambar;
    String[]daftar,isi;

    //TODO membuat constructor untuk variable yang sudah kita buat agar dapat menampung parameter
    public AdapterVocabulary(Context context, int[] gambar, String[] daftar, String[] isi) {
        this.context = context;
        this.gambar = gambar;
        this.daftar = daftar;
        this.isi = isi;
    }

    @NonNull
    @Override
    public AdapterVocabulary.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //menentukan tampilan adapter
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_vocabulary,viewGroup,false);
        //Mengembalikan nilai untuk memberi tahu recyle view bahwa kita menggunakan view yang sudah kita buat
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVocabulary.ViewHolder viewHolder, final int i) {
        viewHolder.txtDaftar.setText(daftar[i]);
        Glide.with(context).load(gambar[i]).into(viewHolder.imgGambar);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("dv",daftar[i]);
                intent.putExtra("iv",isi[i]);
                intent.putExtra("gv",gambar[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDaftar;
        ImageView imgGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           txtDaftar = itemView.findViewById(R.id.txtIsi);
           imgGambar = itemView.findViewById(R.id.imgGambar);
        }
    }
}
