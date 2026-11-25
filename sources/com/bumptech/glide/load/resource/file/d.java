package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.model.o;
import java.io.File;
import java.io.InputStream;
import w0.e;
import w0.f;

/* JADX INFO: loaded from: classes.dex */
public class d implements a1.b<InputStream, File> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f14619c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<File, File> f14620a = new com.bumptech.glide.load.resource.file.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.b<InputStream> f14621b = new o();

    private static class b implements e<InputStream, File> {
        private b() {
        }

        @Override // w0.e
        public String a() {
            return "";
        }

        @Override // w0.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public m<File> b(InputStream inputStream, int i7, int i8) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }
    }

    @Override // a1.b
    public w0.b<InputStream> e() {
        return this.f14621b;
    }

    @Override // a1.b
    public f<File> i() {
        return com.bumptech.glide.load.resource.c.d();
    }

    @Override // a1.b
    public e<InputStream, File> j() {
        return f14619c;
    }

    @Override // a1.b
    public e<File, File> k() {
        return this.f14620a;
    }
}
