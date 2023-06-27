package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.evandro.atividade2.model.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Comments");

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Comment>> call = api.getComments();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Comment>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter comments.");
            }
        });

    }

    public void fillList(List<Comment> comments) {
        Toast.makeText(this, "qtd: " + comments.size(), Toast.LENGTH_LONG).show();
        LinearLayout ll = findViewById(R.id.layoutVerticalItems);

        for (Comment comment : comments) {
            Button bt = new Button(this);
            bt.setText(comment.getName());
            bt.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(), DetailCommentActivity.class);
                intent.putExtra("objComments", comment);
                startActivity(intent);
            });

            ll.addView(bt);
        }
    }

}