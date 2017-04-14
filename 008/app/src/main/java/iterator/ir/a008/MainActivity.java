package iterator.ir.a008;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> selectedFruits=new ArrayList<>();
    TextView textViewCount;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount= (TextView) findViewById(R.id.textViewCount);
        textViewResult= (TextView) findViewById(R.id.textViewResult);
    }

    protected void buttonCount_onClick(View view)
    {
        String result= String.valueOf(selectedFruits.size());
        textViewCount.setText(result);
    }

    protected void  CheckBox_onClick(View view)
    {
        Boolean checked=((CheckBox) view).isChecked();
        int selectedId=view.getId();

        switch (selectedId)
        {
            case R.id.checkBoxApple:
                if (checked)
                {
                    selectedFruits.add("Apple");
                }
                else {
                    selectedFruits.remove("Apple");
                }
                break;
            case R.id.checkBoxOrange:
                if (checked)
                {
                    selectedFruits.add("Orange");
                }
                else {
                    selectedFruits.remove("Orange");
                }
                break;
            case R.id.checkBoxBanana:
                if (checked)
                {
                    selectedFruits.add("Banana");
                }
                else {
                    selectedFruits.remove("Banana");
                }
                break;
        }


        String selected="";

        for (String f:selectedFruits)
        {
            selected +=f + "\r\n";
        }

        textViewResult.setText("");
        textViewResult.setText(selected);
    }
}
