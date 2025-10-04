package cit243.pixlpickr;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRed();
        setGreen();
        setBlue();
    }

    private void setRed() {
        final SeekBar redbar = findViewById(R.id.redSeek);
        final SeekBar greenbar = findViewById(R.id.greenSeek);
        final SeekBar bluebar = findViewById(R.id.blueSeek);

        final TextView redtext = findViewById(R.id.redText);

        final ConstraintLayout bg = findViewById(R.id.background);

        redbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // set the text to it's hex value
                redtext.setText(String.format("%02X", redbar.getProgress()));
                // set the color to its hex value
                redbar.setBackgroundColor(Color.parseColor(
                        "#" + String.format("%02X", redbar.getProgress()) + "0000"));
                // set the final color to the total
                bg.setBackgroundColor(Color.parseColor("#" +
                        String.format("%02X", redbar.getProgress()) +
                        String.format("%02X", greenbar.getProgress()) +
                        String.format("%02X", bluebar.getProgress())));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setGreen() {
        final SeekBar redbar = findViewById(R.id.redSeek);
        final SeekBar greenbar = findViewById(R.id.greenSeek);
        final SeekBar bluebar = findViewById(R.id.blueSeek);

        final TextView greentext = findViewById(R.id.greenText);

        final ConstraintLayout bg = findViewById(R.id.background);

        greenbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // set the text to it's hex value
                greentext.setText(String.format("%02X", greenbar.getProgress()));
                // set the color to its hex value
                greenbar.setBackgroundColor(Color.parseColor(
                        "#00" + String.format("%02X", greenbar.getProgress()) + "00"));
                // set the final color to the total
                bg.setBackgroundColor(Color.parseColor("#" +
                        String.format("%02X", redbar.getProgress()) +
                        String.format("%02X", greenbar.getProgress()) +
                        String.format("%02X", bluebar.getProgress())));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setBlue() {
        final SeekBar redbar = findViewById(R.id.redSeek);
        final SeekBar greenbar = findViewById(R.id.greenSeek);
        final SeekBar bluebar = findViewById(R.id.blueSeek);

        final TextView bluetext = findViewById(R.id.blueText);

        final ConstraintLayout bg = findViewById(R.id.background);

        bluebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // set the text to it's hex value
                bluetext.setText(String.format("%02X", bluebar.getProgress()));
                // set the color to its hex value
                bluebar.setBackgroundColor(Color.parseColor(
                        "#0000" + String.format("%02X", bluebar.getProgress())));
                // set the final color to the total
                bg.setBackgroundColor(Color.parseColor("#" +
                        String.format("%02X", redbar.getProgress()) +
                        String.format("%02X", greenbar.getProgress()) +
                        String.format("%02X", bluebar.getProgress())));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
