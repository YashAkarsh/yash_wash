package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import c.o0;
import com.alipay.sdk.util.j;
import com.facebook.FacebookSdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseEventManager";
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    InAppPurchaseEventManager() {
    }

    @o0
    static Object asInterface(Context context, IBinder iBinder) {
        return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
    }

    static void clearSkuDetailsCache() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = skuDetailSharedPrefs;
        long j7 = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
        if (j7 == 0) {
            sharedPreferences.edit().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
        } else if (jCurrentTimeMillis - j7 > 604800) {
            sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
        }
    }

    private static ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor editorEdit = purchaseInappSharedPrefs.edit();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (String str : arrayList) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j7 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (jCurrentTimeMillis - (j7 / 1000) <= 86400 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                    editorEdit.putString(string, string2);
                    arrayList2.add(str);
                }
            } catch (JSONException unused) {
            }
        }
        editorEdit.apply();
        return arrayList2;
    }

    @o0
    private static Class<?> getClass(Context context, String str) {
        HashMap<String, Class<?>> map = classMap;
        Class<?> clsLoadClass = map.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        try {
            clsLoadClass = context.getClassLoader().loadClass(str);
            map.put(str, clsLoadClass);
            return clsLoadClass;
        } catch (ClassNotFoundException unused) {
            return clsLoadClass;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @o0
    private static Method getMethod(Class<?> cls, String str) {
        byte b8;
        Class<?>[] clsArr;
        HashMap<String, Method> map = methodMap;
        Method declaredMethod = map.get(str);
        if (declaredMethod != null) {
            return declaredMethod;
        }
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (!str.equals(GET_PURCHASES)) {
                        b8 = -1;
                    } else {
                        b8 = 3;
                    }
                    break;
                case -1450694211:
                    if (!str.equals(IS_BILLING_SUPPORTED)) {
                        b8 = -1;
                    } else {
                        b8 = 2;
                    }
                    break;
                case -1123215065:
                    if (!str.equals(AS_INTERFACE)) {
                        b8 = -1;
                    } else {
                        b8 = 0;
                    }
                    break;
                case -594356707:
                    if (!str.equals(GET_PURCHASE_HISTORY)) {
                        b8 = -1;
                    } else {
                        b8 = 4;
                    }
                    break;
                case -573310373:
                    if (!str.equals(GET_SKU_DETAILS)) {
                        b8 = -1;
                    } else {
                        b8 = 1;
                    }
                    break;
                default:
                    b8 = -1;
                    break;
            }
            if (b8 == 0) {
                clsArr = new Class[]{IBinder.class};
            } else if (b8 == 1) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
            } else if (b8 == 2) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class};
            } else if (b8 != 3) {
                clsArr = b8 != 4 ? null : new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
            } else {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
            }
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
            map.put(str, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            return declaredMethod;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x008d  */
    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i7 = 0;
            boolean z7 = false;
            String string = null;
            do {
                Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, string, new Bundle()});
                if (objInvokeMethod != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) objInvokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) != 0 || (stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST)) == null) {
                        string = null;
                    } else {
                        for (String str2 : stringArrayList) {
                            try {
                                if (jCurrentTimeMillis - (new JSONObject(str2).getLong("purchaseTime") / 1000) > 1200) {
                                    z7 = true;
                                    break;
                                }
                                arrayList.add(str2);
                                i7++;
                            } catch (JSONException unused) {
                            }
                        }
                        string = bundle.getString(INAPP_CONTINUATION_TOKEN);
                    }
                } else {
                    string = null;
                }
                if (i7 >= 30 || string == null) {
                    break;
                }
            } while (!z7);
        }
        return arrayList;
    }

    static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : filterPurchases(getPurchaseHistory(context, obj, INAPP));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0055  */
    /* JADX WARN: Code duplicated, block: B:18:0x005a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:20:0x005c A[EDGE_INSN: B:20:0x005c->B:19:0x005c BREAK  A[LOOP:0: B:8:0x0016->B:23:?], SYNTHETIC] */
    private static ArrayList<String> getPurchases(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj != null && isBillingSupported(context, obj, str).booleanValue()) {
            int size = 0;
            String string = null;
            do {
                Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASES, obj, new Object[]{3, PACKAGE_NAME, str, string});
                if (objInvokeMethod == null) {
                    string = null;
                    if (size < 30) {
                        break;
                        break;
                    }
                } else {
                    Bundle bundle = (Bundle) objInvokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                        if (stringArrayList == null) {
                            break;
                        }
                        size += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        string = bundle.getString(INAPP_CONTINUATION_TOKEN);
                    } else {
                        string = null;
                    }
                    if (size < 30) {
                        break;
                    }
                }
            } while (string != null);
        }
        return arrayList;
    }

    static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, INAPP));
    }

    static ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, SUBSCRIPTION));
    }

    static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z7) {
        Map<String, String> skuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (!skuDetailsFromCache.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        skuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z7));
        return skuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z7) {
        HashMap map = new HashMap();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
            Object[] objArr = new Object[4];
            objArr[0] = 3;
            objArr[1] = PACKAGE_NAME;
            objArr[2] = z7 ? SUBSCRIPTION : INAPP;
            objArr[3] = bundle;
            Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
            if (objInvokeMethod != null) {
                Bundle bundle2 = (Bundle) objInvokeMethod;
                if (bundle2.getInt(RESPONSE_CODE) == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                        for (int i7 = 0; i7 < arrayList.size(); i7++) {
                            map.put(arrayList.get(i7), stringArrayList.get(i7));
                        }
                    }
                    writeSkuDetailsToCache(map);
                }
            }
        }
        return map;
    }

    static boolean hasFreeTrialPeirod(String str) {
        try {
            String strOptString = new JSONObject(str).optString("freeTrialPeriod");
            return (strOptString == null || strOptString.isEmpty()) ? false : true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @o0
    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<?> cls = getClass(context, str);
        if (cls == null || (method = getMethod(cls, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        if (obj == null) {
            return Boolean.FALSE;
        }
        boolean z7 = false;
        Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
        if (objInvokeMethod != null && ((Integer) objInvokeMethod).intValue() == 0) {
            z7 = true;
        }
        return Boolean.valueOf(z7);
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        HashMap map = new HashMap();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (String str : arrayList) {
            String string = skuDetailSharedPrefs.getString(str, null);
            if (string != null) {
                String[] strArrSplit = string.split(j.f13806b, 2);
                if (jCurrentTimeMillis - Long.parseLong(strArrSplit[0]) < 43200) {
                    map.put(str, strArrSplit[1]);
                }
            }
        }
        return map;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor editorEdit = skuDetailSharedPrefs.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            editorEdit.putString(entry.getKey(), jCurrentTimeMillis + j.f13806b + entry.getValue());
        }
        editorEdit.apply();
    }
}
