package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.f4;
import c.m0;
import c.x0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class g implements k.a {
    private static final String L = "MenuBuilder";
    private static final String M = "android:menu:presenters";
    private static final String N = "android:menu:actionviewstates";
    private static final String O = "android:menu:expandedactionview";
    private static final int[] P = {1, 4, 5, 3, 2, 0};
    View A;
    private j I;
    private boolean K;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Context f1200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Resources f1201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private a f1204p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f1212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    CharSequence f1213y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    Drawable f1214z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1211w = 0;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private ArrayList<j> G = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<n>> H = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f1199J = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ArrayList<j> f1205q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ArrayList<j> f1206r = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1207s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList<j> f1208t = new ArrayList<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<j> f1209u = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1210v = true;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public interface a {
        boolean a(@m0 g gVar, @m0 MenuItem menuItem);

        void b(@m0 g gVar);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public interface b {
        boolean a(j jVar);
    }

    public g(Context context) {
        this.f1200l = context;
        this.f1201m = context.getResources();
        k0(true);
    }

    private static int E(int i7) {
        int i8 = ((-65536) & i7) >> 16;
        if (i8 >= 0) {
            int[] iArr = P;
            if (i8 < iArr.length) {
                return (i7 & 65535) | (iArr[i8] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void R(int i7, boolean z7) {
        if (i7 < 0 || i7 >= this.f1205q.size()) {
            return;
        }
        this.f1205q.remove(i7);
        if (z7) {
            N(true);
        }
    }

    private void d0(int i7, CharSequence charSequence, int i8, Drawable drawable, View view) {
        Resources resourcesF = F();
        if (view != null) {
            this.A = view;
            this.f1213y = null;
            this.f1214z = null;
        } else {
            if (i7 > 0) {
                this.f1213y = resourcesF.getText(i7);
            } else if (charSequence != null) {
                this.f1213y = charSequence;
            }
            if (i8 > 0) {
                this.f1214z = androidx.core.content.d.i(x(), i8);
            } else if (drawable != null) {
                this.f1214z = drawable;
            }
            this.A = null;
        }
        N(false);
    }

    private j h(int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        return new j(this, i7, i8, i9, i10, charSequence, i11);
    }

    private void j(boolean z7) {
        if (this.H.isEmpty()) {
            return;
        }
        m0();
        for (WeakReference<n> weakReference : this.H) {
            n nVar = weakReference.get();
            if (nVar == null) {
                this.H.remove(weakReference);
            } else {
                nVar.e(z7);
            }
        }
        l0();
    }

    private void k(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(M);
        if (sparseParcelableArray == null || this.H.isEmpty()) {
            return;
        }
        for (WeakReference<n> weakReference : this.H) {
            n nVar = weakReference.get();
            if (nVar == null) {
                this.H.remove(weakReference);
            } else {
                int iA = nVar.a();
                if (iA > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(iA)) != null) {
                    nVar.k(parcelable);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    private void k0(boolean z7) {
        boolean z8;
        if (z7) {
            z8 = this.f1201m.getConfiguration().keyboard != 1 && f4.g(ViewConfiguration.get(this.f1200l), this.f1200l);
        }
        this.f1203o = z8;
    }

    private void l(Bundle bundle) {
        Parcelable parcelableO;
        if (this.H.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference<n> weakReference : this.H) {
            n nVar = weakReference.get();
            if (nVar == null) {
                this.H.remove(weakReference);
            } else {
                int iA = nVar.a();
                if (iA > 0 && (parcelableO = nVar.o()) != null) {
                    sparseArray.put(iA, parcelableO);
                }
            }
        }
        bundle.putSparseParcelableArray(M, sparseArray);
    }

    private boolean m(s sVar, n nVar) {
        if (this.H.isEmpty()) {
            return false;
        }
        boolean zM = nVar != null ? nVar.m(sVar) : false;
        for (WeakReference<n> weakReference : this.H) {
            n nVar2 = weakReference.get();
            if (nVar2 == null) {
                this.H.remove(weakReference);
            } else if (!zM) {
                zM = nVar2.m(sVar);
            }
        }
        return zM;
    }

    private static int q(ArrayList<j> arrayList, int i7) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).i() <= i7) {
                return size + 1;
            }
        }
        return 0;
    }

    public CharSequence A() {
        return this.f1213y;
    }

    public View B() {
        return this.A;
    }

    public ArrayList<j> C() {
        u();
        return this.f1209u;
    }

    boolean D() {
        return this.E;
    }

    Resources F() {
        return this.f1201m;
    }

    public g G() {
        return this;
    }

    @m0
    public ArrayList<j> H() {
        if (!this.f1207s) {
            return this.f1206r;
        }
        this.f1206r.clear();
        int size = this.f1205q.size();
        for (int i7 = 0; i7 < size; i7++) {
            j jVar = this.f1205q.get(i7);
            if (jVar.isVisible()) {
                this.f1206r.add(jVar);
            }
        }
        this.f1207s = false;
        this.f1210v = true;
        return this.f1206r;
    }

    public boolean I() {
        return this.f1199J;
    }

    boolean J() {
        return this.f1202n;
    }

    public boolean K() {
        return this.f1203o;
    }

    void L(j jVar) {
        this.f1210v = true;
        N(true);
    }

    void M(j jVar) {
        this.f1207s = true;
        N(true);
    }

    public void N(boolean z7) {
        if (this.B) {
            this.C = true;
            if (z7) {
                this.D = true;
                return;
            }
            return;
        }
        if (z7) {
            this.f1207s = true;
            this.f1210v = true;
        }
        j(z7);
    }

    public boolean O(MenuItem menuItem, int i7) {
        return P(menuItem, null, i7);
    }

    public boolean P(MenuItem menuItem, n nVar, int i7) {
        j jVar = (j) menuItem;
        if (jVar == null || !jVar.isEnabled()) {
            return false;
        }
        boolean zN = jVar.n();
        androidx.core.view.b bVarB = jVar.b();
        boolean z7 = bVarB != null && bVarB.b();
        if (jVar.m()) {
            zN |= jVar.expandActionView();
            if (zN) {
                f(true);
            }
        } else if (jVar.hasSubMenu() || z7) {
            if ((i7 & 4) == 0) {
                f(false);
            }
            if (!jVar.hasSubMenu()) {
                jVar.A(new s(x(), this, jVar));
            }
            s sVar = (s) jVar.getSubMenu();
            if (z7) {
                bVarB.g(sVar);
            }
            zN |= m(sVar, nVar);
            if (!zN) {
                f(true);
            }
        } else if ((i7 & 1) == 0) {
            f(true);
        }
        return zN;
    }

    public void Q(int i7) {
        R(i7, true);
    }

    public void S(n nVar) {
        for (WeakReference<n> weakReference : this.H) {
            n nVar2 = weakReference.get();
            if (nVar2 == null || nVar2 == nVar) {
                this.H.remove(weakReference);
            }
        }
    }

    public void T(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(w());
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = getItem(i7);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((s) item.getSubMenu()).T(bundle);
            }
        }
        int i8 = bundle.getInt(O);
        if (i8 <= 0 || (menuItemFindItem = findItem(i8)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = getItem(i7);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(O, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((s) item.getSubMenu()).V(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(w(), sparseArray);
        }
    }

    public void W(Bundle bundle) {
        l(bundle);
    }

    public void X(a aVar) {
        this.f1204p = aVar;
    }

    public void Y(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1212x = contextMenuInfo;
    }

    public g Z(int i7) {
        this.f1211w = i7;
        return this;
    }

    protected MenuItem a(int i7, int i8, int i9, CharSequence charSequence) {
        int iE = E(i9);
        j jVarH = h(i7, i8, i9, iE, charSequence, this.f1211w);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1212x;
        if (contextMenuInfo != null) {
            jVarH.y(contextMenuInfo);
        }
        ArrayList<j> arrayList = this.f1205q;
        arrayList.add(q(arrayList, iE), jVarH);
        N(true);
        return jVarH;
    }

    void a0(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1205q.size();
        m0();
        for (int i7 = 0; i7 < size; i7++) {
            j jVar = this.f1205q.get(i7);
            if (jVar.getGroupId() == groupId && jVar.p() && jVar.isCheckable()) {
                jVar.v(jVar == menuItem);
            }
        }
        l0();
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i7, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        int i11;
        PackageManager packageManager = this.f1200l.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i10 & 1) == 0) {
            removeGroup(i7);
        }
        for (int i12 = 0; i12 < size; i12++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i12);
            int i13 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i13 < 0 ? intent : intentArr[i13]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i7, i8, i9, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i11 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i11] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(n nVar) {
        c(nVar, this.f1200l);
    }

    protected g b0(int i7) {
        d0(0, null, i7, null, null);
        return this;
    }

    public void c(n nVar, Context context) {
        this.H.add(new WeakReference<>(nVar));
        nVar.j(context, this);
        this.f1210v = true;
    }

    protected g c0(Drawable drawable) {
        d0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        j jVar = this.I;
        if (jVar != null) {
            g(jVar);
        }
        this.f1205q.clear();
        N(true);
    }

    public void clearHeader() {
        this.f1214z = null;
        this.f1213y = null;
        this.A = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        f(true);
    }

    public void d() {
        a aVar = this.f1204p;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void e() {
        this.B = true;
        clear();
        clearHeader();
        this.H.clear();
        this.B = false;
        this.C = false;
        this.D = false;
        N(true);
    }

    protected g e0(int i7) {
        d0(i7, null, 0, null, null);
        return this;
    }

    public final void f(boolean z7) {
        if (this.F) {
            return;
        }
        this.F = true;
        for (WeakReference<n> weakReference : this.H) {
            n nVar = weakReference.get();
            if (nVar == null) {
                this.H.remove(weakReference);
            } else {
                nVar.d(this, z7);
            }
        }
        this.F = false;
    }

    protected g f0(CharSequence charSequence) {
        d0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i7) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            j jVar = this.f1205q.get(i8);
            if (jVar.getItemId() == i7) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (menuItemFindItem = jVar.getSubMenu().findItem(i7)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public boolean g(j jVar) {
        boolean zG = false;
        if (!this.H.isEmpty() && this.I == jVar) {
            m0();
            for (WeakReference<n> weakReference : this.H) {
                n nVar = weakReference.get();
                if (nVar != null) {
                    zG = nVar.g(this, jVar);
                    if (zG) {
                        break;
                    }
                } else {
                    this.H.remove(weakReference);
                }
            }
            l0();
            if (zG) {
                this.I = null;
            }
        }
        return zG;
    }

    protected g g0(View view) {
        d0(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i7) {
        return this.f1205q.get(i7);
    }

    public void h0(boolean z7) {
        this.E = z7;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.K) {
            return true;
        }
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (this.f1205q.get(i7).isVisible()) {
                return true;
            }
        }
        return false;
    }

    boolean i(@m0 g gVar, @m0 MenuItem menuItem) {
        a aVar = this.f1204p;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public void i0(boolean z7) {
        this.K = z7;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i7, KeyEvent keyEvent) {
        return s(i7, keyEvent) != null;
    }

    public void j0(boolean z7) {
        if (this.f1203o == z7) {
            return;
        }
        k0(z7);
        N(false);
    }

    public void l0() {
        this.B = false;
        if (this.C) {
            this.C = false;
            N(this.D);
        }
    }

    public void m0() {
        if (this.B) {
            return;
        }
        this.B = true;
        this.C = false;
        this.D = false;
    }

    public boolean n(j jVar) {
        boolean zH = false;
        if (this.H.isEmpty()) {
            return false;
        }
        m0();
        for (WeakReference<n> weakReference : this.H) {
            n nVar = weakReference.get();
            if (nVar != null) {
                zH = nVar.h(this, jVar);
                if (zH) {
                    break;
                }
            } else {
                this.H.remove(weakReference);
            }
        }
        l0();
        if (zH) {
            this.I = jVar;
        }
        return zH;
    }

    public int o(int i7) {
        return p(i7, 0);
    }

    public int p(int i7, int i8) {
        int size = size();
        if (i8 < 0) {
            i8 = 0;
        }
        while (i8 < size) {
            if (this.f1205q.get(i8).getGroupId() == i7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i7, int i8) {
        return O(findItem(i7), i8);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i7, KeyEvent keyEvent, int i8) {
        j jVarS = s(i7, keyEvent);
        boolean zO = jVarS != null ? O(jVarS, i8) : false;
        if ((i8 & 2) != 0) {
            f(true);
        }
        return zO;
    }

    public int r(int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.f1205q.get(i8).getItemId() == i7) {
                return i8;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeGroup(int i7) {
        int iO = o(i7);
        if (iO >= 0) {
            int size = this.f1205q.size() - iO;
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (i8 >= size || this.f1205q.get(iO).getGroupId() != i7) {
                    break;
                }
                R(iO, false);
                i8 = i9;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i7) {
        R(r(i7), true);
    }

    j s(int i7, KeyEvent keyEvent) {
        ArrayList<j> arrayList = this.G;
        arrayList.clear();
        t(arrayList, i7, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zJ = J();
        for (int i8 = 0; i8 < size; i8++) {
            j jVar = arrayList.get(i8);
            char alphabeticShortcut = zJ ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zJ && alphabeticShortcut == '\b' && i7 == 67))) {
                return jVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i7, boolean z7, boolean z8) {
        int size = this.f1205q.size();
        for (int i8 = 0; i8 < size; i8++) {
            j jVar = this.f1205q.get(i8);
            if (jVar.getGroupId() == i7) {
                jVar.w(z8);
                jVar.setCheckable(z7);
            }
        }
    }

    @Override // k.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f1199J = z7;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i7, boolean z7) {
        int size = this.f1205q.size();
        for (int i8 = 0; i8 < size; i8++) {
            j jVar = this.f1205q.get(i8);
            if (jVar.getGroupId() == i7) {
                jVar.setEnabled(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i7, boolean z7) {
        int size = this.f1205q.size();
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            j jVar = this.f1205q.get(i8);
            if (jVar.getGroupId() == i7 && jVar.B(z7)) {
                z8 = true;
            }
        }
        if (z8) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f1202n = z7;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1205q.size();
    }

    void t(List<j> list, int i7, KeyEvent keyEvent) {
        boolean zJ = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i7 == 67) {
            int size = this.f1205q.size();
            for (int i8 = 0; i8 < size; i8++) {
                j jVar = this.f1205q.get(i8);
                if (jVar.hasSubMenu()) {
                    ((g) jVar.getSubMenu()).t(list, i7, keyEvent);
                }
                char alphabeticShortcut = zJ ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (((modifiers & k.a.f34392e) == ((zJ ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & k.a.f34392e)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zJ && alphabeticShortcut == '\b' && i7 == 67)) && jVar.isEnabled()) {
                        list.add(jVar);
                    }
                }
            }
        }
    }

    public void u() {
        ArrayList<j> arrayListH = H();
        if (this.f1210v) {
            boolean zF = false;
            for (WeakReference<n> weakReference : this.H) {
                n nVar = weakReference.get();
                if (nVar == null) {
                    this.H.remove(weakReference);
                } else {
                    zF |= nVar.f();
                }
            }
            if (zF) {
                this.f1208t.clear();
                this.f1209u.clear();
                int size = arrayListH.size();
                for (int i7 = 0; i7 < size; i7++) {
                    j jVar = arrayListH.get(i7);
                    if (jVar.o()) {
                        this.f1208t.add(jVar);
                    } else {
                        this.f1209u.add(jVar);
                    }
                }
            } else {
                this.f1208t.clear();
                this.f1209u.clear();
                this.f1209u.addAll(H());
            }
            this.f1210v = false;
        }
    }

    public ArrayList<j> v() {
        u();
        return this.f1208t;
    }

    protected String w() {
        return N;
    }

    public Context x() {
        return this.f1200l;
    }

    public j y() {
        return this.I;
    }

    public Drawable z() {
        return this.f1214z;
    }

    @Override // android.view.Menu
    public MenuItem add(int i7) {
        return a(0, 0, 0, this.f1201m.getString(i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7) {
        return addSubMenu(0, 0, 0, this.f1201m.getString(i7));
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, CharSequence charSequence) {
        return a(i7, i8, i9, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        j jVar = (j) a(i7, i8, i9, charSequence);
        s sVar = new s(this.f1200l, this, jVar);
        jVar.A(sVar);
        return sVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, int i10) {
        return a(i7, i8, i9, this.f1201m.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, int i10) {
        return addSubMenu(i7, i8, i9, this.f1201m.getString(i10));
    }
}
