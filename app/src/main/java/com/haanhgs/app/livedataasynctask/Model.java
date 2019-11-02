package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Model extends ViewModel {
    private MutableLiveData<Integer> progress1 = new MutableLiveData<>();
    private MutableLiveData<Integer> max1 = new MutableLiveData<>();
    private MutableLiveData<Boolean> enable1 = new MutableLiveData<>();

    public MutableLiveData<Integer> getProgress1() {
        return progress1;
    }

    public void setProgress1(Integer progress1) {
        this.progress1.setValue(progress1);
    }

    public MutableLiveData<Integer> getMax1() {
        return max1;
    }

    public void setMax1(Integer max) {
        this.max1.setValue(max);
    }

    public MutableLiveData<Boolean> getEnable1() {
        return enable1;
    }

    public void setEnable1(boolean enable1) {
        this.enable1.setValue(enable1);
    }

    public void runTask(int max){
        Async async = new Async(this);
        async.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, max);
    }
}
