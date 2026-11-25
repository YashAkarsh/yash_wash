package h3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.a f34042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f34043b;

    public d(Class<?> cls, i3.a aVar, int i7) {
        this.f34043b = cls;
        this.f34042a = aVar;
    }

    public abstract void a(com.haier.library.json.parser.b bVar, Object obj, Type type, Map<String, Object> map);

    public void b(Object obj, double d8) throws IllegalAccessException {
        this.f34042a.f34163c.setDouble(obj, d8);
    }

    public void c(Object obj, float f8) throws IllegalAccessException {
        this.f34042a.f34163c.setFloat(obj, f8);
    }

    public void d(Object obj, int i7) throws IllegalAccessException {
        this.f34042a.f34163c.setInt(obj, i7);
    }

    public void e(Object obj, long j7) throws IllegalAccessException {
        this.f34042a.f34163c.setLong(obj, j7);
    }

    public void f(Object obj, Object obj2) {
        if (obj2 == null && this.f34042a.f34167g.isPrimitive()) {
            return;
        }
        i3.a aVar = this.f34042a;
        Field field = aVar.f34163c;
        Method method = aVar.f34162b;
        try {
            if (aVar.f34164d) {
                if (!aVar.f34170j) {
                    field.set(obj, obj2);
                    return;
                }
                if (Map.class.isAssignableFrom(aVar.f34167g)) {
                    Map map = (Map) field.get(obj);
                    if (map != null) {
                        map.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                Collection collection = (Collection) field.get(obj);
                if (collection != null) {
                    collection.addAll((Collection) obj2);
                    return;
                }
                return;
            }
            if (!aVar.f34170j) {
                method.invoke(obj, obj2);
                return;
            }
            if (Map.class.isAssignableFrom(aVar.f34167g)) {
                Map map2 = (Map) method.invoke(obj, new Object[0]);
                if (map2 != null) {
                    map2.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
            if (collection2 != null) {
                collection2.addAll((Collection) obj2);
            }
        } catch (Exception e8) {
            throw new com.haier.library.json.d("set property error, " + this.f34042a.f34161a, e8);
        }
    }
}
