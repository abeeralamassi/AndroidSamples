package com.example.mahmood.a085;


import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

    List<Country> countryList;

    public CountryAdapter(List<Country> countries)
    {
        this.countryList=countries;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.country_row, parent, false);

        CountryViewHolder viewHolder=new CountryViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country=countryList.get(position);

        holder.textViewCountryName.setText(country.getName());
        holder.textViewCountryCapital.setText(country.getCapital());
        holder.imageViewCountry.setImageResource(country.getImage());
    }

    @Override
    public int getItemCount() {
        return this.countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCountryName;
        public TextView textViewCountryCapital;
        public ImageView imageViewCountry;

        public CountryViewHolder(View itemView) {
            super(itemView);

            textViewCountryName= (TextView) itemView.findViewById(R.id.textViewCountryName);
            textViewCountryCapital= (TextView) itemView.findViewById(R.id.textViewCountryCapital);
            imageViewCountry= (ImageView) itemView.findViewById(R.id.imageViewCountry);
        }
    }
}
