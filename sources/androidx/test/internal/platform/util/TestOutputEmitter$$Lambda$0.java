package androidx.test.internal.platform.util;

import androidx.test.internal.platform.ServiceLoaderWrapper;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class TestOutputEmitter$$Lambda$0 implements ServiceLoaderWrapper.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ServiceLoaderWrapper.Factory f9922a = new TestOutputEmitter$$Lambda$0();

    private TestOutputEmitter$$Lambda$0() {
    }

    @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
    public Object create() {
        return TestOutputEmitter.d();
    }
}
