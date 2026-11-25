package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    static final CharSequence a(@CheckForNull Object obj, String str) {
        obj.getClass();
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
