package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Albums;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Posts;

public class DetalhePostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_posts);

        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPosts");
        if (prc instanceof Posts) {

        }
        Posts posts = intent.getParcelableExtra("objPosts");
        bind(posts);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Posts posts = intent.getParcelableExtra("objPosts");
        bind(posts);

    }
    /*public void cbClick(View v) {
        CheckBox cb = findViewById(R.id.cbCompleted);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objAlbums");
        todo.setCompleted(cb.isChecked());
    }*/

    private void bind(Posts obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        tv = findViewById(R.id.tvBody);
        tv.setText(obj.getTitle());
    }
}