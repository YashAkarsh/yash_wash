package org.chromium.base;

import J.N;

/* JADX INFO: loaded from: classes3.dex */
final class c implements b.InterfaceC0519b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b.InterfaceC0519b f38779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r<b.InterfaceC0519b> f38780b = new a();

    class a implements r<b.InterfaceC0519b> {
        a() {
        }

        @Override // org.chromium.base.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b.InterfaceC0519b interfaceC0519b) {
            b.InterfaceC0519b unused = c.f38779a = interfaceC0519b;
        }
    }

    c() {
    }

    public static b.InterfaceC0519b c() {
        if (N.f0a) {
            b.InterfaceC0519b interfaceC0519b = f38779a;
            if (interfaceC0519b != null) {
                return interfaceC0519b;
            }
            if (N.f1b) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.AnimationFrameTimeHistogram.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        return new c();
    }

    @Override // org.chromium.base.b.InterfaceC0519b
    public void a(String str, long[] jArr, int i7) {
        N.M7xB0tc0(str, jArr, i7);
    }
}
