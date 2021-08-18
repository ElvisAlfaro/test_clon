package com.example.dialogalert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialogalert.custom_view.CustomInputType;

public class MainActivity extends AppCompatActivity {
    private CustomDialogFragment dialogFragment;
    private CustomDialog dialog;
    private Button btnDialog;

    private CustomInputType citValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = findViewById(R.id.btn_dialog);
        citValor = findViewById(R.id.cit_valor);

        btnDialog.setOnClickListener(v -> {
            openCustomDialog();
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialogFragment!=null)
            dialogFragment.dismiss();
    }

    private void openCustomDialogFragment() {
        /*dialogFragment = CustomDialogFragment.newInstance(getString(R.string.message),
                    ()-> Toast.makeText(MainActivity.this, "Click ok", Toast.LENGTH_SHORT).show(),
                    ()-> Toast.makeText(MainActivity.this, "Click Cancel", Toast.LENGTH_SHORT).show());*/

        dialogFragment = new CustomDialogFragment(getString(R.string.message),
                ()-> Toast.makeText(MainActivity.this, "Click ok", Toast.LENGTH_SHORT).show(),
                ()-> Toast.makeText(MainActivity.this, "Click Cancel", Toast.LENGTH_SHORT).show());

        dialogFragment.show(getSupportFragmentManager(), CustomDialogFragment.TAG_CUSTOM_DIALOG_FRAGMENT);
    }

    private void openCustomDialog() {
        dialog = new CustomDialog(this);
        dialog.show();
    }
}