package org.junit.rules;

import java.lang.management.ManagementFactory;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f39914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39915b;

    public a(l lVar) {
        this(lVar, ManagementFactory.getRuntimeMXBean().getInputArguments());
    }

    private static boolean c(List<String> list) {
        for (String str : list) {
            if ("-Xdebug".equals(str) || str.startsWith("-agentlib:jdwp")) {
                return true;
            }
        }
        return false;
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        return this.f39915b ? jVar : this.f39914a.a(jVar, cVar);
    }

    public boolean b() {
        return this.f39915b;
    }

    a(l lVar, List<String> list) {
        this.f39914a = lVar;
        this.f39915b = c(list);
    }
}
