package com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public class g extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f32527p = "FileAsyncHttpResponseHandler";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final /* synthetic */ boolean f32528q = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private File f32529o;

    public g(File file) {
        this.f32529o = file;
    }

    @Override // com.loopj.android.http.c
    public void C(int i7, Header[] headerArr, byte[] bArr) {
        N(i7, headerArr, H());
    }

    protected File H() {
        return this.f32529o;
    }

    protected File I(Context context) {
        try {
            return File.createTempFile("temp_", "_handled", context.getCacheDir());
        } catch (Throwable th) {
            Log.e(f32527p, "Cannot create temporary file", th);
            return null;
        }
    }

    public void J(int i7, Throwable th, File file) {
        L(th, file);
    }

    public void K(int i7, Header[] headerArr, Throwable th, File file) {
        J(i7, th, file);
    }

    public void L(Throwable th, File file) {
        u(th);
    }

    public void M(int i7, File file) {
        O(file);
    }

    public void N(int i7, Header[] headerArr, File file) {
        M(i7, file);
    }

    public void O(File file) {
    }

    @Override // com.loopj.android.http.c
    byte[] n(HttpEntity httpEntity) throws IOException {
        if (httpEntity == null) {
            return null;
        }
        InputStream content = httpEntity.getContent();
        long contentLength = httpEntity.getContentLength();
        FileOutputStream fileOutputStream = new FileOutputStream(H());
        if (content == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            int i7 = 0;
            while (true) {
                int i8 = content.read(bArr);
                if (i8 == -1 || Thread.currentThread().isInterrupted()) {
                    break;
                }
                i7 += i8;
                fileOutputStream.write(bArr, 0, i8);
                i(i7, (int) contentLength);
            }
            content.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return null;
        } catch (Throwable th) {
            content.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // com.loopj.android.http.c
    public void t(int i7, Header[] headerArr, byte[] bArr, Throwable th) {
        K(i7, headerArr, th, H());
    }

    public g(Context context) {
        this.f32529o = I(context);
    }
}
