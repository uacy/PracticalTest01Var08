package ro.pub.cs.systems.eim.practicaltest01var08;

import android.support.v7.app.AppCompatActivity;
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

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private EditText riddleText = null;
    private EditText answerText = null;
    private Button playButton = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.play:
                    if(!(riddleText.getText().toString().equals("") || answerText.getText().toString().equals(""))) {
                        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08PlayActivity.class);
                        intent.putExtra("content", riddleText.getText().toString() + '\t' + answerText.getText().toString());
                        startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        riddleText = (EditText)findViewById(R.id.riddle);
        answerText = (EditText)findViewById(R.id.answer);
        riddleText.setText("");
        answerText.setText("");

        playButton = (Button)findViewById(R.id.play);
        playButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("riddleText")) {
                riddleText.setText(savedInstanceState.getString("riddleText"));
            } else {
                riddleText.setText("");
            }
            if (savedInstanceState.containsKey("answerText")) {
                answerText.setText(savedInstanceState.getString("answerText"));
            } else {
                answerText.setText("");
            }
        } else {
            riddleText.setText("");
            answerText.setText("");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("riddleText", riddleText.getText().toString());
        savedInstanceState.putString("answerText", answerText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("riddleText")) {
            riddleText.setText(savedInstanceState.getString("riddleText"));
        } else {
            riddleText.setText("");
        }
        if (savedInstanceState.containsKey("answerText")) {
            answerText.setText(savedInstanceState.getString("answerText"));
        } else {
            answerText.setText("");
        }
    }

}
