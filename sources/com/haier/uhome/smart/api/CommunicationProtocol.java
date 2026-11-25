package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public enum CommunicationProtocol {
    UNDEF(0),
    ZIGBEE3_0(1);

    private int value;

    CommunicationProtocol(int i7) {
        this.value = i7;
    }

    public int getValue() {
        return this.value;
    }
}
