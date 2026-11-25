package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@s1.c
final class v extends h implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f19562b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f19563a;

    private static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matcher f19564a;

        a(Matcher matcher) {
            this.f19564a = (Matcher) e0.E(matcher);
        }

        @Override // com.google.common.base.g
        public int a() {
            return this.f19564a.end();
        }

        @Override // com.google.common.base.g
        public boolean b() {
            return this.f19564a.find();
        }

        @Override // com.google.common.base.g
        public boolean c(int i7) {
            return this.f19564a.find(i7);
        }

        @Override // com.google.common.base.g
        public boolean d() {
            return this.f19564a.matches();
        }

        @Override // com.google.common.base.g
        public String e(String str) {
            return this.f19564a.replaceAll(str);
        }

        @Override // com.google.common.base.g
        public int f() {
            return this.f19564a.start();
        }
    }

    v(Pattern pattern) {
        this.f19563a = (Pattern) e0.E(pattern);
    }

    @Override // com.google.common.base.h
    public int b() {
        return this.f19563a.flags();
    }

    @Override // com.google.common.base.h
    public g d(CharSequence charSequence) {
        return new a(this.f19563a.matcher(charSequence));
    }

    @Override // com.google.common.base.h
    public String e() {
        return this.f19563a.pattern();
    }

    @Override // com.google.common.base.h
    public String toString() {
        return this.f19563a.toString();
    }
}
