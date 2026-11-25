package kotlinx.coroutines.selects;

import i5.l;
import i5.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.a1;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
@a1
public final class j<R> implements kotlinx.coroutines.selects.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.selects.b<R> f37227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final ArrayList<i5.a<l2>> f37228b = new ArrayList<>();

    static final class a extends n0 implements i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.selects.c f37229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<R> f37230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<kotlin.coroutines.d<? super R>, Object> f37231c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.selects.c cVar, j<? super R> jVar, l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
            super(0);
            this.f37229a = cVar;
            this.f37230b = jVar;
            this.f37231c = lVar;
        }

        public final void b() {
            this.f37229a.P(this.f37230b.b(), this.f37231c);
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            b();
            return l2.f34958a;
        }
    }

    static final class b extends n0 implements i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.selects.d<Q> f37232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<R> f37233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p<Q, kotlin.coroutines.d<? super R>, Object> f37234c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(kotlinx.coroutines.selects.d<? extends Q> dVar, j<? super R> jVar, p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
            super(0);
            this.f37232a = dVar;
            this.f37233b = jVar;
            this.f37234c = pVar;
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        public final void b() {
            /*
                r3 = this;
                kotlinx.coroutines.selects.d<Q> r0 = r3.f37232a
                kotlinx.coroutines.selects.j<R> r1 = r3.f37233b
                kotlinx.coroutines.selects.b r1 = r1.b()
                i5.p<Q, kotlin.coroutines.d<? super R>, java.lang.Object> r2 = r3.f37234c
                r0.h(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.j.b.b():void");
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            b();
            return l2.f34958a;
        }
    }

    static final class c extends n0 implements i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<P, Q> f37235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<R> f37236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ P f37237c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p<Q, kotlin.coroutines.d<? super R>, Object> f37238d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(e<? super P, ? extends Q> eVar, j<? super R> jVar, P p7, p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
            super(0);
            this.f37235a = eVar;
            this.f37236b = jVar;
            this.f37237c = p7;
            this.f37238d = pVar;
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        public final void b() {
            /*
                r4 = this;
                kotlinx.coroutines.selects.e<P, Q> r0 = r4.f37235a
                kotlinx.coroutines.selects.j<R> r1 = r4.f37236b
                kotlinx.coroutines.selects.b r1 = r1.b()
                P r2 = r4.f37237c
                i5.p<Q, kotlin.coroutines.d<? super R>, java.lang.Object> r3 = r4.f37238d
                r0.y(r1, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.j.c.b():void");
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            b();
            return l2.f34958a;
        }
    }

    static final class d extends n0 implements i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<R> f37239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f37240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<kotlin.coroutines.d<? super R>, Object> f37241c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(j<? super R> jVar, long j7, l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
            super(0);
            this.f37239a = jVar;
            this.f37240b = j7;
            this.f37241c = lVar;
        }

        public final void b() {
            this.f37239a.b().Q(this.f37240b, this.f37241c);
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            b();
            return l2.f34958a;
        }
    }

    public j(@a7.d kotlin.coroutines.d<? super R> dVar) {
        this.f37227a = new kotlinx.coroutines.selects.b<>(dVar);
    }

    @Override // kotlinx.coroutines.selects.a
    public void Q(long j7, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        this.f37228b.add(new d(this, j7, lVar));
    }

    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void V(@a7.d e<? super P, ? extends Q> eVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        kotlinx.coroutines.selects.a.C0491a.a(this, eVar, pVar);
    }

    @a7.d
    public final ArrayList<i5.a<l2>> a() {
        return this.f37228b;
    }

    @a7.d
    public final kotlinx.coroutines.selects.b<R> b() {
        return this.f37227a;
    }

    @a1
    public final void c(@a7.d Throwable th) {
        this.f37227a.e1(th);
    }

    @a7.e
    @a1
    public final Object d() {
        if (!this.f37227a.E()) {
            try {
                Collections.shuffle(this.f37228b);
                Iterator<T> it = this.f37228b.iterator();
                while (it.hasNext()) {
                    ((i5.a) it.next()).invoke();
                }
            } catch (Throwable th) {
                this.f37227a.e1(th);
            }
        }
        return this.f37227a.d1();
    }

    @Override // kotlinx.coroutines.selects.a
    public void f(@a7.d kotlinx.coroutines.selects.c cVar, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        this.f37228b.add(new a(cVar, this, lVar));
    }

    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void g0(@a7.d e<? super P, ? extends Q> eVar, P p7, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        this.f37228b.add(new c(eVar, this, p7, pVar));
    }

    @Override // kotlinx.coroutines.selects.a
    public <Q> void m(@a7.d kotlinx.coroutines.selects.d<? extends Q> dVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        this.f37228b.add(new b(dVar, this, pVar));
    }
}
