package iterator.ir.a016;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CustomDialogFragment extends DialogFragment {

    private OnCustomDialogButtonClickListener mListener;

    Button buttonNo;
    Button buttonYes;

    public CustomDialogFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_custom_dialog, null);


        buttonNo= (Button) view.findViewById(R.id.buttonNo);
        buttonYes= (Button) view.findViewById(R.id.buttonYes);

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mListener != null) {
                    mListener.onCustomDialogClick(v);
                }

                dismiss();
            }
        });

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mListener != null) {
                    mListener.onCustomDialogClick(v);
                }

                dismiss();
            }
        });

        setCancelable(false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCustomDialogButtonClickListener) {
            mListener = (OnCustomDialogButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCustomDialogButtonClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnCustomDialogButtonClickListener {
        void onCustomDialogClick(View view);
    }
}
