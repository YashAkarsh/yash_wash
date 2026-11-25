package kotlin.coroutines;

import com.alipay.sdk.util.m;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.a1;
import kotlin.d1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@a1
public final class k<T> implements d<T>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final a f34716b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final AtomicReferenceFieldUpdater<k<?>, Object> f34717c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, m.f13818c);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d<T> f34718a;

    @a7.e
    private volatile Object result;

    private static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private static /* synthetic */ void a() {
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@a7.d d<? super T> delegate, @a7.e Object obj) {
        l0.p(delegate, "delegate");
        this.f34718a = delegate;
        this.result = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return null;
    }

    @a7.e
    @a1
    public final Object a() throws Throwable {
        Object obj = this.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.UNDECIDED;
        if (obj == aVar) {
            if (androidx.concurrent.futures.b.a(f34717c, this, aVar, kotlin.coroutines.intrinsics.d.h())) {
                return kotlin.coroutines.intrinsics.d.h();
            }
            obj = this.result;
        }
        if (obj == kotlin.coroutines.intrinsics.a.RESUMED) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        if (obj instanceof d1.b) {
            throw ((d1.b) obj).f34721a;
        }
        return obj;
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public g d() {
        return this.f34718a.d();
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        d<T> dVar = this.f34718a;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @a7.d
    public String toString() {
        return "SafeContinuation for " + this.f34718a;
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        while (true) {
            Object obj2 = this.result;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.UNDECIDED;
            if (obj2 == aVar) {
                if (androidx.concurrent.futures.b.a(f34717c, this, aVar, obj)) {
                    return;
                }
            } else {
                if (obj2 != kotlin.coroutines.intrinsics.d.h()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.b.a(f34717c, this, kotlin.coroutines.intrinsics.d.h(), kotlin.coroutines.intrinsics.a.RESUMED)) {
                    this.f34718a.w(obj);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @a1
    public k(@a7.d d<? super T> delegate) {
        this(delegate, kotlin.coroutines.intrinsics.a.UNDECIDED);
        l0.p(delegate, "delegate");
    }
}
