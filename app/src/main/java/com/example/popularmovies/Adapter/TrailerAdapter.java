package com.example.popularmovies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.popularmovies.POJO.Trailer;
import com.example.popularmovies.R;

import java.util.List;

/**
 * Created by Ian on 5/4/2016.
 */
public class TrailerAdapter extends BaseAdapter {

    private final Trailer mTrailer = new Trailer();
    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<Trailer> mObjects;

    public TrailerAdapter(Context context, List<Trailer> objects) {
        mContext = context;
        mObjects = objects;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Context getContext() {
        return mContext;
    }

    public void add(Trailer object) {
        synchronized (mTrailer) {
            mObjects.add(object);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        synchronized (mTrailer) {
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Trailer getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = mInflater.inflate(R.layout.item_trailer, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Trailer trailer = getItem(position);
        viewHolder = (ViewHolder) view.getTag();
        String ytThumbnailUrl = "http://img.youtube.com/vi/" + trailer.getKey() + "/0.jpg";
        Glide.with(getContext()).load(ytThumbnailUrl).into(viewHolder.imageView);

        viewHolder.nameView.setText(trailer.getName());

        return view;
    }

    public static class ViewHolder {
        public final ImageView imageView;
        public final TextView nameView;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.trailer_image);
            nameView = (TextView) view.findViewById(R.id.trailer_name);
        }
    }

}