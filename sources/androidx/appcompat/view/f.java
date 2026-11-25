package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.p;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f1024b;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f1025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f1026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<f> f1027c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final androidx.collection.i<Menu, Menu> f1028d = new androidx.collection.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f1026b = context;
            this.f1025a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f1028d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            p pVar = new p(this.f1026b, (k.a) menu);
            this.f1028d.put(menu, pVar);
            return pVar;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b bVar) {
            this.f1025a.onDestroyActionMode(e(bVar));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f1025a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f1025a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(b bVar, MenuItem menuItem) {
            return this.f1025a.onActionItemClicked(e(bVar), new androidx.appcompat.view.menu.k(this.f1026b, (k.c) menuItem));
        }

        public ActionMode e(b bVar) {
            int size = this.f1027c.size();
            for (int i7 = 0; i7 < size; i7++) {
                f fVar = this.f1027c.get(i7);
                if (fVar != null && fVar.f1024b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1026b, bVar);
            this.f1027c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f1023a = context;
        this.f1024b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1024b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1024b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new p(this.f1023a, (k.a) this.f1024b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1024b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1024b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1024b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1024b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1024b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1024b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1024b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1024b.n(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1024b.p(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1024b.q(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1024b.s(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z7) {
        this.f1024b.t(z7);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i7) {
        this.f1024b.o(i7);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i7) {
        this.f1024b.r(i7);
    }
}
