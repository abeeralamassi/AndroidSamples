package iterator.ir.a055;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listViewItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    int count = 0;

    Button buttonAdd;
    Button buttonDelete;
    ListView listView;

    LayoutTransition itemLayoutTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listViewItems);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        listView = (ListView) findViewById(R.id.listView);

        Animator scaleUp = ObjectAnimator.ofPropertyValuesHolder((Object) null, PropertyValuesHolder.ofFloat(View.SCALE_X, 0, 1), PropertyValuesHolder.ofFloat(View.SCALE_Y, 0, 1));
        final Animator scaleDown = ObjectAnimator.ofPropertyValuesHolder((Object) null, PropertyValuesHolder.ofFloat(View.SCALE_X, 1, 0), PropertyValuesHolder.ofFloat(View.SCALE_Y, 1, 0));

        itemLayoutTransition = new LayoutTransition();

        itemLayoutTransition.enableTransitionType(LayoutTransition.CHANGING);

        //itemLayoutTransition.setAnimateParentHierarchy(false);

        //itemLayoutTransition.disableTransitionType(LayoutTransition.CHANGE_APPEARING);
        //itemLayoutTransition.disableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
        //itemLayoutTransition.disableTransitionType(LayoutTransition.APPEARING);
        //itemLayoutTransition.disableTransitionType(LayoutTransition.DISAPPEARING);


/*        itemLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, scaleUp);
        itemLayoutTransition.setDuration(LayoutTransition.CHANGE_APPEARING,1000);
        itemLayoutTransition.setInterpolator(LayoutTransition.CHANGE_APPEARING,new OvershootInterpolator());*/

        itemLayoutTransition.setAnimator(LayoutTransition.APPEARING, scaleUp);
        itemLayoutTransition.setDuration(LayoutTransition.APPEARING,1000);
        itemLayoutTransition.setInterpolator(LayoutTransition.APPEARING,new OvershootInterpolator());

/*        itemLayoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, scaleDown);
        itemLayoutTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING,1000);
        itemLayoutTransition.setInterpolator(LayoutTransition.CHANGE_DISAPPEARING,new OvershootInterpolator());*/

        itemLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, scaleDown);
        itemLayoutTransition.setDuration(LayoutTransition.DISAPPEARING,1000);
        itemLayoutTransition.setInterpolator(LayoutTransition.DISAPPEARING,new OvershootInterpolator());

        listView.setLayoutTransition(itemLayoutTransition);

        itemLayoutTransition.addTransitionListener(transitionListener);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                String item = String.format("Item %d", count);
                listViewItems.add(item);

                adapter.notifyDataSetChanged();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listViewItems.size() > 0) {
                    itemLayoutTransition.removeChild(listView, listView.getChildAt(0));
                }
            }
        });
    }

    LayoutTransition.TransitionListener transitionListener=new LayoutTransition.TransitionListener() {
        @Override
        public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
            listView.setHasTransientState(true);
        }

        @Override
        public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
            if (transitionType == LayoutTransition.DISAPPEARING) {
                if (listViewItems.size() > 0) {
                    listViewItems.remove(0);
                    adapter.notifyDataSetChanged();

                    listView.getChildAt(0).setScaleX(1f);
                    listView.getChildAt(0).setScaleY(1f);
                }
            }

            listView.setHasTransientState(false);
        }
    };
}
