package com.rodico.duke0808.myapplication.activity.Notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rodico.duke0808.myapplication.R;

public class NotificationActivity extends AppCompatActivity {
    private NotificationManager nm;
    public static final int NOTIFY_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void init(){
        nm = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder =  new Notification.Builder(this);
        Intent intent1 = new Intent(this,Main2Activity.class);
        PendingIntent intent = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_CANCEL_CURRENT);
        builder
                .setContentIntent(intent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Hello Notification")
                .setContentTitle("MyNotification")
                .setContentText("This is a text of my first notification. Click to go to activity")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);
        Notification notidication = builder.build();
        nm.notify(0,notidication);
    }
}
