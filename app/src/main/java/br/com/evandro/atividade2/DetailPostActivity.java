package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.com.evandro.atividade2.model.Posts;

public class DetailPostActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        getSupportActionBar().setTitle("Post Detail");

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