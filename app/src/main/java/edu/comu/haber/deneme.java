package edu.comu.haber;


import android.os.AsyncTask;
import edu.comu.haber.html.HtmlParser;


public class deneme extends AsyncTask<Void,Void,Void> {


    @Override
    protected Void doInBackground(Void... voids) {

       HtmlParser parser = new HtmlParser();
        parser.deneme();
        parser.setNews();

        return null;
    }
}
