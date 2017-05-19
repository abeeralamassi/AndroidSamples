package ir.mhdr.a082;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mahmood on 5/19/17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countryList;

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
    }

    @Override
    public int getItemCount() {
        return this.countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCountryName;
        public TextView textViewCountryCapital;

        public CountryViewHolder(View itemView) {
            super(itemView);

            textViewCountryName= (TextView) itemView.findViewById(R.id.textViewCountryName);
            textViewCountryCapital= (TextView) itemView.findViewById(R.id.textViewCountryCapital);
        }
    }
}
