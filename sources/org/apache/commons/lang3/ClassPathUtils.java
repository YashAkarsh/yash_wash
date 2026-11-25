package org.apache.commons.lang3;

import com.alibaba.android.arouter.utils.b;

/* JADX INFO: loaded from: classes3.dex */
public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r7, String str) {
        Validate.notNull(r7, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return r7.getName() + b.f12515h + str;
    }

    public static String toFullyQualifiedPath(Package r7, String str) {
        Validate.notNull(r7, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return r7.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + "/" + str;
    }
}
