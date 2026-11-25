package androidx.browser.browseractions;

import android.app.PendingIntent;
import c.m0;
import c.u;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingIntent f2071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u
    private final int f2072c;

    public a(@m0 String str, @m0 PendingIntent pendingIntent, @u int i7) {
        this.f2070a = str;
        this.f2071b = pendingIntent;
        this.f2072c = i7;
    }

    public PendingIntent a() {
        return this.f2071b;
    }

    public int b() {
        return this.f2072c;
    }

    public String c() {
        return this.f2070a;
    }

    public a(@m0 String str, @m0 PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
