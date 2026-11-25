package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements com.bumptech.glide.load.resource.bitmap.a<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14530a = "Downsampler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<m.a> f14531b = EnumSet.of(m.a.JPEG, m.a.PNG_A, m.a.PNG);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f14532c = com.bumptech.glide.util.i.d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f14533d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f14534e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f14535f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f14536g = 5242880;

    static class a extends g {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.g, com.bumptech.glide.load.resource.bitmap.a
        public /* bridge */ /* synthetic */ Bitmap b(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8, w0.a aVar) throws Exception {
            return super.b(inputStream, cVar, i7, i8, aVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.g
        protected int j(int i7, int i8, int i9, int i10) {
            return Math.min(i8 / i10, i7 / i9);
        }
    }

    static class b extends g {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.g, com.bumptech.glide.load.resource.bitmap.a
        public /* bridge */ /* synthetic */ Bitmap b(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8, w0.a aVar) throws Exception {
            return super.b(inputStream, cVar, i7, i8, aVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.g
        protected int j(int i7, int i8, int i9, int i10) {
            int iCeil = (int) Math.ceil(Math.max(i8 / i10, i7 / i9));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return iMax << (iMax >= iCeil ? 0 : 1);
        }
    }

    static class c extends g {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.g, com.bumptech.glide.load.resource.bitmap.a
        public /* bridge */ /* synthetic */ Bitmap b(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8, w0.a aVar) throws Exception {
            return super.b(inputStream, cVar, i7, i8, aVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.g
        protected int j(int i7, int i8, int i9, int i10) {
            return 0;
        }
    }

    private static Bitmap d(com.bumptech.glide.util.g gVar, p pVar, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            gVar.mark(f14536g);
        } else {
            pVar.e();
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(gVar, null, options);
        try {
            if (options.inJustDecodeBounds) {
                gVar.reset();
            }
        } catch (IOException e8) {
            if (Log.isLoggable(f14530a, 6)) {
                Log.e(f14530a, "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e8);
            }
        }
        return bitmapDecodeStream;
    }

    private Bitmap e(com.bumptech.glide.util.g gVar, p pVar, BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8, int i9, w0.a aVar) {
        Bitmap.Config configF = f(gVar, aVar);
        options.inSampleSize = i9;
        options.inPreferredConfig = configF;
        if (n(gVar)) {
            double d8 = i9;
            m(options, cVar.g((int) Math.ceil(((double) i7) / d8), (int) Math.ceil(((double) i8) / d8), configF));
        }
        return d(gVar, pVar, options);
    }

    private static Bitmap.Config f(InputStream inputStream, w0.a aVar) {
        boolean zF;
        if (aVar == w0.a.ALWAYS_ARGB_8888 || aVar == w0.a.PREFER_ARGB_8888) {
            return Bitmap.Config.ARGB_8888;
        }
        inputStream.mark(1024);
        try {
            try {
                zF = new m(inputStream).f();
                try {
                    inputStream.reset();
                } catch (IOException e8) {
                    if (Log.isLoggable(f14530a, 5)) {
                        Log.w(f14530a, "Cannot reset the input stream", e8);
                    }
                }
            } catch (Throwable th) {
                try {
                    inputStream.reset();
                } catch (IOException e9) {
                    if (Log.isLoggable(f14530a, 5)) {
                        Log.w(f14530a, "Cannot reset the input stream", e9);
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            if (Log.isLoggable(f14530a, 5)) {
                Log.w(f14530a, "Cannot determine whether the image has alpha or not from header for format " + aVar, e10);
            }
            try {
                inputStream.reset();
            } catch (IOException e11) {
                if (Log.isLoggable(f14530a, 5)) {
                    Log.w(f14530a, "Cannot reset the input stream", e11);
                }
            }
            zF = false;
        }
        return zF ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options g() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f14532c;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            l(optionsPoll);
        }
        return optionsPoll;
    }

    private int i(int i7, int i8, int i9, int i10, int i11) {
        if (i11 == Integer.MIN_VALUE) {
            i11 = i9;
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = i8;
        }
        int iJ = (i7 == 90 || i7 == 270) ? j(i9, i8, i10, i11) : j(i8, i9, i10, i11);
        return Math.max(1, iJ == 0 ? 0 : Integer.highestOneBit(iJ));
    }

    private static void k(BitmapFactory.Options options) {
        l(options);
        Queue<BitmapFactory.Options> queue = f14532c;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @TargetApi(11)
    private static void l(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    @TargetApi(11)
    private static void m(BitmapFactory.Options options, Bitmap bitmap) {
        options.inBitmap = bitmap;
    }

    private static boolean n(InputStream inputStream) {
        return true;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap b(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8, w0.a aVar) {
        int i9;
        Bitmap bitmapI;
        com.bumptech.glide.util.a aVarB = com.bumptech.glide.util.a.b();
        byte[] bArrC = aVarB.c();
        byte[] bArrC2 = aVarB.c();
        BitmapFactory.Options optionsG = g();
        p pVar = new p(inputStream, bArrC2);
        com.bumptech.glide.util.c cVarF = com.bumptech.glide.util.c.f(pVar);
        com.bumptech.glide.util.g gVar = new com.bumptech.glide.util.g(cVarF);
        try {
            cVarF.mark(f14536g);
            try {
                try {
                    int iC = new m(cVarF).c();
                    try {
                        cVarF.reset();
                    } catch (IOException e8) {
                        if (Log.isLoggable(f14530a, 5)) {
                            Log.w(f14530a, "Cannot reset the input stream", e8);
                        }
                    }
                    i9 = iC;
                } catch (Throwable th) {
                    try {
                        cVarF.reset();
                        throw th;
                    } catch (IOException e9) {
                        if (!Log.isLoggable(f14530a, 5)) {
                            throw th;
                        }
                        Log.w(f14530a, "Cannot reset the input stream", e9);
                        throw th;
                    }
                }
            } catch (IOException e10) {
                if (Log.isLoggable(f14530a, 5)) {
                    Log.w(f14530a, "Cannot determine the image orientation from header", e10);
                }
                try {
                    cVarF.reset();
                } catch (IOException e11) {
                    if (Log.isLoggable(f14530a, 5)) {
                        Log.w(f14530a, "Cannot reset the input stream", e11);
                    }
                }
                i9 = 0;
            }
            optionsG.inTempStorage = bArrC;
            int[] iArrH = h(gVar, pVar, optionsG);
            int i10 = iArrH[0];
            int i11 = iArrH[1];
            Bitmap bitmapE = e(gVar, pVar, optionsG, cVar, i10, i11, i(s.c(i9), i10, i11, i7, i8), aVar);
            IOException iOExceptionE = cVarF.e();
            if (iOExceptionE != null) {
                throw new RuntimeException(iOExceptionE);
            }
            if (bitmapE != null) {
                bitmapI = s.i(bitmapE, cVar, i9);
                if (!bitmapE.equals(bitmapI) && !cVar.b(bitmapE)) {
                    bitmapE.recycle();
                }
            } else {
                bitmapI = null;
            }
            aVarB.d(bArrC);
            aVarB.d(bArrC2);
            cVarF.i();
            k(optionsG);
            return bitmapI;
        } catch (Throwable th2) {
            aVarB.d(bArrC);
            aVarB.d(bArrC2);
            cVarF.i();
            k(optionsG);
            throw th2;
        }
    }

    public int[] h(com.bumptech.glide.util.g gVar, p pVar, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        d(gVar, pVar, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    protected abstract int j(int i7, int i8, int i9, int i10);
}
