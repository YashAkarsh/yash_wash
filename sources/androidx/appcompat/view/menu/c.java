package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
abstract class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Context f1141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.collection.i<k.c, MenuItem> f1142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private androidx.collection.i<k.d, SubMenu> f1143n;

    c(Context context) {
        this.f1141l = context;
    }

    final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof k.c)) {
            return menuItem;
        }
        k.c cVar = (k.c) menuItem;
        if (this.f1142m == null) {
            this.f1142m = new androidx.collection.i<>();
        }
        MenuItem menuItem2 = this.f1142m.get(cVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        k kVar = new k(this.f1141l, cVar);
        this.f1142m.put(cVar, kVar);
        return kVar;
    }

    final SubMenu f(SubMenu subMenu) {
        if (!(subMenu instanceof k.d)) {
            return subMenu;
        }
        k.d dVar = (k.d) subMenu;
        if (this.f1143n == null) {
            this.f1143n = new androidx.collection.i<>();
        }
        SubMenu subMenu2 = this.f1143n.get(dVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        t tVar = new t(this.f1141l, dVar);
        this.f1143n.put(dVar, tVar);
        return tVar;
    }

    final void g() {
        androidx.collection.i<k.c, MenuItem> iVar = this.f1142m;
        if (iVar != null) {
            iVar.clear();
        }
        androidx.collection.i<k.d, SubMenu> iVar2 = this.f1143n;
        if (iVar2 != null) {
            iVar2.clear();
        }
    }

    final void h(int i7) {
        if (this.f1142m == null) {
            return;
        }
        int i8 = 0;
        while (i8 < this.f1142m.size()) {
            if (this.f1142m.k(i8).getGroupId() == i7) {
                this.f1142m.m(i8);
                i8--;
            }
            i8++;
        }
    }

    final void i(int i7) {
        if (this.f1142m == null) {
            return;
        }
        for (int i8 = 0; i8 < this.f1142m.size(); i8++) {
            if (this.f1142m.k(i8).getItemId() == i7) {
                this.f1142m.m(i8);
                return;
            }
        }
    }
}
