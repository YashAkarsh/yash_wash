package org.chromium.net.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import org.chromium.net.q0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends org.chromium.net.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f39404a = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static int h(int i7) {
        switch (i7) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
            default:
                throw new IllegalArgumentException("No request status found.");
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 11;
            case 13:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
        }
    }

    protected abstract void g(String str, String str2);

    protected abstract void i(String str);

    protected abstract void j(q0 q0Var, Executor executor);
}
