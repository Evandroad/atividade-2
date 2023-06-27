package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.evandro.atividade2.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Posts");

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Post>> call = api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter posts.");
            }
        });
    }

    public void fillList(List<Post> posts) {
        Toast.makeText(this,"qtd: " + posts.size(), Toast.LENGTH_SHORT).show();
        LinearLayout ll = findViewById(R.id.layoutVerticalItems);

        for (Post post : posts) {
            Button bt = new Button(this);
            bt.setText(post.getTitle());
            bt.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(), DetailPostActivity.class);
                intent.putExtra("objPosts", post);
                startActivity(intent);
            });

            ll.addView(bt);
        }
    }

}