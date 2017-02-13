package iterator.ir.a026;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.buttonLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(getBaseContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_login,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId()==R.id.itemLoginAdmin)
                        {
                            Toast.makeText(getBaseContext(),"Admin",Toast.LENGTH_LONG).show();
                            return true;
                        }
                        else if (item.getItemId()==R.id.itemLoginUser)
                        {
                            Toast.makeText(getBaseContext(),"User",Toast.LENGTH_LONG).show();
                            return true;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }
}
