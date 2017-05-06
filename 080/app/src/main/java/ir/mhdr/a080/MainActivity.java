package ir.mhdr.a080;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sccomponents.widgets.ScArcGauge;
import com.sccomponents.widgets.ScCopier;
import com.sccomponents.widgets.ScFeature;
import com.sccomponents.widgets.ScGauge;
import com.sccomponents.widgets.ScNotches;
import com.sccomponents.widgets.ScPointer;
import com.sccomponents.widgets.ScWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the components
        final ScArcGauge gauge = (ScArcGauge) this.findViewById(R.id.gauge);
        assert gauge != null;

        final TextView counter = (TextView) this.findViewById(R.id.counter);
        assert counter != null;

        // Create a drawable
        final Bitmap indicator = BitmapFactory.decodeResource(this.getResources(), R.drawable.indicator);

        // If you set the value from the xml that not produce an event so I will change the
        // value from code.
        gauge.setHighValue(60);


        int[] strokeColors = {Color.parseColor("#EC4949"), Color.parseColor("#EC4949"),
                Color.parseColor("#F7AD36"), Color.parseColor("#F7AD36"),
                Color.parseColor("#F7AD36"), Color.parseColor("#F7AD36"),
                Color.parseColor("#8BBE28"),Color.parseColor("#8BBE28")};

        // Get the base feature
        gauge.setStrokeColors(strokeColors);
        gauge.setStrokeColorsMode(ScFeature.ColorsMode.SOLID);


        // Each time I will change the value I must write it inside the counter text.
        gauge.setOnEventListener(new ScGauge.OnEventListener() {
            @Override
            public void onValueChange(float lowValue, float highValue) {
                // Write the value

                ScFeature base = gauge.findFeature(ScGauge.BASE_IDENTIFIER);
                counter.setTextColor(base.getGradientColor(highValue, 100));
                counter.setText(String.valueOf(highValue));
            }
        });

        gauge.setOnDrawListener(new ScGauge.OnDrawListener() {
            @Override
            public void onBeforeDrawCopy(ScCopier.CopyInfo info) {
                // Do nothing
            }

            @Override
            public void onBeforeDrawNotch(ScNotches.NotchInfo info) {
                // Do nothing
            }

            @Override
            public void onBeforeDrawPointer(ScPointer.PointerInfo info) {
                // Check if the pointer if the high pointer
                if (info.source.getTag() == ScGauge.HIGH_POINTER_IDENTIFIER) {
                    // Adjust the offset
                    info.offset.x = -indicator.getWidth() / 2;
                    info.offset.y = -indicator.getHeight() / 2;
                    // Assign the bitmap to the pointer info structure
                    info.bitmap = indicator;
                }
            }

            @Override
            public void onBeforeDrawToken(ScWriter.TokenInfo info) {
                // Do nothing
            }
        });
    }
}
