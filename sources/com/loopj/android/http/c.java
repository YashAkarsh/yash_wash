package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class c implements m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f32493f = "AsyncHttpResponseHandler";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final int f32494g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final int f32495h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected static final int f32496i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final int f32497j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final int f32498k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected static final int f32499l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected static final int f32500m = 4096;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f32501n = "UTF-8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f32502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f32503b = "UTF-8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f32504c = Boolean.FALSE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private URI f32505d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Header[] f32506e = null;

    static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f32507a;

        a(c cVar) {
            this.f32507a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.f32507a.get();
            if (cVar != null) {
                cVar.p(message);
            }
        }
    }

    public c() {
        if (Looper.myLooper() != null) {
            this.f32502a = new a(this);
        }
    }

    @Deprecated
    public void A(int i7, String str) {
        D(str);
    }

    @Deprecated
    public void B(int i7, Header[] headerArr, String str) {
        A(i7, str);
    }

    public void C(int i7, Header[] headerArr, byte[] bArr) {
        String str;
        if (bArr == null) {
            str = null;
        } else {
            try {
                str = new String(bArr, m());
            } catch (UnsupportedEncodingException e8) {
                Log.e(f32493f, e8.toString());
                s(i7, headerArr, e8, null);
                return;
            }
        }
        B(i7, headerArr, str);
    }

    @Deprecated
    public void D(String str) {
    }

    protected void E(Runnable runnable) {
        if (runnable != null) {
            this.f32502a.post(runnable);
        }
    }

    protected void F(Message message) {
        if (o() || this.f32502a == null) {
            p(message);
        } else {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            this.f32502a.sendMessage(message);
        }
    }

    public void G(String str) {
        this.f32503b = str;
    }

    @Override // com.loopj.android.http.m
    public void a(Header[] headerArr) {
        this.f32506e = headerArr;
    }

    @Override // com.loopj.android.http.m
    public final void b(int i7, Header[] headerArr, byte[] bArr) {
        F(q(0, new Object[]{Integer.valueOf(i7), headerArr, bArr}));
    }

    @Override // com.loopj.android.http.m
    public Header[] c() {
        return this.f32506e;
    }

    @Override // com.loopj.android.http.m
    public void d(HttpResponse httpResponse) throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        byte[] bArrN = n(httpResponse.getEntity());
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (statusLine.getStatusCode() >= 300) {
            g(statusLine.getStatusCode(), httpResponse.getAllHeaders(), bArrN, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
        } else {
            b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), bArrN);
        }
    }

    @Override // com.loopj.android.http.m
    public void e(boolean z7) {
        this.f32504c = Boolean.valueOf(z7);
    }

    @Override // com.loopj.android.http.m
    public final void f() {
        F(q(2, null));
    }

    @Override // com.loopj.android.http.m
    public final void g(int i7, Header[] headerArr, byte[] bArr, Throwable th) {
        F(q(1, new Object[]{Integer.valueOf(i7), headerArr, bArr, th}));
    }

    @Override // com.loopj.android.http.m
    public final void h() {
        F(q(3, null));
    }

    @Override // com.loopj.android.http.m
    public final void i(int i7, int i8) {
        F(q(4, new Object[]{Integer.valueOf(i7), Integer.valueOf(i8)}));
    }

    @Override // com.loopj.android.http.m
    public final void j() {
        F(q(5, null));
    }

    @Override // com.loopj.android.http.m
    public void k(URI uri) {
        this.f32505d = uri;
    }

    @Override // com.loopj.android.http.m
    public URI l() {
        return this.f32505d;
    }

    public String m() {
        String str = this.f32503b;
        return str == null ? "UTF-8" : str;
    }

    byte[] n(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength > 2147483647L) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (contentLength < 0) {
            contentLength = PlaybackStateCompat.f449y;
        }
        try {
            int i7 = (int) contentLength;
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i7);
            try {
                byte[] bArr = new byte[4096];
                int i8 = 0;
                while (true) {
                    int i9 = content.read(bArr);
                    if (i9 == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i8 += i9;
                    byteArrayBuffer.append(bArr, 0, i9);
                    i(i8, i7);
                }
                content.close();
                return byteArrayBuffer.toByteArray();
            } catch (Throwable th) {
                content.close();
                throw th;
            }
        } catch (OutOfMemoryError unused) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
        }
    }

    public boolean o() {
        return this.f32504c.booleanValue();
    }

    protected void p(Message message) {
        int i7 = message.what;
        if (i7 == 0) {
            Object[] objArr = (Object[]) message.obj;
            if (objArr == null || objArr.length < 3) {
                Log.e(f32493f, "SUCCESS_MESSAGE didn't got enough params");
                return;
            } else {
                C(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                return;
            }
        }
        if (i7 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 == null || objArr2.length < 4) {
                Log.e(f32493f, "FAILURE_MESSAGE didn't got enough params");
                return;
            } else {
                t(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                return;
            }
        }
        if (i7 == 2) {
            z();
            return;
        }
        if (i7 == 3) {
            w();
            return;
        }
        if (i7 != 4) {
            if (i7 != 5) {
                return;
            }
            y();
            return;
        }
        Object[] objArr3 = (Object[]) message.obj;
        if (objArr3 == null || objArr3.length < 2) {
            Log.e(f32493f, "PROGRESS_MESSAGE didn't got enough params");
            return;
        }
        try {
            x(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
        } catch (Throwable th) {
            Log.e(f32493f, "custom onProgress contains an error", th);
        }
    }

    protected Message q(int i7, Object obj) {
        Handler handler = this.f32502a;
        if (handler != null) {
            return handler.obtainMessage(i7, obj);
        }
        Message messageObtain = Message.obtain();
        if (messageObtain != null) {
            messageObtain.what = i7;
            messageObtain.obj = obj;
        }
        return messageObtain;
    }

    @Deprecated
    public void r(int i7, Throwable th, String str) {
        v(th, str);
    }

    @Deprecated
    public void s(int i7, Header[] headerArr, Throwable th, String str) {
        r(i7, th, str);
    }

    public void t(int i7, Header[] headerArr, byte[] bArr, Throwable th) {
        String str;
        if (bArr == null) {
            str = null;
        } else {
            try {
                str = new String(bArr, m());
            } catch (UnsupportedEncodingException e8) {
                Log.e(f32493f, e8.toString());
                s(i7, headerArr, e8, null);
                return;
            }
        }
        s(i7, headerArr, th, str);
    }

    @Deprecated
    public void u(Throwable th) {
    }

    @Deprecated
    public void v(Throwable th, String str) {
        u(th);
    }

    public void w() {
    }

    public void x(int i7, int i8) {
    }

    public void y() {
    }

    public void z() {
    }
}
