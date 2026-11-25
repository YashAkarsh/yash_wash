package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a1;
import kotlin.b1;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final String f36433a = "kotlinx.coroutines.flow.defaultConcurrency";

    @a7.e
    public static final <T> Object A(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return n.f(iVar, pVar, dVar);
    }

    @a7.d
    @e2
    public static final <T, R> i<R> A0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.a(iVar, pVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> A1(@a7.d i<? extends T> iVar, long j7) {
        return r.h(iVar, j7);
    }

    @a7.e
    public static final <T> Object B(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return v.b(iVar, pVar, dVar);
    }

    @a7.d
    @d2
    public static final <T, R> i<R> B0(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.b(iVar, pVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> B1(@a7.d i<? extends T> iVar, long j7) {
        return r.i(iVar, j7);
    }

    @a7.d
    @e2
    public static final <T, R> i<R> C0(@a7.d i<? extends T> iVar, int i7, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.c(iVar, i7, pVar);
    }

    @a7.d
    public static final <T, R> i<R> C1(@a7.d i<? extends T> iVar, R r7, @a7.d @kotlin.b i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return a0.j(iVar, r7, qVar);
    }

    @a7.d
    public static final <T1, T2, R> i<R> D(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return b0.c(iVar, iVar2, qVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @b1(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> i<R> D1(@a7.d i<? extends T> iVar, R r7, @a7.d @kotlin.b i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return x.B(iVar, r7, qVar);
    }

    @a7.d
    public static final <T1, T2, T3, R> i<R> E(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d @kotlin.b i5.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.d<? super R>, ? extends Object> rVar) {
        return b0.d(iVar, iVar2, iVar3, rVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @b1(expression = "flattenConcat()", imports = {}))
    public static final <T> i<T> E0(@a7.d i<? extends i<? extends T>> iVar) {
        return x.m(iVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @b1(expression = "runningReduce(operation)", imports = {}))
    public static final <T> i<T> E1(@a7.d i<? extends T> iVar, @a7.d i5.q<? super T, ? super T, ? super kotlin.coroutines.d<? super T>, ? extends Object> qVar) {
        return x.C(iVar, qVar);
    }

    @a7.d
    public static final <T1, T2, T3, T4, R> i<R> F(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i5.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.d<? super R>, ? extends Object> sVar) {
        return b0.e(iVar, iVar2, iVar3, iVar4, sVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> F0(@a7.d i<? extends i<? extends T>> iVar) {
        return w.e(iVar);
    }

    @a7.d
    public static final <T> i0<T> F1(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var, @a7.d o0 o0Var, int i7) {
        return z.g(iVar, v0Var, o0Var, i7);
    }

    @a7.d
    public static final <T1, T2, T3, T4, T5, R> i<R> G(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i<? extends T5> iVar5, @a7.d i5.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.d<? super R>, ? extends Object> tVar) {
        return b0.f(iVar, iVar2, iVar3, iVar4, iVar5, tVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> G0(@a7.d i<? extends i<? extends T>> iVar, int i7) {
        return w.f(iVar, i7);
    }

    @a7.e
    public static final <T> Object H1(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.j(iVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> i<R> I(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return x.b(iVar, iVar2, qVar);
    }

    @a7.d
    public static final <T> i<T> I0(@a7.d @kotlin.b i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return l.n(pVar);
    }

    @a7.e
    public static final <T> Object I1(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.k(iVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> i<R> J(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i5.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.d<? super R>, ? extends Object> rVar) {
        return x.c(iVar, iVar2, iVar3, rVar);
    }

    @a7.d
    @h5.h(name = "flowCombine")
    public static final <T1, T2, R> i<R> J0(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return b0.p(iVar, iVar2, qVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @b1(expression = "drop(count)", imports = {}))
    public static final <T> i<T> J1(@a7.d i<? extends T> iVar, int i7) {
        return x.D(iVar, i7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> i<R> K(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i5.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.d<? super R>, ? extends Object> sVar) {
        return x.d(iVar, iVar2, iVar3, iVar4, sVar);
    }

    @a7.d
    @h5.h(name = "flowCombineTransform")
    public static final <T1, T2, R> i<R> K0(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d @kotlin.b i5.r<? super j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.d<? super l2>, ? extends Object> rVar) {
        return b0.q(iVar, iVar2, rVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @b1(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> i<T> K1(@a7.d i<? extends T> iVar, T t7) {
        return x.E(iVar, t7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> i<R> L(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i<? extends T5> iVar5, @a7.d i5.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.d<? super R>, ? extends Object> tVar) {
        return x.e(iVar, iVar2, iVar3, iVar4, iVar5, tVar);
    }

    @a7.d
    public static final <T> i<T> L0(T t7) {
        return l.o(t7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @b1(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> i<T> L1(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        return x.F(iVar, iVar2);
    }

    @a7.d
    public static final <T> i<T> M0(@a7.d T... tArr) {
        return l.p(tArr);
    }

    @a7.e
    public static final <T> Object M1(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var, @a7.d kotlin.coroutines.d<? super t0<? extends T>> dVar) {
        return z.i(iVar, v0Var, dVar);
    }

    @a7.d
    public static final <T1, T2, R> i<R> N(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d @kotlin.b i5.r<? super j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.d<? super l2>, ? extends Object> rVar) {
        return b0.i(iVar, iVar2, rVar);
    }

    @a7.d
    public static final <T> i<T> N0(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        return p.h(iVar, gVar);
    }

    @a7.d
    public static final <T> t0<T> N1(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var, @a7.d o0 o0Var, T t7) {
        return z.j(iVar, v0Var, o0Var, t7);
    }

    @a7.d
    public static final <T1, T2, T3, R> i<R> O(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d @kotlin.b i5.s<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.d<? super l2>, ? extends Object> sVar) {
        return b0.j(iVar, iVar2, iVar3, sVar);
    }

    @a7.e
    public static final <T, R> Object O0(@a7.d i<? extends T> iVar, R r7, @a7.d i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        return y.e(iVar, r7, qVar, dVar);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void O1(@a7.d i<? extends T> iVar) {
        x.G(iVar);
    }

    @a7.d
    public static final <T1, T2, T3, T4, R> i<R> P(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d @kotlin.b i5.t<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.d<? super l2>, ? extends Object> tVar) {
        return b0.k(iVar, iVar2, iVar3, iVar4, tVar);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @b1(expression = "collect(action)", imports = {}))
    public static final <T> void P0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        x.n(iVar, pVar);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void P1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        x.H(iVar, pVar);
    }

    @a7.d
    public static final <T1, T2, T3, T4, T5, R> i<R> Q(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i<? extends T5> iVar5, @a7.d @kotlin.b i5.u<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.d<? super l2>, ? extends Object> uVar) {
        return b0.l(iVar, iVar2, iVar3, iVar4, iVar5, uVar);
    }

    public static final int Q0() {
        return w.h();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Q1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, @a7.d i5.p<? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar2) {
        x.I(iVar, pVar, pVar2);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'flowOn' instead")
    public static final <T> i<T> R1(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        return x.J(iVar, gVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @b1(expression = "let(transformer)", imports = {}))
    public static final <T, R> i<R> S(@a7.d i<? extends T> iVar, @a7.d i5.l<? super i<? extends T>, ? extends i<? extends R>> lVar) {
        return x.f(iVar, lVar);
    }

    @a7.e
    public static final <T> Object S0(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.g(iVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @b1(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> i<R> S1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return x.K(iVar, pVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @b1(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> i<R> T(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, ? extends i<? extends R>> lVar) {
        return x.g(iVar, lVar);
    }

    @a7.e
    public static final <T> Object T0(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.h(iVar, dVar);
    }

    @a7.d
    public static final <T> i<T> T1(@a7.d i<? extends T> iVar, int i7) {
        return v.g(iVar, i7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @b1(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> i<T> U(@a7.d i<? extends T> iVar, T t7) {
        return x.h(iVar, t7);
    }

    @a7.d
    public static final <T> o2 U0(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var) {
        return n.h(iVar, v0Var);
    }

    @a7.d
    public static final <T> i<T> U1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return v.h(iVar, pVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @b1(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    public static final <T> i<T> V(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        return x.i(iVar, iVar2);
    }

    @a7.d
    public static final <T, R> i<R> V0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return a0.e(iVar, pVar);
    }

    @a7.e
    public static final <T, C extends Collection<? super T>> Object V1(@a7.d i<? extends T> iVar, @a7.d C c8, @a7.d kotlin.coroutines.d<? super C> dVar) {
        return o.a(iVar, c8, dVar);
    }

    @a7.d
    public static final <T> i<T> W(@a7.d i<? extends T> iVar) {
        return p.g(iVar);
    }

    @a7.d
    @d2
    public static final <T, R> i<R> W0(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return w.k(iVar, pVar);
    }

    @a7.e
    public static final <T> Object W1(@a7.d i<? extends T> iVar, @a7.d List<T> list, @a7.d kotlin.coroutines.d<? super List<? extends T>> dVar) {
        return o.b(iVar, list, dVar);
    }

    @a7.d
    public static final <T> i<T> X(@a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var) {
        return m.c(i0Var);
    }

    @a7.d
    public static final <T, R> i<R> X0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return a0.f(iVar, pVar);
    }

    @a7.e
    public static final <T> Object Y(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super Integer> dVar) {
        return q.a(iVar, pVar, dVar);
    }

    @a7.d
    public static final <T> i<T> Y0(@a7.d Iterable<? extends i<? extends T>> iterable) {
        return w.l(iterable);
    }

    @a7.e
    public static final <T> Object Y1(@a7.d i<? extends T> iVar, @a7.d Set<T> set, @a7.d kotlin.coroutines.d<? super Set<? extends T>> dVar) {
        return o.d(iVar, set, dVar);
    }

    @a7.e
    public static final <T> Object Z(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super Integer> dVar) {
        return q.b(iVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @b1(expression = "flattenConcat()", imports = {}))
    public static final <T> i<T> Z0(@a7.d i<? extends i<? extends T>> iVar) {
        return x.o(iVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> a(@a7.d i5.a<? extends T> aVar) {
        return l.a(aVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> a0(@a7.d i<? extends T> iVar, long j7) {
        return r.a(iVar, j7);
    }

    @a7.d
    public static final <T> i<T> a1(@a7.d i<? extends T>... iVarArr) {
        return w.m(iVarArr);
    }

    @a7.d
    public static final <T, R> i<R> a2(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return t.g(iVar, qVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> b(@a7.d i5.l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar) {
        return l.b(lVar);
    }

    @a7.d
    @kotlin.t0
    @e2
    public static final <T> i<T> b0(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, Long> lVar) {
        return r.b(iVar, lVar);
    }

    @a7.d
    public static final Void b1() {
        return x.p();
    }

    @a7.d
    @d2
    public static final <T, R> i<R> b2(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return w.n(iVar, qVar);
    }

    @a7.d
    public static final <T> i<T> c(@a7.d Iterable<? extends T> iterable) {
        return l.c(iterable);
    }

    @a7.d
    @e2
    public static final <T> i<T> c0(@a7.d i<? extends T> iVar, long j7) {
        return r.c(iVar, j7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> i<T> c1(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        return x.q(iVar, gVar);
    }

    @a7.d
    public static final <T, R> i<R> c2(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> qVar) {
        return v.i(iVar, qVar);
    }

    @a7.d
    public static final <T> i<T> d(@a7.d Iterator<? extends T> it) {
        return l.d(it);
    }

    @h5.h(name = "debounceDuration")
    @kotlin.t0
    @e2
    @a7.d
    public static final <T> i<T> d0(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, kotlin.time.d> lVar) {
        return r.d(iVar, lVar);
    }

    @a7.d
    public static final <T> i<T> d1(@a7.d i<? extends T> iVar, @a7.d i5.q<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return t.d(iVar, qVar);
    }

    @a7.d
    @a1
    public static final <T, R> i<R> d2(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return t.h(iVar, qVar);
    }

    @a7.d
    public static final i<Integer> e(@a7.d kotlin.ranges.k kVar) {
        return l.e(kVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @b1(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> i<T> e0(@a7.d i<? extends T> iVar, long j7) {
        return x.j(iVar, j7);
    }

    @a7.d
    public static final <T> i<T> e1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return a0.g(iVar, pVar);
    }

    @a7.d
    public static final <T> i<kotlin.collections.r0<T>> e2(@a7.d i<? extends T> iVar) {
        return a0.k(iVar);
    }

    @a7.d
    public static final i<Long> f(@a7.d kotlin.ranges.n nVar) {
        return l.f(nVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @b1(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> i<T> f0(@a7.d i<? extends T> iVar, long j7) {
        return x.k(iVar, j7);
    }

    @a7.d
    public static final <T> i<T> f1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return t.e(iVar, pVar);
    }

    @a7.d
    public static final <T1, T2, R> i<R> f2(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return b0.s(iVar, iVar2, qVar);
    }

    @a7.d
    public static final <T> i<T> g(@a7.d kotlin.sequences.m<? extends T> mVar) {
        return l.g(mVar);
    }

    @a7.d
    public static final <T> i<T> g0(@a7.d i<? extends T> iVar) {
        return s.a(iVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @b1(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> i<T> g1(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        return x.r(iVar, iVar2);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> i<T> h(@a7.d kotlinx.coroutines.channels.i<T> iVar) {
        return m.b(iVar);
    }

    @a7.d
    public static final <T> i<T> h0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super T, Boolean> pVar) {
        return s.b(iVar, pVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @b1(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> i<T> h1(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        return x.s(iVar, iVar2);
    }

    @a7.d
    public static final i<Integer> i(@a7.d int[] iArr) {
        return l.h(iArr);
    }

    @a7.d
    public static final <T, K> i<T> i0(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, ? extends K> lVar) {
        return s.c(iVar, lVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @b1(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> i<T> i1(@a7.d i<? extends T> iVar, T t7) {
        return x.t(iVar, t7);
    }

    @a7.d
    public static final i<Long> j(@a7.d long[] jArr) {
        return l.i(jArr);
    }

    @a7.d
    public static final <T> i<T> j0(@a7.d i<? extends T> iVar, int i7) {
        return v.d(iVar, i7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @b1(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> i<T> j1(@a7.d i<? extends T> iVar, T t7, @a7.d i5.l<? super Throwable, Boolean> lVar) {
        return x.u(iVar, t7, lVar);
    }

    @a7.d
    public static final <T> i<T> k(@a7.d T[] tArr) {
        return l.j(tArr);
    }

    @a7.d
    public static final <T> i<T> k0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return v.e(iVar, pVar);
    }

    @a7.d
    public static final <T> i0<T> l(@a7.d d0<T> d0Var) {
        return z.a(d0Var);
    }

    @a7.e
    public static final <T> Object l0(@a7.d j<? super T> jVar, @a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return m.d(jVar, i0Var, dVar);
    }

    @a7.d
    public static final <T> i<T> l1(@a7.d i<? extends T> iVar, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return t.f(iVar, pVar);
    }

    @a7.d
    public static final <T> t0<T> m(@a7.d e0<T> e0Var) {
        return z.b(e0Var);
    }

    @a7.e
    public static final <T> Object m0(@a7.d j<? super T> jVar, @a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return n.g(jVar, iVar, dVar);
    }

    @a7.d
    public static final <T> i0<T> m1(@a7.d i0<? extends T> i0Var, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return z.f(i0Var, pVar);
    }

    @a7.d
    public static final <T> i<T> n0() {
        return l.m();
    }

    @a7.d
    @e2
    public static final <T> kotlinx.coroutines.channels.i0<T> n1(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var) {
        return m.f(iVar, v0Var);
    }

    @a7.d
    public static final <T> i<T> o(@a7.d i<? extends T> iVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return p.b(iVar, i7, mVar);
    }

    public static final void o0(@a7.d j<?> jVar) {
        t.b(jVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.shareIn(scope, 0)", imports = {}))
    public static final <T> i<T> o1(@a7.d i<? extends T> iVar) {
        return x.w(iVar);
    }

    @a7.d
    public static final <T> i<T> p0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return a0.a(iVar, pVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    public static final <T> i<T> p1(@a7.d i<? extends T> iVar, int i7) {
        return x.x(iVar, i7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> i<T> q1(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        return x.y(iVar, gVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @b1(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    public static final <T> i<T> r(@a7.d i<? extends T> iVar) {
        return x.a(iVar);
    }

    @a7.d
    public static final <T> i<T> r0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return a0.c(iVar, pVar);
    }

    @a7.d
    public static final <T> i<T> r1(@a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var) {
        return m.g(i0Var);
    }

    @a7.d
    public static final <T> i<T> s(@a7.d @kotlin.b i5.p<? super kotlinx.coroutines.channels.g0<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return l.k(pVar);
    }

    @a7.d
    public static final <T> i<T> s0(@a7.d i<? extends T> iVar) {
        return a0.d(iVar);
    }

    @a7.e
    public static final <S, T extends S> Object s1(@a7.d i<? extends T> iVar, @a7.d i5.q<? super S, ? super T, ? super kotlin.coroutines.d<? super S>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super S> dVar) {
        return y.i(iVar, qVar, dVar);
    }

    @a7.d
    public static final <T> i<T> t(@a7.d i<? extends T> iVar) {
        return p.e(iVar);
    }

    @a7.e
    public static final <T> Object t0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.a(iVar, pVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    public static final <T> i<T> t1(@a7.d i<? extends T> iVar) {
        return x.z(iVar);
    }

    @a7.d
    public static final <T> i<T> u(@a7.d i<? extends T> iVar, @a7.d i5.q<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return u.a(iVar, qVar);
    }

    @a7.e
    public static final <T> Object u0(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.b(iVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    public static final <T> i<T> u1(@a7.d i<? extends T> iVar, int i7) {
        return x.A(iVar, i7);
    }

    @a7.e
    public static final <T> Object v(@a7.d i<? extends T> iVar, @a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super Throwable> dVar) throws Throwable {
        return u.b(iVar, jVar, dVar);
    }

    @a7.e
    public static final <T> Object v0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.c(iVar, pVar, dVar);
    }

    @a7.d
    public static final <T> i<T> v1(@a7.d i<? extends T> iVar, long j7, @a7.d i5.p<? super Throwable, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return u.e(iVar, j7, pVar);
    }

    @a7.d
    public static final <T> i<T> w(@a7.d @kotlin.b i5.p<? super kotlinx.coroutines.channels.g0<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return l.l(pVar);
    }

    @a7.e
    public static final <T> Object w0(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return y.d(iVar, dVar);
    }

    @a7.d
    public static final kotlinx.coroutines.channels.i0<l2> x0(@a7.d kotlinx.coroutines.v0 v0Var, long j7, long j8) {
        return r.f(v0Var, j7, j8);
    }

    @a7.d
    public static final <T> i<T> x1(@a7.d i<? extends T> iVar, @a7.d i5.r<? super j<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> rVar) {
        return u.g(iVar, rVar);
    }

    @a7.e
    public static final Object y(@a7.d i<?> iVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return n.b(iVar, dVar);
    }

    @a7.d
    public static final <T, R> i<R> y1(@a7.d i<? extends T> iVar, R r7, @a7.d @kotlin.b i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return a0.h(iVar, r7, qVar);
    }

    @a7.e
    public static final <T> Object z(@a7.d i<? extends T> iVar, @a7.d i5.q<? super Integer, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return n.d(iVar, qVar, dVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @b1(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> i<R> z0(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return x.l(iVar, pVar);
    }

    @a7.d
    public static final <T> i<T> z1(@a7.d i<? extends T> iVar, @a7.d i5.q<? super T, ? super T, ? super kotlin.coroutines.d<? super T>, ? extends Object> qVar) {
        return a0.i(iVar, qVar);
    }
}
