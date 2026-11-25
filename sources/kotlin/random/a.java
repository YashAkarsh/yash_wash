package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends f {
    @Override // kotlin.random.f
    public int b(int i7) {
        return g.j(r().nextInt(), i7);
    }

    @Override // kotlin.random.f
    public boolean c() {
        return r().nextBoolean();
    }

    @Override // kotlin.random.f
    @a7.d
    public byte[] e(@a7.d byte[] array) {
        l0.p(array, "array");
        r().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.f
    public double h() {
        return r().nextDouble();
    }

    @Override // kotlin.random.f
    public float k() {
        return r().nextFloat();
    }

    @Override // kotlin.random.f
    public int l() {
        return r().nextInt();
    }

    @Override // kotlin.random.f
    public int m(int i7) {
        return r().nextInt(i7);
    }

    @Override // kotlin.random.f
    public long o() {
        return r().nextLong();
    }

    @a7.d
    public abstract Random r();
}
