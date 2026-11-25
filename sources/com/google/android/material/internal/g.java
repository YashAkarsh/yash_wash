package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import c.b1;
import c.h0;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class g implements androidx.appcompat.view.menu.n {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f17804w = "android:menu:list";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f17805x = "android:menu:adapter";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f17806y = "android:menu:header";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NavigationMenuView f17807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LinearLayout f17808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.appcompat.view.menu.n.a f17809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    androidx.appcompat.view.menu.g f17810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    c f17812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LayoutInflater f17813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f17814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f17815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    ColorStateList f17816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ColorStateList f17817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Drawable f17818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f17819m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f17820n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f17821o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f17822p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17824r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17825s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f17826t;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f17823q = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f17827u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final View.OnClickListener f17828v = new a();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z7 = true;
            g.this.N(true);
            androidx.appcompat.view.menu.j itemData = ((NavigationMenuItemView) view).getItemData();
            g gVar = g.this;
            boolean zP = gVar.f17810d.P(itemData, gVar, 0);
            if (itemData != null && itemData.isCheckable() && zP) {
                g.this.f17812f.O(itemData);
            } else {
                z7 = false;
            }
            g.this.N(false);
            if (z7) {
                g.this.e(false);
            }
        }
    }

    private static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    private class c extends RecyclerView.g<l> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f17830g = "android:menu:checked";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f17831h = "android:menu:action_views";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f17832i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f17833j = 1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f17834k = 2;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f17835l = 3;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList<e> f17836c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.appcompat.view.menu.j f17837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17838e;

        c() {
            M();
        }

        private void F(int i7, int i8) {
            while (i7 < i8) {
                ((C0200g) this.f17836c.get(i7)).f17843b = true;
                i7++;
            }
        }

        private void M() {
            if (this.f17838e) {
                return;
            }
            boolean z7 = true;
            this.f17838e = true;
            this.f17836c.clear();
            this.f17836c.add(new d());
            int size = g.this.f17810d.H().size();
            int i7 = -1;
            int i8 = 0;
            boolean z8 = false;
            int size2 = 0;
            while (i8 < size) {
                androidx.appcompat.view.menu.j jVar = g.this.f17810d.H().get(i8);
                if (jVar.isChecked()) {
                    O(jVar);
                }
                if (jVar.isCheckable()) {
                    jVar.w(false);
                }
                if (jVar.hasSubMenu()) {
                    SubMenu subMenu = jVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i8 != 0) {
                            this.f17836c.add(new f(g.this.f17826t, 0));
                        }
                        this.f17836c.add(new C0200g(jVar));
                        int size3 = this.f17836c.size();
                        int size4 = subMenu.size();
                        int i9 = 0;
                        boolean z9 = false;
                        while (i9 < size4) {
                            androidx.appcompat.view.menu.j jVar2 = (androidx.appcompat.view.menu.j) subMenu.getItem(i9);
                            if (jVar2.isVisible()) {
                                if (!z9 && jVar2.getIcon() != null) {
                                    z9 = z7;
                                }
                                if (jVar2.isCheckable()) {
                                    jVar2.w(false);
                                }
                                if (jVar.isChecked()) {
                                    O(jVar);
                                }
                                this.f17836c.add(new C0200g(jVar2));
                            }
                            i9++;
                            z7 = true;
                        }
                        if (z9) {
                            F(size3, this.f17836c.size());
                        }
                    }
                } else {
                    int groupId = jVar.getGroupId();
                    if (groupId != i7) {
                        size2 = this.f17836c.size();
                        z8 = jVar.getIcon() != null;
                        if (i8 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.f17836c;
                            int i10 = g.this.f17826t;
                            arrayList.add(new f(i10, i10));
                        }
                    } else if (!z8 && jVar.getIcon() != null) {
                        F(size2, this.f17836c.size());
                        z8 = true;
                    }
                    C0200g c0200g = new C0200g(jVar);
                    c0200g.f17843b = z8;
                    this.f17836c.add(c0200g);
                    i7 = groupId;
                }
                i8++;
                z7 = true;
            }
            this.f17838e = false;
        }

        @m0
        public Bundle G() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.j jVar = this.f17837d;
            if (jVar != null) {
                bundle.putInt(f17830g, jVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f17836c.size();
            for (int i7 = 0; i7 < size; i7++) {
                e eVar = this.f17836c.get(i7);
                if (eVar instanceof C0200g) {
                    androidx.appcompat.view.menu.j jVarA = ((C0200g) eVar).a();
                    View actionView = jVarA != null ? jVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(jVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(f17831h, sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.j H() {
            return this.f17837d;
        }

        int I() {
            int i7 = g.this.f17808b.getChildCount() == 0 ? 0 : 1;
            for (int i8 = 0; i8 < g.this.f17812f.e(); i8++) {
                if (g.this.f17812f.g(i8) == 0) {
                    i7++;
                }
            }
            return i7;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public void u(@m0 l lVar, int i7) {
            int iG = g(i7);
            if (iG != 0) {
                if (iG == 1) {
                    ((TextView) lVar.f9157a).setText(((C0200g) this.f17836c.get(i7)).a().getTitle());
                    return;
                } else {
                    if (iG != 2) {
                        return;
                    }
                    f fVar = (f) this.f17836c.get(i7);
                    lVar.f9157a.setPadding(0, fVar.b(), 0, fVar.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.f9157a;
            navigationMenuItemView.setIconTintList(g.this.f17817k);
            g gVar = g.this;
            if (gVar.f17815i) {
                navigationMenuItemView.setTextAppearance(gVar.f17814h);
            }
            ColorStateList colorStateList = g.this.f17816j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = g.this.f17818l;
            n2.I1(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            C0200g c0200g = (C0200g) this.f17836c.get(i7);
            navigationMenuItemView.setNeedsEmptyIcon(c0200g.f17843b);
            navigationMenuItemView.setHorizontalPadding(g.this.f17819m);
            navigationMenuItemView.setIconPadding(g.this.f17820n);
            g gVar2 = g.this;
            if (gVar2.f17822p) {
                navigationMenuItemView.setIconSize(gVar2.f17821o);
            }
            navigationMenuItemView.setMaxLines(g.this.f17824r);
            navigationMenuItemView.g(c0200g.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        @o0
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public l w(ViewGroup viewGroup, int i7) {
            if (i7 == 0) {
                g gVar = g.this;
                return new i(gVar.f17813g, viewGroup, gVar.f17828v);
            }
            if (i7 == 1) {
                return new k(g.this.f17813g, viewGroup);
            }
            if (i7 == 2) {
                return new j(g.this.f17813g, viewGroup);
            }
            if (i7 != 3) {
                return null;
            }
            return new b(g.this.f17808b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public void B(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.f9157a).G();
            }
        }

        public void N(@m0 Bundle bundle) {
            androidx.appcompat.view.menu.j jVarA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.j jVarA2;
            int i7 = bundle.getInt(f17830g, 0);
            if (i7 != 0) {
                this.f17838e = true;
                int size = this.f17836c.size();
                for (int i8 = 0; i8 < size; i8++) {
                    e eVar = this.f17836c.get(i8);
                    if ((eVar instanceof C0200g) && (jVarA2 = ((C0200g) eVar).a()) != null && jVarA2.getItemId() == i7) {
                        O(jVarA2);
                        break;
                    }
                }
                this.f17838e = false;
                M();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f17831h);
            if (sparseParcelableArray != null) {
                int size2 = this.f17836c.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    e eVar2 = this.f17836c.get(i9);
                    if ((eVar2 instanceof C0200g) && (jVarA = ((C0200g) eVar2).a()) != null && (actionView = jVarA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(jVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void O(@m0 androidx.appcompat.view.menu.j jVar) {
            if (this.f17837d == jVar || !jVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.j jVar2 = this.f17837d;
            if (jVar2 != null) {
                jVar2.setChecked(false);
            }
            this.f17837d = jVar;
            jVar.setChecked(true);
        }

        public void P(boolean z7) {
            this.f17838e = z7;
        }

        public void Q() {
            M();
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int e() {
            return this.f17836c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public long f(int i7) {
            return i7;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int g(int i7) {
            e eVar = this.f17836c.get(i7);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof C0200g) {
                return ((C0200g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }
    }

    private static class d implements e {
        d() {
        }
    }

    private interface e {
    }

    private static class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f17841b;

        public f(int i7, int i8) {
            this.f17840a = i7;
            this.f17841b = i8;
        }

        public int a() {
            return this.f17841b;
        }

        public int b() {
            return this.f17840a;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.g$g, reason: collision with other inner class name */
    private static class C0200g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.appcompat.view.menu.j f17842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f17843b;

        C0200g(androidx.appcompat.view.menu.j jVar) {
            this.f17842a = jVar;
        }

        public androidx.appcompat.view.menu.j a() {
            return this.f17842a;
        }
    }

    private class h extends y {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.y, androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.Y0(l0.b.e(g.this.f17812f.I(), 0, false));
        }
    }

    private static class i extends l {
        public i(@m0 LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.f9157a.setOnClickListener(onClickListener);
        }
    }

    private static class j extends l {
        public j(@m0 LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class k extends l {
        public k(@m0 LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class l extends RecyclerView.d0 {
        public l(View view) {
            super(view);
        }
    }

    private void O() {
        int i7 = (this.f17808b.getChildCount() == 0 && this.f17823q) ? this.f17825s : 0;
        NavigationMenuView navigationMenuView = this.f17807a;
        navigationMenuView.setPadding(0, i7, 0, navigationMenuView.getPaddingBottom());
    }

    public void A(@m0 View view) {
        this.f17808b.removeView(view);
        if (this.f17808b.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.f17807a;
            navigationMenuView.setPadding(0, this.f17825s, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void B(boolean z7) {
        if (this.f17823q != z7) {
            this.f17823q = z7;
            O();
        }
    }

    public void C(@m0 androidx.appcompat.view.menu.j jVar) {
        this.f17812f.O(jVar);
    }

    public void D(int i7) {
        this.f17811e = i7;
    }

    public void E(@o0 Drawable drawable) {
        this.f17818l = drawable;
        e(false);
    }

    public void F(int i7) {
        this.f17819m = i7;
        e(false);
    }

    public void G(int i7) {
        this.f17820n = i7;
        e(false);
    }

    public void H(@c.q int i7) {
        if (this.f17821o != i7) {
            this.f17821o = i7;
            this.f17822p = true;
            e(false);
        }
    }

    public void I(@o0 ColorStateList colorStateList) {
        this.f17817k = colorStateList;
        e(false);
    }

    public void J(int i7) {
        this.f17824r = i7;
        e(false);
    }

    public void K(@b1 int i7) {
        this.f17814h = i7;
        this.f17815i = true;
        e(false);
    }

    public void L(@o0 ColorStateList colorStateList) {
        this.f17816j = colorStateList;
        e(false);
    }

    public void M(int i7) {
        this.f17827u = i7;
        NavigationMenuView navigationMenuView = this.f17807a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i7);
        }
    }

    public void N(boolean z7) {
        c cVar = this.f17812f;
        if (cVar != null) {
            cVar.P(z7);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public int a() {
        return this.f17811e;
    }

    public void c(@m0 View view) {
        this.f17808b.addView(view);
        NavigationMenuView navigationMenuView = this.f17807a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(androidx.appcompat.view.menu.g gVar, boolean z7) {
        androidx.appcompat.view.menu.n.a aVar = this.f17809c;
        if (aVar != null) {
            aVar.d(gVar, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        c cVar = this.f17812f;
        if (cVar != null) {
            cVar.Q();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean g(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean h(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void i(androidx.appcompat.view.menu.n.a aVar) {
        this.f17809c = aVar;
    }

    @Override // androidx.appcompat.view.menu.n
    public void j(@m0 Context context, @m0 androidx.appcompat.view.menu.g gVar) {
        this.f17813g = LayoutInflater.from(context);
        this.f17810d = gVar;
        this.f17826t = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.n
    public void k(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f17807a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(f17805x);
            if (bundle2 != null) {
                this.f17812f.N(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray(f17806y);
            if (sparseParcelableArray2 != null) {
                this.f17808b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void l(@m0 w5 w5Var) {
        int iR = w5Var.r();
        if (this.f17825s != iR) {
            this.f17825s = iR;
            O();
        }
        NavigationMenuView navigationMenuView = this.f17807a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, w5Var.o());
        n2.p(this.f17808b, w5Var);
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean m(androidx.appcompat.view.menu.s sVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public androidx.appcompat.view.menu.o n(ViewGroup viewGroup) {
        if (this.f17807a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f17813g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f17807a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f17807a));
            if (this.f17812f == null) {
                this.f17812f = new c();
            }
            int i7 = this.f17827u;
            if (i7 != -1) {
                this.f17807a.setOverScrollMode(i7);
            }
            this.f17808b = (LinearLayout) this.f17813g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f17807a, false);
            this.f17807a.setAdapter(this.f17812f);
        }
        return this.f17807a;
    }

    @Override // androidx.appcompat.view.menu.n
    @m0
    public Parcelable o() {
        Bundle bundle = new Bundle();
        if (this.f17807a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f17807a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f17812f;
        if (cVar != null) {
            bundle.putBundle(f17805x, cVar.G());
        }
        if (this.f17808b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f17808b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(f17806y, sparseArray2);
        }
        return bundle;
    }

    @o0
    public androidx.appcompat.view.menu.j p() {
        return this.f17812f.H();
    }

    public int q() {
        return this.f17808b.getChildCount();
    }

    public View r(int i7) {
        return this.f17808b.getChildAt(i7);
    }

    @o0
    public Drawable s() {
        return this.f17818l;
    }

    public int t() {
        return this.f17819m;
    }

    public int u() {
        return this.f17820n;
    }

    public int v() {
        return this.f17824r;
    }

    @o0
    public ColorStateList w() {
        return this.f17816j;
    }

    @o0
    public ColorStateList x() {
        return this.f17817k;
    }

    public View y(@h0 int i7) {
        View viewInflate = this.f17813g.inflate(i7, (ViewGroup) this.f17808b, false);
        c(viewInflate);
        return viewInflate;
    }

    public boolean z() {
        return this.f17823q;
    }
}
