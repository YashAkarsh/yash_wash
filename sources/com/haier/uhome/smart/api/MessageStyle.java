package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public enum MessageStyle {
    VOICE(1),
    ACTION(2),
    VOICE_ACTION(3);

    private int stateValue;

    MessageStyle(int i7) {
        this.stateValue = i7;
    }

    public static MessageStyle getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return VOICE;
        }
    }

    public int value() {
        return this.stateValue;
    }
}
