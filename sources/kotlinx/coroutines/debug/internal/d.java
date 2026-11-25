package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.a1;

/* JADX INFO: loaded from: classes2.dex */
@a1
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f35923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final kotlin.coroutines.jvm.internal.e f35924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final List<StackTraceElement> f35926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final String f35927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private final Thread f35928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.e
    private final kotlin.coroutines.jvm.internal.e f35929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private final List<StackTraceElement> f35930h;

    public d(@a7.d e eVar, @a7.d kotlin.coroutines.g gVar) {
        this.f35923a = gVar;
        this.f35924b = eVar.d();
        this.f35925c = eVar.f35932b;
        this.f35926d = eVar.e();
        this.f35927e = eVar.g();
        this.f35928f = eVar.f35935e;
        this.f35929g = eVar.f();
        this.f35930h = eVar.h();
    }

    @a7.d
    public final kotlin.coroutines.g a() {
        return this.f35923a;
    }

    @a7.e
    public final kotlin.coroutines.jvm.internal.e b() {
        return this.f35924b;
    }

    @a7.d
    public final List<StackTraceElement> c() {
        return this.f35926d;
    }

    @a7.e
    public final kotlin.coroutines.jvm.internal.e d() {
        return this.f35929g;
    }

    @a7.e
    public final Thread e() {
        return this.f35928f;
    }

    public final long f() {
        return this.f35925c;
    }

    @a7.d
    public final String g() {
        return this.f35927e;
    }

    @a7.d
    @h5.h(name = "lastObservedStackTrace")
    public final List<StackTraceElement> h() {
        return this.f35930h;
    }
}
