package com.alipay.security.mobile.module.b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class d implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f13905a;

    d(c cVar) {
        this.f13905a = cVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
