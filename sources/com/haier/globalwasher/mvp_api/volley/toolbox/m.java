package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.haier.globalwasher.mvp_api.volley.v;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.haier.globalwasher.mvp_api.volley.n<Bitmap> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f25019w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f25020x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final float f25021y = 2.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Object f25022z = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.haier.globalwasher.mvp_api.moudle.b<Bitmap> f25023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Bitmap.Config f25024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f25025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f25026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView.ScaleType f25027v;

    public m(String str, com.haier.globalwasher.mvp_api.moudle.b<Bitmap> bVar, int i7, int i8, ImageView.ScaleType scaleType, Bitmap.Config config, com.haier.globalwasher.mvp_api.moudle.b bVar2) {
        super(0, str, bVar2);
        P(new com.haier.globalwasher.mvp_api.volley.d(1000, 2, f25021y));
        this.f25023r = bVar;
        this.f25024s = config;
        this.f25025t = i7;
        this.f25026u = i8;
        this.f25027v = scaleType;
    }

    private com.haier.globalwasher.mvp_api.volley.p<Bitmap> V(com.haier.globalwasher.mvp_api.volley.j jVar) {
        Bitmap bitmapDecodeByteArray;
        byte[] bArr = jVar.f24843b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f25025t == 0 && this.f25026u == 0) {
            options.inPreferredConfig = this.f25024s;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i7 = options.outWidth;
            int i8 = options.outHeight;
            int iX = X(this.f25025t, this.f25026u, i7, i8, this.f25027v);
            int iX2 = X(this.f25026u, this.f25025t, i8, i7, this.f25027v);
            options.inJustDecodeBounds = false;
            options.inSampleSize = W(i7, i8, iX, iX2);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iX || bitmapDecodeByteArray.getHeight() > iX2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iX, iX2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        return bitmapDecodeByteArray == null ? com.haier.globalwasher.mvp_api.volley.p.a(new com.haier.globalwasher.mvp_api.volley.l(jVar)) : com.haier.globalwasher.mvp_api.volley.p.c(bitmapDecodeByteArray, i.a(jVar));
    }

    static int W(int i7, int i8, int i9, int i10) {
        double dMin = Math.min(((double) i7) / ((double) i9), ((double) i8) / ((double) i10));
        float f8 = 1.0f;
        while (true) {
            float f9 = f25021y * f8;
            if (f9 > dMin) {
                return (int) f8;
            }
            f8 = f9;
        }
    }

    private static int X(int i7, int i8, int i9, int i10, ImageView.ScaleType scaleType) {
        if (i7 == 0 && i8 == 0) {
            return i9;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i7 == 0 ? i9 : i7;
        }
        if (i7 == 0) {
            return (int) (((double) i9) * (((double) i8) / ((double) i10)));
        }
        if (i8 == 0) {
            return i7;
        }
        double d8 = ((double) i10) / ((double) i9);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d9 = i8;
            return ((double) i7) * d8 < d9 ? (int) (d9 / d8) : i7;
        }
        double d10 = i8;
        return ((double) i7) * d8 > d10 ? (int) (d10 / d8) : i7;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected com.haier.globalwasher.mvp_api.volley.p<Bitmap> L(com.haier.globalwasher.mvp_api.volley.j jVar) {
        com.haier.globalwasher.mvp_api.volley.p<Bitmap> pVarV;
        synchronized (f25022z) {
            try {
                try {
                    pVarV = V(jVar);
                } catch (OutOfMemoryError e8) {
                    v.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(jVar.f24843b.length), F());
                    return com.haier.globalwasher.mvp_api.volley.p.a(new com.haier.globalwasher.mvp_api.volley.l(e8));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVarV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.haier.globalwasher.mvp_api.volley.n
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void g(Bitmap bitmap) {
        this.f25023r.b(bitmap);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public com.haier.globalwasher.mvp_api.volley.n.c z() {
        return com.haier.globalwasher.mvp_api.volley.n.c.LOW;
    }

    @Deprecated
    public m(String str, com.haier.globalwasher.mvp_api.moudle.b<Bitmap> bVar, int i7, int i8, Bitmap.Config config, com.haier.globalwasher.mvp_api.moudle.b bVar2) {
        this(str, bVar, i7, i8, ImageView.ScaleType.CENTER_INSIDE, config, bVar2);
    }
}
