package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKFaultInformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30919b;

    public void a(int i7) {
        this.f30918a = i7;
    }

    public void b(int i7) {
        this.f30919b = i7;
    }

    @Keep
    public int getState() {
        return this.f30918a;
    }

    @Keep
    public int getStateCode() {
        return this.f30919b;
    }

    @Keep
    public String toString() {
        return "uSDKFaultInformation{state=" + this.f30918a + ", stateCode=" + this.f30919b + '}';
    }
}
