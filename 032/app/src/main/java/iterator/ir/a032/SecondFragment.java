package iterator.ir.a032;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    TextView textViewMessage;

    public SecondFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view= inflater.inflate(R.layout.fragment_second, container, false);

        textViewMessage= (TextView) view.findViewById(R.id.textViewMessage);

        return view;
    }

    public void setTextViewMessage(String name)
    {
        textViewMessage.setText("Hello " + name);
    }
}
