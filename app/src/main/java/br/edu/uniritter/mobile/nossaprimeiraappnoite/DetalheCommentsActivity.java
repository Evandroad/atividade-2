package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Comments;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Posts;

public class DetalheCommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comments);

        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objComments");
        if (prc instanceof Comments) {

        }
        Comments comments = intent.getParcelableExtra("objComments");
        bind(comments);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Comments comments = intent.getParcelableExtra("objComments");
        bind(comments);

    }
    /*public void cbClick(View v) {
        CheckBox cb = findViewById(R.id.cbCompleted);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objAlbums");
        todo.setCompleted(cb.isChecked());
    }*/

    private void bind(Comments obj) {
        TextView tv = findViewById(R.id.tvPostId);
        tv.setText(obj.getPostId()+"");
        tv = findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvName);
        tv.setText(obj.getName());
        tv = findViewById(R.id.tvEmail);
        tv.setText(obj.getEmail());
        tv = findViewById(R.id.tvBody);
        tv.setText(obj.getBody());
    }
}