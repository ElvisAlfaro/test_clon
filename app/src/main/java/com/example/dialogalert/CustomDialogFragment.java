package com.example.dialogalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.io.Serializable;

public class CustomDialogFragment extends DialogFragment {
    public static final String TAG_CUSTOM_DIALOG_FRAGMENT = "TAG_CUSTOM_DIALOG_FRAGMENT";
    public static final String TAG_MESSAGE = "TAG_MESSAGE";
    public static final String TAG_RUNNABLE_OK = "TAG_RUNNABLE_OK";
    public static final String TAG_RUNNABLE_CANCEL = "TAG_RUNNABLE_CANCEL";

    private String message;
    private Runnable actionOk, actionCancel;

    public static CustomDialogFragment newInstance(String message, Runnable actionOk, Runnable actionCancel) {
        Bundle args = new Bundle();
        args.putString(TAG_MESSAGE, message);
        //args.putParcelable(TAG_RUNNABLE_OK, (Parcelable) actionOk);
        //args.putParcelable(TAG_RUNNABLE_CANCEL, (Parce) actionCancel);
        CustomDialogFragment fragment = new CustomDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }
/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        message = getArguments().getString(TAG_MESSAGE);
        actionOk = (Runnable) getArguments().getSerializable(TAG_RUNNABLE_OK);
        actionCancel = (Runnable) getArguments().getSerializable(TAG_RUNNABLE_CANCEL);
    }*/

    public CustomDialogFragment() {
    }

    public CustomDialogFragment(String message, Runnable actionOk, Runnable actionCancel) {
        super(R.layout.dialog_view);
        this.message = message;
        this.actionOk = actionOk;
        this.actionCancel = actionCancel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_view, null, false);
        TextView tvMessage = view.findViewById(R.id.tv_message);
        tvMessage.setText(Html.fromHtml(message));
        Button buttonOk = view.findViewById(R.id.btn_ok);
        Button buttonCancel = view.findViewById(R.id.btn_cancel);

        buttonOk.setOnClickListener(v -> {
            getActivity().runOnUiThread(()-> actionOk.run());
        });

        buttonCancel.setOnClickListener(v -> {
            getActivity().runOnUiThread(() -> actionCancel.run());
        });

        builder.setView(view);
        builder.setCancelable(true);
        return builder.create();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
