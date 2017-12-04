package org.farfallettalaviano.simplecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        final String LOG_TAG = "MainScreen";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText value1 = findViewById(this, R.id.value1);
        final EditText value2 = findViewById(this, R.id.value2);
        final TextView result = findViewById(this, R.id.result);

        Button addButton = findViewById(this, R.id.addValues);
        Button multiplyButton = findViewById(this, R.id.multiplyValues);

        View.OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case (R.id.addValues):
                        // call addValues(int, int)
                        break;

                    case (R.id.multiplyValues):
                        // call multiplyValues(int, int)
                        break;

                    default:
                        break;
                }
            }
        };

        addButton.setOnClickListener(listener);
        multiplyButton.setOnClickListener(listener);
    }

    /**
     * this method let to avoid casting every time the Views to their specific sub-classes;
     * @param act
     * @param viewId
     * @param <T>
     * @return
     */
    public static <T extends View> T findViewById(Activity act, int viewId) {
        // We get the VuewGroup of the Activity
        View containerView = act.getWindow().getDecorView();
        View toRet = containerView.findViewById(viewId);
        return (T) toRet;
    }


}

