package com.example.dialogalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDialog extends Dialog {
    private Activity activity;
    private TextView tvMessagePopup;
    private Runnable runnableOk, runnableCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_view);
        setCancelable(false);

        tvMessagePopup  = findViewById(R.id.tv_message);
        findViewById(R.id.btn_ok).setOnClickListener(v -> {
            Toast.makeText(activity, "btn ok", Toast.LENGTH_SHORT).show();
        });
        findViewById(R.id.btn_cancel).setOnClickListener(v -> {
            Toast.makeText(activity, "btn cancel", Toast.LENGTH_SHORT).show();
            dismiss();
        });
    }

    public CustomDialog(Activity activity) {
        super(activity, android.R.style.Theme_Translucent_NoTitleBar);
        this.activity = activity;
    }

}
