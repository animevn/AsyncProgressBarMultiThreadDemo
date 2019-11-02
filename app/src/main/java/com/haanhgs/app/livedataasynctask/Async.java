package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;

public class Async extends AsyncTask<Integer, Integer, Integer> {

    private Model model;

    public Async(Model model){
        this.model = model;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        model.setEnable(false);
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        int count = 0;
        while (count <= integers[0]){
            try{
                Thread.sleep(200);
                publishProgress(count);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            count += integers[0]/10;
        }
        return count;
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
