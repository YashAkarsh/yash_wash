package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public enum MessageActionType {
    DELIVERDATA(1);

    private int stateValue;

    MessageActionType(int i7) {
        this.stateValue = i7;
    }

    public static MessageActionType getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return DELIVERDATA;
        }
    }

    public int value() {
        return this.stateValue;
    }
}
