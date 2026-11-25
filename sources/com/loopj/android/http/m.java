package com.loopj.android.http;

import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface m {
    void a(Header[] headerArr);

    void b(int i7, Header[] headerArr, byte[] bArr);

    Header[] c();

    void d(HttpResponse httpResponse) throws IOException;

    void e(boolean z7);

    void f();

    void g(int i7, Header[] headerArr, byte[] bArr, Throwable th);

    void h();

    void i(int i7, int i8);

    void j();

    void k(URI uri);

    URI l();
}
