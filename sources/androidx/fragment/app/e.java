package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    @m0
    @Deprecated
    public Fragment b(@m0 Context context, @m0 String str, @o0 Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    @o0
    public abstract View c(@c.b0 int i7);

    public abstract boolean d();
}
