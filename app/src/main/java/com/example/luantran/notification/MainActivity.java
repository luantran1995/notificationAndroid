package com.example.luantran.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
 private NotificationCompat.Builder notbuider;
    private  static  final int MY_NOTIFICATION_ID =12345;
    private static  final int MY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.notbuider = new NotificationCompat.Builder(this);
        //thong bao tu huy khi nguoi dung click vao panel
        this.notbuider.setAutoCancel(true);

    }
    public void notiButtonClicked(View view)  {

        // --------------------------
        // Chuẩn bị một thông báo
        // --------------------------

        this.notbuider.setSmallIcon(R.mipmap.ic_launcher);
        this.notbuider.setTicker("This is a ticker");

        // Sét đặt thời điểm sự kiện xẩy ra.
        // Các thông báo trên Panel được sắp xếp bởi thời gian này.
        this.notbuider.setWhen(System.currentTimeMillis()+ 10* 1000);
        this.notbuider.setContentTitle("This is title");
        this.notbuider.setContentText("This is content text ....");

        // Tạo một Intent
        Intent intent = new Intent(this, MainActivity.class);


        // PendingIntent.getActivity(..) sẽ start mới một Activity và trả về
        // đối tượng PendingIntent.
        // Nó cũng tương đương với gọi Context.startActivity(Intent).
        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);


        this.notbuider.setContentIntent(pendingIntent);

        // Lấy ra dịch vụ thông báo (Một dịch vụ có sẵn của hệ thống).
        NotificationManager notificationService  =
                (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);

        // Xây dựng thông báo và gửi nó lên hệ thống.

        Notification notification =  notbuider.build();
        notificationService.notify(MY_NOTIFICATION_ID, notification);

    }
}
