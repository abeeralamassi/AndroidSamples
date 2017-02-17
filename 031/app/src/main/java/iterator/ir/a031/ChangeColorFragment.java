package iterator.ir.a031;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class ChangeColorFragment extends Fragment {

    private OnChangeColorFragmentInteractionListener mListener;
    RadioGroup radioGroupColors;

    public ChangeColorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_change_color, container, false);

        radioGroupColors= (RadioGroup) view.findViewById(R.id.radioGroupColors);

        radioGroupColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onColorChanged(checkedId);
            }
        });

        return view;
    }

    public void onColorChanged(int id) {
        if (mListener != null) {
            mListener.onChangeColorFragmentInteraction(id);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnChangeColorFragmentInteractionListener) {
            mListener = (OnChangeColorFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChangeColorFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnChangeColorFragmentInteractionListener {
        void onChangeColorFragmentInteraction(int id);
    }
}
