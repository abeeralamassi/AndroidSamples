package iterator.ir.a015;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listViewMovies;
    MovieAdapter movieAdapter;

    int[] posters={
            R.drawable.movie01,
            R.drawable.movie02,
            R.drawable.movie03,
            R.drawable.movie04,
            R.drawable.movie05,
            R.drawable.movie06,
            R.drawable.movie07,
            R.drawable.movie08,
            R.drawable.movie09,
            R.drawable.movie10
    };

    String[] titles;
    String[] years;
    String[] ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMovies= (ListView) findViewById(R.id.listViewMovies);

        titles=getResources().getStringArray(R.array.movie_titles);
        years=getResources().getStringArray(R.array.movie_years);
        ratings=getResources().getStringArray(R.array.movie_ratings);

        movieAdapter=new MovieAdapter(getApplicationContext(),R.layout.listview_custom_row);

        for (int i=0;i<10;i++)
        {
            MovieDataProvider movieDataProvider=new MovieDataProvider(posters[i],titles[i],
                    years[i],ratings[i]);

            movieAdapter.add(movieDataProvider);
        }

        listViewMovies.setAdapter(movieAdapter);
    }
}
