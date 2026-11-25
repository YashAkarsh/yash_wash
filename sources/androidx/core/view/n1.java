package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    public static final class a implements kotlin.sequences.m<MenuItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Menu f6720a;

        a(Menu menu) {
            this.f6720a = menu;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<MenuItem> iterator() {
            return n1.i(this.f6720a);
        }
    }

    public static final class b implements Iterator<MenuItem>, j5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Menu f6722b;

        b(Menu menu) {
            this.f6722b = menu;
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MenuItem next() {
            Menu menu = this.f6722b;
            int i7 = this.f6721a;
            this.f6721a = i7 + 1;
            MenuItem item = menu.getItem(i7);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6721a < this.f6722b.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu menu = this.f6722b;
            int i7 = this.f6721a - 1;
            this.f6721a = i7;
            menu.removeItem(i7);
        }
    }

    public static final boolean a(@a7.d Menu menu, @a7.d MenuItem item) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        kotlin.jvm.internal.l0.p(item, "item");
        int size = menu.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (kotlin.jvm.internal.l0.g(menu.getItem(i7), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void b(@a7.d Menu menu, @a7.d i5.l<? super MenuItem, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int size = menu.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = menu.getItem(i7);
            kotlin.jvm.internal.l0.o(item, "getItem(index)");
            action.z(item);
        }
    }

    public static final void c(@a7.d Menu menu, @a7.d i5.p<? super Integer, ? super MenuItem, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int size = menu.size();
        for (int i7 = 0; i7 < size; i7++) {
            Integer numValueOf = Integer.valueOf(i7);
            MenuItem item = menu.getItem(i7);
            kotlin.jvm.internal.l0.o(item, "getItem(index)");
            action.a0(numValueOf, item);
        }
    }

    @a7.d
    public static final MenuItem d(@a7.d Menu menu, int i7) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        MenuItem item = menu.getItem(i7);
        kotlin.jvm.internal.l0.o(item, "getItem(index)");
        return item;
    }

    @a7.d
    public static final kotlin.sequences.m<MenuItem> e(@a7.d Menu menu) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        return new a(menu);
    }

    public static final int f(@a7.d Menu menu) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        return menu.size();
    }

    public static final boolean g(@a7.d Menu menu) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean h(@a7.d Menu menu) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        return menu.size() != 0;
    }

    @a7.d
    public static final Iterator<MenuItem> i(@a7.d Menu menu) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        return new b(menu);
    }

    public static final void j(@a7.d Menu menu, @a7.d MenuItem item) {
        kotlin.jvm.internal.l0.p(menu, "<this>");
        kotlin.jvm.internal.l0.p(item, "item");
        menu.removeItem(item.getItemId());
    }
}
