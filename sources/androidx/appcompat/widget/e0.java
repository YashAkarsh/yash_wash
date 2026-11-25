package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public interface e0 {
    boolean b();

    boolean c();

    boolean g();

    CharSequence getTitle();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    void l(SparseArray<Parcelable> sparseArray);

    void m(int i7);

    void n();

    void o(SparseArray<Parcelable> sparseArray);

    void setIcon(int i7);

    void setIcon(Drawable drawable);

    void setLogo(int i7);

    void setMenu(Menu menu, androidx.appcompat.view.menu.n.a aVar);

    void setMenuPrepared();

    void setUiOptions(int i7);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
