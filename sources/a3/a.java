package a3;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f33a = "/bluetooth_application/BlueToothOfAbroadWasherApp";

    public static String[] a() {
        Field[] fields = a.class.getFields();
        String[] strArr = new String[fields.length];
        for (int i7 = 0; i7 < fields.length; i7++) {
            strArr = new String[fields.length];
            try {
                strArr[i7] = (String) fields[i7].get(null);
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
                System.out.println(e8.toString());
            }
        }
        return strArr;
    }
}
