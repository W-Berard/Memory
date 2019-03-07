package com.example.william.memory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start_button;
    Button change_theme_button;
    Button change_difficulty_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        change_theme_button = findViewById(R.id.change_theme_button);

        change_theme_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_theme();
            }
        });

        start_button = findViewById(R.id.start_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

    }

    public void change_theme(){
        GameState.INSTANCE.changeTheme();
    }

    public void start(){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
