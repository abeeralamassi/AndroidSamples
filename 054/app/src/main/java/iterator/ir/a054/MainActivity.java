package iterator.ir.a054;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.icu.util.ValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonFadeIn,buttonFadeOut,buttonBlink,buttonZoomIn,buttonZoomOut,buttonRotate,buttonMove,buttonSlideUp,
    buttonSlideDown,buttonBounce;
    TextView textViewFadeIn,textViewFadeOut,textViewBlink,textViewZoomIn,textViewZoomOut,textViewRotate,textViewMove,textViewSlideUp,
    textViewSlideDown,textViewBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonFadeIn= (Button) findViewById(R.id.buttonFadeIn);
        buttonFadeOut= (Button) findViewById(R.id.buttonFadeOut);
        buttonBlink= (Button) findViewById(R.id.buttonBlink);
        buttonZoomIn= (Button) findViewById(R.id.buttonZoomIn);
        buttonZoomOut= (Button) findViewById(R.id.buttonZoomOut);
        buttonRotate= (Button) findViewById(R.id.buttonRotate);
        buttonMove= (Button) findViewById(R.id.buttonMove);
        buttonSlideUp= (Button) findViewById(R.id.buttonSlideUp);
        buttonSlideDown= (Button) findViewById(R.id.buttonSlideDown);
        buttonBounce= (Button) findViewById(R.id.buttonBounce);

        textViewFadeIn= (TextView) findViewById(R.id.textViewFadeIn);
        textViewFadeOut= (TextView) findViewById(R.id.textViewFadeOut);
        textViewBlink= (TextView) findViewById(R.id.textViewBlink);
        textViewZoomIn= (TextView) findViewById(R.id.textViewZoomIn);
        textViewZoomOut= (TextView) findViewById(R.id.textViewZoomOut);
        textViewRotate= (TextView) findViewById(R.id.textViewRotate);
        textViewMove= (TextView) findViewById(R.id.textViewMove);
        textViewSlideUp= (TextView) findViewById(R.id.textViewSlideUp);
        textViewSlideDown= (TextView) findViewById(R.id.textViewSlideDown);
        textViewBounce= (TextView) findViewById(R.id.textViewBounce);


        buttonFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,
                        R.animator.fade_in);
                set.setTarget(textViewFadeIn);
                set.start();
            }
        });

        buttonFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,
                        R.animator.fade_out);
                set.setTarget(textViewFadeOut);
                set.start();
            }
        });

        buttonBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textViewBlink,View.ALPHA,0f,1f);
                objectAnimator.setDuration(600);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator.setInterpolator(new AccelerateInterpolator());
                objectAnimator.start();
            }
        });

        buttonZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder propertyValuesHolder1=PropertyValuesHolder.ofFloat(View.SCALE_X,1f,2f);
                PropertyValuesHolder propertyValuesHolder2=PropertyValuesHolder.ofFloat(View.SCALE_Y,1f,2f);

                ObjectAnimator objectAnimator=ObjectAnimator.ofPropertyValuesHolder(textViewZoomIn,
                        propertyValuesHolder1,propertyValuesHolder2);

                objectAnimator.setDuration(1000);
                objectAnimator.start();
            }
        });


        buttonZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValueAnimator valueAnimator1=ValueAnimator.ofFloat(1f,0.5f);
                valueAnimator1.setDuration(1000);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewZoomOut.setScaleX((Float) animation.getAnimatedValue());
                    }
                });


                ValueAnimator valueAnimator2=ValueAnimator.ofFloat(1f,0.5f);
                valueAnimator2.setDuration(1000);
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewZoomOut.setScaleY((Float) animation.getAnimatedValue());
                    }
                });


                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.playTogether(valueAnimator1,valueAnimator2);
                animatorSet.start();
            }
        });

        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // to perform rotate on center of the element
                // by default : pivotX=50 and pivotY=50
                textViewRotate.setPivotX(50);
                textViewRotate.setPivotY(50);

                ValueAnimator valueAnimator1=ValueAnimator.ofFloat(0,360);
                valueAnimator1.setDuration(600);
                valueAnimator1.setInterpolator(new CycleInterpolator(0.25f));
                valueAnimator1.setRepeatMode(ValueAnimator.RESTART);
                valueAnimator1.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewRotate.setRotation((Float) animation.getAnimatedValue());
                    }
                });

                valueAnimator1.start();
            }
        });

        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator1=ValueAnimator.ofFloat(0f,150f);
                valueAnimator1.setDuration(1000);
                valueAnimator1.setRepeatMode(ValueAnimator.REVERSE);
                valueAnimator1.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator1.setInterpolator(new AccelerateInterpolator());

                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewMove.setTranslationX((Float) animation.getAnimatedValue());
                    }
                });

                valueAnimator1.start();
            }
        });

        buttonSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewSlideUp.setPivotY(0);

                ValueAnimator valueAnimator1=ValueAnimator.ofFloat(1f,0f);
                valueAnimator1.setDuration(1000);
                valueAnimator1.setInterpolator(new AccelerateInterpolator());

                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewSlideUp.setScaleY((Float) animation.getAnimatedValue());
                    }
                });

                valueAnimator1.start();
            }
        });

        buttonSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewSlideDown.setPivotY(0);

                ValueAnimator valueAnimator1=ValueAnimator.ofFloat(0f,1f);
                valueAnimator1.setDuration(1000);
                valueAnimator1.setInterpolator(new AccelerateInterpolator());

                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewSlideDown.setScaleY((Float) animation.getAnimatedValue());
                    }
                });

                valueAnimator1.start();
            }
        });

        buttonBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValueAnimator valueAnimator1=ValueAnimator.ofFloat(0f,1f);
                valueAnimator1.setDuration(1000);
                valueAnimator1.setInterpolator(new BounceInterpolator());

                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textViewBounce.setScaleY((Float) animation.getAnimatedValue());
                    }
                });

                valueAnimator1.start();
            }
        });
    }
}
