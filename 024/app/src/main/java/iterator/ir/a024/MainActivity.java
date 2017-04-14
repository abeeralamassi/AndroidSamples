package iterator.ir.a024;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView) findViewById(R.id.imageView);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (actionMode==null)
                {
                    actionMode=startActionMode(new android.view.ActionMode.Callback() {
                        @Override
                        public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {

                            getMenuInflater().inflate(R.menu.custom_menu,menu);

                            return true;
                        }

                        @Override
                        public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                            mode.setTitle("Item Selected");
                            return true;
                        }

                        @Override
                        public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {

                            if (item.getItemId()==R.id.itemShare)
                            {
                                Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_LONG).show();
                                return true;
                            }
                            else if (item.getItemId()==R.id.itemDelete)
                            {
                                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();
                                return true;
                            }

                            return false;
                        }

                        @Override
                        public void onDestroyActionMode(android.view.ActionMode mode) {
                            actionMode=null;
                        }
                    });

                    return true;
                }

                return false;
            }
        });
    }
}
