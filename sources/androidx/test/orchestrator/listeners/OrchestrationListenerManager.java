package androidx.test.orchestrator.listeners;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import androidx.test.orchestrator.junit.BundleJUnitUtils;
import androidx.test.orchestrator.junit.ParcelableDescription;
import androidx.test.orchestrator.junit.ParcelableFailure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OrchestrationListenerManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10282e = "ListenerManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10283f = "TestEvent";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Instrumentation f10285b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ParcelableDescription f10287d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<OrchestrationRunListener> f10284a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10286c = false;

    /* JADX INFO: renamed from: androidx.test.orchestrator.listeners.OrchestrationListenerManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10288a;

        static {
            int[] iArr = new int[TestEvent.values().length];
            f10288a = iArr;
            try {
                iArr[TestEvent.TEST_RUN_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10288a[TestEvent.TEST_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10288a[TestEvent.TEST_RUN_FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10288a[TestEvent.TEST_STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10288a[TestEvent.TEST_FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10288a[TestEvent.TEST_ASSUMPTION_FAILURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10288a[TestEvent.TEST_IGNORED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum TestEvent {
        TEST_RUN_STARTED,
        TEST_RUN_FINISHED,
        TEST_STARTED,
        TEST_FINISHED,
        TEST_FAILURE,
        TEST_ASSUMPTION_FAILURE,
        TEST_IGNORED
    }

    public OrchestrationListenerManager(Instrumentation instrumentation) {
        if (instrumentation == null) {
            throw new IllegalArgumentException("Instrumentation must not be null");
        }
        this.f10285b = instrumentation;
    }

    private void b(Bundle bundle) {
        if (BundleJUnitUtils.e(bundle) != null) {
            this.f10287d = BundleJUnitUtils.e(bundle);
        }
        int i7 = AnonymousClass1.f10288a[TestEvent.valueOf(bundle.getString(f10283f)).ordinal()];
        if (i7 == 1) {
            this.f10286c = true;
        } else if (i7 == 2) {
            this.f10286c = false;
        } else {
            if (i7 != 3) {
                return;
            }
            this.f10286c = false;
        }
    }

    private void d(OrchestrationRunListener listener, Bundle bundle) {
        switch (AnonymousClass1.f10288a[TestEvent.valueOf(bundle.getString(f10283f)).ordinal()]) {
            case 1:
                listener.j(BundleJUnitUtils.e(bundle));
                break;
            case 2:
                listener.e(BundleJUnitUtils.f(bundle));
                break;
            case 3:
                listener.i(BundleJUnitUtils.g(bundle));
                break;
            case 4:
                listener.k(BundleJUnitUtils.e(bundle));
                break;
            case 5:
                listener.f(BundleJUnitUtils.e(bundle));
                break;
            case 6:
                listener.d(BundleJUnitUtils.f(bundle));
                break;
            case 7:
                listener.g(BundleJUnitUtils.e(bundle));
                break;
            default:
                Log.e(f10282e, "Unknown notification type");
                break;
        }
    }

    public void a(OrchestrationRunListener listener) {
        listener.c(this.f10285b);
        this.f10284a.add(listener);
    }

    public void c(Bundle bundle) {
        bundle.setClassLoader(OrchestrationListenerManager.class.getClassLoader());
        b(bundle);
        Iterator<OrchestrationRunListener> it = this.f10284a.iterator();
        while (it.hasNext()) {
            d(it.next(), bundle);
        }
    }

    public void e(int testCount) {
        Iterator<OrchestrationRunListener> it = this.f10284a.iterator();
        while (it.hasNext()) {
            it.next().b(testCount);
        }
    }

    public void f(String outputFile) {
        if (this.f10286c) {
            for (OrchestrationRunListener orchestrationRunListener : this.f10284a) {
                ParcelableDescription parcelableDescription = this.f10287d;
                StringBuilder sb = new StringBuilder(String.valueOf(outputFile).length() + 56);
                sb.append("Test instrumentation process crashed. Check ");
                sb.append(outputFile);
                sb.append(" for details");
                orchestrationRunListener.e(new ParcelableFailure(parcelableDescription, new Throwable(sb.toString())));
                orchestrationRunListener.f(this.f10287d);
            }
        }
    }

    public void g(ParcelableDescription description) {
        this.f10287d = description;
        this.f10286c = true;
    }
}
