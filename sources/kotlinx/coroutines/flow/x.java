package kotlinx.coroutines.flow;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.b1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.g1;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", f = "Migration.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
    static final class a<T> extends kotlin.coroutines.jvm.internal.o implements i5.p<T, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36809e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f36810f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j7, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36810f = j7;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new a(this.f36810f, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36809e;
            if (i7 == 0) {
                e1.n(obj);
                long j7 = this.f36810f;
                this.f36809e = 1;
                if (g1.b(j7, this) == objH) {
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
        public final Object a0(T t7, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(t7, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
    static final class b<T> extends kotlin.coroutines.jvm.internal.o implements i5.p<j<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f36812f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j7, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f36812f = j7;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new b(this.f36812f, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36811e;
            if (i7 == 0) {
                e1.n(obj);
                long j7 = this.f36812f;
                this.f36811e = 1;
                if (g1.b(j7, this) == objH) {
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
        public final Object a0(@a7.d j<? super T> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((b) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    static final class c extends kotlin.jvm.internal.n0 implements i5.l<Throwable, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f36813a = new c();

        c() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(@a7.d Throwable th) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    static final class d<T> extends kotlin.coroutines.jvm.internal.o implements i5.q<j<? super T>, Throwable, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36816g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.l<Throwable, Boolean> f36817h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ T f36818i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(i5.l<? super Throwable, Boolean> lVar, T t7, kotlin.coroutines.d<? super d> dVar) {
            super(3, dVar);
            this.f36817h = lVar;
            this.f36818i = t7;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) throws Throwable {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36814e;
            if (i7 == 0) {
                e1.n(obj);
                j jVar = (j) this.f36815f;
                Throwable th = (Throwable) this.f36816g;
                if (!this.f36817h.z(th).booleanValue()) {
                    throw th;
                }
                T t7 = this.f36818i;
                this.f36815f = null;
                this.f36814e = 1;
                if (jVar.f(t7, this) == objH) {
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

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d j<? super T> jVar, @a7.d Throwable th, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            d dVar2 = new d(this.f36817h, this.f36818i, dVar);
            dVar2.f36815f = jVar;
            dVar2.f36816g = th;
            return dVar2.R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class e<R, T> extends kotlin.coroutines.jvm.internal.o implements i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36819e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36821g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p f36822h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i5.p pVar, kotlin.coroutines.d dVar) {
            super(3, dVar);
            this.f36822h = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            j jVar;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36819e;
            if (i7 != 0) {
                if (i7 == 1) {
                    jVar = (j) this.f36820f;
                    e1.n(obj);
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            jVar = (j) this.f36820f;
            Object obj2 = this.f36821g;
            i5.p pVar = this.f36822h;
            this.f36820f = jVar;
            this.f36819e = 1;
            obj = pVar.a0(obj2, this);
            if (obj == objH) {
                return objH;
            }
            this.f36820f = null;
            this.f36819e = 2;
            if (k.m0(jVar, (i) obj, this) == objH) {
                return objH;
            }
            return l2.f34958a;
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d j<? super R> jVar, T t7, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            e eVar = new e(this.f36822h, dVar);
            eVar.f36820f = jVar;
            eVar.f36821g = t7;
            return eVar.R(l2.f34958a);
        }
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    public static final <T> i<T> A(@a7.d i<? extends T> iVar, int i7) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @b1(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> i<R> B(@a7.d i<? extends T> iVar, R r7, @a7.d @kotlin.b i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @b1(expression = "runningReduce(operation)", imports = {}))
    public static final <T> i<T> C(@a7.d i<? extends T> iVar, @a7.d i5.q<? super T, ? super T, ? super kotlin.coroutines.d<? super T>, ? extends Object> qVar) {
        return k.z1(iVar, qVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @b1(expression = "drop(count)", imports = {}))
    public static final <T> i<T> D(@a7.d i<? extends T> iVar, int i7) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @b1(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> i<T> E(@a7.d i<? extends T> iVar, T t7) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @b1(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> i<T> F(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void G(@a7.d i<? extends T> iVar) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void H(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void I(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, @a7.d i5.p<? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar2) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'flowOn' instead")
    public static final <T> i<T> J(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @b1(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> i<R> K(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return k.b2(iVar, new e(pVar, null));
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @b1(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    public static final <T> i<T> a(@a7.d i<? extends T> iVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> i<R> b(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return k.D(iVar, iVar2, qVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> i<R> c(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i5.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.d<? super R>, ? extends Object> rVar) {
        return k.E(iVar, iVar2, iVar3, rVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> i<R> d(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i5.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.d<? super R>, ? extends Object> sVar) {
        return k.F(iVar, iVar2, iVar3, iVar4, sVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @b1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> i<R> e(@a7.d i<? extends T1> iVar, @a7.d i<? extends T2> iVar2, @a7.d i<? extends T3> iVar3, @a7.d i<? extends T4> iVar4, @a7.d i<? extends T5> iVar5, @a7.d i5.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.d<? super R>, ? extends Object> tVar) {
        return k.G(iVar, iVar2, iVar3, iVar4, iVar5, tVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @b1(expression = "let(transformer)", imports = {}))
    public static final <T, R> i<R> f(@a7.d i<? extends T> iVar, @a7.d i5.l<? super i<? extends T>, ? extends i<? extends R>> lVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @b1(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> i<R> g(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, ? extends i<? extends R>> lVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @b1(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> i<T> h(@a7.d i<? extends T> iVar, T t7) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @b1(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    public static final <T> i<T> i(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @b1(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> i<T> j(@a7.d i<? extends T> iVar, long j7) {
        return k.e1(iVar, new a(j7, null));
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @b1(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> i<T> k(@a7.d i<? extends T> iVar, long j7) {
        return k.l1(iVar, new b(j7, null));
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @b1(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> i<R> l(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @b1(expression = "flattenConcat()", imports = {}))
    public static final <T> i<T> m(@a7.d i<? extends i<? extends T>> iVar) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @b1(expression = "collect(action)", imports = {}))
    public static final <T> void n(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @b1(expression = "flattenConcat()", imports = {}))
    public static final <T> i<T> o(@a7.d i<? extends i<? extends T>> iVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    public static final Void p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> i<T> q(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @b1(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> i<T> r(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @b1(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> i<T> s(@a7.d i<? extends T> iVar, @a7.d i<? extends T> iVar2) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @b1(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> i<T> t(@a7.d i<? extends T> iVar, T t7) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @b1(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> i<T> u(@a7.d i<? extends T> iVar, T t7, @a7.d i5.l<? super Throwable, Boolean> lVar) {
        return k.u(iVar, new d(lVar, t7, null));
    }

    public static /* synthetic */ i v(i iVar, Object obj, i5.l lVar, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            lVar = c.f36813a;
        }
        return k.j1(iVar, obj, lVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.shareIn(scope, 0)", imports = {}))
    public static final <T> i<T> w(@a7.d i<? extends T> iVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    public static final <T> i<T> x(@a7.d i<? extends T> iVar, int i7) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> i<T> y(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @b1(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    public static final <T> i<T> z(@a7.d i<? extends T> iVar) {
        k.b1();
        throw new kotlin.y();
    }
}
