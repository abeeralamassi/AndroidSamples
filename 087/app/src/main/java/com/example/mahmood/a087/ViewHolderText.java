package com.example.mahmood.a087;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderText extends RecyclerView.ViewHolder {

    public TextView textViewText;

    public ViewHolderText(View itemView) {
        super(itemView);

        textViewText= (TextView) itemView.findViewById(R.id.textViewText);
    }
}
