package com.eudekagroup16.myapplication.listener;

import android.view.View;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/25/2019
 */
public class ClickListenerModel {
    private String title;
    private View.OnClickListener listener;

    public ClickListenerModel(String title, View.OnClickListener listener) {
        this.title = title;
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
