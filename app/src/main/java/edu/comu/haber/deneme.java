package edu.comu.haber;


import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import edu.comu.haber.webpages.MainPage;
import edu.comu.haber.webpages.model.News;


public class deneme extends AsyncTask<Void,Void,Void> {


    @Override
    protected Void doInBackground(Void... voids) {
        MainPage mainPage = new MainPage();
        try {
            mainPage.connectToPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<News> yeter = mainPage.getNews();

        return null;
    }
}
