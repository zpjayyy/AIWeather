package com.jay.aiweather.ui.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;


import com.jay.aiweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jay on 17/3/10.
 */

public class ToolbarActivity extends BaseActivity {

    class ToolbarViewHolder {
        @BindView(R.id.toolbar)
        Toolbar toolbar;
    }

    ToolbarViewHolder holder = new ToolbarViewHolder();
    Toolbar toolbar;


    public boolean canBack() {
        return false;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(holder, this);
        toolbar = holder.toolbar;

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowHomeEnabled(true);
                if (canBack()) {
                    actionBar.setDisplayHomeAsUpEnabled(true);
                }
            }
        }
    }

    public void setDiaplayShowTitleEnabled(boolean enable) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(enable);
        }
    }

}
