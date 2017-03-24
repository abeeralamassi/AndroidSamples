package iterator.ir.a032;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    Button buttonSend;
    EditText editTextName;

    private OnFragment1InteractionListener mListener;

    public FirstFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_first, container, false);

        buttonSend= (Button) view.findViewById(R.id.buttonSend);
        editTextName= (EditText) view.findViewById(R.id.editTextName);

        buttonSend.setOnClickListener(onClickListener);

        return view;
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=editTextName.getText().toString();
            onButtonPressed(name);
        }
    };

    public void onButtonPressed(String name) {
        if (mListener != null) {
            mListener.onFragment1ButtonClicked(name);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment1InteractionListener) {
            mListener = (OnFragment1InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragment1InteractionListener {
        void onFragment1ButtonClicked(String name);
    }
}
