package com.example.dialogalert.custom_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dialogalert.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CustomInputType extends TextInputLayout {
    private TextInputLayout tilContainer;
    private TextInputEditText tietInput;

    public CustomInputType(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.custom_input_type_layout, this, true);
        tilContainer = view.findViewById(R.id.til_container);
        tietInput = view.findViewById(R.id.tiet_input);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomInputType);
        validateAttrs(typedArray);
    }

    private void validateAttrs(TypedArray typedArray) {
        int type = typedArray.getInteger(R.styleable.CustomInputType_type, 0);
        String hint = typedArray.getString(R.styleable.CustomInputType_hint);
        int resHintColor = typedArray.getInteger(R.styleable.CustomInputType_hint_color, 0);
        String text = typedArray.getString(R.styleable.CustomInputType_text);
        int resColor = typedArray.getColor(R.styleable.CustomInputType_textColor, 0);
        int maxDecimal = typedArray.getInteger(R.styleable.CustomInputType_type, 0);
        int resBackground = typedArray.getResourceId(R.styleable.CustomInputType_background, 0);
        boolean editable = typedArray.getBoolean(R.styleable.CustomInputType_editable, true);
        typedArray.recycle();

        setType(type);
        setHint(nullStringValue(hint));
        setHintColor(resHintColor);
        setText(nullStringValue(text));
        setTextColor(resColor);
        setBackground(resBackground);
        setEditable(editable);

    }

    private String nullStringValue(String stringValue) {
        return stringValue!=null? stringValue : "";
    }

    public void setType(int type) {
        switch (type) {
            case 1:
                tilContainer.setSuffixText("%");
                break;
            case 2:
                tilContainer.setPrefixText("S/");
                break;
            case 3:
                tilContainer.setPrefixText("$");
                break;
            default:
                tilContainer.setPrefixText("");
        }
    }

    public void setBackground(int resBackground) {
        if (resBackground != 0)
            tietInput.setBackgroundResource(resBackground);
        else
            tietInput.setBackgroundResource(R.color.white);
    }

    public void setHint(String hint) {
        tilContainer.setHint(hint);
    }

    public void setHintColor(int resHintColor) {
        if (resHintColor == 0)
            tilContainer.setHintTextColor(getResources().getColorStateList(R.color.black));
        else
            tilContainer.setHintTextColor(getResources().getColorStateList(resHintColor));
    }

    public void setText(String text) {
        tietInput.setText(String.valueOf(text));
    }

    public void setTextColor(int resColor) {
        if (resColor == 0)
            tilContainer.setSuffixTextColor(getResources().getColorStateList(R.color.black));
        else
            tilContainer.setSuffixTextColor(getResources().getColorStateList(resColor));
        tietInput.setTextColor(resColor);
    }

    public String getText() {
        return tietInput.getText().toString();
    }

    public void setEditable(boolean isEditable) {
        //tilContainer.setEnabled(isEditable);
        tietInput.setEnabled(isEditable);
    }

}
