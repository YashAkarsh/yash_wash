package b;

import a7.d;
import a7.e;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static final class C0134a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f11250a;

        public C0134a(T t7) {
            this.f11250a = t7;
        }

        public final T a() {
            return this.f11250a;
        }
    }

    @d
    public abstract Intent a(@d Context context, I i7);

    @e
    public C0134a<O> b(@d Context context, I i7) {
        l0.p(context, "context");
        return null;
    }

    public abstract O c(int i7, @e Intent intent);
}
