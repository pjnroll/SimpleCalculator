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

import static android.content.ContentValues.TAG;


public class MainActivity extends Activity {
    final static String LOG_TAG = "MainScreen";

    private EditText mTxtValue1;
    private EditText mTxtValue2;

    private Button mBtnAdd;
    private Button mBtnSubtract;
    private Button mBtnMultiply;
    private Button mBtnDivide;


    private TextView mTxtResult;

    private float mValue1;
    private float mValue2;
    private float mResult;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtValue1 = findViewById(this, R.id.value1);
        mTxtValue2 = findViewById(this, R.id.value2);
        mTxtResult = findViewById(this, R.id.result);

        mBtnAdd = findViewById(this, R.id.addValues);
        mBtnSubtract = findViewById(this, R.id.addValues);
        mBtnMultiply = findViewById(this, R.id.multiplyValues);
        mBtnDivide = findViewById(this, R.id.multiplyValues);

        View.OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                float result = 0f;
                switch (v.getId()) {
                    case (R.id.addValues):
                        result = addValues();
                        break;

                    case (R.id.multiplyValues):
                        result = multiplyValues();
                        break;

                    case (R.id.subtractValues):
                        result = subtractValues();
                        break;

                    case (R.id.divideValues):
                        result = divideValues();
                        break;

                    default:
                        break;
                }
            }
        };

        mBtnAdd.setOnClickListener(listener);
        mBtnSubtract.setOnClickListener(listener);
        mBtnMultiply.setOnClickListener(listener);
        mBtnDivide.setOnClickListener(listener);
    }

    private float addValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 + mValue2;
        } catch (NullPointerException e) {
            Log.e(TAG, "Empty values");
        }
        return toRet;
    }

    private float multiplyValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 * mValue2;
        } catch (NullPointerException e) {
            Log.e(TAG, "Empty values");
        }
        return toRet;
    }

    private float subtractValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 - mValue2;
        } catch (NullPointerException e) {
            Log.e(TAG, "Empty values");
        }
        return toRet;
    }

    private float divideValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 / mValue2;
        } catch (NullPointerException e) {
            Log.e(TAG, "Empty values");
        }
        return toRet;
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