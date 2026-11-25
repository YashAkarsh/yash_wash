package androidx.constraintlayout.core.state;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class c extends a implements androidx.constraintlayout.core.state.helpers.e {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    protected final h f3284j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    final h.e f3285k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected ArrayList<Object> f3286l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.j f3287m0;

    public c(h hVar, h.e eVar) {
        super(hVar);
        this.f3286l0 = new ArrayList<>();
        this.f3284j0 = hVar;
        this.f3285k0 = eVar;
    }

    public c L0(Object... objArr) {
        Collections.addAll(this.f3286l0, objArr);
        return this;
    }

    public androidx.constraintlayout.core.widgets.j M0() {
        return this.f3287m0;
    }

    public h.e N0() {
        return this.f3285k0;
    }

    public void O0(androidx.constraintlayout.core.widgets.j jVar) {
        this.f3287m0 = jVar;
    }

    @Override // androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public androidx.constraintlayout.core.widgets.e a() {
        return M0();
    }

    @Override // androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public void apply() {
    }
}
