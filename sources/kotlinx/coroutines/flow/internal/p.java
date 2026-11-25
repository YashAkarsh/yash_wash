package kotlinx.coroutines.flow.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class a<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.q f36386a;

        public a(i5.q qVar) {
            this.f36386a = qVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = p.a(new b(this.f36386a, jVar, null), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {ConstraintLayout.LayoutParams.a.Z}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36387e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36388f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i5.q<v0, kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> f36389g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f36390h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(i5.q<? super v0, ? super kotlinx.coroutines.flow.j<? super R>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlinx.coroutines.flow.j<? super R> jVar, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f36389g = qVar;
            this.f36390h = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b bVar = new b(this.f36389g, this.f36390h, dVar);
            bVar.f36388f = obj;
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
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36387e;
            if (i7 == 0) {
                e1.n(obj);
                v0 v0Var = (v0) this.f36388f;
                i5.q<v0, kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> qVar = this.f36389g;
                Object obj2 = this.f36390h;
                this.f36387e = 1;
                if (qVar.v(v0Var, obj2, this) == objH) {
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
            return ((b) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @a7.e
    public static final <R> Object a(@a7.d @kotlin.b i5.p<? super v0, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        o oVar = new o(dVar.d(), dVar);
        Object objF = r5.b.f(oVar, oVar, pVar);
        if (objF == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objF;
    }

    @a7.d
    public static final <R> kotlinx.coroutines.flow.i<R> b(@a7.d @kotlin.b i5.q<? super v0, ? super kotlinx.coroutines.flow.j<? super R>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return new a(qVar);
    }
}
