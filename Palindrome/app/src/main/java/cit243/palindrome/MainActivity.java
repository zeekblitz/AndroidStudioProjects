package cit243.palindrome;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
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
        clear();
    }

    private void clear() {
        final EditText text = findViewById(R.id.editText);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.getText().clear();
            }
        });
    }

    private void check() {
        final Button btn = findViewById(R.id.button);
        final EditText text = findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer(text.getText().toString());
                //text.getText().clear();
                if (sb.length() < 3){
                    Toast.makeText(btn.getContext(),
                            "you need at least 3 characters.",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    for (int i = 0; i < sb.length(); i++){
                        if (!Character.isLetterOrDigit(sb.charAt(i))) {
                            sb.deleteCharAt(i);
                            //sb.trimToSize();
                        }
                    }
                    String str = sb.toString().toLowerCase();
                    String temp = sb.reverse().toString().toLowerCase();

                    if (str.equals(temp))
                        Toast.makeText(btn.getContext(),
                                "\"" + text.getText().toString() + "\" is a palindrome.",
                                Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(btn.getContext(),
                                "\"" + text.getText().toString() + "\" is NOT a palindrome.",
                                Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
