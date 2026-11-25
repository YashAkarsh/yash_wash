package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
@c.t0(api = 28)
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class s extends AppComponentFactory {

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public interface a {
        Object a();
    }

    static <T> T a(T t7) {
        T t8;
        return (!(t7 instanceof a) || (t8 = (T) ((a) t7).a()) == null) ? t7 : t8;
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public Activity instantiateActivity(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Activity) a(super.instantiateActivity(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public Application instantiateApplication(@c.m0 ClassLoader classLoader, @c.m0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Application) a(super.instantiateApplication(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public ContentProvider instantiateProvider(@c.m0 ClassLoader classLoader, @c.m0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (ContentProvider) a(super.instantiateProvider(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public BroadcastReceiver instantiateReceiver(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (BroadcastReceiver) a(super.instantiateReceiver(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public Service instantiateService(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Service) a(super.instantiateService(classLoader, str, intent));
    }
}
