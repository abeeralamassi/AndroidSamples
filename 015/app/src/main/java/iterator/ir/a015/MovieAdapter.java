package iterator.ir.a015;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mahmood on 2/2/17.
 */

public class MovieAdapter extends ArrayAdapter<MovieDataProvider> {

    public MovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;

        if (view==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            view=layoutInflater.inflate(R.layout.listview_custom_row,parent,false);
        }

        MovieDataProvider currentMovie=this.getItem(position);

        if (currentMovie!=null)
        {
            ImageView imageViewRow= (ImageView) view.findViewById(R.id.imageViewRow);
            TextView textViewMovieTitle= (TextView) view.findViewById(R.id.textViewMovieTitle);
            TextView textViewMovieYear= (TextView) view.findViewById(R.id.textViewYear);
            TextView textViewMovieRating= (TextView) view.findViewById(R.id.textViewRating);

            String year= String.format("(%s)",currentMovie.Year);

            imageViewRow.setImageResource(currentMovie.Poster);
            textViewMovieTitle.setText(currentMovie.Title);
            textViewMovieYear.setText(year);
            textViewMovieRating.setText(currentMovie.Rating);
        }

        return view;
    }
}
