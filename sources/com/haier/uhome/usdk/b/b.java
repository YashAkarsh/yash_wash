package com.haier.uhome.usdk.b;

import com.haier.library.common.util.w;
import com.haier.uhome.usdk.api.R;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f31043a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f31044a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f31044a;
    }

    public void b() {
        e3.a.e("DNSTrace enable = %s", this.f31043a);
        if (this.f31043a.get()) {
            e3.a.e("parseDNS-->", new Object[0]);
            String[] stringArray = com.haier.uhome.usdk.base.service.e.a().b().getResources().getStringArray(R.array.hostname);
            HashMap<String, String> map = new HashMap<>();
            for (String str : stringArray) {
                map.put(str, w.e(str));
            }
            com.haier.uhome.trace.b.g.a().a(map);
        }
    }

    private b() {
        this.f31043a = new AtomicBoolean(true);
    }

    public void a(boolean z7) {
        this.f31043a.set(z7);
    }
}
