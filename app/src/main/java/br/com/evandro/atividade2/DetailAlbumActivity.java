package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import br.com.evandro.atividade2.model.Album;

public class DetailAlbumActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_album);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Album Detail");

        Intent intent = getIntent();
        Album album = intent.getParcelableExtra("objAlbums");

        TextView tv = findViewById(R.id.tvIdAlbum);
        tv.setText(String.valueOf(album.getId()));
        tv = findViewById(R.id.tvIdUserAlbum);
        tv.setText(String.valueOf(album.getUserId()));
        tv = findViewById(R.id.tvTitleAlbum);
        tv.setText(album.getTitle());
    }

}