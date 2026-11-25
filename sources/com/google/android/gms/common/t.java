package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class t extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Intent f15983a;

    public t(@c.m0 String str, @c.m0 Intent intent) {
        super(str);
        this.f15983a = intent;
    }

    @c.m0
    public Intent a() {
        return new Intent(this.f15983a);
    }
}
