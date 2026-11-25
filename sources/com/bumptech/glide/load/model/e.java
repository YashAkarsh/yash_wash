package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final e f14474a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f14475b = new j.a().c();

    static class a implements e {
        a() {
        }

        @Override // com.bumptech.glide.load.model.e
        public Map<String, String> a() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> a();
}
