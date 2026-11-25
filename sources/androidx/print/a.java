package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import c.m0;
import c.o0;
import c.t0;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8969g = "PrintHelper";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8970h = 3500;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f8971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final boolean f8972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8973k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8974l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f8975m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f8976n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8977o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f8978p = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f8979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BitmapFactory.Options f8980b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f8981c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f8982d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f8983e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f8984f = 1;

    /* JADX INFO: renamed from: androidx.print.a$a, reason: collision with other inner class name */
    class AsyncTaskC0118a extends AsyncTask<Void, Void, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellationSignal f8985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrintAttributes f8986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bitmap f8987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ PrintAttributes f8988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f8989e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptor f8990f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f8991g;

        AsyncTaskC0118a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i7, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.f8985a = cancellationSignal;
            this.f8986b = printAttributes;
            this.f8987c = bitmap;
            this.f8988d = printAttributes2;
            this.f8989e = i7;
            this.f8990f = parcelFileDescriptor;
            this.f8991g = writeResultCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable doInBackground(Void... voidArr) {
            RectF rectF;
            try {
                if (this.f8985a.isCanceled()) {
                    return null;
                }
                PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(a.this.f8979a, this.f8986b);
                Bitmap bitmapA = a.a(this.f8987c, this.f8986b.getColorMode());
                if (this.f8985a.isCanceled()) {
                    return null;
                }
                try {
                    PdfDocument.Page pageStartPage = printedPdfDocument.startPage(1);
                    boolean z7 = a.f8972j;
                    if (z7) {
                        rectF = new RectF(pageStartPage.getInfo().getContentRect());
                    } else {
                        PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(a.this.f8979a, this.f8988d);
                        PdfDocument.Page pageStartPage2 = printedPdfDocument2.startPage(1);
                        RectF rectF2 = new RectF(pageStartPage2.getInfo().getContentRect());
                        printedPdfDocument2.finishPage(pageStartPage2);
                        printedPdfDocument2.close();
                        rectF = rectF2;
                    }
                    Matrix matrixD = a.d(bitmapA.getWidth(), bitmapA.getHeight(), rectF, this.f8989e);
                    if (!z7) {
                        matrixD.postTranslate(rectF.left, rectF.top);
                        pageStartPage.getCanvas().clipRect(rectF);
                    }
                    pageStartPage.getCanvas().drawBitmap(bitmapA, matrixD, null);
                    printedPdfDocument.finishPage(pageStartPage);
                    if (this.f8985a.isCanceled()) {
                        return null;
                    }
                    printedPdfDocument.writeTo(new FileOutputStream(this.f8990f.getFileDescriptor()));
                    return null;
                } finally {
                    printedPdfDocument.close();
                    ParcelFileDescriptor parcelFileDescriptor = this.f8990f;
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (bitmapA != this.f8987c) {
                        bitmapA.recycle();
                    }
                }
            } catch (Throwable th) {
                return th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Throwable th) {
            if (this.f8985a.isCanceled()) {
                this.f8991g.onWriteCancelled();
            } else if (th == null) {
                this.f8991g.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } else {
                Log.e(a.f8969g, "Error writing printed content", th);
                this.f8991g.onWriteFailed(null);
            }
        }
    }

    public interface b {
        void a();
    }

    @t0(19)
    private class c extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Bitmap f8995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f8996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private PrintAttributes f8997e;

        c(String str, int i7, Bitmap bitmap, b bVar) {
            this.f8993a = str;
            this.f8994b = i7;
            this.f8995c = bitmap;
            this.f8996d = bVar;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            b bVar = this.f8996d;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.f8997e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f8993a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            a.this.r(this.f8997e, this.f8994b, this.f8995c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @t0(19)
    private class d extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f8999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Uri f9000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final b f9001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f9002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        PrintAttributes f9003e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        AsyncTask<Uri, Boolean, Bitmap> f9004f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Bitmap f9005g = null;

        /* JADX INFO: renamed from: androidx.print.a$d$a, reason: collision with other inner class name */
        class AsyncTaskC0119a extends AsyncTask<Uri, Boolean, Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellationSignal f9007a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PrintAttributes f9008b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PrintAttributes f9009c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f9010d;

            /* JADX INFO: renamed from: androidx.print.a$d$a$a, reason: collision with other inner class name */
            class C0120a implements CancellationSignal.OnCancelListener {
                C0120a() {
                }

                @Override // android.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    d.this.a();
                    AsyncTaskC0119a.this.cancel(false);
                }
            }

            AsyncTaskC0119a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.f9007a = cancellationSignal;
                this.f9008b = printAttributes;
                this.f9009c = printAttributes2;
                this.f9010d = layoutResultCallback;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Bitmap doInBackground(Uri... uriArr) {
                try {
                    d dVar = d.this;
                    return a.this.i(dVar.f9000b);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onCancelled(Bitmap bitmap) {
                this.f9010d.onLayoutCancelled();
                d.this.f9004f = null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Bitmap bitmap) {
                PrintAttributes.MediaSize mediaSize;
                super.onPostExecute(bitmap);
                if (bitmap != null && (!a.f8971i || a.this.f8984f == 0)) {
                    synchronized (this) {
                        mediaSize = d.this.f9003e.getMediaSize();
                    }
                    if (mediaSize != null && mediaSize.isPortrait() != a.g(bitmap)) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    }
                }
                d.this.f9005g = bitmap;
                if (bitmap != null) {
                    this.f9010d.onLayoutFinished(new PrintDocumentInfo.Builder(d.this.f8999a).setContentType(1).setPageCount(1).build(), true ^ this.f9008b.equals(this.f9009c));
                } else {
                    this.f9010d.onLayoutFailed(null);
                }
                d.this.f9004f = null;
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                this.f9007a.setOnCancelListener(new C0120a());
            }
        }

        d(String str, Uri uri, b bVar, int i7) {
            this.f8999a = str;
            this.f9000b = uri;
            this.f9001c = bVar;
            this.f9002d = i7;
        }

        void a() {
            synchronized (a.this.f8981c) {
                BitmapFactory.Options options = a.this.f8980b;
                if (options != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    a.this.f8980b = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f9004f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            b bVar = this.f9001c;
            if (bVar != null) {
                bVar.a();
            }
            Bitmap bitmap = this.f9005g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f9005g = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.f9003e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f9005g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f8999a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.f9004f = new AsyncTaskC0119a(cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            a.this.r(this.f9003e, this.f9002d, this.f9005g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        int i7 = Build.VERSION.SDK_INT;
        f8971i = i7 > 23;
        f8972j = i7 != 23;
    }

    public a(@m0 Context context) {
        this.f8979a = context;
    }

    static Bitmap a(Bitmap bitmap, int i7) {
        if (i7 != 1) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    @t0(19)
    private static PrintAttributes.Builder b(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix d(int i7, int i8, RectF rectF, int i9) {
        Matrix matrix = new Matrix();
        float f8 = i7;
        float fWidth = rectF.width() / f8;
        float fMax = i9 == 2 ? Math.max(fWidth, rectF.height() / i8) : Math.min(fWidth, rectF.height() / i8);
        matrix.postScale(fMax, fMax);
        matrix.postTranslate((rectF.width() - (f8 * fMax)) / 2.0f, (rectF.height() - (i8 * fMax)) / 2.0f);
        return matrix;
    }

    static boolean g(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private Bitmap h(Uri uri, BitmapFactory.Options options) throws Throwable {
        Context context;
        if (uri == null || (context = this.f8979a) == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e8) {
                        Log.w(f8969g, "close fail ", e8);
                    }
                }
                return bitmapDecodeStream;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                        Log.w(f8969g, "close fail ", e9);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean q() {
        return true;
    }

    public int c() {
        return this.f8983e;
    }

    public int e() {
        int i7 = this.f8984f;
        if (i7 == 0) {
            return 1;
        }
        return i7;
    }

    public int f() {
        return this.f8982d;
    }

    Bitmap i(Uri uri) throws Throwable {
        BitmapFactory.Options options;
        if (uri == null || this.f8979a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        h(uri, options2);
        int i7 = options2.outWidth;
        int i8 = options2.outHeight;
        if (i7 > 0 && i8 > 0) {
            int iMax = Math.max(i7, i8);
            int i9 = 1;
            while (iMax > 3500) {
                iMax >>>= 1;
                i9 <<= 1;
            }
            if (i9 > 0 && Math.min(i7, i8) / i9 > 0) {
                synchronized (this.f8981c) {
                    options = new BitmapFactory.Options();
                    this.f8980b = options;
                    options.inMutable = true;
                    options.inSampleSize = i9;
                }
                try {
                    Bitmap bitmapH = h(uri, options);
                    synchronized (this.f8981c) {
                        this.f8980b = null;
                    }
                    return bitmapH;
                } catch (Throwable th) {
                    synchronized (this.f8981c) {
                        this.f8980b = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    public void j(@m0 String str, @m0 Bitmap bitmap) {
        k(str, bitmap, null);
    }

    public void k(@m0 String str, @m0 Bitmap bitmap, @o0 b bVar) {
        if (bitmap == null) {
            return;
        }
        ((PrintManager) this.f8979a.getSystemService("print")).print(str, new c(str, this.f8982d, bitmap, bVar), new PrintAttributes.Builder().setMediaSize(g(bitmap) ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.f8983e).build());
    }

    public void l(@m0 String str, @m0 Uri uri) throws FileNotFoundException {
        m(str, uri, null);
    }

    public void m(@m0 String str, @m0 Uri uri, @o0 b bVar) throws FileNotFoundException {
        d dVar = new d(str, uri, bVar, this.f8982d);
        PrintManager printManager = (PrintManager) this.f8979a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f8983e);
        int i7 = this.f8984f;
        if (i7 == 1 || i7 == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i7 == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, dVar, builder.build());
    }

    public void n(int i7) {
        this.f8983e = i7;
    }

    public void o(int i7) {
        this.f8984f = i7;
    }

    public void p(int i7) {
        this.f8982d = i7;
    }

    @t0(19)
    void r(PrintAttributes printAttributes, int i7, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        new AsyncTaskC0118a(cancellationSignal, f8972j ? printAttributes : b(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build(), bitmap, printAttributes, i7, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }
}
