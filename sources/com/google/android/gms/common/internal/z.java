package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f15825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15826b;

    public z(@c.m0 Context context) {
        u.k(context);
        Resources resources = context.getResources();
        this.f15825a = resources;
        this.f15826b = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @c.o0
    @c1.a
    public String a(@c.m0 String str) {
        int identifier = this.f15825a.getIdentifier(str, androidx.constraintlayout.core.motion.utils.w.b.f3030e, this.f15826b);
        if (identifier == 0) {
            return null;
        }
        return this.f15825a.getString(identifier);
    }
}
