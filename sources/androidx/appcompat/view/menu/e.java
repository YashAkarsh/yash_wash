package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class e implements n, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f1179k = "ListMenuPresenter";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f1180l = "android:menu:list";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f1181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LayoutInflater f1182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    g f1183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExpandedMenuView f1184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n.a f1188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    a f1189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1190j;

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1191a = -1;

        public a() {
            a();
        }

        void a() {
            j jVarY = e.this.f1183c.y();
            if (jVarY != null) {
                ArrayList<j> arrayListC = e.this.f1183c.C();
                int size = arrayListC.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (arrayListC.get(i7) == jVarY) {
                        this.f1191a = i7;
                        return;
                    }
                }
            }
            this.f1191a = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j getItem(int i7) {
            ArrayList<j> arrayListC = e.this.f1183c.C();
            int i8 = i7 + e.this.f1185e;
            int i9 = this.f1191a;
            if (i9 >= 0 && i8 >= i9) {
                i8++;
            }
            return arrayListC.get(i8);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f1183c.C().size() - e.this.f1185e;
            return this.f1191a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.Adapter
        public View getView(int i7, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f1182b.inflate(eVar.f1187g, viewGroup, false);
            }
            ((o.a) view).g(getItem(i7), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i7) {
        this(i7, 0);
        this.f1181a = context;
        this.f1182b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.n
    public int a() {
        return this.f1190j;
    }

    public ListAdapter b() {
        if (this.f1189i == null) {
            this.f1189i = new a();
        }
        return this.f1189i;
    }

    int c() {
        return this.f1185e;
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(g gVar, boolean z7) {
        n.a aVar = this.f1188h;
        if (aVar != null) {
            aVar.d(gVar, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        a aVar = this.f1189i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean g(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean h(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void i(n.a aVar) {
        this.f1188h = aVar;
    }

    @Override // androidx.appcompat.view.menu.n
    public void j(Context context, g gVar) {
        if (this.f1186f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1186f);
            this.f1181a = contextThemeWrapper;
            this.f1182b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1181a != null) {
            this.f1181a = context;
            if (this.f1182b == null) {
                this.f1182b = LayoutInflater.from(context);
            }
        }
        this.f1183c = gVar;
        a aVar = this.f1189i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void k(Parcelable parcelable) {
        l((Bundle) parcelable);
    }

    public void l(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(f1180l);
        if (sparseParcelableArray != null) {
            this.f1184d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean m(s sVar) {
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        new h(sVar).c(null);
        n.a aVar = this.f1188h;
        if (aVar == null) {
            return true;
        }
        aVar.e(sVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.n
    public o n(ViewGroup viewGroup) {
        if (this.f1184d == null) {
            this.f1184d = (ExpandedMenuView) this.f1182b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1189i == null) {
                this.f1189i = new a();
            }
            this.f1184d.setAdapter((ListAdapter) this.f1189i);
            this.f1184d.setOnItemClickListener(this);
        }
        return this.f1184d;
    }

    @Override // androidx.appcompat.view.menu.n
    public Parcelable o() {
        if (this.f1184d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        p(bundle);
        return bundle;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
        this.f1183c.P(this.f1189i.getItem(i7), this, 0);
    }

    public void p(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1184d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(f1180l, sparseArray);
    }

    public void q(int i7) {
        this.f1190j = i7;
    }

    public void r(int i7) {
        this.f1185e = i7;
        if (this.f1184d != null) {
            e(false);
        }
    }

    public e(int i7, int i8) {
        this.f1187g = i7;
        this.f1186f = i8;
    }
}
