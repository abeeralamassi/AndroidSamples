package iterator.ir.a044;


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

        View view=inflater.inflate(R.layout.fragment_page, container, false);

        TextView textViewPage= (TextView) view.findViewById(R.id.textViewPage);
        Bundle bundle=getArguments();
        int pageNumber= bundle.getInt("pageNumber");

        String output=String.format("Page %d",pageNumber);
        textViewPage.setText(output);

        return view;
    }

}
