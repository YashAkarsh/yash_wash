package r3;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a3.a.f33a)
public class a implements IBaseApplication {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f40143b;

    @Override // com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication
    public void a() {
    }

    @Override // com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication
    public void b(Application application) {
        f40143b = application;
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication
    public void onLowMemory() {
    }

    @Override // com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication
    public void onTrimMemory(int i7) {
    }
}
