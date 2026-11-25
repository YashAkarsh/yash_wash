package org.chromium.net;

import org.chromium.base.ApplicationStatus;

/* JADX INFO: loaded from: classes3.dex */
public class j0 extends NetworkChangeNotifierAutoDetect.g implements ApplicationStatus.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39444c;

    @Override // org.chromium.base.ApplicationStatus.f
    public void a(int i7) {
        if (i7 == 1) {
            d();
        } else if (i7 == 2) {
            e();
        }
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.g
    protected void b() {
        if (this.f39444c) {
            return;
        }
        ApplicationStatus.x(this);
        this.f39444c = true;
    }

    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.g
    protected void c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.c(networkChangeNotifierAutoDetect);
        ApplicationStatus.s(this);
        a(f());
    }

    @org.chromium.base.s0
    int f() {
        return ApplicationStatus.getStateForApplication();
    }
}
