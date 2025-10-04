package cit243.ger2eng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisplayList extends AppCompatActivity {

    private static final String FILE = "WordList.txt";
    EditText engDisplay;
    EditText gerDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        engDisplay = findViewById(R.id.editText);
        gerDisplay = findViewById(R.id.editText2);

        Bundle b = getIntent().getExtras();
        Integer id = b.getInt("id");

        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder eng = new StringBuilder();
            StringBuilder ger = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                if (text.equals(id.toString()))
                {
                    text = br.readLine();
                    eng.append(text).append("\n");
                    text = br.readLine();
                    ger.append(text).append("\n");
                }
                else{
                    br.readLine();
                    br.readLine();
                }
            }
            engDisplay.setText(eng.toString());
            gerDisplay.setText(ger.toString());

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
}
