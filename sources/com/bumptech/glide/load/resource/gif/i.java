package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class i implements w0.e<InputStream, com.bumptech.glide.load.resource.gif.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14669f = "GifResourceDecoder";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f14670g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f14671h = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f14673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f14675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.a f14676e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.gifdecoder.a> f14677a = com.bumptech.glide.util.i.d(0);

        a() {
        }

        public synchronized com.bumptech.glide.gifdecoder.a a(com.bumptech.glide.gifdecoder.a.InterfaceC0161a interfaceC0161a) {
            com.bumptech.glide.gifdecoder.a aVarPoll;
            aVarPoll = this.f14677a.poll();
            if (aVarPoll == null) {
                aVarPoll = new com.bumptech.glide.gifdecoder.a(interfaceC0161a);
            }
            return aVarPoll;
        }

        public synchronized void b(com.bumptech.glide.gifdecoder.a aVar) {
            aVar.b();
            this.f14677a.offer(aVar);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.gifdecoder.d> f14678a = com.bumptech.glide.util.i.d(0);

        b() {
        }

        public synchronized com.bumptech.glide.gifdecoder.d a(byte[] bArr) {
            com.bumptech.glide.gifdecoder.d dVarPoll;
            dVarPoll = this.f14678a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.bumptech.glide.gifdecoder.d();
            }
            return dVarPoll.o(bArr);
        }

        public synchronized void b(com.bumptech.glide.gifdecoder.d dVar) {
            dVar.a();
            this.f14678a.offer(dVar);
        }
    }

    public i(Context context) {
        this(context, l.o(context).r());
    }

    private d d(byte[] bArr, int i7, int i8, com.bumptech.glide.gifdecoder.d dVar, com.bumptech.glide.gifdecoder.a aVar) {
        Bitmap bitmapE;
        com.bumptech.glide.gifdecoder.c cVarC = dVar.c();
        if (cVarC.b() <= 0 || cVarC.c() != 0 || (bitmapE = e(aVar, cVarC, bArr)) == null) {
            return null;
        }
        return new d(new com.bumptech.glide.load.resource.gif.b(this.f14672a, this.f14676e, this.f14674c, com.bumptech.glide.load.resource.e.c(), i7, i8, cVarC, bArr, bitmapE));
    }

    private Bitmap e(com.bumptech.glide.gifdecoder.a aVar, com.bumptech.glide.gifdecoder.c cVar, byte[] bArr) {
        aVar.x(cVar, bArr);
        aVar.a();
        return aVar.n();
    }

    private static byte[] f(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i7 = inputStream.read(bArr);
                if (i7 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i7);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e8) {
            Log.w(f14669f, "Error reading data from stream", e8);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // w0.e
    public String a() {
        return "";
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d b(InputStream inputStream, int i7, int i8) {
        byte[] bArrF = f(inputStream);
        com.bumptech.glide.gifdecoder.d dVarA = this.f14673b.a(bArrF);
        com.bumptech.glide.gifdecoder.a aVarA = this.f14675d.a(this.f14676e);
        try {
            return d(bArrF, i7, i8, dVarA, aVarA);
        } finally {
            this.f14673b.b(dVarA);
            this.f14675d.b(aVarA);
        }
    }

    public i(Context context, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(context, cVar, f14670g, f14671h);
    }

    i(Context context, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, b bVar, a aVar) {
        this.f14672a = context.getApplicationContext();
        this.f14674c = cVar;
        this.f14675d = aVar;
        this.f14676e = new com.bumptech.glide.load.resource.gif.a(cVar);
        this.f14673b = bVar;
    }
}
