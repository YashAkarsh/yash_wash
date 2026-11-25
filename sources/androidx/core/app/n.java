package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
@c.t0(28)
public class n extends AppComponentFactory {
    @c.m0
    public Activity a(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (Activity) Class.forName(str, false, classLoader).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e8) {
            throw new RuntimeException("Couldn't call constructor", e8);
        }
    }

    @c.m0
    public Application b(@c.m0 ClassLoader classLoader, @c.m0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (Application) Class.forName(str, false, classLoader).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e8) {
            throw new RuntimeException("Couldn't call constructor", e8);
        }
    }

    @c.m0
    public ContentProvider c(@c.m0 ClassLoader classLoader, @c.m0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (ContentProvider) Class.forName(str, false, classLoader).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e8) {
            throw new RuntimeException("Couldn't call constructor", e8);
        }
    }

    @c.m0
    public BroadcastReceiver d(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (BroadcastReceiver) Class.forName(str, false, classLoader).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e8) {
            throw new RuntimeException("Couldn't call constructor", e8);
        }
    }

    @c.m0
    public Service e(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (Service) Class.forName(str, false, classLoader).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e8) {
            throw new RuntimeException("Couldn't call constructor", e8);
        }
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public final Activity instantiateActivity(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Activity) s.a(a(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public final Application instantiateApplication(@c.m0 ClassLoader classLoader, @c.m0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Application) s.a(b(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public final ContentProvider instantiateProvider(@c.m0 ClassLoader classLoader, @c.m0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (ContentProvider) s.a(c(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public final BroadcastReceiver instantiateReceiver(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (BroadcastReceiver) s.a(d(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @c.m0
    public final Service instantiateService(@c.m0 ClassLoader classLoader, @c.m0 String str, @c.o0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Service) s.a(e(classLoader, str, intent));
    }
}
