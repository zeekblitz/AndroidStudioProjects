package cit243.ger2eng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Search extends AppCompatActivity {
    private static final String FILE = "WordList.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search();
    }

    private void search() {
        final EditText input = findViewById(R.id.editText3);
        final EditText output = findViewById(R.id.editText4);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FileInputStream fis = null;
                try {
                    fis = openFileInput(FILE);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    //StringBuilder sb = new StringBuilder();
                    String text;

                    while ((text = br.readLine()) != null){
                        text = br.readLine();
                        if (text.equals(input.getText().toString()))
                        {
                            text = br.readLine();
                            if (output.getText().equals("")) {
                                output.setText(text);
                            }
                            else{
                                output.getText().clear();
                                output.setText(text);
                            }
                            break;
                        }
                        else{
                            text = br.readLine();
                        }
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
