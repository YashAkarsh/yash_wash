package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@c.t0(24)
final class e0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocaleList f6083a;

    e0(Object obj) {
        this.f6083a = o.a(obj);
    }

    @Override // androidx.core.os.v
    public int a(Locale locale) {
        return this.f6083a.indexOf(locale);
    }

    @Override // androidx.core.os.v
    public String b() {
        return this.f6083a.toLanguageTags();
    }

    @Override // androidx.core.os.v
    public Object c() {
        return this.f6083a;
    }

    @Override // androidx.core.os.v
    @c.o0
    public Locale d(@c.m0 String[] strArr) {
        return this.f6083a.getFirstMatch(strArr);
    }

    public boolean equals(Object obj) {
        return this.f6083a.equals(((v) obj).c());
    }

    @Override // androidx.core.os.v
    public Locale get(int i7) {
        return this.f6083a.get(i7);
    }

    public int hashCode() {
        return this.f6083a.hashCode();
    }

    @Override // androidx.core.os.v
    public boolean isEmpty() {
        return this.f6083a.isEmpty();
    }

    @Override // androidx.core.os.v
    public int size() {
        return this.f6083a.size();
    }

    public String toString() {
        return this.f6083a.toString();
    }
}
