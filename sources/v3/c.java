package v3;

import android.app.Activity;
import com.jiao.project.bluetoothofabroadwasherapp.enums.d;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f40430a = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    boolean a(String str);

    com.haier.hailicommontlib.mvp.model.utils.loading.a b();

    <T> T c();

    void d();

    void e(String str, String str2, a aVar);

    void f(Activity activity, b bVar, t3.b bVar2);

    void g(String str, a aVar);

    d h(String str);

    void i();

    <T> void j(T t7);
}
