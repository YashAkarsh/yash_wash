package com.haier.library.common.util.permissions;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, com.haier.library.common.util.permissions.a> f26609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f26610b;

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f26611a = new d();

        private b() {
        }
    }

    public static d d() {
        return b.f26611a;
    }

    private void e(Context context, String[] strArr, com.haier.library.common.util.permissions.a aVar) {
        int iJ = j();
        this.f26609a.put(Integer.valueOf(iJ), aVar);
        Intent intent = new Intent(context, (Class<?>) ShadowActivity.class);
        intent.putExtra(NativeProtocol.RESULT_ARGS_PERMISSIONS, strArr);
        intent.putExtra("sn", iJ);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(com.haier.library.common.util.permissions.b bVar, CountDownLatch countDownLatch, boolean z7, String[] strArr, String[] strArr2) {
        bVar.a(z7);
        bVar.b(strArr);
        bVar.d(strArr2);
        countDownLatch.countDown();
    }

    @TargetApi(23)
    private boolean g(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    private String[] i(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!g(context, str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private int j() {
        if (this.f26610b.get() == Integer.MAX_VALUE) {
            this.f26610b.set(1);
        }
        return this.f26610b.incrementAndGet();
    }

    protected com.haier.library.common.util.permissions.a b(int i7) {
        return this.f26609a.remove(Integer.valueOf(i7));
    }

    public com.haier.library.common.util.permissions.b c(Context context, String... strArr) {
        if (context == null || strArr.length == 0) {
            e3.a.h("invalid param(context=%s,permissions=%s) when request permission,so skip process", context, strArr);
            throw new IllegalArgumentException("Invalid param when request permissions.");
        }
        final com.haier.library.common.util.permissions.b bVar = new com.haier.library.common.util.permissions.b();
        String[] strArrI = i(context, strArr);
        if (strArrI.length == 0) {
            e3.a.e("no permissions need to be granted", new Object[0]);
            bVar.a(true);
            return bVar;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        e(context, strArrI, new com.haier.library.common.util.permissions.a() { // from class: com.haier.library.common.util.permissions.c
            @Override // com.haier.library.common.util.permissions.a
            public final void a(boolean z7, String[] strArr2, String[] strArr3) {
                d.f(bVar, countDownLatch, z7, strArr2, strArr3);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e8) {
            e3.a.e("requestPermission get excp %s", e8);
            Thread.currentThread().interrupt();
        }
        return bVar;
    }

    public void h() {
        this.f26609a.clear();
        this.f26610b.set(1);
    }

    private d() {
        this.f26609a = new ConcurrentHashMap<>();
        this.f26610b = new AtomicInteger(1);
    }
}
