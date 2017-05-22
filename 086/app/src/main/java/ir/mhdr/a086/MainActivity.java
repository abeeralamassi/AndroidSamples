package ir.mhdr.a086;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd;
    Button buttonRemove;
    RecyclerView recyclerView;
    List<Integer> integerList = new ArrayList<>();
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonRemove = (Button) findViewById(R.id.buttonRemove);

        buttonAdd.setOnClickListener(buttonAdd_OnClickListener);
        buttonRemove.setOnClickListener(buttonRemove_OnClickListener);

        for (int i = 0; i < 1000; i++) {
            integerList.add(random.nextInt());
            i++;
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new OvershootInRightAnimator());
        recyclerView.getItemAnimator().setAddDuration(1000);
        recyclerView.getItemAnimator().setRemoveDuration(1000);

        adapter = new NumberAdapter(integerList);

        SlideInLeftAnimationAdapter slideAdapter = new SlideInLeftAnimationAdapter(adapter);
        slideAdapter.setDuration(1000);
        recyclerView.setAdapter(slideAdapter);
    }

    View.OnClickListener buttonAdd_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer num = random.nextInt();
            integerList.add(0, num);

            //adapter.notifyDataSetChanged();
            adapter.notifyItemInserted(0);
            recyclerView.scrollToPosition(0);
        }
    };

    View.OnClickListener buttonRemove_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            integerList.remove(0);
            adapter.notifyItemRemoved(0);
        }
    };
}
