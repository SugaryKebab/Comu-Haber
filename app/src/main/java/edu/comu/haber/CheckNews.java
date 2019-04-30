package edu.comu.haber;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import androidx.work.Worker;
import androidx.work.WorkerParameters;
import edu.comu.haber.webpages.MainPage;
import edu.comu.haber.webpages.model.News;

public class CheckNews  extends Worker {
    private NotificationUtils mNotificationUtils;
    int badge = 0;
    MainPage mainPage = new MainPage();


    public CheckNews(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("Edu.comu.haber","I'm working");
        if(getIsItFirst()) {
            setIsItFirst();

            try {
                mainPage.connectToPage();
            } catch (IOException e) {
                e.printStackTrace();
                return Result.retry();
            }
            List<News> news = mainPage.getNews();


            for (int i = 0; i < news.size(); i++) {
                if (mainPage.getLastNews(getApplicationContext()).equals(news.get(i).getTitle())) {

                    break;
                } else {
                    badge++;
                }
            }


            if (badge > 1) {
                Notification.Builder nb;
                mNotificationUtils = new NotificationUtils(getApplicationContext());


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    nb = mNotificationUtils.getAndroidChannelNotificationForOreo(getApplicationContext(), "Çomü'den yeni haber var", badge + "' tane yeni haber");
                    mNotificationUtils.getManager().notify(101, nb.build());
                } else {
                    nb = mNotificationUtils.getAndroidChannelNotificationFor(getApplicationContext(), "Çomü'den yeni haber var", badge + "' tane yeni haber");
                    mNotificationUtils.getManager().notify(101, nb.build());
                }
            }

            return Result.success();
        }else{
            setIsItFirst();
            return Result.success();
        }


    }


    public Boolean getIsItFirst() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("first", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("first", false);
    }

    public void setIsItFirst() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("first", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("first", true);
        editor.apply();
    }
}
