package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;
import android.util.Log;

public class Async1 extends AsyncTask<Integer, Integer, Void> {

    private static final String ETAG = "E.Async1";
    private ThreadViewModel model;

    public Async1(ThreadViewModel model) {
        this.model = model;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        model.setEnable1(false);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        int count = 0;
        while (count <= max){
            try{
                Thread.sleep(max/10);
                publishProgress(count);
            }catch (InterruptedException e){
                Log.e(ETAG, "thread interupted");
            }
            count += max/10;
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        model.setProgress1(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        model.setEnable1(true);
    }
}
