package com.id.myrepublic.glider_slide.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.id.myrepublic.glider_slide.R;
import com.id.myrepublic.glider_slide.adapter.GalleryAdapter;
import com.id.myrepublic.glider_slide.model.Image;
import com.id.myrepublic.glider_slide.presenter.GlidePresenter;
import com.id.myrepublic.glider_slide.presenter.GlideViewInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GlideViewInterface {

    private String TAG = MainActivity.class.getSimpleName();
//    private static final String endpoint = "http://api.androidhive.info/json/glide.json";


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private GlidePresenter mainPresenter;
    private GalleryAdapter adapter;
//    private ArrayList<Image> images;
//    private ProgressDialog pDialog;
//    private GalleryAdapter mAdapter;
//    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mvpInit();
        setupViews();
        getMovieList();
    }

    private void mvpInit() {
        mainPresenter = new GlidePresenter(this);
    }

    private void setupViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
            Log.d("BANGSAAAATTT",responseApi.get(0).getTimestamp());
            adapter = new GalleryAdapter(MainActivity.this,responseApi){};
            recyclerView.setAdapter(adapter);
//            RxView.clicks(recyleview).subscribe(o ->
//                    Toast.makeText(MainActivity.this,o.toString(),Toast.LENGTH_LONG).show()
//            );
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
//        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress(){
//        progressBar.setVisibility(View.GONE);
    }
}
