package iterator.ir.a017;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

public class CustomTimePickerDialogFragment extends DialogFragment {

    private OnCustomTimePickerClickListener mListener;
    Button buttonDone;
    TimePicker timePickerMain;

    public CustomTimePickerDialogFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_custom_time_picker_dialog, null);

        buttonDone= (Button) view.findViewById(R.id.buttonDone);
        timePickerMain= (TimePicker) view.findViewById(R.id.timePickerMain);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onCustomTimePickerClick(timePickerMain);
                }

                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCustomTimePickerClickListener) {
            mListener = (OnCustomTimePickerClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCustomTimePickerClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnCustomTimePickerClickListener {
        void onCustomTimePickerClick(View view);
    }
}
