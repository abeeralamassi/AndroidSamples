package iterator.ir.a025;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewCountries;
    ArrayList<String> countries=new ArrayList<>();
    ArrayList<String> selections=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] temp1=getResources().getStringArray(R.array.countries);

        for (String c:temp1)
        {
            countries.add(c);
        }

        listViewCountries= (ListView) findViewById(R.id.listViewCountries);
        final ArrayAdapter arrayAdapter=new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,countries);
        listViewCountries.setAdapter(arrayAdapter);

        listViewCountries.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        listViewCountries.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if (checked)
                {
                    selections.add(countries.get(position));
                }
                else {
                    selections.remove(countries.get(position));
                }

                mode.setTitle(selections.size() + " Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.custom_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                if (item.getItemId()==R.id.itemDelete)
                {

                    for (String i:selections)
                    {
                        countries.remove(i);
                    }

                    arrayAdapter.notifyDataSetChanged();
                    mode.finish();

                    return true;
                }

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                selections.clear();
            }
        });


    }
}
