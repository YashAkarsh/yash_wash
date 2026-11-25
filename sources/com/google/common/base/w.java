package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19565a;

    class a extends w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19566b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(w wVar, String str) {
            super(wVar, null);
            this.f19566b = str;
        }

        @Override // com.google.common.base.w
        public w q() {
            throw new UnsupportedOperationException("already specified useForNull");
        }

        @Override // com.google.common.base.w
        CharSequence r(Object obj) {
            return obj == null ? this.f19566b : w.this.r(obj);
        }

        @Override // com.google.common.base.w
        public w s(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    class b extends w {
        b(w wVar) {
            super(wVar, null);
        }

        @Override // com.google.common.base.w
        public <A extends Appendable> A d(A a8, Iterator<?> it) throws IOException {
            e0.F(a8, "appendable");
            e0.F(it, "parts");
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    a8.append(w.this.r(next));
                    break;
                }
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                if (next2 != null) {
                    a8.append(w.this.f19565a);
                    a8.append(w.this.r(next2));
                }
            }
            return a8;
        }

        @Override // com.google.common.base.w
        public w s(String str) {
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        @Override // com.google.common.base.w
        public d u(String str) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    static class c extends AbstractList<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f19569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f19570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f19571c;

        c(Object[] objArr, Object obj, Object obj2) {
            this.f19569a = objArr;
            this.f19570b = obj;
            this.f19571c = obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i7) {
            if (i7 != 0) {
                return i7 != 1 ? this.f19569a[i7 - 2] : this.f19571c;
            }
            return this.f19570b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f19569a.length + 2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w f19572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19573b;

        /* synthetic */ d(w wVar, String str, a aVar) {
            this(wVar, str);
        }

        @s1.a
        @u1.a
        public <A extends Appendable> A a(A a8, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) b(a8, iterable.iterator());
        }

        @s1.a
        @u1.a
        public <A extends Appendable> A b(A a8, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            e0.E(a8);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a8.append(this.f19572a.r(next.getKey()));
                a8.append(this.f19573b);
                a8.append(this.f19572a.r(next.getValue()));
                while (it.hasNext()) {
                    a8.append(this.f19572a.f19565a);
                    Map.Entry<?, ?> next2 = it.next();
                    a8.append(this.f19572a.r(next2.getKey()));
                    a8.append(this.f19573b);
                    a8.append(this.f19572a.r(next2.getValue()));
                }
            }
            return a8;
        }

        @u1.a
        public <A extends Appendable> A c(A a8, Map<?, ?> map) throws IOException {
            return (A) a(a8, map.entrySet());
        }

        @s1.a
        @u1.a
        public StringBuilder d(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return e(sb, iterable.iterator());
        }

        @s1.a
        @u1.a
        public StringBuilder e(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                b(sb, it);
                return sb;
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @u1.a
        public StringBuilder f(StringBuilder sb, Map<?, ?> map) {
            return d(sb, map.entrySet());
        }

        @s1.a
        public String g(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return h(iterable.iterator());
        }

        @s1.a
        public String h(Iterator<? extends Map.Entry<?, ?>> it) {
            return e(new StringBuilder(), it).toString();
        }

        public String i(Map<?, ?> map) {
            return g(map.entrySet());
        }

        public d j(String str) {
            return new d(this.f19572a.s(str), this.f19573b);
        }

        private d(w wVar, String str) {
            this.f19572a = wVar;
            this.f19573b = (String) e0.E(str);
        }
    }

    /* synthetic */ w(w wVar, a aVar) {
        this(wVar);
    }

    private static Iterable<Object> j(Object obj, Object obj2, Object[] objArr) {
        e0.E(objArr);
        return new c(objArr, obj, obj2);
    }

    public static w o(char c8) {
        return new w(String.valueOf(c8));
    }

    public static w p(String str) {
        return new w(str);
    }

    @u1.a
    public <A extends Appendable> A b(A a8, Iterable<?> iterable) throws IOException {
        return (A) d(a8, iterable.iterator());
    }

    @u1.a
    public final <A extends Appendable> A c(A a8, Object obj, Object obj2, Object... objArr) throws IOException {
        return (A) b(a8, j(obj, obj2, objArr));
    }

    @u1.a
    public <A extends Appendable> A d(A a8, Iterator<?> it) throws IOException {
        e0.E(a8);
        if (it.hasNext()) {
            a8.append(r(it.next()));
            while (it.hasNext()) {
                a8.append(this.f19565a);
                a8.append(r(it.next()));
            }
        }
        return a8;
    }

    @u1.a
    public final <A extends Appendable> A e(A a8, Object[] objArr) throws IOException {
        return (A) b(a8, Arrays.asList(objArr));
    }

    @u1.a
    public final StringBuilder f(StringBuilder sb, Iterable<?> iterable) {
        return h(sb, iterable.iterator());
    }

    @u1.a
    public final StringBuilder g(StringBuilder sb, Object obj, Object obj2, Object... objArr) {
        return f(sb, j(obj, obj2, objArr));
    }

    @u1.a
    public final StringBuilder h(StringBuilder sb, Iterator<?> it) {
        try {
            d(sb, it);
            return sb;
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    @u1.a
    public final StringBuilder i(StringBuilder sb, Object[] objArr) {
        return f(sb, Arrays.asList(objArr));
    }

    public final String k(Iterable<?> iterable) {
        return m(iterable.iterator());
    }

    public final String l(Object obj, Object obj2, Object... objArr) {
        return k(j(obj, obj2, objArr));
    }

    public final String m(Iterator<?> it) {
        return h(new StringBuilder(), it).toString();
    }

    public final String n(Object[] objArr) {
        return k(Arrays.asList(objArr));
    }

    public w q() {
        return new b(this);
    }

    CharSequence r(Object obj) {
        e0.E(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public w s(String str) {
        e0.E(str);
        return new a(this, str);
    }

    public d t(char c8) {
        return u(String.valueOf(c8));
    }

    public d u(String str) {
        return new d(this, str, null);
    }

    private w(String str) {
        this.f19565a = (String) e0.E(str);
    }

    private w(w wVar) {
        this.f19565a = wVar.f19565a;
    }
}
