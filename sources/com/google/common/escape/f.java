package com.google.common.escape;

import com.google.common.base.s;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s<String, String> f21532a = new a();

    class a implements s<String, String> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return f.this.b(str);
        }
    }

    protected f() {
    }

    public final s<String, String> a() {
        return this.f21532a;
    }

    public abstract String b(String str);
}
