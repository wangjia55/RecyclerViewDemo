package com.jacob.recyclerview.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jacob.recyclerview.R;

import java.util.List;

/**
 * Created by jacob-wj on 2015/4/13.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private List<Integer> mListData;

    private LayoutInflater mLayoutInflater;

    private OnClickListener mClickListener;


    public GalleryAdapter(Context context, List<Integer> mListData) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mListData = mListData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.layout_gallery_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.imageView = (ImageView) view.findViewById(R.id.imageview_gallery_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(mListData.get(i));
        final  int position = i;
        if (mClickListener != null){
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onClick(position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mListData.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView imageView;
    }


    public interface OnClickListener{
        void onClick(int position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.mClickListener = listener;
    }
}
