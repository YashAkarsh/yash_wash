package com.alibaba.android.arouter.core;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f12450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static ThreadPoolExecutor f12451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f12452c;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12453a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f12453a = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12453a[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Postcard a(String str) {
        RouteMeta routeMeta = f.f12457d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void b(Postcard postcard) {
        if (postcard == null) {
            throw new d0.c("ARouter::No postcard!");
        }
        RouteMeta routeMeta = f.f12455b.get(postcard.getPath());
        if (routeMeta == null) {
            Class<? extends IRouteGroup> cls = f.f12454a.get(postcard.getGroup());
            if (cls == null) {
                throw new d0.c("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
            }
            try {
                if (com.alibaba.android.arouter.launcher.a.f()) {
                    com.alibaba.android.arouter.launcher.a.f12464e.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                cls.getConstructor(new Class[0]).newInstance(new Object[0]).loadInto(f.f12455b);
                f.f12454a.remove(postcard.getGroup());
                if (com.alibaba.android.arouter.launcher.a.f()) {
                    com.alibaba.android.arouter.launcher.a.f12464e.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                b(postcard);
            } catch (Exception e8) {
                throw new d0.a("ARouter::Fatal exception when loading group meta. [" + e8.getMessage() + "]");
            }
        } else {
            postcard.setDestination(routeMeta.getDestination());
            postcard.setType(routeMeta.getType());
            postcard.setPriority(routeMeta.getPriority());
            postcard.setExtra(routeMeta.getExtra());
            Uri uri = postcard.getUri();
            if (uri != null) {
                Map<String, String> mapE = com.alibaba.android.arouter.utils.f.e(uri);
                Map<String, Integer> paramsType = routeMeta.getParamsType();
                if (com.alibaba.android.arouter.utils.d.b(paramsType)) {
                    for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                        j(postcard, entry.getValue(), entry.getKey(), mapE.get(entry.getKey()));
                    }
                    postcard.getExtras().putStringArray(com.alibaba.android.arouter.launcher.a.f12461b, (String[]) paramsType.keySet().toArray(new String[0]));
                }
                postcard.withString(com.alibaba.android.arouter.launcher.a.f12460a, uri.toString());
            }
            int i7 = a.f12453a[routeMeta.getType().ordinal()];
            if (i7 == 1) {
                Class<?> destination = routeMeta.getDestination();
                IProvider iProvider = f.f12456c.get(destination);
                if (iProvider == null) {
                    try {
                        iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iProvider.init(f12450a);
                        f.f12456c.put(destination, iProvider);
                    } catch (Exception e9) {
                        throw new d0.a("Init provider failed! " + e9.getMessage());
                    }
                }
                postcard.setProvider(iProvider);
                postcard.greenChannel();
            } else if (i7 == 2) {
                postcard.greenChannel();
            }
        }
    }

    public static synchronized void c(Context context, ThreadPoolExecutor threadPoolExecutor) throws d0.a {
        Set<String> setA;
        f12450a = context;
        f12451b = threadPoolExecutor;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            d();
            if (f12452c) {
                com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Load router map by arouter-auto-register plugin.");
            } else {
                if (com.alibaba.android.arouter.launcher.a.f() || com.alibaba.android.arouter.utils.e.b(context)) {
                    com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Run with debug mode or new install, rebuild router map.");
                    setA = com.alibaba.android.arouter.utils.a.a(f12450a, "com.alibaba.android.arouter.routes");
                    if (!setA.isEmpty()) {
                        context.getSharedPreferences(com.alibaba.android.arouter.utils.b.f12517j, 0).edit().putStringSet(com.alibaba.android.arouter.utils.b.f12518k, setA).apply();
                    }
                    com.alibaba.android.arouter.utils.e.c(context);
                } else {
                    com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Load router map from cache.");
                    setA = new HashSet<>(context.getSharedPreferences(com.alibaba.android.arouter.utils.b.f12517j, 0).getStringSet(com.alibaba.android.arouter.utils.b.f12518k, new HashSet()));
                }
                com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Find router map finished, map size = " + setA.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : setA) {
                    if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                        ((IRouteRoot) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(f.f12454a);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                        ((IInterceptorGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(f.f12458e);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                        ((IProviderGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(f.f12457d);
                    }
                }
            }
            com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Load root element finished, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
            if (f.f12454a.size() == 0) {
                com.alibaba.android.arouter.launcher.a.f12464e.error("ARouter::", "No mapping files were found, check your configuration please!");
            }
            if (com.alibaba.android.arouter.launcher.a.f()) {
                com.alibaba.android.arouter.launcher.a.f12464e.debug("ARouter::", String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(f.f12454a.size()), Integer.valueOf(f.f12458e.size()), Integer.valueOf(f.f12457d.size())));
            }
        } catch (Exception e8) {
            throw new d0.a("ARouter::ARouter init logistics center exception! [" + e8.getMessage() + "]");
        }
    }

    private static void d() {
        f12452c = false;
    }

    private static void e() {
        if (f12452c) {
            return;
        }
        f12452c = true;
    }

    private static void f(String str) {
        if (com.alibaba.android.arouter.utils.f.d(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof IRouteRoot) {
                i((IRouteRoot) objNewInstance);
            } else if (objNewInstance instanceof IProviderGroup) {
                h((IProviderGroup) objNewInstance);
            } else if (objNewInstance instanceof IInterceptorGroup) {
                g((IInterceptorGroup) objNewInstance);
            } else {
                com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
            }
        } catch (Exception unused) {
            com.alibaba.android.arouter.launcher.a.f12464e.error("ARouter::", "register class error:" + str);
        }
    }

    private static void g(IInterceptorGroup iInterceptorGroup) {
        e();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(f.f12458e);
        }
    }

    private static void h(IProviderGroup iProviderGroup) {
        e();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(f.f12457d);
        }
    }

    private static void i(IRouteRoot iRouteRoot) {
        e();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(f.f12454a);
        }
    }

    private static void j(Postcard postcard, Integer num, String str, String str2) {
        if (com.alibaba.android.arouter.utils.f.d(str) || com.alibaba.android.arouter.utils.f.d(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
            } else if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
            } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.valueOf(str2).byteValue());
            } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.valueOf(str2).shortValue());
            } else if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.valueOf(str2).intValue());
            } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.valueOf(str2).longValue());
            } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.valueOf(str2).floatValue());
            } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.valueOf(str2).doubleValue());
            } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th) {
            com.alibaba.android.arouter.launcher.a.f12464e.warning("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
        }
    }

    public static void k() {
        f.a();
    }
}
