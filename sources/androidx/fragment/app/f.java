package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.q0;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<?> f7999a;

    private f(h<?> hVar) {
        this.f7999a = hVar;
    }

    @m0
    public static f b(@m0 h<?> hVar) {
        return new f((h) androidx.core.util.w.m(hVar, "callbacks == null"));
    }

    @o0
    public Fragment A(@m0 String str) {
        return this.f7999a.f8005e.r0(str);
    }

    @m0
    public List<Fragment> B(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.f7999a.f8005e.x0();
    }

    public int C() {
        return this.f7999a.f8005e.w0();
    }

    @m0
    public FragmentManager D() {
        return this.f7999a.f8005e;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public androidx.loader.app.a E() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void F() {
        this.f7999a.f8005e.h1();
    }

    @o0
    public View G(@o0 View view, @m0 String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        return this.f7999a.f8005e.I0().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void H() {
    }

    @Deprecated
    public void I(@o0 Parcelable parcelable, @o0 l lVar) {
        this.f7999a.f8005e.D1(parcelable, lVar);
    }

    @Deprecated
    public void J(@o0 Parcelable parcelable, @o0 List<Fragment> list) {
        this.f7999a.f8005e.D1(parcelable, new l(list, null, null));
    }

    @Deprecated
    public void K(@SuppressLint({"UnknownNullness"}) androidx.collection.i<String, androidx.loader.app.a> iVar) {
    }

    public void L(@o0 Parcelable parcelable) {
        h<?> hVar = this.f7999a;
        if (!(hVar instanceof q0)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        hVar.f8005e.E1(parcelable);
    }

    @o0
    @Deprecated
    public androidx.collection.i<String, androidx.loader.app.a> M() {
        return null;
    }

    @o0
    @Deprecated
    public l N() {
        return this.f7999a.f8005e.F1();
    }

    @o0
    @Deprecated
    public List<Fragment> O() {
        l lVarF1 = this.f7999a.f8005e.F1();
        if (lVarF1 == null || lVarF1.b() == null) {
            return null;
        }
        return new ArrayList(lVarF1.b());
    }

    @o0
    public Parcelable P() {
        return this.f7999a.f8005e.H1();
    }

    public void a(@o0 Fragment fragment) {
        h<?> hVar = this.f7999a;
        hVar.f8005e.p(hVar, hVar, fragment);
    }

    public void c() {
        this.f7999a.f8005e.D();
    }

    public void d(@m0 Configuration configuration) {
        this.f7999a.f8005e.F(configuration);
    }

    public boolean e(@m0 MenuItem menuItem) {
        return this.f7999a.f8005e.G(menuItem);
    }

    public void f() {
        this.f7999a.f8005e.H();
    }

    public boolean g(@m0 Menu menu, @m0 MenuInflater menuInflater) {
        return this.f7999a.f8005e.I(menu, menuInflater);
    }

    public void h() {
        this.f7999a.f8005e.J();
    }

    public void i() {
        this.f7999a.f8005e.K();
    }

    public void j() {
        this.f7999a.f8005e.L();
    }

    public void k(boolean z7) {
        this.f7999a.f8005e.M(z7);
    }

    public boolean l(@m0 MenuItem menuItem) {
        return this.f7999a.f8005e.O(menuItem);
    }

    public void m(@m0 Menu menu) {
        this.f7999a.f8005e.P(menu);
    }

    public void n() {
        this.f7999a.f8005e.R();
    }

    public void o(boolean z7) {
        this.f7999a.f8005e.S(z7);
    }

    public boolean p(@m0 Menu menu) {
        return this.f7999a.f8005e.T(menu);
    }

    @Deprecated
    public void q() {
    }

    public void r() {
        this.f7999a.f8005e.V();
    }

    public void s() {
        this.f7999a.f8005e.W();
    }

    public void t() {
        this.f7999a.f8005e.Y();
    }

    @Deprecated
    public void u() {
    }

    @Deprecated
    public void v() {
    }

    @Deprecated
    public void w() {
    }

    @Deprecated
    public void x(boolean z7) {
    }

    @Deprecated
    public void y(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
    }

    public boolean z() {
        return this.f7999a.f8005e.h0(true);
    }
}
