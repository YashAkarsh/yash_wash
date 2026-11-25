package kotlinx.coroutines.channels;

import kotlin.b1;
import kotlin.d1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class t {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {}, l = {com.alibaba.fastjson.asm.j.f12628v}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m0<E> f35662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ E f35663g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(m0<? super E> m0Var, E e8, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f35662f = m0Var;
            this.f35663g = e8;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new a(this.f35662f, this.f35663g, dVar);
        }

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
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35661e;
            if (i7 == 0) {
                e1.n(obj);
                m0<E> m0Var = this.f35662f;
                E e8 = this.f35663g;
                this.f35661e = 1;
                if (m0Var.R(e8, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super r<? extends l2>>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35664e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35665f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m0<E> f35666g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ E f35667h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(m0<? super E> m0Var, E e8, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f35666g = m0Var;
            this.f35667h = e8;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b bVar = new b(this.f35666g, this.f35667h, dVar);
            bVar.f35665f = obj;
            return bVar;
        }

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
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objB;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35664e;
            try {
                if (i7 == 0) {
                    e1.n(obj);
                    m0<E> m0Var = this.f35666g;
                    E e8 = this.f35667h;
                    d1.a aVar = d1.f34719b;
                    this.f35664e = 1;
                    if (m0Var.R(e8, this) == objH) {
                        return objH;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                objB = d1.b(l2.f34958a);
            } catch (Throwable th) {
                d1.a aVar2 = d1.f34719b;
                objB = d1.b(e1.a(th));
            }
            return r.b(d1.j(objB) ? r.f35656b.c(l2.f34958a) : r.f35656b.a(d1.e(objB)));
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super r<l2>> dVar) {
            return ((b) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @b1(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void a(@a7.d m0<? super E> m0Var, E e8) throws InterruptedException {
        if (r.m(m0Var.Q(e8))) {
            return;
        }
        kotlinx.coroutines.k.b(null, new a(m0Var, e8, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <E> Object b(@a7.d m0<? super E> m0Var, E e8) {
        Object objQ = m0Var.Q(e8);
        if (objQ instanceof r.c) {
            return ((r) kotlinx.coroutines.k.b(null, new b(m0Var, e8, null), 1, null)).o();
        }
        return r.f35656b.c(l2.f34958a);
    }
}
