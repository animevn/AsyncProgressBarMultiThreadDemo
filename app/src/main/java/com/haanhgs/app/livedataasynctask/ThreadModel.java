package com.haanhgs.app.livedataasynctask;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThreadModel extends ViewModel {

    private MutableLiveData<Integer> progress1 = new MutableLiveData<>();
    private MutableLiveData<Integer> progress2 = new MutableLiveData<>();
    private MutableLiveData<Integer> progress3 = new MutableLiveData<>();

    private MutableLiveData<Integer> max1 = new MutableLiveData<>();
    private MutableLiveData<Integer> max2 = new MutableLiveData<>();
    private MutableLiveData<Integer> max3 = new MutableLiveData<>();

    private MutableLiveData<Boolean> enable1 = new MutableLiveData<>();
    private MutableLiveData<Boolean> enable2 = new MutableLiveData<>();
    private MutableLiveData<Boolean> enable3 = new MutableLiveData<>();

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

    public MutableLiveData<Integer> getMax1() {
        return max1;
    }

    public void setMax1(Integer max1) {
        this.max1.setValue(max1);
    }

    public MutableLiveData<Integer> getMax2() {
        return max2;
    }

    public void setMax2(Integer max2) {
        this.max2.setValue(max2);
    }

    public MutableLiveData<Integer> getMax3() {
        return max3;
    }

    public void setMax3(Integer max3) {
        this.max3.setValue(max3);
    }

    public MutableLiveData<Boolean> getEnable1() {
        return enable1;
    }

    public void setEnable1(boolean enable1) {
        this.enable1.setValue(enable1);
    }

    public MutableLiveData<Boolean> getEnable2() {
        return enable2;
    }

    public void setEnable2(boolean enable2) {
        this.enable2.setValue(enable2);
    }

    public MutableLiveData<Boolean> getEnable3() {
        return enable3;
    }

    public void setEnable3(boolean enable3) {
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
