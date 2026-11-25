package com.google.common.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class d2 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f21957a;

    public d2(String str) {
        this(Pattern.compile(str));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f21957a.matcher(str).matches();
    }

    public d2(Pattern pattern) {
        this.f21957a = (Pattern) com.google.common.base.e0.E(pattern);
    }
}
