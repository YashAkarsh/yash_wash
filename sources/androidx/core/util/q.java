package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    public static final class a extends n0 implements i5.p<Object, Object, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6381a = new a();

        public a() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer a0(@a7.d Object obj, @a7.d Object obj2) {
            l0.p(obj, "<anonymous parameter 0>");
            l0.p(obj2, "<anonymous parameter 1>");
            return 1;
        }
    }

    public static final class b extends n0 implements i5.l<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6382a = new b();

        public b() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        public final Object z(@a7.d Object it) {
            l0.p(it, "it");
            return null;
        }
    }

    public static final class c extends n0 implements i5.r<Boolean, Object, Object, Object, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6383a = new c();

        public c() {
            super(4);
        }

        @Override // i5.r
        public /* bridge */ /* synthetic */ l2 K(Boolean bool, Object obj, Object obj2, Object obj3) {
            b(bool.booleanValue(), obj, obj2, obj3);
            return l2.f34958a;
        }

        public final void b(boolean z7, @a7.d Object obj, @a7.d Object obj2, @a7.e Object obj3) {
            l0.p(obj, "<anonymous parameter 1>");
            l0.p(obj2, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public static final class d<K, V> extends LruCache<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<K, V, Integer> f6384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<K, V> f6385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.r<Boolean, K, V, V, l2> f6386c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(int i7, i5.p<? super K, ? super V, Integer> pVar, i5.l<? super K, ? extends V> lVar, i5.r<? super Boolean, ? super K, ? super V, ? super V, l2> rVar) {
            super(i7);
            this.f6384a = pVar;
            this.f6385b = lVar;
            this.f6386c = rVar;
        }

        @Override // android.util.LruCache
        @a7.e
        protected V create(@a7.d K key) {
            l0.p(key, "key");
            return this.f6385b.z(key);
        }

        @Override // android.util.LruCache
        protected void entryRemoved(boolean z7, @a7.d K key, @a7.d V oldValue, @a7.e V v7) {
            l0.p(key, "key");
            l0.p(oldValue, "oldValue");
            this.f6386c.K(Boolean.valueOf(z7), key, oldValue, v7);
        }

        @Override // android.util.LruCache
        protected int sizeOf(@a7.d K key, @a7.d V value) {
            l0.p(key, "key");
            l0.p(value, "value");
            return this.f6384a.a0(key, value).intValue();
        }
    }

    @a7.d
    public static final <K, V> LruCache<K, V> a(int i7, @a7.d i5.p<? super K, ? super V, Integer> sizeOf, @a7.d i5.l<? super K, ? extends V> create, @a7.d i5.r<? super Boolean, ? super K, ? super V, ? super V, l2> onEntryRemoved) {
        l0.p(sizeOf, "sizeOf");
        l0.p(create, "create");
        l0.p(onEntryRemoved, "onEntryRemoved");
        return new d(i7, sizeOf, create, onEntryRemoved);
    }

    public static /* synthetic */ LruCache b(int i7, i5.p sizeOf, i5.l create, i5.r onEntryRemoved, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            sizeOf = a.f6381a;
        }
        if ((i8 & 4) != 0) {
            create = b.f6382a;
        }
        if ((i8 & 8) != 0) {
            onEntryRemoved = c.f6383a;
        }
        l0.p(sizeOf, "sizeOf");
        l0.p(create, "create");
        l0.p(onEntryRemoved, "onEntryRemoved");
        return new d(i7, sizeOf, create, onEntryRemoved);
    }
}
