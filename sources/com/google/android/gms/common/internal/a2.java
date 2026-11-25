package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Uri f15658f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final String f15659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private final String f15660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private final ComponentName f15661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f15663e;

    public a2(ComponentName componentName, int i7) {
        this.f15659a = null;
        this.f15660b = null;
        u.k(componentName);
        this.f15661c = componentName;
        this.f15662d = i7;
        this.f15663e = false;
    }

    public final int a() {
        return this.f15662d;
    }

    @c.o0
    public final ComponentName b() {
        return this.f15661c;
    }

    public final Intent c(Context context) {
        Bundle bundleCall;
        if (this.f15659a == null) {
            return new Intent().setComponent(this.f15661c);
        }
        Intent intent = null;
        if (this.f15663e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f15659a);
            try {
                bundleCall = context.getContentResolver().call(f15658f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e8) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e8.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                String strValueOf = String.valueOf(this.f15659a);
                Log.w("ConnectionStatusConfig", strValueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(strValueOf) : new String("Dynamic lookup for intent failed for action: "));
            }
        }
        return intent != null ? intent : new Intent(this.f15659a).setPackage(this.f15660b);
    }

    @c.o0
    public final String d() {
        return this.f15660b;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return s.b(this.f15659a, a2Var.f15659a) && s.b(this.f15660b, a2Var.f15660b) && s.b(this.f15661c, a2Var.f15661c) && this.f15662d == a2Var.f15662d && this.f15663e == a2Var.f15663e;
    }

    public final int hashCode() {
        return s.c(this.f15659a, this.f15660b, this.f15661c, Integer.valueOf(this.f15662d), Boolean.valueOf(this.f15663e));
    }

    public final String toString() {
        String str = this.f15659a;
        if (str != null) {
            return str;
        }
        u.k(this.f15661c);
        return this.f15661c.flattenToString();
    }

    public a2(String str, int i7, boolean z7) {
        this(str, "com.google.android.gms", i7, false);
    }

    public a2(String str, String str2, int i7, boolean z7) {
        u.g(str);
        this.f15659a = str;
        u.g(str2);
        this.f15660b = str2;
        this.f15661c = null;
        this.f15662d = i7;
        this.f15663e = z7;
    }
}
