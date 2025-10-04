package cit243.ger2eng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        createFileBtn();
        displayBtn();
        searchBtn();
        quitBtn();
    }



    private void createFileBtn() {
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenu.this, CreateFile.class));
            }
        });
    }

    private void displayBtn() {

        final Intent i = new Intent(MainMenu.this, DisplayList.class);

        Button nouns = findViewById(R.id.nounsBtn);
        nouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("id", R.id.nounRB);
                startActivity(i);
            }
        });
        Button verbs = findViewById(R.id.verbsBtn);
        verbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("id", R.id.verbRB);
                startActivity(i);
            }
        });
        Button adj = findViewById(R.id.adjBtn);
        adj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("id", R.id.adjectiveRB);
                startActivity(i);
            }
        });
        Button adverbs = findViewById(R.id.advBtn);
        adverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("id", R.id.adverbRB);
                startActivity(i);
            }
        });
        Button prep = findViewById(R.id.prepBtn);
        prep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("id", R.id.prepRB);
                startActivity(i);
            }
        });
        Button number = findViewById(R.id.numBtn);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("id", R.id.numRB);
                startActivity(i);
            }
        });
    }

    private void searchBtn() {
        Button button = findViewById(R.id.searchBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenu.this, Search.class));
            }
        });
    }

    private void quitBtn() {
        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
