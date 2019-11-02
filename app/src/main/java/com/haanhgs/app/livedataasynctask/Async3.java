package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;

public class Async3 extends AsyncTask<Integer, Integer, Integer> {

    private Model model;

    public Async3(Model model){
        this.model = model;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        model.setEnable3(false);
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        int count = 0;
        while (count <= integers[0]){
            try{
                Thread.sleep(integers[0]/10);
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
        model.setProgress3(values[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        model.setEnable3(true);
    }
}

