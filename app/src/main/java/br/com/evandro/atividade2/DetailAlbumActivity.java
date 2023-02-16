package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.com.evandro.atividade2.model.Albums;

public class DetailAlbumActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_album);

        getSupportActionBar().setTitle("Album Detail");

        Intent intent = getIntent();
        Albums albums = intent.getParcelableExtra("objAlbums");

        TextView tv = findViewById(R.id.tvIdAlbum);
        tv.setText(String.valueOf(albums.getId()));
        tv = findViewById(R.id.tvIdUserAlbum);
        tv.setText(String.valueOf(albums.getUserId()));
        tv = findViewById(R.id.tvTitleAlbum);
        tv.setText(albums.getTitle());
    }

}