package edu.comu.haber;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        listView= (ListView)findViewById(R.id.listview);
        bar = (ProgressBar)findViewById(R.id.bar);

        if (appStatus.isOnline(getApplicationContext())) { //when internet connection is aviable
       /*  MainPage mainPage = new MainPage();

            mainPage.setLastNews(getApplicationContext(),"ÇOMÜ – Ziraat Sigorta Arasında BES Protokolü 1 Yıl Daha Uzatıldı");
            Log.d("gel",mainPage.getLastNews(getApplicationContext()));
*/
     new  GetNews().execute();

        } else {

        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsList.get(position).getUrl()));
                startActivity(browserIntent);
            }
        });

        Notification.Builder nb;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationUtils = new NotificationUtils(this);


            nb = mNotificationUtils.getAndroidChannelNotificationForOreo("yarak", "By " + "çük");
            mNotificationUtils.getManager().notify(101, nb.build());
        }else{

            nb = mNotificationUtils.getAndroidChannelNotificationFor("yarak", "By " + "çük");
            mNotificationUtils.getManager().notify(101, nb.build());
        }





    }
    class GetNews extends AsyncTask<Void,Void, List<News>> {
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

           for(int i = 0; i< news.size(); i++) {
             title.add(news.get(i).getTitle());
           }

           for(int  i = 0; i< title.size(); i++){
               if (title.indexOf(mainPage.getLastNews(getApplicationContext())) == i || mainPage.getLastNews(getApplicationContext()).equals("false")){
                   mainPage.setLastNews(getApplicationContext(),newestNews);
                   break;
               }else{
                   title.set(i,"-YENİ HABER- "+title.get(i));
               }
           }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,title);
            listView.setAdapter(adapter);

            bar.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);

            newsList = news;

        }

    }
}
