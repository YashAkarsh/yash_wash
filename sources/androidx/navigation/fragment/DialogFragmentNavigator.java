package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.navigation.l;
import androidx.navigation.t;
import androidx.navigation.w;
import androidx.navigation.x;
import c.i;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@w.b("dialog")
public final class DialogFragmentNavigator extends w<a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8806e = "DialogFragmentNavigator";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8807f = "androidx-nav-dialogfragment:navigator:count";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8808g = "androidx-nav-fragment:navigator:dialog:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentManager f8810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8811c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o f8812d = new o() { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.o
        public void g(@m0 q qVar, @m0 m.b bVar) {
            if (bVar == m.b.ON_STOP) {
                c cVar = (c) qVar;
                if (cVar.requireDialog().isShowing()) {
                    return;
                }
                b.D(cVar).I();
            }
        }
    };

    @l.a(c.class)
    public static class a extends l implements androidx.navigation.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f8814j;

        public a(@m0 x xVar) {
            this((w<? extends a>) xVar.d(DialogFragmentNavigator.class));
        }

        @m0
        public final String H() {
            String str = this.f8814j;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        @m0
        public final a I(@m0 String str) {
            this.f8814j = str;
            return this;
        }

        @Override // androidx.navigation.l
        @i
        public void u(@m0 Context context, @m0 AttributeSet attributeSet) {
            super.u(context, attributeSet);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.DialogFragmentNavigator);
            String string = typedArrayObtainAttributes.getString(R.styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                I(string);
            }
            typedArrayObtainAttributes.recycle();
        }

        public a(@m0 w<? extends a> wVar) {
            super(wVar);
        }
    }

    public DialogFragmentNavigator(@m0 Context context, @m0 FragmentManager fragmentManager) {
        this.f8809a = context;
        this.f8810b = fragmentManager;
    }

    @Override // androidx.navigation.w
    public void c(@o0 Bundle bundle) {
        if (bundle != null) {
            this.f8811c = bundle.getInt(f8807f, 0);
            for (int i7 = 0; i7 < this.f8811c; i7++) {
                c cVar = (c) this.f8810b.q0(f8808g + i7);
                if (cVar == null) {
                    throw new IllegalStateException("DialogFragment " + i7 + " doesn't exist in the FragmentManager");
                }
                cVar.getLifecycle().a(this.f8812d);
            }
        }
    }

    @Override // androidx.navigation.w
    @o0
    public Bundle d() {
        if (this.f8811c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(f8807f, this.f8811c);
        return bundle;
    }

    @Override // androidx.navigation.w
    public boolean e() {
        if (this.f8811c == 0) {
            return false;
        }
        if (this.f8810b.Y0()) {
            Log.i(f8806e, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        FragmentManager fragmentManager = this.f8810b;
        StringBuilder sb = new StringBuilder();
        sb.append(f8808g);
        int i7 = this.f8811c - 1;
        this.f8811c = i7;
        sb.append(i7);
        Fragment fragmentQ0 = fragmentManager.q0(sb.toString());
        if (fragmentQ0 != null) {
            fragmentQ0.getLifecycle().c(this.f8812d);
            ((c) fragmentQ0).dismiss();
        }
        return true;
    }

    @Override // androidx.navigation.w
    @m0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a a() {
        return new a(this);
    }

    @Override // androidx.navigation.w
    @o0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public l b(@m0 a aVar, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar2) {
        if (this.f8810b.Y0()) {
            Log.i(f8806e, "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String strH = aVar.H();
        if (strH.charAt(0) == '.') {
            strH = this.f8809a.getPackageName() + strH;
        }
        Fragment fragmentA = this.f8810b.E0().a(this.f8809a.getClassLoader(), strH);
        if (!c.class.isAssignableFrom(fragmentA.getClass())) {
            throw new IllegalArgumentException("Dialog destination " + aVar.H() + " is not an instance of DialogFragment");
        }
        c cVar = (c) fragmentA;
        cVar.setArguments(bundle);
        cVar.getLifecycle().a(this.f8812d);
        FragmentManager fragmentManager = this.f8810b;
        StringBuilder sb = new StringBuilder();
        sb.append(f8808g);
        int i7 = this.f8811c;
        this.f8811c = i7 + 1;
        sb.append(i7);
        cVar.show(fragmentManager, sb.toString());
        return aVar;
    }
}
