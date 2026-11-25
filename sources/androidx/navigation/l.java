package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import c.b0;
import c.m0;
import c.o0;
import c.x0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f8878i = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f8880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f8883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<i> f8884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.collection.j<d> f8885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HashMap<String, f> f8886h;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
        Class<?> value();
    }

    static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final l f8887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        private final Bundle f8888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f8889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f8890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f8891e;

        b(@m0 l lVar, @o0 Bundle bundle, boolean z7, boolean z8, int i7) {
            this.f8887a = lVar;
            this.f8888b = bundle;
            this.f8889c = z7;
            this.f8890d = z8;
            this.f8891e = i7;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@m0 b bVar) {
            boolean z7 = this.f8889c;
            if (z7 && !bVar.f8889c) {
                return 1;
            }
            if (!z7 && bVar.f8889c) {
                return -1;
            }
            Bundle bundle = this.f8888b;
            if (bundle != null && bVar.f8888b == null) {
                return 1;
            }
            if (bundle == null && bVar.f8888b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - bVar.f8888b.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z8 = this.f8890d;
            if (z8 && !bVar.f8890d) {
                return 1;
            }
            if (z8 || !bVar.f8890d) {
                return this.f8891e - bVar.f8891e;
            }
            return -1;
        }

        @m0
        l b() {
            return this.f8887a;
        }

        @o0
        Bundle c() {
            return this.f8888b;
        }
    }

    public l(@m0 w<? extends l> wVar) {
        this(x.c(wVar.getClass()));
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    static String l(@m0 Context context, int i7) {
        if (i7 <= 16777215) {
            return Integer.toString(i7);
        }
        try {
            return context.getResources().getResourceName(i7);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i7);
        }
    }

    @m0
    protected static <C> Class<? extends C> v(@m0 Context context, @m0 String str, @m0 Class<? extends C> cls) {
        if (str.charAt(0) == '.') {
            str = context.getPackageName() + str;
        }
        HashMap<String, Class<?>> map = f8878i;
        Class<? extends C> cls2 = (Class<? extends C>) map.get(str);
        if (cls2 == null) {
            try {
                cls2 = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                map.put(str, cls2);
            } catch (ClassNotFoundException e8) {
                throw new IllegalArgumentException(e8);
            }
        }
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        throw new IllegalArgumentException(str + " must be a subclass of " + cls);
    }

    public final void A(@m0 String str) {
        HashMap<String, f> map = this.f8886h;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    public final void B(@b0 int i7) {
        this.f8881c = i7;
        this.f8882d = null;
    }

    public final void D(@o0 CharSequence charSequence) {
        this.f8883e = charSequence;
    }

    final void F(n nVar) {
        this.f8880b = nVar;
    }

    boolean G() {
        return true;
    }

    public final void a(@m0 String str, @m0 f fVar) {
        if (this.f8886h == null) {
            this.f8886h = new HashMap<>();
        }
        this.f8886h.put(str, fVar);
    }

    public final void b(@m0 i iVar) {
        if (this.f8884f == null) {
            this.f8884f = new ArrayList<>();
        }
        this.f8884f.add(iVar);
    }

    public final void d(@m0 String str) {
        b(new i.a().g(str).a());
    }

    @o0
    Bundle f(@o0 Bundle bundle) {
        HashMap<String, f> map;
        if (bundle == null && ((map = this.f8886h) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, f> map2 = this.f8886h;
        if (map2 != null) {
            for (Map.Entry<String, f> entry : map2.entrySet()) {
                entry.getValue().e(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, f> map3 = this.f8886h;
            if (map3 != null) {
                for (Map.Entry<String, f> entry2 : map3.entrySet()) {
                    if (!entry2.getValue().f(entry2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().b().c() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    @m0
    int[] g() {
        ArrayDeque arrayDeque = new ArrayDeque();
        l lVar = this;
        while (true) {
            n nVarP = lVar.p();
            if (nVarP == null || nVarP.O() != lVar.m()) {
                arrayDeque.addFirst(lVar);
            }
            if (nVarP == null) {
                break;
            }
            lVar = nVarP;
        }
        int[] iArr = new int[arrayDeque.size()];
        Iterator it = arrayDeque.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr[i7] = ((l) it.next()).m();
            i7++;
        }
        return iArr;
    }

    @o0
    public final d h(@b0 int i7) {
        androidx.collection.j<d> jVar = this.f8885g;
        d dVarM = jVar == null ? null : jVar.m(i7);
        if (dVarM != null) {
            return dVarM;
        }
        if (p() != null) {
            return p().h(i7);
        }
        return null;
    }

    @m0
    public final Map<String, f> j() {
        HashMap<String, f> map = this.f8886h;
        return map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public String k() {
        if (this.f8882d == null) {
            this.f8882d = Integer.toString(this.f8881c);
        }
        return this.f8882d;
    }

    @b0
    public final int m() {
        return this.f8881c;
    }

    @o0
    public final CharSequence n() {
        return this.f8883e;
    }

    @m0
    public final String o() {
        return this.f8879a;
    }

    @o0
    public final n p() {
        return this.f8880b;
    }

    public boolean r(@m0 Uri uri) {
        return s(new k(uri, null, null));
    }

    public boolean s(@m0 k kVar) {
        return t(kVar) != null;
    }

    @o0
    b t(@m0 k kVar) {
        ArrayList<i> arrayList = this.f8884f;
        if (arrayList == null) {
            return null;
        }
        b bVar = null;
        for (i iVar : arrayList) {
            Uri uriC = kVar.c();
            Bundle bundleC = uriC != null ? iVar.c(uriC, j()) : null;
            String strA = kVar.a();
            boolean z7 = strA != null && strA.equals(iVar.b());
            String strB = kVar.b();
            int iE = strB != null ? iVar.e(strB) : -1;
            if (bundleC != null || z7 || iE > -1) {
                b bVar2 = new b(this, bundleC, iVar.g(), z7, iE);
                if (bVar == null || bVar2.compareTo(bVar) > 0) {
                    bVar = bVar2;
                }
            }
        }
        return bVar;
    }

    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.f8882d;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.f8881c));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.f8883e != null) {
            sb.append(" label=");
            sb.append(this.f8883e);
        }
        return sb.toString();
    }

    @c.i
    public void u(@m0 Context context, @m0 AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.Navigator);
        B(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
        this.f8882d = l(context, this.f8881c);
        D(typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label));
        typedArrayObtainAttributes.recycle();
    }

    public final void w(@b0 int i7, @b0 int i8) {
        x(i7, new d(i8));
    }

    public final void x(@b0 int i7, @m0 d dVar) {
        if (G()) {
            if (i7 == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            if (this.f8885g == null) {
                this.f8885g = new androidx.collection.j<>();
            }
            this.f8885g.s(i7, dVar);
            return;
        }
        throw new UnsupportedOperationException("Cannot add action " + i7 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void z(@b0 int i7) {
        androidx.collection.j<d> jVar = this.f8885g;
        if (jVar == null) {
            return;
        }
        jVar.v(i7);
    }

    public l(@m0 String str) {
        this.f8879a = str;
    }
}
