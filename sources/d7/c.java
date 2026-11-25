package d7;

import java.util.Comparator;
import org.junit.runner.i;
import org.junit.runner.l;
import org.junit.runner.manipulation.e;

/* JADX INFO: loaded from: classes3.dex */
public class c extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f33512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator<org.junit.runner.c> f33513b;

    public c(i iVar, Comparator<org.junit.runner.c> comparator) {
        this.f33512a = iVar;
        this.f33513b = comparator;
    }

    @Override // org.junit.runner.i
    public l h() {
        l lVarH = this.f33512a.h();
        new e(this.f33513b).a(lVarH);
        return lVarH;
    }
}
