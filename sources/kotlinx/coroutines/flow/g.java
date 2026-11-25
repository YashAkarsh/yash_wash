package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class g<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i<T> f36248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public final i5.l<T, Object> f36249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final i5.p<Object, Object, Boolean> f36250c;

    static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f36251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.h<Object> f36252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f36253c;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.g$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", i = {}, l = {81}, m = "emit", n = {}, s = {})
        static final class C0462a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36254d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ a<T> f36255e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36256f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0462a(a<? super T> aVar, kotlin.coroutines.d<? super C0462a> dVar) {
                super(dVar);
                this.f36255e = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36254d = obj;
                this.f36256f |= Integer.MIN_VALUE;
                return this.f36255e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(g<T> gVar, k1.h<Object> hVar, j<? super T> jVar) {
            this.f36251a = gVar;
            this.f36252b = hVar;
            this.f36253c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            C0462a c0462a;
            if (dVar instanceof C0462a) {
                c0462a = (C0462a) dVar;
                int i7 = c0462a.f36256f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    c0462a.f36256f = i7 - Integer.MIN_VALUE;
                } else {
                    c0462a = new C0462a(this, dVar);
                }
            } else {
                c0462a = new C0462a(this, dVar);
            }
            Object obj = c0462a.f36254d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = c0462a.f36256f;
            if (i8 == 0) {
                e1.n(obj);
                T t8 = (T) this.f36251a.f36249b.z(t7);
                Object obj2 = this.f36252b.f34872a;
                if (obj2 != kotlinx.coroutines.flow.internal.u.f36394a && this.f36251a.f36250c.a0(obj2, t8).booleanValue()) {
                    return l2.f34958a;
                }
                this.f36252b.f34872a = t8;
                j<T> jVar = this.f36253c;
                c0462a.f36256f = 1;
                if (jVar.f(t7, c0462a) == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, ? extends Object> lVar, @a7.d i5.p<Object, Object, Boolean> pVar) {
        this.f36248a = iVar;
        this.f36249b = lVar;
        this.f36250c = pVar;
    }

    @Override // kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        k1.h hVar = new k1.h();
        hVar.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
        Object objA = this.f36248a.a(new a(this, hVar, jVar), dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }
}
