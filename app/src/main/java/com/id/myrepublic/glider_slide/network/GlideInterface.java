package com.id.myrepublic.glider_slide.network;

import com.id.myrepublic.glider_slide.model.Image;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GlideInterface {

    @GET("/json/glide.json")
    Observable<List<Image>> getAllData();
}
