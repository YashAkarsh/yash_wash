package com.airbnb.lottie.model;

import androidx.core.util.s;
import c.o0;
import c.x0;
import com.alipay.sdk.util.j;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    T f12091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    T f12092b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t7, T t8) {
        this.f12091a = t7;
        this.f12092b = t8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return a(sVar.f6387a, this.f12091a) && a(sVar.f6388b, this.f12092b);
    }

    public int hashCode() {
        T t7 = this.f12091a;
        int iHashCode = t7 == null ? 0 : t7.hashCode();
        T t8 = this.f12092b;
        return iHashCode ^ (t8 != null ? t8.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f12091a) + " " + String.valueOf(this.f12092b) + j.f13808d;
    }
}
