package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.a1;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.u0;

/* JADX INFO: loaded from: classes2.dex */
@a1
public final class j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Long f35968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final String f35969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private final String f35970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final String f35971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private final String f35972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private final String f35973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final List<StackTraceElement> f35974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f35975h;

    public j(@a7.d e eVar, @a7.d kotlin.coroutines.g gVar) {
        Thread.State state;
        t0 t0Var = (t0) gVar.get(t0.f37299b);
        this.f35968a = t0Var == null ? null : Long.valueOf(t0Var.a1());
        kotlin.coroutines.e eVar2 = (kotlin.coroutines.e) gVar.get(kotlin.coroutines.e.f34677q0);
        this.f35969b = eVar2 == null ? null : eVar2.toString();
        u0 u0Var = (u0) gVar.get(u0.f37321b);
        this.f35970c = u0Var == null ? null : u0Var.a1();
        this.f35971d = eVar.g();
        Thread thread = eVar.f35935e;
        this.f35972e = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = eVar.f35935e;
        this.f35973f = thread2 != null ? thread2.getName() : null;
        this.f35974g = eVar.h();
        this.f35975h = eVar.f35932b;
    }

    @a7.e
    public final Long a() {
        return this.f35968a;
    }

    @a7.e
    public final String b() {
        return this.f35969b;
    }

    @a7.d
    public final List<StackTraceElement> c() {
        return this.f35974g;
    }

    @a7.e
    public final String d() {
        return this.f35973f;
    }

    @a7.e
    public final String e() {
        return this.f35972e;
    }

    @a7.e
    public final String f() {
        return this.f35970c;
    }

    public final long g() {
        return this.f35975h;
    }

    @a7.d
    public final String h() {
        return this.f35971d;
    }
}
