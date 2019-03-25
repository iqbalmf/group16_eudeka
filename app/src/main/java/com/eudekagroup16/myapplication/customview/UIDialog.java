package com.eudekagroup16.myapplication.customview;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.listener.ClickListenerModel;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/25/2019
 */
public class UIDialog {
    public static AlertDialog showDialogChecker(Context context,
                                                String title,
                                                String message,
                                                ClickListenerModel positive) {
        LayoutInflater layout = LayoutInflater.from(context);
        View view = layout.inflate(R.layout.dialog_view_check_result, null);

        TextView textTitle = view.findViewById(R.id.tvTitleDialog);
        TextView textMessage = view.findViewById(R.id.tvMessageDialog);
        Button btnDialog = view.findViewById(R.id.btnDialog);

        textTitle.setText(title);
        textMessage.setText(message);

        if (positive != null && positive.getListener() != null) {
            btnDialog.setOnClickListener(positive.getListener());
            btnDialog.setText(positive.getTitle());
        }

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setView(view);
        dialogBuilder.setCancelable(Boolean.TRUE);
        final AlertDialog dialog = dialogBuilder.create();
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }
}
