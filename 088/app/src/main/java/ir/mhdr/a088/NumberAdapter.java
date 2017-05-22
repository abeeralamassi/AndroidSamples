package ir.mhdr.a088;


import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    private List<Integer> integerList;
    Context context;

    public NumberAdapter(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.custom_row, parent, false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final NumberViewHolder holder, int position) {

        Integer num = integerList.get(position);

        holder.textViewNumber.setText(String.valueOf(num));

        final Button button = holder.buttonOptions;

        holder.buttonOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, button);

                popup.inflate(R.menu.custom_menu);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.itemDelete:

                                integerList.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                                return true;
                        }
                        return false;
                    }
                });

                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNumber;
        public Button buttonOptions;

        public NumberViewHolder(View itemView) {
            super(itemView);

            textViewNumber = (TextView) itemView.findViewById(R.id.textViewNumber);
            buttonOptions = (Button) itemView.findViewById(R.id.buttonOptions);
        }
    }
}
