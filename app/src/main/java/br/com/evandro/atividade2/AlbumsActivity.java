package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.evandro.atividade2.model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Albums");

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Album>> call = api.getAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NonNull Call<List<Album>> call, @NonNull Response<List<Album>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Album>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter albums.");
            }
        });
    }

    public void fillList(List<Album> albums) {
        Toast.makeText(this,"qtd: " + albums.size(), Toast.LENGTH_SHORT).show();
        LinearLayout ll = findViewById(R.id.layoutVerticalItems);

        for (Album album : albums) {
            Button bt = new Button(this);
            bt.setText(album.getTitle());
            bt.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(), DetailAlbumActivity.class);
                intent.putExtra("objAlbums", album);
                startActivity(intent);
            });

            ll.addView(bt);
        }
    }

}