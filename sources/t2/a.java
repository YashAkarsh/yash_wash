package t2;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f40354a = "user_info";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f40355b = "app_sp_accesstoken";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f40356c = "app_sp_user_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f40357d = "app_sp_user_phone_number";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f40358e = "app_sp_user_avatar_url";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f40359f = "app_sp_user_name";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f40360g = "app_sp_init";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f40361h = "last_update_app_model_time";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f40362i = "app_info";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f40363j = "app_permission_file";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f40364k = "privacy_agreement";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f40365l = "privacy_code";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f40366m = "通知开关弹窗";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f40367n = "LANGUGE_TYPE";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f40368o = "BASE_URL";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f40369p = "SHARE_AUTHORITY";

    public static String a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        } catch (NullPointerException e8) {
            e8.printStackTrace();
            return "";
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }
}
