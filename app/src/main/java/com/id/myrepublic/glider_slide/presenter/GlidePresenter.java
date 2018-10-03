package com.id.myrepublic.glider_slide.presenter;

import com.id.myrepublic.glider_slide.model.Image;
import com.id.myrepublic.glider_slide.network.GlideInterface;
import com.id.myrepublic.glider_slide.network.GlideNetwork;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class GlidePresenter implements GlidePresenterInterface {

    private GlideViewInterface glideViewInterface;
    private GlideInterface api;

    public GlidePresenter(GlideViewInterface glideViewInterface){
        this.glideViewInterface = glideViewInterface;
    }

    @Override
    public void getData(){
        getObservable().subscribeWith(getObserver());
    }

    public Observable<List<Image>> getObservable(){

        api = GlideNetwork.getRetrofit().create(GlideInterface.class);
        return api.getAllData().subscribeOn(Schedulers.io())       //setting up worker thread
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<List<Image>> getObserver(){
        return new DisposableObserver<List<Image>>() {
            @Override
            public void onNext(List<Image> resultApis) {
                glideViewInterface.displayData(resultApis);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                glideViewInterface.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                glideViewInterface.hideProgress();
            }
        };

    }
}
