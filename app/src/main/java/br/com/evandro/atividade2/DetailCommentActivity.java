package br.com.evandro.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.com.evandro.atividade2.model.Comments;

public class DetailCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comment);

        Intent intent = getIntent();
        Comments comments = intent.getParcelableExtra("objComments");

        TextView tv = findViewById(R.id.tvPostIdComment);
        tv.setText(String.valueOf(comments.getPostId()));
        tv = findViewById(R.id.tvIdComment);
        tv.setText(String.valueOf(comments.getId()));
        tv = findViewById(R.id.tvName);
        tv.setText(comments.getName());
        tv = findViewById(R.id.tvEmail);
        tv.setText(comments.getEmail());
        tv = findViewById(R.id.tvBodyPost);
        tv.setText(comments.getBody());
    }

}