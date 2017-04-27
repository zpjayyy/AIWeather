package com.jay.aiweather.ui;

import android.os.Bundle;

import com.jay.aiweather.R;
import com.jay.aiweather.ui.base.ToolbarActivity;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
