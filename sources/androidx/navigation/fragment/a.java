package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.v;
import androidx.navigation.l;
import androidx.navigation.t;
import androidx.navigation.w;
import androidx.navigation.x;
import c.i;
import c.m0;
import c.o0;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@w.b("fragment")
public class a extends w<C0113a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8815e = "FragmentNavigator";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8816f = "androidx-nav-fragment:navigator:backStackIds";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentManager f8818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayDeque<Integer> f8820d = new ArrayDeque<>();

    /* JADX INFO: renamed from: androidx.navigation.fragment.a$a, reason: collision with other inner class name */
    @l.a(Fragment.class)
    public static class C0113a extends l {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f8821j;

        public C0113a(@m0 x xVar) {
            this((w<? extends C0113a>) xVar.d(a.class));
        }

        @m0
        public final String H() {
            String str = this.f8821j;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        @m0
        public final C0113a I(@m0 String str) {
            this.f8821j = str;
            return this;
        }

        @Override // androidx.navigation.l
        @m0
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f8821j;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            return sb.toString();
        }

        @Override // androidx.navigation.l
        @i
        public void u(@m0 Context context, @m0 AttributeSet attributeSet) {
            super.u(context, attributeSet);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            String string = typedArrayObtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                I(string);
            }
            typedArrayObtainAttributes.recycle();
        }

        public C0113a(@m0 w<? extends C0113a> wVar) {
            super(wVar);
        }
    }

    public static final class b implements w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LinkedHashMap<View, String> f8822a;

        /* JADX INFO: renamed from: androidx.navigation.fragment.a$b$a, reason: collision with other inner class name */
        public static final class C0114a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final LinkedHashMap<View, String> f8823a = new LinkedHashMap<>();

            @m0
            public C0114a a(@m0 View view, @m0 String str) {
                this.f8823a.put(view, str);
                return this;
            }

            @m0
            public C0114a b(@m0 Map<View, String> map) {
                for (Map.Entry<View, String> entry : map.entrySet()) {
                    View key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null && value != null) {
                        a(key, value);
                    }
                }
                return this;
            }

            @m0
            public b c() {
                return new b(this.f8823a);
            }
        }

        b(Map<View, String> map) {
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this.f8822a = linkedHashMap;
            linkedHashMap.putAll(map);
        }

        @m0
        public Map<View, String> a() {
            return Collections.unmodifiableMap(this.f8822a);
        }
    }

    public a(@m0 Context context, @m0 FragmentManager fragmentManager, int i7) {
        this.f8817a = context;
        this.f8818b = fragmentManager;
        this.f8819c = i7;
    }

    @m0
    private String g(int i7, int i8) {
        return i7 + "-" + i8;
    }

    @Override // androidx.navigation.w
    public void c(@o0 Bundle bundle) {
        int[] intArray;
        if (bundle == null || (intArray = bundle.getIntArray(f8816f)) == null) {
            return;
        }
        this.f8820d.clear();
        for (int i7 : intArray) {
            this.f8820d.add(Integer.valueOf(i7));
        }
    }

    @Override // androidx.navigation.w
    @o0
    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f8820d.size()];
        Iterator<Integer> it = this.f8820d.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr[i7] = it.next().intValue();
            i7++;
        }
        bundle.putIntArray(f8816f, iArr);
        return bundle;
    }

    @Override // androidx.navigation.w
    public boolean e() {
        if (this.f8820d.isEmpty()) {
            return false;
        }
        if (this.f8818b.Y0()) {
            Log.i(f8815e, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.f8818b.n1(g(this.f8820d.size(), this.f8820d.peekLast().intValue()), 1);
        this.f8820d.removeLast();
        return true;
    }

    @Override // androidx.navigation.w
    @m0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0113a a() {
        return new C0113a(this);
    }

    @m0
    @Deprecated
    public Fragment h(@m0 Context context, @m0 FragmentManager fragmentManager, @m0 String str, @o0 Bundle bundle) {
        return fragmentManager.E0().a(context.getClassLoader(), str);
    }

    @Override // androidx.navigation.w
    @o0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public l b(@m0 C0113a c0113a, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar) {
        if (this.f8818b.Y0()) {
            Log.i(f8815e, "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String strH = c0113a.H();
        boolean z7 = false;
        if (strH.charAt(0) == '.') {
            strH = this.f8817a.getPackageName() + strH;
        }
        Fragment fragmentH = h(this.f8817a, this.f8818b, strH, bundle);
        fragmentH.setArguments(bundle);
        v vVarR = this.f8818b.r();
        int iA = tVar != null ? tVar.a() : -1;
        int iB = tVar != null ? tVar.b() : -1;
        int iC = tVar != null ? tVar.c() : -1;
        int iD = tVar != null ? tVar.d() : -1;
        if (iA != -1 || iB != -1 || iC != -1 || iD != -1) {
            if (iA == -1) {
                iA = 0;
            }
            if (iB == -1) {
                iB = 0;
            }
            if (iC == -1) {
                iC = 0;
            }
            if (iD == -1) {
                iD = 0;
            }
            vVarR.O(iA, iB, iC, iD);
        }
        vVarR.D(this.f8819c, fragmentH);
        vVarR.Q(fragmentH);
        int iM = c0113a.m();
        boolean zIsEmpty = this.f8820d.isEmpty();
        boolean z8 = tVar != null && !zIsEmpty && tVar.g() && this.f8820d.peekLast().intValue() == iM;
        if (zIsEmpty) {
            z7 = true;
        } else if (!z8) {
            vVarR.p(g(this.f8820d.size() + 1, iM));
            z7 = true;
        } else if (this.f8820d.size() > 1) {
            this.f8818b.n1(g(this.f8820d.size(), this.f8820d.peekLast().intValue()), 1);
            vVarR.p(g(this.f8820d.size(), iM));
        }
        if (aVar instanceof b) {
            for (Map.Entry<View, String> entry : ((b) aVar).a().entrySet()) {
                vVarR.o(entry.getKey(), entry.getValue());
            }
        }
        vVarR.R(true);
        vVarR.r();
        if (!z7) {
            return null;
        }
        this.f8820d.add(Integer.valueOf(iM));
        return c0113a;
    }
}
