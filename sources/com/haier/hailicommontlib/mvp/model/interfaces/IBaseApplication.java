package com.haier.hailicommontlib.mvp.model.interfaces;

import android.app.Application;
import android.content.res.Configuration;
import com.alibaba.android.arouter.facade.template.IProvider;

/* JADX INFO: loaded from: classes2.dex */
public interface IBaseApplication extends IProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26158a = "IBaseApplication";

    void a();

    void b(Application application);

    void onConfigurationChanged(Configuration configuration);

    void onLowMemory();

    void onTrimMemory(int i7);
}
