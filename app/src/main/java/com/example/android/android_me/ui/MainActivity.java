package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.android_me.R;

/**
 * Created by asrma2 on 5/6/18.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.onImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {

        int categoryNumber = position / 12;
        int partNumber = position % 12;

        switch (categoryNumber) {
            case 0: headIndex = partNumber;
                    break;
            case 1: bodyIndex = partNumber;
                    break;
            case 2: legIndex = partNumber;
                    break;
            default: break;
        }

        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }
}
