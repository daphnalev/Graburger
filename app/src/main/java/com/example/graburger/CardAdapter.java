package com.example.graburger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CardAdapter extends PagerAdapter {
    private int LOOPS_COUNT;
    private List<FoodItemModel> models;
    private Context context;

    public CardAdapter(List<FoodItemModel> models, Context context, boolean infinite) {
        this.models = models;
        this.context = context;
        this.LOOPS_COUNT = infinite? 1000 : 1;
    }

    @Override
    public int getCount() {
        return models.size() * LOOPS_COUNT;
    }

    // This is called when notifyDataSetChanged() is called
    @Override
    public int getItemPosition(Object object) {
        // refresh all fragments when data set changed
        int index = models.indexOf(object);
        if (index == -1) {
            return POSITION_NONE;
        }
        return index;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        int new_position = position % models.size();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_item, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.image);
        imageView.setImageResource(models.get(new_position).getImage());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
