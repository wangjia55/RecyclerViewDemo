package com.jacob.recyclerview.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by jacob-wj on 2015/4/13.
 */
public class GalleryRecyclerView extends RecyclerView implements RecyclerView.OnScrollListener{
    private OnItemScrollChangeListener mChangeListener;
    private View mCurrentView;

    public GalleryRecyclerView(Context context) {
        this(context, null);
    }

    public GalleryRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GalleryRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(int i) {
    }

    @Override
    public void onScrolled(int i, int i2) {
        View newView = getChildAt(0);
        if (mChangeListener != null){
            if (newView != null && mCurrentView != newView){
                mCurrentView = newView;
                mChangeListener.onItemChanged(mCurrentView,getChildPosition(mCurrentView));
            }
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mChangeListener != null){
            mChangeListener.onItemChanged(mCurrentView,getChildPosition(mCurrentView));
        }
    }

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener listener){
        this.mChangeListener = listener;
    }

    public interface OnItemScrollChangeListener{
        void onItemChanged(View view ,int position);
    }
}
