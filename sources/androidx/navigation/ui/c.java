package androidx.navigation.ui;

import android.annotation.SuppressLint;
import android.view.Menu;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.n;
import c.m0;
import c.o0;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Set<Integer> f8944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final androidx.customview.widget.c f8945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private final InterfaceC0116c f8946c;

    /* JADX INFO: renamed from: androidx.navigation.ui.c$c, reason: collision with other inner class name */
    public interface InterfaceC0116c {
        boolean a();
    }

    @o0
    @Deprecated
    public DrawerLayout a() {
        androidx.customview.widget.c cVar = this.f8945b;
        if (cVar instanceof DrawerLayout) {
            return (DrawerLayout) cVar;
        }
        return null;
    }

    @o0
    public InterfaceC0116c b() {
        return this.f8946c;
    }

    @o0
    public androidx.customview.widget.c c() {
        return this.f8945b;
    }

    @m0
    public Set<Integer> d() {
        return this.f8944a;
    }

    private c(@m0 Set<Integer> set, @o0 androidx.customview.widget.c cVar, @o0 InterfaceC0116c interfaceC0116c) {
        this.f8944a = set;
        this.f8945b = cVar;
        this.f8946c = interfaceC0116c;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final Set<Integer> f8947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        private androidx.customview.widget.c f8948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private InterfaceC0116c f8949c;

        public b(@m0 n nVar) {
            HashSet hashSet = new HashSet();
            this.f8947a = hashSet;
            hashSet.add(Integer.valueOf(e.b(nVar).m()));
        }

        @m0
        @SuppressLint({"SyntheticAccessor"})
        public c a() {
            return new c(this.f8947a, this.f8948b, this.f8949c);
        }

        @m0
        @Deprecated
        public b b(@o0 DrawerLayout drawerLayout) {
            this.f8948b = drawerLayout;
            return this;
        }

        @m0
        public b c(@o0 InterfaceC0116c interfaceC0116c) {
            this.f8949c = interfaceC0116c;
            return this;
        }

        @m0
        public b d(@o0 androidx.customview.widget.c cVar) {
            this.f8948b = cVar;
            return this;
        }

        public b(@m0 Menu menu) {
            this.f8947a = new HashSet();
            int size = menu.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f8947a.add(Integer.valueOf(menu.getItem(i7).getItemId()));
            }
        }

        public b(@m0 int... iArr) {
            this.f8947a = new HashSet();
            for (int i7 : iArr) {
                this.f8947a.add(Integer.valueOf(i7));
            }
        }

        public b(@m0 Set<Integer> set) {
            HashSet hashSet = new HashSet();
            this.f8947a = hashSet;
            hashSet.addAll(set);
        }
    }
}
