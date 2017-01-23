package iterator.ir.a001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonShow;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShow= (Button) findViewById(R.id.buttonShow);
        editTextMessage= (EditText) findViewById(R.id.editTextMessage);
    }


    protected void buttonShow_onClick(View view){

        String message=editTextMessage.getText().toString();
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra("msg",message);
        startActivity(intent);
    }
}
