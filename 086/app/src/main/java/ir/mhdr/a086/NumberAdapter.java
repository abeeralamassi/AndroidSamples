package ir.mhdr.a086;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {


    private List<Integer> integerList;

    public NumberAdapter(List<Integer> integerList)
    {
        this.integerList=integerList;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.number_row, parent, false);

        NumberViewHolder viewHolder=new NumberViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Integer number=integerList.get(position);

        holder.textViewNumber.setText(String.valueOf(number));
    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewNumber;

        public NumberViewHolder(View itemView) {
            super(itemView);

            textViewNumber= (TextView) itemView.findViewById(R.id.textViewNumber);
        }
    }
}
