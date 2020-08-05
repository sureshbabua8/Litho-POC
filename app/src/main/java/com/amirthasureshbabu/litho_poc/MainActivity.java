package com.amirthasureshbabu.litho_poc;

import android.app.DownloadManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.soloader.SoLoader;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

        final Component component =
                RecyclerCollectionComponent.create(c)
                        .disablePTR(true)
                        .section(ListSection.create(new SectionContext(c)).build())
                        .build();

        setContentView(LithoView.create(c, component));

        // make example GET request
//        final TextView textView = (TextView) findViewById(R.id.text);
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://"; // IP ADDRESS HERE

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}