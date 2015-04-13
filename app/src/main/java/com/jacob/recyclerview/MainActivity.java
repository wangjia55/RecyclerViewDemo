package com.jacob.recyclerview;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jacob.recyclerview.gallery.GalleryAdapter;
import com.jacob.recyclerview.gallery.GalleryRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    private ImageView mImageView;
    private GalleryRecyclerView mRecyclerView ;
    private GalleryAdapter mGalleryAdapter;
    private List<Integer> mListData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (GalleryRecyclerView) findViewById(R.id.recyclerView);
        initData();
        mGalleryAdapter = new GalleryAdapter(this,mListData);
        mGalleryAdapter.setOnClickListener(new GalleryAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                System.out.println("position:"+position);
                mImageView.setImageResource(mListData.get(position));
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mGalleryAdapter);
        mRecyclerView.setOnItemScrollChangeListener(new GalleryRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onItemChanged(View view, int position) {
//                mImageView.setImageResource(mListData.get(position));
            }
        });


        mImageView = (ImageView) findViewById(R.id.image_view_scale);
        mImageView.setImageResource(R.drawable.pic1);
    }


    private void initData(){
        mListData.add(R.drawable.pic1);
        mListData.add(R.drawable.pic2);
        mListData.add(R.drawable.pic3);
        mListData.add(R.drawable.pic4);
        mListData.add(R.drawable.pic5);
        mListData.add(R.drawable.pic6);
        mListData.add(R.drawable.pic7);
    }

}
