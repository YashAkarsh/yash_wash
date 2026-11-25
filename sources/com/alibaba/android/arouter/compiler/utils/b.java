package com.alibaba.android.arouter.compiler.utils;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Messager f12433a;

    public b(Messager messager) {
        this.f12433a = messager;
    }

    private String c(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("    at ");
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void a(CharSequence charSequence) {
        if (StringUtils.isNotEmpty(charSequence)) {
            this.f12433a.printMessage(Diagnostic.Kind.ERROR, "ARouter::Compiler An exception is encountered, [" + ((Object) charSequence) + "]");
        }
    }

    public void b(Throwable th) {
        if (th != null) {
            this.f12433a.printMessage(Diagnostic.Kind.ERROR, "ARouter::Compiler An exception is encountered, [" + th.getMessage() + "]\n" + c(th.getStackTrace()));
        }
    }

    public void d(CharSequence charSequence) {
        if (StringUtils.isNotEmpty(charSequence)) {
            this.f12433a.printMessage(Diagnostic.Kind.NOTE, "ARouter::Compiler " + ((Object) charSequence));
        }
    }

    public void e(CharSequence charSequence) {
        if (StringUtils.isNotEmpty(charSequence)) {
            this.f12433a.printMessage(Diagnostic.Kind.WARNING, "ARouter::Compiler " + ((Object) charSequence));
        }
    }
}
