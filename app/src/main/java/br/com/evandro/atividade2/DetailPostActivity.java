package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import br.com.evandro.atividade2.model.Post;

public class DetailPostActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Post Detail");

        Intent intent = getIntent();
        Post post = intent.getParcelableExtra("objPosts");

        TextView tv = findViewById(R.id.tvIdPost);
        tv.setText(String.valueOf(post.getId()));
        tv = findViewById(R.id.tvIdUserPost);
        tv.setText(String.valueOf(post.getUserId()));
        tv = findViewById(R.id.tvTitlePost);
        tv.setText(post.getTitle());
        tv = findViewById(R.id.tvBodyPost);
        tv.setText(post.getBody());
    }

}