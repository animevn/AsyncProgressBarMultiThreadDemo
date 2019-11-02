package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;

public class Async extends AsyncTask<Void, Integer, Integer> {

    private Model model;
    private int s;

    public Async(Model model){
        this.model = model;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        s = 3000;
        model.setMax(s);
        model.setEnable(false);
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        int count = 0;
        while (count <= s){
            try{
                Thread.sleep(200);
                publishProgress(count);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            count += 100;
        }
        return s;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        model.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        model.setEnable(true);
    }
}
