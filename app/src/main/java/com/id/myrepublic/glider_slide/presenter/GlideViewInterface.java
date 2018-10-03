package com.id.myrepublic.glider_slide.presenter;

import com.id.myrepublic.glider_slide.model.Image;

import java.util.List;

public interface GlideViewInterface {

    void displayData(List<Image> resultApi);
    void showToast(String str);
    void displayError(String str);
    void showProgress();
    void hideProgress();
}
