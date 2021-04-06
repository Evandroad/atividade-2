package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Albums;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button todo = (Button) findViewById(R.id.btTodo);
        Button posts = (Button) findViewById(R.id.btPosts);
        Button albums = (Button) findViewById(R.id.btAlbums);
        Button comments = (Button) findViewById(R.id.btComments);

        todo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abreTodoActivity(v);
            }
        });

        posts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abrePostsActivity(v);
            }
        });

        albums.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abreAlbumsActivity(v);
            }
        });

        comments.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abreCommentsActivity(v);
            }
        });
    }

    public void abreTodoActivity(View view) {
        Intent intent = new Intent(this, TodoActivity.class);
        startActivity(intent);
    }

    public void abrePostsActivity(View view) {
        Intent intent = new Intent(this, PostsActivity.class);
        startActivity(intent);
    }

    public void abreAlbumsActivity(View view) {
        Intent intent = new Intent(this, AlbumsActivity.class);
        startActivity(intent);
    }
    public void abreCommentsActivity(View view) {
        Intent intent = new Intent(this, CommentsActivity.class);
        startActivity(intent);
    }
}