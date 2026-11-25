package org.chromium.base;

import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38860c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f38861a = Process.myTid();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<Class<? extends q0>, q0> f38862b = new HashMap<>();

    private void a() {
    }

    public void b() {
        a();
        HashMap<Class<? extends q0>, q0> map = this.f38862b;
        this.f38862b = null;
        Iterator<q0> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public <T extends q0> T c(Class<T> cls) {
        a();
        return cls.cast(this.f38862b.get(cls));
    }

    public <T extends q0> T d(Class<T> cls) {
        a();
        return cls.cast(this.f38862b.remove(cls));
    }

    public <T extends q0> T e(Class<T> cls, T t7) {
        a();
        this.f38862b.put(cls, t7);
        return (T) c(cls);
    }
}
