package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes3.dex */
abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    MemberUtils() {
    }

    static int compareParameterTypes(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f8 = 0.0f;
        while (cls != null && !cls2.equals(cls)) {
            if (cls2.isInterface() && ClassUtils.isAssignable(cls, cls2)) {
                f8 += 0.25f;
                break;
            }
            f8 += 1.0f;
            cls = cls.getSuperclass();
        }
        return cls == null ? f8 + 1.5f : f8;
    }

    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f8;
        if (cls.isPrimitive()) {
            f8 = 0.0f;
        } else {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f8 = 0.1f;
        }
        int i7 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i7 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i7]) {
                f8 += 0.1f;
                if (i7 < clsArr.length - 1) {
                    cls = clsArr[i7 + 1];
                }
            }
            i7++;
        }
        return f8;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float objectTransformationCost = 0.0f;
        for (int i7 = 0; i7 < clsArr.length; i7++) {
            objectTransformationCost += getObjectTransformationCost(clsArr[i7], clsArr2[i7]);
        }
        return objectTransformationCost;
    }

    static boolean isAccessible(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    static boolean isPackageAccess(int i7) {
        return (i7 & 7) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }
}
