package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Albums;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;

public class AlbumsActivity extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<Albums> albums =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

// Volley
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);

        queue.add(jsonArrayRequest);
        Toast.makeText(this,"qtd:"+albums.size(),Toast.LENGTH_LONG).show();
    }

// Volley
    @Override
    public void onResponse(JSONArray response) {
        try {
            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Albums obj = new Albums(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"));
                albums.add(obj);
            }
            Toast.makeText(this,"qtd:"+albums.size(),Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for(Albums obj1 : albums) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Albums albums = (Albums) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalheAlbumsActivity.class);
                        intent.putExtra("objAlbums", albums);
                        startActivity(intent);
                    }
                });
                ll.addView(bt);
            }
        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"deu erro: "+msg,Toast.LENGTH_LONG).show();
    }
}