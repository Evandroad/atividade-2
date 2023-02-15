package br.com.evandro.atividade2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button todo = (Button) findViewById(R.id.btTodo);
        Button posts = (Button) findViewById(R.id.btPosts);
        Button albums = (Button) findViewById(R.id.btAlbums);
        Button comments = (Button) findViewById(R.id.btComments);

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