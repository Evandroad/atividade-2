package br.com.evandro.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PrincipalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        getSupportActionBar().setTitle("Tela Principal");

        Button todo = findViewById(R.id.btTodo);
        Button posts = findViewById(R.id.btPosts);
        Button albums = findViewById(R.id.btAlbums);
        Button comments = findViewById(R.id.btComments);

        todo.setOnClickListener(v -> intentTo(TodoActivity.class));
        posts.setOnClickListener(v -> intentTo(PostsActivity.class));
        albums.setOnClickListener(v -> intentTo(AlbumsActivity.class));
        comments.setOnClickListener(v -> intentTo(CommentsActivity.class));
    }

    public void intentTo(Class<?> activity){
        Intent it = new Intent(this, activity);
        startActivity(it);
    }

}