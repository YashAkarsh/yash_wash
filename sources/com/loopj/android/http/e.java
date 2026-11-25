package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String[] f32525o;

    public e() {
        this.f32525o = new String[]{"image/jpeg", "image/png"};
    }

    @Override // com.loopj.android.http.c
    public void C(int i7, Header[] headerArr, byte[] bArr) {
        I(i7, bArr);
    }

    public String[] H() {
        return this.f32525o;
    }

    public void I(int i7, byte[] bArr) {
        J(bArr);
    }

    public void J(byte[] bArr) {
    }

    @Override // com.loopj.android.http.c, com.loopj.android.http.m
    public final void d(HttpResponse httpResponse) throws IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            g(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        Header header = headers[0];
        boolean z7 = false;
        for (String str : H()) {
            try {
                if (Pattern.matches(str, header.getValue())) {
                    z7 = true;
                }
            } catch (PatternSyntaxException e8) {
                Log.e("BinaryHttpResponseHandler", "Given pattern is not valid: " + str, e8);
            }
        }
        if (z7) {
            super.d(httpResponse);
        } else {
            g(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"));
        }
    }

    @Override // com.loopj.android.http.c
    public void t(int i7, Header[] headerArr, byte[] bArr, Throwable th) {
        r(i7, th, null);
    }

    public e(String[] strArr) {
        this();
        this.f32525o = strArr;
    }
}
