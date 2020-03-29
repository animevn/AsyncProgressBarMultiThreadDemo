package com.haanhgs.app.asynctask;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThreadViewModel extends ViewModel {

    private final MutableLiveData<Integer> progress1 = new MutableLiveData<>();
    private final MutableLiveData<Integer> progress2 = new MutableLiveData<>();
    private final MutableLiveData<Integer> progress3 = new MutableLiveData<>();

    private final MutableLiveData<Boolean> enable1 = new MutableLiveData<>();
    private final MutableLiveData<Boolean> enable2 = new MutableLiveData<>();
    private final MutableLiveData<Boolean> enable3 = new MutableLiveData<>();

    public MutableLiveData<Integer> getProgress1() {
        return progress1;
    }

    public void setProgress1(Integer progress1) {
        this.progress1.setValue(progress1);
    }

    public MutableLiveData<Integer> getProgress2() {
        return progress2;
    }

    public void setProgress2(Integer progress2) {
        this.progress2.setValue(progress2);
    }

    public MutableLiveData<Integer> getProgress3() {
        return progress3;
    }

    public void setProgress3(Integer progress3) {
        this.progress3.setValue(progress3);
    }

    public MutableLiveData<Boolean> getEnable1() {
        return enable1;
    }

    public void setEnable1(Boolean enable1) {
        this.enable1.setValue(enable1);
    }

    public MutableLiveData<Boolean> getEnable2() {
        return enable2;
    }

    public void setEnable2(Boolean enable2) {
        this.enable2.setValue(enable2);
    }

    public MutableLiveData<Boolean> getEnable3() {
        return enable3;
    }

    public void setEnable3(Boolean enable3) {
        this.enable3.setValue(enable3);
    }

    public void runTask1(int max){
        new Async1(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, max);
    }

    public void runTask2(int max){
        new Async2(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, max);
    }

    public void runTask3(int max){
        new Async3(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, max);
    }

}
