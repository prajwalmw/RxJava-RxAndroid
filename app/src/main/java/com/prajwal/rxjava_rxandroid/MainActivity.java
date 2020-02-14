package com.prajwal.rxjava_rxandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Observable<String> stringObservable;
    DisposableObserver<String> disposableObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        stringObservable = Observable.just("Bitch, I m learning Rx!!!");


/*
        stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                textView.setText(s); //emitted data is set to textview.
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
*/

       disposableObserver = new DisposableObserver<String>() {
           @Override
           public void onNext(String s) {
               textView.setText("Bitch! I'm learning Rx....");
           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       };

        stringObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposableObserver.dispose();
    }
}
