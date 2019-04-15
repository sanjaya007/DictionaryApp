package com.sanjaya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private ListView lstDictionary;
    private HashMap<String,String> dictionary;

    private static final String words[] = {
        "Yeta au","Come Here",
        "Khana Khayeu","Did you eat?",
        "Timlai usle mann paraucha re","I love you",
        "Kata chas","Where are you?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();


        for (int i=0;i<words.length;i+=2){
            dictionary.put(words[i],words[i+1]);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet()));

        lstDictionary.setAdapter(adapter);

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String meaning = dictionary.get(key);

                Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
                intent.putExtra("meaning",meaning);
                startActivity(intent);
            }
        });


    }
}
