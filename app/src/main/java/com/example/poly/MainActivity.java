package com.example.poly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvWeather;
    AsyncHttpClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvWeather=findViewById(R.id.lv);
        client=new AsyncHttpClient();
    }
    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<POLY> alPoly = new ArrayList<POLY>();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {
            private int Year;
            private String type;
            private int enrolment;
            //            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonRecord=response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonRecord.getJSONArray("records");
                    for(int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject r = jsonArrRecords.getJSONObject(i);
                        Year=r.getInt("year");
                        type=r.getString("type_of_study");
                        enrolment=r.getInt("enrolment");
                        POLY poly = new POLY(Year,type,enrolment);
                        alPoly.add(poly);
                    }
                }
                catch(JSONException e){
                }
                //POINT X – Code to display List View
                ArrayAdapter adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alPoly);
                lvWeather.setAdapter(adapter);


            }//end onSuccess
        });
    }//end onResume
}