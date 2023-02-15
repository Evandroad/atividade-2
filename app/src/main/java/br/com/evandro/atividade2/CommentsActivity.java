package br.com.evandro.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import br.com.evandro.atividade2.model.Comments;

public class CommentsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    List<Comments> comments =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        // Volley
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/comments";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            this,
            this
        );

        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);

                Comments obj = new Comments();
                obj.setPostId(json.getInt("postId"));
                obj.setId(json.getInt("id"));
                obj.setName(json.getString("name"));
                obj.setEmail(json.getString("email"));
                obj.setBody(json.getString("body"));

                comments.add(obj);
            }

            Toast.makeText(this,"qtd: " + comments.size(), Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);

            for (Comments obj1 : comments) {
                Button bt = new Button(this);
                bt.setText(obj1.getName());
                bt.setTag(obj1);
                bt.setOnClickListener(v -> {
                    Button btn = (Button) v;
                    Comments comments = (Comments) btn.getTag();
                    Intent intent = new Intent(getApplicationContext(), DetailCommentActivity.class);
                    intent.putExtra("objComments", comments);
                    startActivity(intent);
                });

                ll.addView(bt);
            }
        } catch (JSONException e) {
            Log.e("Error: ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"Error: " + msg, Toast.LENGTH_LONG).show();
    }
}