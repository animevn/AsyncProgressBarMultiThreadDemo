package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Model extends ViewModel {
    private MutableLiveData<Integer> progress = new MutableLiveData<>();
    private MutableLiveData<Integer> max = new MutableLiveData<>();
    private MutableLiveData<Boolean> enable = new MutableLiveData<>();

    public MutableLiveData<Integer> getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress.setValue(progress);
    }

    public MutableLiveData<Integer> getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max.setValue(max);
    }

    public MutableLiveData<Boolean> getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable.setValue(enable);
    }

    public void runTask(int max){
        Async async = new Async(this);
        async.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, max);
    }


}
