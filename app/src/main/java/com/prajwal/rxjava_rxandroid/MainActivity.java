package com.prajwal.rxjava_rxandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Observable<String> stringObservable;
    Observer<String> stringObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        stringObservable = Observable.just("Bitch, I m learning Rx!!!");

        stringObservable.subscribeOn(Schedulers.io());
        stringObservable.observeOn(AndroidSchedulers.mainThread());

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

        stringObservable.subscribe(stringObserver);
    }
}
