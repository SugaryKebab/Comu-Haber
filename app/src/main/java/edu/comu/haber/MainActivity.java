package edu.comu.haber;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import edu.comu.haber.webpages.MainPage;
import edu.comu.haber.webpages.model.News;

public class MainActivity extends AppCompatActivity {

    AppStatus appStatus = new AppStatus();
    List<News> newsList = new ArrayList<>();
    ListView listView;
    ProgressBar bar;
    private NotificationUtils mNotificationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        bar = (ProgressBar) findViewById(R.id.bar);

        if (appStatus.isOnline(getApplicationContext())) {
            new GetNews().execute();
        } else {
            Toast.makeText(MainActivity.this,"İnternet Bağlantısı Yok! Uygulamayı Yeniden Başlatın",Toast.LENGTH_LONG).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsList.get(position).getUrl()));
                startActivity(browserIntent);
            }
        });
    }


    class GetNews extends AsyncTask<Void, Void, List<News>> {
        MainPage mainPage = new MainPage();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<News> doInBackground(Void... voids) {
            try {
                mainPage.connectToPage();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return mainPage.getNews();
        }

        @Override
        protected void onPostExecute(List<News> news) {
            super.onPostExecute(news);
            List<String> title = new ArrayList<String>();
            String newestNews = news.get(0).getTitle();

            for (int i = 0; i < news.size(); i++) {
                title.add(news.get(i).getTitle());
            }

            for (int i = 0; i < title.size(); i++) {
                if (title.indexOf(mainPage.getLastNews(getApplicationContext())) == i || mainPage.getLastNews(getApplicationContext()).equals("false")) {
                    mainPage.setLastNews(getApplicationContext(), newestNews);
                    break;
                } else {
                    title.set(i, "-YENİ HABER- " + title.get(i));
                }
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, title);
            listView.setAdapter(adapter);

            bar.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);

            newsList = news;

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();

            PeriodicWorkRequest builder = new PeriodicWorkRequest.Builder(CheckNews.class,2, TimeUnit.HOURS).setConstraints(constraints).build();
            WorkManager.getInstance().enqueueUniquePeriodicWork("check",  ExistingPeriodicWorkPolicy.KEEP,builder);

        }
    }
}
