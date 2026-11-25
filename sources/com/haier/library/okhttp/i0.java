package com.haier.library.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface i0 {

    public interface a {
        int K();

        com.haier.library.okhttp.a a(f fVar) throws IOException;

        f a();

        a b(int i7, TimeUnit timeUnit);

        @Nullable
        v b();

        a c(int i7, TimeUnit timeUnit);

        q c();

        int d();

        a d(int i7, TimeUnit timeUnit);

        int f();
    }

    com.haier.library.okhttp.a a(a aVar) throws IOException;
}
