package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.haier.globalwasher.presenter.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = "LegacyTokenHelper";
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    private void deserializeKey(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean(JSON_VALUE));
            return;
        }
        int i7 = 0;
        if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            JSONArray jSONArray = jSONObject.getJSONArray(JSON_VALUE);
            int length = jSONArray.length();
            boolean[] zArr = new boolean[length];
            while (i7 < length) {
                zArr[i7] = jSONArray.getBoolean(i7);
                i7++;
            }
            bundle.putBooleanArray(str, zArr);
            return;
        }
        if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt(JSON_VALUE));
            return;
        }
        if (string.equals(TYPE_BYTE_ARRAY)) {
            JSONArray jSONArray2 = jSONObject.getJSONArray(JSON_VALUE);
            int length2 = jSONArray2.length();
            byte[] bArr = new byte[length2];
            while (i7 < length2) {
                bArr[i7] = (byte) jSONArray2.getInt(i7);
                i7++;
            }
            bundle.putByteArray(str, bArr);
            return;
        }
        if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt(JSON_VALUE));
            return;
        }
        if (string.equals(TYPE_SHORT_ARRAY)) {
            JSONArray jSONArray3 = jSONObject.getJSONArray(JSON_VALUE);
            int length3 = jSONArray3.length();
            short[] sArr = new short[length3];
            while (i7 < length3) {
                sArr[i7] = (short) jSONArray3.getInt(i7);
                i7++;
            }
            bundle.putShortArray(str, sArr);
            return;
        }
        if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt(JSON_VALUE));
            return;
        }
        if (string.equals(TYPE_INTEGER_ARRAY)) {
            JSONArray jSONArray4 = jSONObject.getJSONArray(JSON_VALUE);
            int length4 = jSONArray4.length();
            int[] iArr = new int[length4];
            while (i7 < length4) {
                iArr[i7] = jSONArray4.getInt(i7);
                i7++;
            }
            bundle.putIntArray(str, iArr);
            return;
        }
        if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong(JSON_VALUE));
            return;
        }
        if (string.equals(TYPE_LONG_ARRAY)) {
            JSONArray jSONArray5 = jSONObject.getJSONArray(JSON_VALUE);
            int length5 = jSONArray5.length();
            long[] jArr = new long[length5];
            while (i7 < length5) {
                jArr[i7] = jSONArray5.getLong(i7);
                i7++;
            }
            bundle.putLongArray(str, jArr);
            return;
        }
        if (string.equals("float")) {
            bundle.putFloat(str, (float) jSONObject.getDouble(JSON_VALUE));
            return;
        }
        if (string.equals(TYPE_FLOAT_ARRAY)) {
            JSONArray jSONArray6 = jSONObject.getJSONArray(JSON_VALUE);
            int length6 = jSONArray6.length();
            float[] fArr = new float[length6];
            while (i7 < length6) {
                fArr[i7] = (float) jSONArray6.getDouble(i7);
                i7++;
            }
            bundle.putFloatArray(str, fArr);
            return;
        }
        if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble(JSON_VALUE));
            return;
        }
        if (string.equals(TYPE_DOUBLE_ARRAY)) {
            JSONArray jSONArray7 = jSONObject.getJSONArray(JSON_VALUE);
            int length7 = jSONArray7.length();
            double[] dArr = new double[length7];
            while (i7 < length7) {
                dArr[i7] = jSONArray7.getDouble(i7);
                i7++;
            }
            bundle.putDoubleArray(str, dArr);
            return;
        }
        if (string.equals(TYPE_CHAR)) {
            String string2 = jSONObject.getString(JSON_VALUE);
            if (string2 == null || string2.length() != 1) {
                return;
            }
            bundle.putChar(str, string2.charAt(0));
            return;
        }
        if (string.equals(TYPE_CHAR_ARRAY)) {
            JSONArray jSONArray8 = jSONObject.getJSONArray(JSON_VALUE);
            int length8 = jSONArray8.length();
            char[] cArr = new char[length8];
            for (int i8 = 0; i8 < length8; i8++) {
                String string3 = jSONArray8.getString(i8);
                if (string3 != null && string3.length() == 1) {
                    cArr[i8] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
            return;
        }
        if (string.equals("string")) {
            bundle.putString(str, jSONObject.getString(JSON_VALUE));
            return;
        }
        if (!string.equals(TYPE_STRING_LIST)) {
            if (string.equals(TYPE_ENUM)) {
                try {
                    bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString(JSON_VALUE)));
                    return;
                } catch (ClassNotFoundException | IllegalArgumentException unused) {
                    return;
                }
            }
            return;
        }
        JSONArray jSONArray9 = jSONObject.getJSONArray(JSON_VALUE);
        int length9 = jSONArray9.length();
        ArrayList<String> arrayList = new ArrayList<>(length9);
        while (i7 < length9) {
            Object obj = jSONArray9.get(i7);
            arrayList.add(i7, obj == JSONObject.NULL ? null : (String) obj);
            i7++;
        }
        bundle.putStringArrayList(str, arrayList);
    }

    public static String getApplicationId(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        return bundle.getString(APPLICATION_ID_KEY);
    }

    static Date getDate(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j7 = bundle.getLong(str, Long.MIN_VALUE);
        if (j7 == Long.MIN_VALUE) {
            return null;
        }
        return new Date(j7);
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        return getDate(bundle, EXPIRATION_DATE_KEY);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        return bundle.getLong(EXPIRATION_DATE_KEY);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        return getDate(bundle, LAST_REFRESH_DATE_KEY);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        return bundle.getLong(LAST_REFRESH_DATE_KEY);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (stringArrayList == null) {
            return null;
        }
        return new HashSet(stringArrayList);
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        if (bundle.containsKey(TOKEN_SOURCE_KEY)) {
            return (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY);
        }
        return bundle.getBoolean(IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        return bundle.getString(TOKEN_KEY);
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString(TOKEN_KEY)) == null || string.length() == 0 || bundle.getLong(EXPIRATION_DATE_KEY, 0L) == 0) ? false : true;
    }

    public static void putApplicationId(Bundle bundle, String str) {
        Validate.notNull(bundle, y.f25405c);
        bundle.putString(APPLICATION_ID_KEY, str);
    }

    static void putDate(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, y.f25405c);
        Validate.notNull(collection, JSON_VALUE);
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList<>(collection));
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, y.f25405c);
        Validate.notNull(date, JSON_VALUE);
        putDate(bundle, EXPIRATION_DATE_KEY, date);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j7) {
        Validate.notNull(bundle, y.f25405c);
        bundle.putLong(EXPIRATION_DATE_KEY, j7);
    }

    public static void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, y.f25405c);
        Validate.notNull(collection, JSON_VALUE);
        bundle.putStringArrayList(EXPIRED_PERMISSIONS_KEY, new ArrayList<>(collection));
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, y.f25405c);
        Validate.notNull(date, JSON_VALUE);
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j7) {
        Validate.notNull(bundle, y.f25405c);
        bundle.putLong(LAST_REFRESH_DATE_KEY, j7);
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, y.f25405c);
        Validate.notNull(collection, JSON_VALUE);
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList<>(collection));
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Validate.notNull(bundle, y.f25405c);
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
    }

    public static void putToken(Bundle bundle, String str) {
        Validate.notNull(bundle, y.f25405c);
        Validate.notNull(str, JSON_VALUE);
        bundle.putString(TOKEN_KEY, str);
    }

    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x018c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0193  */
    private void serializeKey(String str, Bundle bundle, SharedPreferences.Editor editor) throws JSONException {
        JSONArray jSONArray;
        String str2;
        Object obj = bundle.get(str);
        if (obj == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        String str3 = null;
        if (obj instanceof Byte) {
            jSONObject.put(JSON_VALUE, ((Byte) obj).intValue());
            str2 = TYPE_BYTE;
        } else if (obj instanceof Short) {
            jSONObject.put(JSON_VALUE, ((Short) obj).intValue());
            str2 = TYPE_SHORT;
        } else if (obj instanceof Integer) {
            jSONObject.put(JSON_VALUE, ((Integer) obj).intValue());
            str2 = TYPE_INTEGER;
        } else if (obj instanceof Long) {
            jSONObject.put(JSON_VALUE, ((Long) obj).longValue());
            str2 = TYPE_LONG;
        } else if (obj instanceof Float) {
            jSONObject.put(JSON_VALUE, ((Float) obj).doubleValue());
            str2 = "float";
        } else if (obj instanceof Double) {
            jSONObject.put(JSON_VALUE, ((Double) obj).doubleValue());
            str2 = TYPE_DOUBLE;
        } else if (obj instanceof Boolean) {
            jSONObject.put(JSON_VALUE, ((Boolean) obj).booleanValue());
            str2 = TYPE_BOOLEAN;
        } else if (obj instanceof Character) {
            jSONObject.put(JSON_VALUE, obj.toString());
            str2 = TYPE_CHAR;
        } else {
            if (!(obj instanceof String)) {
                if (obj instanceof Enum) {
                    jSONObject.put(JSON_VALUE, obj.toString());
                    jSONObject.put(JSON_VALUE_ENUM_TYPE, obj.getClass().getName());
                    str2 = TYPE_ENUM;
                } else {
                    jSONArray = new JSONArray();
                    int i7 = 0;
                    if (obj instanceof byte[]) {
                        byte[] bArr = (byte[]) obj;
                        int length = bArr.length;
                        while (i7 < length) {
                            jSONArray.put((int) bArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_BYTE_ARRAY;
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        int length2 = sArr.length;
                        while (i7 < length2) {
                            jSONArray.put((int) sArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_SHORT_ARRAY;
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        int length3 = iArr.length;
                        while (i7 < length3) {
                            jSONArray.put(iArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_INTEGER_ARRAY;
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        int length4 = jArr.length;
                        while (i7 < length4) {
                            jSONArray.put(jArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_LONG_ARRAY;
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        int length5 = fArr.length;
                        while (i7 < length5) {
                            jSONArray.put(fArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_FLOAT_ARRAY;
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        int length6 = dArr.length;
                        while (i7 < length6) {
                            jSONArray.put(dArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_DOUBLE_ARRAY;
                    } else if (obj instanceof boolean[]) {
                        boolean[] zArr = (boolean[]) obj;
                        int length7 = zArr.length;
                        while (i7 < length7) {
                            jSONArray.put(zArr[i7]);
                            i7++;
                        }
                        str3 = TYPE_BOOLEAN_ARRAY;
                    } else if (obj instanceof char[]) {
                        char[] cArr = (char[]) obj;
                        int length8 = cArr.length;
                        while (i7 < length8) {
                            jSONArray.put(String.valueOf(cArr[i7]));
                            i7++;
                        }
                        str3 = TYPE_CHAR_ARRAY;
                    } else if (obj instanceof List) {
                        for (Object obj2 : (List) obj) {
                            if (obj2 == null) {
                                obj2 = JSONObject.NULL;
                            }
                            jSONArray.put(obj2);
                        }
                        str3 = TYPE_STRING_LIST;
                    } else {
                        jSONArray = null;
                    }
                }
                if (str3 != null) {
                    jSONObject.put(JSON_VALUE_TYPE, str3);
                    if (jSONArray != null) {
                        jSONObject.putOpt(JSON_VALUE, jSONArray);
                    }
                    editor.putString(str, jSONObject.toString());
                }
            }
            jSONObject.put(JSON_VALUE, (String) obj);
            str2 = "string";
        }
        jSONArray = null;
        str3 = str2;
        if (str3 != null) {
            jSONObject.put(JSON_VALUE_TYPE, str3);
            if (jSONArray != null) {
                jSONObject.putOpt(JSON_VALUE, jSONArray);
            }
            editor.putString(str, jSONObject.toString());
        }
    }

    public void clear() {
        this.cache.edit().clear().apply();
    }

    public Bundle load() {
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                deserializeKey(str, bundle);
            } catch (JSONException e8) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + str + "' -- " + e8);
                return null;
            }
        }
        return bundle;
    }

    public void save(Bundle bundle) {
        Validate.notNull(bundle, y.f25405c);
        SharedPreferences.Editor editorEdit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, editorEdit);
            } catch (JSONException e8) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + str + "' -- " + e8);
                return;
            }
        }
        editorEdit.apply();
    }

    public LegacyTokenHelper(Context context, String str) {
        Validate.notNull(context, "context");
        this.cacheKey = Utility.isNullOrEmpty(str) ? DEFAULT_CACHE_KEY : str;
        Context applicationContext = context.getApplicationContext();
        this.cache = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.cacheKey, 0);
    }
}
