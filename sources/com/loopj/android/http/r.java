package com.loopj.android.http;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public class r extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f32592o = "TextHttpResponseHandler";

    public r() {
        this("UTF-8");
    }

    @Override // com.loopj.android.http.c
    public void B(int i7, Header[] headerArr, String str) {
        A(i7, str);
    }

    @Override // com.loopj.android.http.c
    public void C(int i7, Header[] headerArr, byte[] bArr) {
        String str;
        if (bArr == null) {
            str = null;
        } else {
            try {
                str = new String(bArr, m());
            } catch (UnsupportedEncodingException e8) {
                Log.v(f32592o, "String encoding failed, calling onFailure(int, Header[], String, Throwable)");
                H(0, headerArr, null, e8);
                return;
            }
        }
        B(i7, headerArr, str);
    }

    public void H(int i7, Header[] headerArr, String str, Throwable th) {
        I(str, th);
    }

    public void I(String str, Throwable th) {
    }

    @Override // com.loopj.android.http.c
    public void t(int i7, Header[] headerArr, byte[] bArr, Throwable th) {
        String str;
        if (bArr == null) {
            str = null;
        } else {
            try {
                str = new String(bArr, m());
            } catch (UnsupportedEncodingException e8) {
                Log.v(f32592o, "String encoding failed, calling onFailure(int, Header[], String, Throwable)");
                H(0, headerArr, null, e8);
                return;
            }
        }
        H(i7, headerArr, str, th);
    }

    public r(String str) {
        G(str);
    }
}
