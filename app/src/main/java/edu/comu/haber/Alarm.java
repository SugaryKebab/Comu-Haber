package edu.comu.haber;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

import java.util.Calendar;
import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

public class Alarm {
    private PendingIntent realTimeWakeUp;
    private PendingIntent rtcWAKEUp;
    private int hour = 60;
    private Context context;
    private  Intent intent;
    private AlarmManager manager;

    Alarm(Context context){
        this.context = context;
        this.intent = new Intent(context, CheckNewsService.class);
        this.manager  = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.realTimeWakeUp = PendingIntent.getForegroundService(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            this.rtcWAKEUp = PendingIntent.getForegroundService(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        }else{
            this.realTimeWakeUp = PendingIntent.getService(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            this.rtcWAKEUp = PendingIntent.getService(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        }
    }

    public boolean isWorkingHour() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour >= 9 && hour <= 18) {
            return true;
        } else {
            return false;
        }
    }

    public void setAlarmOneTime() {
        if (Build.VERSION.SDK_INT >= 23) {
            manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()
                    + randomHour(), realTimeWakeUp);
        } else {
            manager.set(AlarmManager.ELAPSED_REALTIME, System.currentTimeMillis() + randomHour(), realTimeWakeUp);
        }
    }

    public void setAlarmNextDay(Context context) {
       Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, randomHour());

        if (Calendar.getInstance().after(calendar)) {
            calendar.add(Calendar.DATE, 1);
        }

        if (Build.VERSION.SDK_INT >= 23) {

            manager.setAndAllowWhileIdle(AlarmManager.RTC, calendar.getTimeInMillis(), rtcWAKEUp);
        } else {
            manager.set(AlarmManager.RTC, calendar.getTimeInMillis(), rtcWAKEUp);
        }
    }

    private int randomHour() {
        Random rand = new Random();
        hour = rand.nextInt((60 - 30) + 1) + 30;

        return hour * 60 * 1000;
    }

}
