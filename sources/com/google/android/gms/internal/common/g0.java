package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class g0 implements Iterable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CharSequence f16103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i0 f16104b;

    g0(i0 i0Var, CharSequence charSequence) {
        this.f16104b = i0Var;
        this.f16103a = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return this.f16104b.h(this.f16103a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<String> it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(b0.a(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(b0.a(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }
}
