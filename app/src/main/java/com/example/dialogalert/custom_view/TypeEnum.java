package com.example.dialogalert.custom_view;

public enum TypeEnum {
    PORCENTAJE,
    MONEDA_SOL,
    MOMEDA_DOLAR;

    String getValueString() {
        return this.toString();
    }
}
