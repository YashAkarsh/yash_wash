package com.google.common.io;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Readable f21948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f21949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharBuffer f21950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f21951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Queue<String> f21952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a0 f21953f;

    class a extends a0 {
        a() {
        }

        @Override // com.google.common.io.a0
        protected void d(String str, String str2) {
            c0.this.f21952e.add(str);
        }
    }

    public c0(Readable readable) {
        CharBuffer charBufferE = q.e();
        this.f21950c = charBufferE;
        this.f21951d = charBufferE.array();
        this.f21952e = new LinkedList();
        this.f21953f = new a();
        this.f21948a = (Readable) com.google.common.base.e0.E(readable);
        this.f21949b = readable instanceof Reader ? (Reader) readable : null;
    }

    @u1.a
    public String b() throws IOException {
        int i7;
        while (this.f21952e.peek() == null) {
            this.f21950c.clear();
            Reader reader = this.f21949b;
            if (reader != null) {
                char[] cArr = this.f21951d;
                i7 = reader.read(cArr, 0, cArr.length);
            } else {
                i7 = this.f21948a.read(this.f21950c);
            }
            if (i7 == -1) {
                this.f21953f.b();
                break;
            }
            this.f21953f.a(this.f21951d, 0, i7);
        }
        return this.f21952e.poll();
    }
}
