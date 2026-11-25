package kotlin.properties;

import i5.q;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlin.reflect.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f34980a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.properties.a$a, reason: collision with other inner class name */
    public static final class C0435a<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q<o<?>, T, T, l2> f34981b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0435a(T t7, q<? super o<?>, ? super T, ? super T, l2> qVar) {
            super(t7);
            this.f34981b = qVar;
        }

        @Override // kotlin.properties.c
        protected void c(@a7.d o<?> property, T t7, T t8) {
            l0.p(property, "property");
            this.f34981b.v(property, t7, t8);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q<o<?>, T, T, Boolean> f34982b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(T t7, q<? super o<?>, ? super T, ? super T, Boolean> qVar) {
            super(t7);
            this.f34982b = qVar;
        }

        @Override // kotlin.properties.c
        protected boolean d(@a7.d o<?> property, T t7, T t8) {
            l0.p(property, "property");
            return this.f34982b.v(property, t7, t8).booleanValue();
        }
    }

    private a() {
    }

    @a7.d
    public final <T> f<Object, T> a() {
        return new kotlin.properties.b();
    }

    @a7.d
    public final <T> f<Object, T> b(T t7, @a7.d q<? super o<?>, ? super T, ? super T, l2> onChange) {
        l0.p(onChange, "onChange");
        return new C0435a(t7, onChange);
    }

    @a7.d
    public final <T> f<Object, T> c(T t7, @a7.d q<? super o<?>, ? super T, ? super T, Boolean> onChange) {
        l0.p(onChange, "onChange");
        return new b(t7, onChange);
    }
}
