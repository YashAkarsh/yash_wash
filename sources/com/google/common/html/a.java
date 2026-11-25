package com.google.common.html;

import com.google.common.escape.f;
import com.google.common.escape.g;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f21897a = g.b().b(h0.f35376b, "&quot;").b('\'', "&#39;").b(h0.f35378d, "&amp;").b(h0.f35379e, "&lt;").b(h0.f35380f, "&gt;").c();

    private a() {
    }

    public static f a() {
        return f21897a;
    }
}
