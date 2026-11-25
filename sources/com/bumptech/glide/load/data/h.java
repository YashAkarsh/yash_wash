package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.p;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<T> implements c<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14207d = "LocalUriFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f14208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f14210c;

    public h(Context context, Uri uri) {
        this.f14209b = context.getApplicationContext();
        this.f14208a = uri;
    }

    @Override // com.bumptech.glide.load.data.c
    public String a() {
        return this.f14208a.toString();
    }

    @Override // com.bumptech.glide.load.data.c
    public void b() {
        T t7 = this.f14210c;
        if (t7 != null) {
            try {
                d(t7);
            } catch (IOException e8) {
                if (Log.isLoggable(f14207d, 2)) {
                    Log.v(f14207d, "failed to close data", e8);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final T c(p pVar) throws Exception {
        T tE = e(this.f14208a, this.f14209b.getContentResolver());
        this.f14210c = tE;
        return tE;
    }

    @Override // com.bumptech.glide.load.data.c
    public void cancel() {
    }

    protected abstract void d(T t7) throws IOException;

    protected abstract T e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
