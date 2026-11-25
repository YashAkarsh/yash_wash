package okhttp3.internal.cache;

import i5.l;
import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import okio.m;
import okio.m0;
import okio.r;

/* JADX INFO: loaded from: classes3.dex */
public class e extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f37695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final l<IOException, l2> f37696b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(@a7.d m0 delegate, @a7.d l<? super IOException, l2> onException) {
        super(delegate);
        l0.p(delegate, "delegate");
        l0.p(onException, "onException");
        this.f37696b = onException;
    }

    @a7.d
    public final l<IOException, l2> b() {
        return this.f37696b;
    }

    @Override // okio.r, okio.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f37695a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e8) {
            this.f37695a = true;
            this.f37696b.z(e8);
        }
    }

    @Override // okio.r, okio.m0, java.io.Flushable
    public void flush() {
        if (this.f37695a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e8) {
            this.f37695a = true;
            this.f37696b.z(e8);
        }
    }

    @Override // okio.r, okio.m0
    public void write(@a7.d m source, long j7) throws EOFException {
        l0.p(source, "source");
        if (this.f37695a) {
            source.skip(j7);
            return;
        }
        try {
            super.write(source, j7);
        } catch (IOException e8) {
            this.f37695a = true;
            this.f37696b.z(e8);
        }
    }
}
