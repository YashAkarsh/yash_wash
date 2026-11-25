package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.core.view.n4;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public interface f0 {
    int A();

    void B(int i7);

    n4 C(int i7, long j7);

    void D(int i7);

    void E(int i7);

    void F(androidx.appcompat.view.menu.n.a aVar, androidx.appcompat.view.menu.g.a aVar2);

    ViewGroup G();

    void H(boolean z7);

    void I(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    void J(SparseArray<Parcelable> sparseArray);

    CharSequence K();

    int L();

    int M();

    void N(int i7);

    void O(View view);

    void P();

    int Q();

    void R();

    void S(Drawable drawable);

    void T(boolean z7);

    void a(Drawable drawable);

    boolean b();

    boolean c();

    void collapseActionView();

    Context d();

    int e();

    int f();

    boolean g();

    CharSequence getTitle();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    void l(int i7);

    void m();

    View n();

    void o(ScrollingTabContainerView scrollingTabContainerView);

    void p(Drawable drawable);

    boolean q();

    boolean r();

    void s(int i7);

    void setIcon(int i7);

    void setIcon(Drawable drawable);

    void setLogo(int i7);

    void setMenu(Menu menu, androidx.appcompat.view.menu.n.a aVar);

    void setMenuPrepared();

    void setTitle(CharSequence charSequence);

    void setVisibility(int i7);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(CharSequence charSequence);

    void u(CharSequence charSequence);

    void v(Drawable drawable);

    void w(SparseArray<Parcelable> sparseArray);

    void x(int i7);

    Menu y();

    boolean z();
}
