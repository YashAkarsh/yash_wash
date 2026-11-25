package androidx.activity.result;

import android.annotation.SuppressLint;
import androidx.core.app.i;
import c.j0;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<I> {
    @m0
    public abstract b.a<I, ?> a();

    public void b(@SuppressLint({"UnknownNullness"}) I i7) {
        c(i7, null);
    }

    public abstract void c(@SuppressLint({"UnknownNullness"}) I i7, @o0 i iVar);

    @j0
    public abstract void d();
}
