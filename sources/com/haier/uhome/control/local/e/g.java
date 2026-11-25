package com.haier.uhome.control.local.e;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<String> f29427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<String, List<a>> f29428b;

    public interface a {
        void onUplusIdReady();
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f29429a = new g();

        private b() {
        }
    }

    public static g a() {
        return b.f29429a;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f29427a.contains(str);
    }

    private g() {
        this.f29427a = new CopyOnWriteArrayList();
        this.f29428b = new ConcurrentHashMap();
    }

    public void a(String str) {
        this.f29427a.add(str);
        List<a> list = this.f29428b.get(str);
        if (list == null) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            it.next().onUplusIdReady();
        }
    }

    public synchronized void a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<a> copyOnWriteArrayList = this.f29428b.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f29428b.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(aVar);
        if (b(str)) {
            aVar.onUplusIdReady();
        }
    }
}
