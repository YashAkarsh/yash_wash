package androidx.emoji2.viewsintegration;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.q;
import c.m0;
import c.o0;
import c.z;

/* JADX INFO: loaded from: classes.dex */
final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f7705a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @z("INSTANCE_LOCK")
    private static volatile Editable.Factory f7706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private static Class<?> f7707c;

    @SuppressLint({"PrivateApi"})
    private b() {
        try {
            f7707c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f7706b == null) {
            synchronized (f7705a) {
                if (f7706b == null) {
                    f7706b = new b();
                }
            }
        }
        return f7706b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@m0 CharSequence charSequence) {
        Class<?> cls = f7707c;
        return cls != null ? q.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
