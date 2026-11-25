package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
final class c extends Random {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final a f34991c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    private static final long f34992d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final f f34993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34994b;

    private static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public c(@a7.d f impl) {
        l0.p(impl, "impl");
        this.f34993a = impl;
    }

    @a7.d
    public final f a() {
        return this.f34993a;
    }

    @Override // java.util.Random
    protected int next(int i7) {
        return this.f34993a.b(i7);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.f34993a.c();
    }

    @Override // java.util.Random
    public void nextBytes(@a7.d byte[] bytes) {
        l0.p(bytes, "bytes");
        this.f34993a.e(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.f34993a.h();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.f34993a.k();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.f34993a.l();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.f34993a.o();
    }

    @Override // java.util.Random
    public void setSeed(long j7) {
        if (this.f34994b) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.f34994b = true;
    }

    @Override // java.util.Random
    public int nextInt(int i7) {
        return this.f34993a.m(i7);
    }
}
