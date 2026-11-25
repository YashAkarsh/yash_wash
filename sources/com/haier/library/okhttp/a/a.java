package com.haier.library.okhttp.a;

import android.text.TextUtils;
import com.haier.library.okhttp.c0;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c0 f26901b = c0.f27512a;

    private List<InetAddress> b(List<String> list) throws UnknownHostException {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(InetAddress.getAllByName(it.next())));
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private c c(String str) {
        return b.a().g().get(str);
    }

    private boolean d(String str) {
        if (str.length() < 7 || str.length() > 15) {
            return false;
        }
        return str.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
    }

    @Override // com.haier.library.okhttp.c0
    public List<InetAddress> a(String str) throws UnknownHostException {
        e3.a.e("https dns lookup url:" + str, new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (d(str)) {
            arrayList.addAll(Arrays.asList(InetAddress.getAllByName(str)));
            return arrayList;
        }
        if (!b.a().h().get()) {
            List<InetAddress> listA = f26901b.a(str);
            e3.a.e("https dns disable url:" + str + " so with system lookup result:" + listA, new Object[0]);
            if (listA == null || listA.size() <= 0) {
                return null;
            }
            return listA;
        }
        c cVarC = c(str);
        if (b.a().e(cVarC)) {
            List<InetAddress> listB = b(cVarC.a());
            e3.a.e("https dns from cache return:" + listB, new Object[0]);
            return listB;
        }
        if (b.a().f(str)) {
            c cVarC2 = c(str);
            if (b.a().e(cVarC2)) {
                List<InetAddress> listB2 = b(cVarC2.a());
                e3.a.e("https dns direct return:" + listB2, new Object[0]);
                return listB2;
            }
        }
        e3.a.e("https dns fail! so with system dns lookup", new Object[0]);
        List<InetAddress> listA2 = f26901b.a(str);
        e3.a.e("https dns enable url:" + str + " so with system lookup result:" + listA2, new Object[0]);
        if (listA2 == null || listA2.size() <= 0) {
            return null;
        }
        return listA2;
    }
}
