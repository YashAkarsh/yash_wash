package com.google.android.gms.common.images;

import android.net.Uri;
import c.o0;
import com.google.android.gms.common.internal.s;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f15612a;

    public e(Uri uri) {
        this.f15612a = uri;
    }

    public final boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return s.b(((e) obj).f15612a, this.f15612a);
        }
        return false;
    }

    public final int hashCode() {
        return s.c(this.f15612a);
    }
}
