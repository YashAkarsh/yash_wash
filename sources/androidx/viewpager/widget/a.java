package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11131c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11132d = -2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSetObservable f11133a = new DataSetObservable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f11134b;

    @Deprecated
    public void a(@m0 View view, int i7, @m0 Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void b(@m0 ViewGroup viewGroup, int i7, @m0 Object obj) {
        a(viewGroup, i7, obj);
    }

    @Deprecated
    public void c(@m0 View view) {
    }

    public void d(@m0 ViewGroup viewGroup) {
        c(viewGroup);
    }

    public abstract int e();

    public int f(@m0 Object obj) {
        return -1;
    }

    @o0
    public CharSequence g(int i7) {
        return null;
    }

    public float h(int i7) {
        return 1.0f;
    }

    @m0
    @Deprecated
    public Object i(@m0 View view, int i7) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @m0
    public Object j(@m0 ViewGroup viewGroup, int i7) {
        return i(viewGroup, i7);
    }

    public abstract boolean k(@m0 View view, @m0 Object obj);

    public void l() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f11134b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f11133a.notifyChanged();
    }

    public void m(@m0 DataSetObserver dataSetObserver) {
        this.f11133a.registerObserver(dataSetObserver);
    }

    public void n(@o0 Parcelable parcelable, @o0 ClassLoader classLoader) {
    }

    @o0
    public Parcelable o() {
        return null;
    }

    @Deprecated
    public void p(@m0 View view, int i7, @m0 Object obj) {
    }

    public void q(@m0 ViewGroup viewGroup, int i7, @m0 Object obj) {
        p(viewGroup, i7, obj);
    }

    void r(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f11134b = dataSetObserver;
        }
    }

    @Deprecated
    public void s(@m0 View view) {
    }

    public void t(@m0 ViewGroup viewGroup) {
        s(viewGroup);
    }

    public void u(@m0 DataSetObserver dataSetObserver) {
        this.f11133a.unregisterObserver(dataSetObserver);
    }
}
