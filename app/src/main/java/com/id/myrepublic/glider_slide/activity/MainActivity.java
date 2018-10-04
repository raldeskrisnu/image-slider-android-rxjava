package com.id.myrepublic.glider_slide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.id.myrepublic.glider_slide.R;
import com.id.myrepublic.glider_slide.model.Image;
import com.id.myrepublic.glider_slide.presenter.GlidePresenter;
import com.id.myrepublic.glider_slide.presenter.GlideViewInterface;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GlideViewInterface {

    private String TAG = MainActivity.class.getSimpleName();

    private GlidePresenter mainPresenter;

    @BindView(R.id.imageSlider)
    SliderLayout sliderLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mvpInit();
        getMovieList();

        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
    }

    private void mvpInit() {
        mainPresenter = new GlidePresenter(this);
    }

    private void getMovieList() {
        mainPresenter.getData();
    }

    @Override
    public void showToast(String str){
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayData(List<Image> responseApi){

        if(responseApi!=null) {
            Integer count=responseApi.size();
            for(int i=0;i<count; i++){
                SliderView sliderView = new SliderView(this);
                sliderView.setImageUrl(responseApi.get(i).getUrl().getMedium());
                sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                sliderView.setDescription("setDescription " + (i + 1));
                final int finalI = i;
                sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(SliderView sliderView) {
                        Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                    }
                });

                sliderLayout.addSliderView(sliderView);
            }

        }else{
            Log.d(TAG,"Movies response null");
        }
    }

    @Override
    public void displayError(String str){
        Log.d(TAG,str);
    }

    @Override
    public void showProgress(){

    }

    @Override
    public void hideProgress(){

    }
}
