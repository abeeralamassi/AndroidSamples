package com.example.mahmood.a087;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class ViewHolderImage extends RecyclerView.ViewHolder{

    public ImageView imageViewImage;

    public ViewHolderImage(View itemView) {
        super(itemView);

        imageViewImage= (ImageView) itemView.findViewById(R.id.imageViewImage);
    }
}
