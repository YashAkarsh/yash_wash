package androidx.test.internal.statement;

import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
public class UiThreadStatement extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f10231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10232b;

    public UiThreadStatement(j base, boolean runOnUiThread) {
        this.f10231a = base;
        this.f10232b = runOnUiThread;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        if (!this.f10232b) {
            this.f10231a.a();
            return;
        }
        final AtomicReference atomicReference = new AtomicReference();
        InstrumentationRegistry.b().runOnMainSync(new Runnable() { // from class: androidx.test.internal.statement.UiThreadStatement.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UiThreadStatement.this.f10231a.a();
                } catch (Throwable th) {
                    atomicReference.set(th);
                }
            }
        });
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            throw th;
        }
    }
}
