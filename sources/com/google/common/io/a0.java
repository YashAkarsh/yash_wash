package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f21900a = new StringBuilder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f21901b;

    a0() {
    }

    @u1.a
    private boolean c(boolean z7) throws IOException {
        String str;
        if (this.f21901b) {
            str = z7 ? "\r\n" : "\r";
        } else {
            str = z7 ? "\n" : "";
        }
        d(this.f21900a.toString(), str);
        this.f21900a = new StringBuilder();
        this.f21901b = false;
        return z7;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    protected void a(char[] cArr, int i7, int i8) throws IOException {
        int i9;
        if (!this.f21901b || i8 <= 0) {
            i9 = i7;
        } else {
            if (c(cArr[i7] == '\n')) {
                i9 = i7 + 1;
            } else {
                i9 = i7;
            }
        }
        int i10 = i7 + i8;
        int i11 = i9;
        while (i9 < i10) {
            char c8 = cArr[i9];
            if (c8 != '\n') {
                if (c8 == '\r') {
                    this.f21900a.append(cArr, i11, i9 - i11);
                    this.f21901b = true;
                    int i12 = i9 + 1;
                    if (i12 < i10) {
                        if (c(cArr[i12] == '\n')) {
                            i9 = i12;
                        }
                    }
                }
                i9++;
            } else {
                this.f21900a.append(cArr, i11, i9 - i11);
                c(true);
            }
            i11 = i9 + 1;
            i9++;
        }
        this.f21900a.append(cArr, i11, i10 - i11);
    }

    protected void b() throws IOException {
        if (this.f21901b || this.f21900a.length() > 0) {
            c(false);
        }
    }

    protected abstract void d(String str, String str2) throws IOException;
}
