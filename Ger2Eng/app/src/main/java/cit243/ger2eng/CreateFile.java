package cit243.ger2eng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CreateFile extends AppCompatActivity {

    private static final String FILE = "WordList.txt";

    EditText english, german;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_file);

        english = findViewById(R.id.englishWord);
        german = findViewById(R.id.germanWord);
        rg = findViewById((R.id.radioGroup));


        submitBtn();

        german.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_1) {
                    german.getText().append("ä");
                    return true;
                }
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_2){
                    german.getText().append("ü");
                    return true;
                }
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_3) {
                    german.getText().append("ö");
                    return true;
                }
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_4){
                    german.getText().append("Ö");
                    return true;
                }
                return false;
            }
        });

    }

    private void submitBtn() {
        final Button submit = findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (english.getText().toString() == "" ||
                        german.getText().toString() == "" ||
                        rg.getCheckedRadioButtonId() == -1)

                    Toast.makeText(submit.getContext(),
                            "Please fill out all the data",
                            Toast.LENGTH_LONG).show();

                else {

                    int rbType = rg.getCheckedRadioButtonId();
                    final String string =
                            rbType + "\n" +
                                    english.getText().toString() + "\n" +
                                    german.getText().toString() + "\n";

                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput(FILE, MODE_APPEND);
                        fos.write(string.getBytes());


                        english.getText().clear();
                        german.getText().clear();
                        rg.clearCheck();
                        Toast.makeText(submit.getContext(),
                                "saved to: " +
                                getFilesDir() + "/" + FILE,
                                Toast.LENGTH_LONG).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }
}
