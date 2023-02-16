package br.com.evandro.atividade2;

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
import java.util.Objects;

import br.com.evandro.atividade2.model.Todo;

public class TodoActivity extends BaseActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    List<Todo> todos =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Objects.requireNonNull(getSupportActionBar()).setTitle("ToDo");

        // Volley
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/todos";

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

                Todo obj = new Todo();
                obj.setUserId(json.getInt("userId"));
                obj.setId(json.getInt("id"));
                obj.setTitle(json.getString("title"));
                obj.setCompleted(json.getBoolean("completed"));

                todos.add(obj);
            }

            Toast.makeText(this,"qtd: " + todos.size(), Toast.LENGTH_SHORT).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);

            for (Todo todo : todos) {
                Button bt = new Button(this);
                bt.setText(todo.getTitle());
                bt.setTag(todo);
                bt.setOnClickListener(v -> {
                    Button btn = (Button) v;
                    Todo _todo = (Todo) btn.getTag();
                    Intent intent = new Intent(getApplicationContext(), DetailTodoActivity.class);
                    intent.putExtra("objTodo", _todo);
                    startActivity(intent);
                });

                ll.addView(bt);
            }
        } catch (JSONException e) {
            Log.e("Error: ",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"Error: " + msg, Toast.LENGTH_LONG).show();
    }

}