package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.engine.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import w0.e;

/* JADX INFO: loaded from: classes.dex */
public class c<T> implements e<File, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f14616c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e<InputStream, T> f14617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f14618b;

    static class a {
        a() {
        }

        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public c(e<InputStream, T> eVar) {
        this(eVar, f14616c);
    }

    @Override // w0.e
    public String a() {
        return "";
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m<T> b(File file, int i7, int i8) throws IOException {
        InputStream inputStreamA = null;
        try {
            inputStreamA = this.f14618b.a(file);
            return this.f14617a.b(inputStreamA, i7, i8);
        } finally {
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    c(e<InputStream, T> eVar, a aVar) {
        this.f14617a = eVar;
        this.f14618b = aVar;
    }
}
