package iterator.ir.a021;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        RelativeLayout relativeLayout= (RelativeLayout) findViewById(R.id.activity_main);

        switch (item.getItemId())
        {
            case R.id.itemBlue:

                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                break;
            case R.id.itemGreen:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                break;
            case R.id.itemPurple:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                break;
            case R.id.itemRed:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
