package cit243.midterm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends Activity {

    int score = 0, num = 0, arr = 1;
    Question q[] = new Question[arr];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        TextView qtext = findViewById(R.id.textView);

        q[num] = new Question("java starts with the letter J.", num + 1, true);
        /*

        questions

        */
        qtext.setText(q[num].getQ());

        next();
        back();
    }

    private void back() {
        final Button back = findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView qtext = findViewById(R.id.textView);
                num--;
                if (num < 1)
                    back.setVisibility(View.INVISIBLE);
                qtext.setText(q[num].getQ());

            }
        });
    }

    private void next() {
        final Button next = findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView qtext = findViewById(R.id.textView);
                RadioGroup rg = findViewById(R.id.radioGroup);
                RadioButton t = findViewById(R.id.trueRB);
                Button back = findViewById(R.id.button3);
                if (num > 0)
                    back.setVisibility(View.VISIBLE);

                if (num == (arr - 1)) {
                    Toast.makeText(next.getContext(), "your final score is: " + score, Toast.LENGTH_LONG).show();
                }
                else {
                    qtext.setText(q[num].getQ());
                    num++;
                    if (rg.getCheckedRadioButtonId() == t.getId()) {
                        if (q[num].isAns() == true) {
                            score++;
                        }

                    } else {
                        if (q[num].isAns() == false) {
                            score++;
                        }
                    }
                }

            }
        });
    }
}
