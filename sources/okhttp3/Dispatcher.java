package okhttp3;

import a7.e;
import androidx.core.app.l2;
import h5.h;
import j0.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.b1;
import kotlin.collections.g0;
import kotlin.collections.z;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;
import okhttp3.internal.d;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b;\u0010=J\u0016\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J+\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0013\u001a\u00020\rJ\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u000f\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!R*\u0010#\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010)\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R.\u0010.\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u00107\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u0005068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u00109\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u0005068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0005068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u0011\u0010\"\u001a\u00020\u001f8G¢\u0006\u0006\u001a\u0004\b\"\u0010!¨\u0006>"}, d2 = {"Lokhttp3/Dispatcher;", "", "", c.f34242f, "Lokhttp3/internal/connection/e$a;", "Lokhttp3/internal/connection/e;", "findExistingCallWithHost", "", "promoteAndExecute", "T", "Ljava/util/Deque;", "calls", l2.f5208p0, "Lkotlin/l2;", "finished", "(Ljava/util/Deque;Ljava/lang/Object;)V", "enqueue$okhttp", "(Lokhttp3/internal/connection/e$a;)V", "enqueue", "cancelAll", "executed$okhttp", "(Lokhttp3/internal/connection/e;)V", "executed", "finished$okhttp", "", "Lokhttp3/Call;", "queuedCalls", "runningCalls", "", "queuedCallsCount", "runningCallsCount", "Ljava/util/concurrent/ExecutorService;", "-deprecated_executorService", "()Ljava/util/concurrent/ExecutorService;", "executorService", "maxRequests", "I", "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ljava/lang/Runnable;", "<set-?>", "idleCallback", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "executorServiceOrNull", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "runningAsyncCalls", "runningSyncCalls", "<init>", "()V", "(Ljava/util/concurrent/ExecutorService;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;

    @e
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<okhttp3.internal.connection.e.a> readyAsyncCalls;
    private final ArrayDeque<okhttp3.internal.connection.e.a> runningAsyncCalls;
    private final ArrayDeque<okhttp3.internal.connection.e> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final okhttp3.internal.connection.e.a findExistingCallWithHost(String str) {
        for (okhttp3.internal.connection.e.a aVar : this.runningAsyncCalls) {
            if (l0.g(aVar.d(), str)) {
                return aVar;
            }
        }
        for (okhttp3.internal.connection.e.a aVar2 : this.readyAsyncCalls) {
            if (l0.g(aVar2.d(), str)) {
                return aVar2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t7) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t7)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.idleCallback;
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean promoteAndExecute() {
        int i7;
        boolean z7;
        if (d.f37861h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<okhttp3.internal.connection.e.a> it = this.readyAsyncCalls.iterator();
            l0.o(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                okhttp3.internal.connection.e.a asyncCall = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (asyncCall.c().get() < this.maxRequestsPerHost) {
                    it.remove();
                    asyncCall.c().incrementAndGet();
                    l0.o(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.runningAsyncCalls.add(asyncCall);
                }
            }
            z7 = runningCallsCount() > 0;
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        }
        int size = arrayList.size();
        for (i7 = 0; i7 < size; i7++) {
            ((okhttp3.internal.connection.e.a) arrayList.get(i7)).a(executorService());
        }
        return z7;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "executorService", imports = {}))
    @h(name = "-deprecated_executorService")
    /* JADX INFO: renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m41deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<okhttp3.internal.connection.e.a> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().b().cancel();
        }
        Iterator<okhttp3.internal.connection.e.a> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().b().cancel();
        }
        Iterator<okhttp3.internal.connection.e> it3 = this.runningSyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final void enqueue$okhttp(@a7.d okhttp3.internal.connection.e.a call) {
        okhttp3.internal.connection.e.a aVarFindExistingCallWithHost;
        l0.p(call, "call");
        synchronized (this) {
            this.readyAsyncCalls.add(call);
            if (!call.b().p() && (aVarFindExistingCallWithHost = findExistingCallWithHost(call.d())) != null) {
                call.f(aVarFindExistingCallWithHost);
            }
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(@a7.d okhttp3.internal.connection.e call) {
        l0.p(call, "call");
        this.runningSyncCalls.add(call);
    }

    @a7.d
    @h(name = "executorService")
    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.U(d.f37862i + " Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        l0.m(executorService);
        return executorService;
    }

    public final void finished$okhttp(@a7.d okhttp3.internal.connection.e.a call) {
        l0.p(call, "call");
        call.c().decrementAndGet();
        finished(this.runningAsyncCalls, call);
    }

    @e
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @a7.d
    public final synchronized List<Call> queuedCalls() {
        List<Call> listUnmodifiableList;
        ArrayDeque<okhttp3.internal.connection.e.a> arrayDeque = this.readyAsyncCalls;
        ArrayList arrayList = new ArrayList(z.Z(arrayDeque, 10));
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            arrayList.add(((okhttp3.internal.connection.e.a) it.next()).b());
        }
        listUnmodifiableList = Collections.unmodifiableList(arrayList);
        l0.o(listUnmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        return listUnmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    @a7.d
    public final synchronized List<Call> runningCalls() {
        List<Call> listUnmodifiableList;
        ArrayDeque<okhttp3.internal.connection.e> arrayDeque = this.runningSyncCalls;
        ArrayDeque<okhttp3.internal.connection.e.a> arrayDeque2 = this.runningAsyncCalls;
        ArrayList arrayList = new ArrayList(z.Z(arrayDeque2, 10));
        Iterator<T> it = arrayDeque2.iterator();
        while (it.hasNext()) {
            arrayList.add(((okhttp3.internal.connection.e.a) it.next()).b());
        }
        listUnmodifiableList = Collections.unmodifiableList(g0.y4(arrayDeque, arrayList));
        l0.o(listUnmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        return listUnmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(@e Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i7) {
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + i7).toString());
        }
        synchronized (this) {
            this.maxRequests = i7;
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        }
        promoteAndExecute();
    }

    public final void setMaxRequestsPerHost(int i7) {
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + i7).toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = i7;
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        }
        promoteAndExecute();
    }

    public final void finished$okhttp(@a7.d okhttp3.internal.connection.e call) {
        l0.p(call, "call");
        finished(this.runningSyncCalls, call);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(@a7.d ExecutorService executorService) {
        this();
        l0.p(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }
}
