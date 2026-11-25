package androidx.databinding;

import android.view.View;
import c.m0;
import c.x0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public abstract class j {
    @m0
    public List<j> a() {
        return Collections.emptyList();
    }

    public abstract String b(int i7);

    public abstract ViewDataBinding c(DataBindingComponent dataBindingComponent, View view, int i7);

    public abstract ViewDataBinding d(DataBindingComponent dataBindingComponent, View[] viewArr, int i7);

    public abstract int e(String str);
}
