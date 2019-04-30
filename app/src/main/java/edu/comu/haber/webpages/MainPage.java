package edu.comu.haber.webpages;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.comu.haber.html.HtmlParser;
import edu.comu.haber.webpages.model.News;

public class MainPage extends HtmlParser {
    private final String URL = "https://www.comu.edu.tr/haberler.html";
    private final String table = "table > tbody > tr > td:has(a)";
    private final String LINK = "a";
    private final String TITLE = "title";
    private String lastNews = "last";
    private List<News> news = new ArrayList<>();


    public void connectToPage() throws IOException {
        fetchHtml(URL);

    }

    public List<News> getNews() {
        findTable(table);
        for (int i = 0; i < getTable().size() - 1; i++) {
            news.add(new News(findTitle(TITLE, i), findLink(LINK, i)));
        }
        Log.d("news", news.toString());
        return news;
    }

    public String getLastNews(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(lastNews, Context.MODE_PRIVATE);
        return sharedPref.getString(this.lastNews, "false");
    }

    public void setLastNews(Context context, String lastNews) {
        SharedPreferences sharedPref = context.getSharedPreferences(this.lastNews, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(this.lastNews, lastNews);
        editor.apply();
    }
}
