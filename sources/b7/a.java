package b7;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.junit.runners.g;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes3.dex */
public class a extends g {
    public a(Class<?> cls, h hVar) throws Throwable {
        super(hVar, cls, K(cls.getClasses()));
    }

    private static Class<?>[] K(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add(cls);
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }
}
