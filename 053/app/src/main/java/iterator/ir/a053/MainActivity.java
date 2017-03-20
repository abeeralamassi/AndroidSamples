package iterator.ir.a053;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);

                switch (item.getItemId())
                {
                    case R.id.itemAdd:
                        Toast.makeText(MainActivity.this,"Add",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itemEdit:
                        Toast.makeText(MainActivity.this,"Edit",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itemDelete:
                        Toast.makeText(MainActivity.this,"Delete",Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}
