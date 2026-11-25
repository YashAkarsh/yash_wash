package androidx.lifecycle;

import androidx.core.app.l2;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes.dex */
@kotlin.i0(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/o;", "Landroidx/lifecycle/q;", ShareConstants.FEED_SOURCE_PARAM, "Landroidx/lifecycle/m$b;", l2.f5216t0, "Lkotlin/l2;", "g", "Landroidx/lifecycle/f0;", "a", "Landroidx/lifecycle/f0;", "provider", "<init>", "(Landroidx/lifecycle/f0;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0})
public final class SavedStateHandleAttacher implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final f0 f8241a;

    public SavedStateHandleAttacher(@a7.d f0 provider) {
        kotlin.jvm.internal.l0.p(provider, "provider");
        this.f8241a = provider;
    }

    @Override // androidx.lifecycle.o
    public void g(@a7.d q source, @a7.d m.b event) {
        kotlin.jvm.internal.l0.p(source, "source");
        kotlin.jvm.internal.l0.p(event, "event");
        if (event == m.b.ON_CREATE) {
            source.getLifecycle().c(this);
            this.f8241a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
