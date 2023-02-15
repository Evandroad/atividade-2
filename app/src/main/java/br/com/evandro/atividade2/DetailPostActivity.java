package br.com.evandro.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.com.evandro.atividade2.model.Posts;

public class DetailPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        Intent intent = getIntent();
        Posts posts = intent.getParcelableExtra("objPosts");

        TextView tv = findViewById(R.id.tvIdPost);
        tv.setText(String.valueOf(posts.getId()));
        tv = findViewById(R.id.tvIdUserPost);
        tv.setText(String.valueOf(posts.getUserId()));
        tv = findViewById(R.id.tvTitlePost);
        tv.setText(posts.getTitle());
        tv = findViewById(R.id.tvBodyPost);
        tv.setText(posts.getTitle());
    }

}