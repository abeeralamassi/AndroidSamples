package iterator.ir.a019;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by mahmood on 2/5/17.
 */

public class CustomDatePicker extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar=Calendar.getInstance();

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String output=String.format("%s:%s:%s",year,month,dayOfMonth);
                Toast.makeText(getContext(),output,Toast.LENGTH_LONG).show();
            }
        },year,month,day);



        return datePickerDialog;
    }
}
