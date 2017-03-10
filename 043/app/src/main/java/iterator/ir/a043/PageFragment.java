package iterator.ir.a043;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_page, container, false);

        TextView textViewCounter= (TextView) view.findViewById(R.id.textViewCounter);

        Bundle bundle=getArguments();

        int counter=bundle.getInt("counter");
        String output=String.format("Page %d",counter);

        textViewCounter.setText(output);

        return view;
    }

}
