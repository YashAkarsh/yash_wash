package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<t> f11589a = new ArrayList();

    void a(t tVar) {
        this.f11589a.add(tVar);
    }

    public void b(Path path) {
        for (int size = this.f11589a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.utils.j.b(path, this.f11589a.get(size));
        }
    }
}
