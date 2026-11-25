package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public interface n {

    public interface a {
        void d(@m0 g gVar, boolean z7);

        boolean e(@m0 g gVar);
    }

    int a();

    void d(g gVar, boolean z7);

    void e(boolean z7);

    boolean f();

    boolean g(g gVar, j jVar);

    boolean h(g gVar, j jVar);

    void i(a aVar);

    void j(Context context, g gVar);

    void k(Parcelable parcelable);

    boolean m(s sVar);

    o n(ViewGroup viewGroup);

    Parcelable o();
}
