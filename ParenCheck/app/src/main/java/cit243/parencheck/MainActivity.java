package cit243.parencheck;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check();
    }

    private void check() {
        final Button btn = findViewById(R.id.button);
        final EditText text = findViewById(R.id.editText);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer(text.getText().toString());
                String outputTxt = "empty string";

                for (int i = 0; i < sb.length(); i++) {
                    //search the string for an open delimiter
                    if (sb.charAt(i) == '(' || sb.charAt(i) == '[' || sb.charAt(i) == '{') {
                        // extend the string in case it's at the end
                        sb.append(' ');
                        // if one is found search the string from the end for an equal closing delimiter
                        for (int j = i; j < sb.length(); j++) {
                            if (sb.charAt(j) == ')' && sb.charAt(i) == '(' ||
                                    sb.charAt(j) == ']' && sb.charAt(i) == '[' ||
                                    sb.charAt(j) == '}' && sb.charAt(i) == '{') {
                                //if one is found, replace both delimiters and search the rest of the string
                                sb.setCharAt(i, ' ');
                                sb.setCharAt(j, ' ');
                                outputTxt = "valid string";
                                break;
                            }
                            else {
                                outputTxt = "Missing closing bracket for " + i;
                            }
                        }
                    } else if (sb.charAt(i) == ')' || sb.charAt(i) == ']' || sb.charAt(i) == '}') {
                        outputTxt = "Missing open bracket for " + i;
                        break;
                    }
                    //else
                    //  outputTxt = "valid string 2 " + i;
                }

                Toast.makeText(btn.getContext(),
                        outputTxt,
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
