package ro.pub.cs.systems.eim.practicaltest01var08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08PlayActivity extends AppCompatActivity {

    private Button checkButton = null;
    private Button backButton = null;
    private EditText riddle2Text = null;
    private EditText answer2Text = null;
    private EditText attemptText = null;
    private Activity this_activity = this;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.check:
                    if (attemptText.getText().toString().equals(answer2Text.getText().toString())) {
                        Toast.makeText(this_activity, "CORRECT!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this_activity, "INCORRECT!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.back:

                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_play);

        riddle2Text = (EditText) findViewById(R.id.riddle2);
        answer2Text = (EditText) findViewById(R.id.answer2);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle b = intent.getExtras();
            String textToParse = (String)b.get("content");
            String[] ridans = textToParse.split("\t");

            riddle2Text.setText(ridans[0]);
            answer2Text.setText(ridans[1]);
        }

        attemptText = (EditText) findViewById(R.id.attempt);


        checkButton = (Button)findViewById(R.id.check);
        checkButton.setOnClickListener(buttonClickListener);

        backButton = (Button)findViewById(R.id.back);
        backButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var08Service.class);
        stopService(intent);
        super.onDestroy();
    }
}
