package ro.pub.cs.systems.eim.practicaltest01var08;

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
import android.content.Context;

import android.util.Log;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;
    private String answer;

    public ProcessingThread(Context context, String ans) {
        this.context = context;
        StringBuilder aux = new StringBuilder();

        for (int i = 0; i < ans.length(); ++i) {
            if (i == 2)  {
                aux.append(ans.charAt(i));
            } else {
                aux.append("*");
            }
        }
        answer = aux.toString();
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(answer);
        intent.putExtra("answer", answer);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
