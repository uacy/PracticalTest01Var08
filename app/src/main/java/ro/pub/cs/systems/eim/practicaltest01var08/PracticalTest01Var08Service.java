package ro.pub.cs.systems.eim.practicaltest01var08;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class PracticalTest01Var08Service extends Service {
    public PracticalTest01Var08Service() {
    }

    private ProcessingThread processingThread = null;
    String ans;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle b = intent.getExtras();
        if (b != null) {
            ans =(String) b.get("answer");
        }
        processingThread = new ProcessingThread(this, ans);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}
