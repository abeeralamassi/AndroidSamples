package com.example.mahmood.a087;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class ObjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int Text = 0, Image = 1;
    List<Object> objectList;

    public ObjectAdapter(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == Text) {
            View view = inflater.inflate(R.layout.text_row, parent, false);
            viewHolder = new ViewHolderText(view);
        } else if (viewType == Image) {
            View view = inflater.inflate(R.layout.image_row, parent, false);
            viewHolder = new ViewHolderImage(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==Text)
        {
            ViewHolderText viewHolder= (ViewHolderText) holder;
            com.example.mahmood.a087.Text obj= (com.example.mahmood.a087.Text) objectList.get(position);

            viewHolder.textViewText.setText(obj.getText());
        }
        else if (holder.getItemViewType()==Image)
        {
            ViewHolderImage viewHolder= (ViewHolderImage) holder;
            com.example.mahmood.a087.Image obj= (com.example.mahmood.a087.Image) objectList.get(position);

            viewHolder.imageViewImage.setImageResource(obj.getImage());
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof Text) {
            return Text;
        } else if (objectList.get(position) instanceof Image) {
            return Image;
        }


        return -1;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }
}
