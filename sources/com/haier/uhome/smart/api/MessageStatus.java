package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public enum MessageStatus {
    READ(1),
    DELIVERED(2);

    private int stateValue;

    MessageStatus(int i7) {
        this.stateValue = i7;
    }

    public static MessageStatus getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return DELIVERED;
        }
    }

    public int value() {
        return this.stateValue;
    }
}
