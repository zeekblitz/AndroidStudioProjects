package cit243.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    //Question question[] = new Question[25];
    int num = 0, score = 0, arr = 5;
    String questions[] = new String[arr];
    boolean answer[] = new boolean[arr];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setQandA();
        next();
    }

    private void next() {
        final Button next = findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                TextView q = findViewById(R.id.question);
                RadioGroup rg = findViewById(R.id.radioGroup);
                RadioButton t = findViewById(R.id.trueRadio);
                if (num == (arr - 1)){
                    Toast.makeText(next.getContext(), "your final score is: " + score, Toast.LENGTH_LONG).show();

                }
                else {q.setText(questions[num] + num);
                    num++;
                    if (rg.getCheckedRadioButtonId() == t.getId()) {
                        if (answer[num] = true) {
                            score++;
                        }

                    } else {
                        if (answer[num] = false) {
                            score++;
                        }
                    }
                }
            }
        });

    }

    private void setQandA() {
        for (int i = 0; i < questions.length; i++){
            questions[i] = "Question: ";
            answer[i] = true;
        }
    }

}
