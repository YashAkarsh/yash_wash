package org.chromium.net.impl;

import android.content.Context;
import java.util.Arrays;
import org.chromium.base.annotations.UsedByReflection;

/* JADX INFO: loaded from: classes3.dex */
public class NativeCronetProvider extends org.chromium.net.l {
    @UsedByReflection("CronetProvider.java")
    public NativeCronetProvider(Context context) {
        super(context);
    }

    @Override // org.chromium.net.l
    public org.chromium.net.j.a c() {
        return new org.chromium.net.o.a(new m(this.f39457a));
    }

    @Override // org.chromium.net.l
    public String e() {
        return org.chromium.net.l.f39449b;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof NativeCronetProvider) && this.f39457a.equals(((NativeCronetProvider) obj).f39457a));
    }

    @Override // org.chromium.net.l
    public String f() {
        return i.b();
    }

    @Override // org.chromium.net.l
    public boolean g() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.f39457a});
    }
}
