package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import br.com.evandro.atividade2.model.Comment;

public class DetailCommentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comment);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Comment Detail");

        Intent intent = getIntent();
        Comment comment = intent.getParcelableExtra("objComments");

        TextView tv = findViewById(R.id.tvPostIdComment);
        tv.setText(String.valueOf(comment.getPostId()));
        tv = findViewById(R.id.tvIdComment);
        tv.setText(String.valueOf(comment.getId()));
        tv = findViewById(R.id.tvName);
        tv.setText(comment.getName());
        tv = findViewById(R.id.tvEmail);
        tv.setText(comment.getEmail());
        tv = findViewById(R.id.tvBodyPost);
        tv.setText(comment.getBody());
    }

}