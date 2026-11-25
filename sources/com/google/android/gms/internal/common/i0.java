package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f16111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0 f16113c;

    private i0(f0 f0Var, boolean z7, z zVar, int i7, byte[] bArr) {
        this.f16113c = f0Var;
        this.f16112b = z7;
        this.f16111a = zVar;
    }

    public static i0 c(z zVar) {
        return new i0(new f0(zVar), false, y.f16127b, Integer.MAX_VALUE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator<String> h(CharSequence charSequence) {
        return new e0(this.f16113c, this, charSequence);
    }

    public final i0 b() {
        return new i0(this.f16113c, true, this.f16111a, Integer.MAX_VALUE, null);
    }

    public final Iterable<String> d(CharSequence charSequence) {
        return new g0(this, charSequence);
    }

    public final List<String> f(CharSequence charSequence) {
        charSequence.getClass();
        Iterator<String> itH = h(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itH.hasNext()) {
            arrayList.add(itH.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
