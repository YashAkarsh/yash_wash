package androidx.test.orchestrator.junit;

import android.os.Bundle;
import org.junit.runner.c;
import org.junit.runner.j;
import org.junit.runner.notification.a;

/* JADX INFO: loaded from: classes.dex */
public final class BundleJUnitUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10271a = "description";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10272b = "failure";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10273c = "result";

    private BundleJUnitUtils() {
    }

    public static Bundle a(c description) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("description", new ParcelableDescription(description));
        return bundle;
    }

    public static Bundle b(a failure) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f10272b, new ParcelableFailure(failure));
        return bundle;
    }

    public static Bundle c(j result) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("result", new ParcelableResult(result));
        return bundle;
    }

    public static Bundle d(c description, Throwable throwable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f10272b, new ParcelableFailure(new ParcelableDescription(description), throwable));
        return bundle;
    }

    public static ParcelableDescription e(Bundle bundle) {
        return (ParcelableDescription) bundle.getParcelable("description");
    }

    public static ParcelableFailure f(Bundle bundle) {
        return (ParcelableFailure) bundle.getParcelable(f10272b);
    }

    public static ParcelableResult g(Bundle bundle) {
        return (ParcelableResult) bundle.getParcelable("result");
    }
}
