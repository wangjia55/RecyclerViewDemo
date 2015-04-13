package com.jacob.recyclerview.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jacob.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob-wj on 2015/4/13.
 */
public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ListViewHolder> {

    private List<MessageBean> mListMessages = new ArrayList<>();

    private LayoutInflater mLayoutInflater;
    private int animatingPosition = -1;
    private int numberOfColumns = 1;

    public RecyclerListAdapter(Context context,List<MessageBean> mListMessages) {
        this.mListMessages = mListMessages;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.layout_list_item,viewGroup,false);
        ListViewHolder holder = new ListViewHolder(view);
        holder.imageView  = (ImageView) view.findViewById(R.id.image_view_list_item);
        holder.textView = (TextView) view.findViewById(R.id.text_view_list_item);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mListMessages.size();
    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int position) {
        MessageBean messageBean = mListMessages.get(position);
        listViewHolder.imageView.setImageResource(messageBean.getDrawable());
        listViewHolder.textView.setText(messageBean.getMessage());
//            listViewHolder.itemView.animate().cancel();
//            listViewHolder.itemView.setAlpha(0f);
//            swingInRight(listViewHolder.itemView,position);
//            animatingPosition = position;

    }

     class ListViewHolder extends RecyclerView.ViewHolder{

        public ListViewHolder(View itemView) {
            super(itemView);
        }

       ImageView imageView;
       TextView textView;

    }
    private void swingInRight(View animatableView,int position) {
        Animator fadeAnimator = ObjectAnimator.ofFloat(animatableView, "alpha",
                0.5f, 1);
        Animator translateAnimator = ObjectAnimator.ofFloat(animatableView, "translationX",
                100, 0);
        Animator[] combinedAnimator = new Animator[2];
        combinedAnimator[0] = fadeAnimator;
        combinedAnimator[1] = translateAnimator;

        AnimatorSet set = new AnimatorSet();
        set.playTogether(combinedAnimator);
        set.setStartDelay(calculateAnimationDelay(position));
        set.setDuration(100);
        set.start();
    }
    private int calculateAnimationDelay(final int position) {
        if(position == 0) return position;
        int delay;
        int mAnimationDelayMillis = 200;
        delay = mAnimationDelayMillis * (position % numberOfColumns +1);
        return delay;
    }
}
