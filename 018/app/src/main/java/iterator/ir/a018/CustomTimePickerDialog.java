package iterator.ir.a018;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by mahmood on 2/4/17.
 */

public class CustomTimePickerDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar= Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time=String.format("%s:%s",hourOfDay,minute);
                Toast.makeText(getContext(),time,Toast.LENGTH_LONG).show();
            }
        },hour,minute,false);

        return timePickerDialog;
    }
}
