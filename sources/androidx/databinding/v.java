package androidx.databinding;

import c.o0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class v<T> extends b implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7307c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f7308b;

    public v(T t7) {
        this.f7308b = t7;
    }

    @o0
    public T g() {
        return this.f7308b;
    }

    public void h(T t7) {
        if (t7 != this.f7308b) {
            this.f7308b = t7;
            e();
        }
    }

    public v() {
    }

    public v(s... sVarArr) {
        super(sVarArr);
    }
}
