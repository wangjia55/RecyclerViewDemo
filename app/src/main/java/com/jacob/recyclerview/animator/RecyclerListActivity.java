package com.jacob.recyclerview.animator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.jacob.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;

/**
 * Created by jacob-wj on 2015/4/13.
 */
public class RecyclerListActivity extends FragmentActivity {
    private RecyclerView mRecyclerView;
    private RecyclerListAdapter mListAdapter ;
    private List<MessageBean> mListMessages;
    SlideInRightAnimationAdapter mAnimatorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mListAdapter = new RecyclerListAdapter(this,mListMessages);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        mAnimatorAdapter = new SlideInRightAnimationAdapter(mListAdapter);
        mAnimatorAdapter.setDuration(300);
        mAnimatorAdapter.setInterpolator(new AccelerateInterpolator());
        mAnimatorAdapter.setFirstOnly(false);
        mRecyclerView.setAdapter(mAnimatorAdapter);
    }

    public void change(View view){
        mAnimatorAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mListMessages = new ArrayList<>();
        MessageBean messageBean1 = new MessageBean(R.drawable.pic1,"用户资料");
        MessageBean messageBean2 = new MessageBean(R.drawable.pic2,"家庭成员");
        MessageBean messageBean3 = new MessageBean(R.drawable.pic3,"地理位置");
        MessageBean messageBean4 = new MessageBean(R.drawable.pic4,"周边活动");

        mListMessages.add(messageBean1);
        mListMessages.add(messageBean2);
        mListMessages.add(messageBean3);
        mListMessages.add(messageBean4);
    }
}
