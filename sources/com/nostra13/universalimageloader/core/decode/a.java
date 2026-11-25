package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.e;
import com.nostra13.universalimageloader.utils.d;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.nostra13.universalimageloader.core.decode.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f32742b = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final String f32743c = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final String f32744d = "Rotate image on %1$d° [%2$s]";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final String f32745e = "Flip image horizontally [%s]";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final String f32746f = "Image can't be decoded [%s]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f32747a;

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f32750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0399a f32751b;

        protected b(e eVar, C0399a c0399a) {
            this.f32750a = eVar;
            this.f32751b = c0399a;
        }
    }

    public a(boolean z7) {
        this.f32747a = z7;
    }

    private boolean b(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && com.nostra13.universalimageloader.core.download.c.a.c(str) == com.nostra13.universalimageloader.core.download.c.a.FILE;
    }

    @Override // com.nostra13.universalimageloader.core.decode.b
    public Bitmap a(c cVar) throws IOException {
        InputStream inputStreamF = f(cVar);
        try {
            b bVarE = e(inputStreamF, cVar);
            inputStreamF = h(inputStreamF, cVar);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamF, null, g(bVarE.f32750a, cVar));
            com.nostra13.universalimageloader.utils.c.a(inputStreamF);
            if (bitmapDecodeStream == null) {
                d.c(f32746f, cVar.g());
                return bitmapDecodeStream;
            }
            C0399a c0399a = bVarE.f32751b;
            return c(bitmapDecodeStream, cVar, c0399a.f32748a, c0399a.f32749b);
        } catch (Throwable th) {
            com.nostra13.universalimageloader.utils.c.a(inputStreamF);
            throw th;
        }
    }

    protected Bitmap c(Bitmap bitmap, c cVar, int i7, boolean z7) {
        Matrix matrix = new Matrix();
        com.nostra13.universalimageloader.core.assist.d dVarH = cVar.h();
        if (dVarH == com.nostra13.universalimageloader.core.assist.d.EXACTLY || dVarH == com.nostra13.universalimageloader.core.assist.d.EXACTLY_STRETCHED) {
            e eVar = new e(bitmap.getWidth(), bitmap.getHeight(), i7);
            float fB = com.nostra13.universalimageloader.utils.b.b(eVar, cVar.j(), cVar.k(), dVarH == com.nostra13.universalimageloader.core.assist.d.EXACTLY_STRETCHED);
            if (Float.compare(fB, 1.0f) != 0) {
                matrix.setScale(fB, fB);
                if (this.f32747a) {
                    d.a(f32743c, eVar, eVar.c(fB), Float.valueOf(fB), cVar.g());
                }
            }
        }
        if (z7) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f32747a) {
                d.a(f32745e, cVar.g());
            }
        }
        if (i7 != 0) {
            matrix.postRotate(i7);
            if (this.f32747a) {
                d.a(f32744d, Integer.valueOf(i7), cVar.g());
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected C0399a d(String str) {
        int i7;
        boolean z7 = true;
        int i8 = 0;
        try {
            switch (new ExifInterface(com.nostra13.universalimageloader.core.download.c.a.FILE.b(str)).getAttributeInt("Orientation", 1)) {
                case 1:
                default:
                    z7 = false;
                    break;
                case 2:
                    break;
                case 3:
                    z7 = false;
                    i7 = 180;
                    i8 = i7;
                    break;
                case 4:
                    i7 = 180;
                    i8 = i7;
                    break;
                case 5:
                    i7 = 270;
                    i8 = i7;
                    break;
                case 6:
                    z7 = false;
                    i7 = 90;
                    i8 = i7;
                    break;
                case 7:
                    i7 = 90;
                    i8 = i7;
                    break;
                case 8:
                    z7 = false;
                    i7 = 270;
                    i8 = i7;
                    break;
            }
        } catch (IOException unused) {
            d.i("Can't read EXIF tags from file [%s]", str);
        }
        return new C0399a(i8, z7);
    }

    protected b e(InputStream inputStream, c cVar) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String strI = cVar.i();
        C0399a c0399aD = (cVar.l() && b(strI, options.outMimeType)) ? d(strI) : new C0399a();
        return new b(new e(options.outWidth, options.outHeight, c0399aD.f32748a), c0399aD);
    }

    protected InputStream f(c cVar) throws IOException {
        return cVar.e().a(cVar.i(), cVar.f());
    }

    protected BitmapFactory.Options g(e eVar, c cVar) {
        int iA;
        com.nostra13.universalimageloader.core.assist.d dVarH = cVar.h();
        if (dVarH == com.nostra13.universalimageloader.core.assist.d.NONE) {
            iA = com.nostra13.universalimageloader.utils.b.c(eVar);
        } else {
            iA = com.nostra13.universalimageloader.utils.b.a(eVar, cVar.j(), cVar.k(), dVarH == com.nostra13.universalimageloader.core.assist.d.IN_SAMPLE_POWER_OF_2);
        }
        if (iA > 1 && this.f32747a) {
            d.a(f32742b, eVar, eVar.d(iA), Integer.valueOf(iA), cVar.g());
        }
        BitmapFactory.Options optionsD = cVar.d();
        optionsD.inSampleSize = iA;
        return optionsD;
    }

    protected InputStream h(InputStream inputStream, c cVar) throws IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            com.nostra13.universalimageloader.utils.c.a(inputStream);
            return f(cVar);
        }
    }

    /* JADX INFO: renamed from: com.nostra13.universalimageloader.core.decode.a$a, reason: collision with other inner class name */
    protected static class C0399a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f32749b;

        protected C0399a() {
            this.f32748a = 0;
            this.f32749b = false;
        }

        protected C0399a(int i7, boolean z7) {
            this.f32748a = i7;
            this.f32749b = z7;
        }
    }
}
