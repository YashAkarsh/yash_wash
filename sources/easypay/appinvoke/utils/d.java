package easypay.appinvoke.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import easypay.appinvoke.manager.Constants;
import w4.h;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static String a(Context context, String str, String str2, String str3) {
        h hVar;
        try {
            String string = context.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, "");
            com.google.gson.f fVar = new com.google.gson.f();
            if (TextUtils.isEmpty(string) || (hVar = (h) fVar.n(string, h.class)) == null) {
                return "";
            }
            for (int i7 = 0; i7 < hVar.a().size(); i7++) {
                w4.a aVar = hVar.a().get(i7);
                if ((str + str2 + str3).equals(aVar.toString())) {
                    return aVar.d();
                }
            }
            return "";
        } catch (Exception e8) {
            e8.printStackTrace();
            b.a("EXCEPTION", e8);
            return "";
        }
    }

    public static void b(Context context, String str, String str2) {
        h hVar;
        h hVar2;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0);
            String string = sharedPreferences.getString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, "");
            com.google.gson.f fVar = new com.google.gson.f();
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(string) || (hVar = (h) fVar.n(string, h.class)) == null) {
                    return;
                }
                for (int i7 = 0; i7 < hVar.a().size(); i7++) {
                    w4.a aVar = hVar.a().get(i7);
                    if (aVar.d().equals(str2)) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(Constants.EASY_PAY_CONFIG_PREF_KEY, new com.google.gson.f().z(aVar));
                        editorEdit.apply();
                        return;
                    }
                }
                return;
            }
            w4.f fVar2 = (w4.f) fVar.n(str, w4.f.class);
            if (fVar2 != null && fVar2.b() != null && !TextUtils.isEmpty(fVar2.c()) && fVar2.b().intValue() != 403 && !fVar2.c().contains("Bank name is not supported")) {
                if (fVar2.a() != null) {
                    fVar2.a().j(str2);
                }
                if (TextUtils.isEmpty(string)) {
                    hVar2 = new h();
                    hVar2.a().add(fVar2.a());
                } else {
                    hVar2 = (h) fVar.n(string, h.class);
                    if (hVar2 != null) {
                        int i8 = 0;
                        while (true) {
                            if (i8 >= hVar2.a().size()) {
                                i8 = -1;
                                break;
                            } else if (fVar2.a().equals(hVar2.a().get(i8))) {
                                break;
                            } else {
                                i8++;
                            }
                        }
                        if (i8 != -1) {
                            hVar2.a().set(i8, fVar2.a());
                        } else if (hVar2.a().size() < 5) {
                            hVar2.a().add(fVar2.a());
                        } else {
                            hVar2.a().remove(hVar2.a().size() - 1);
                            hVar2.a().add(0, fVar2.a());
                        }
                    }
                }
                SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                editorEdit2.putString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, new com.google.gson.f().z(hVar2));
                editorEdit2.putString(Constants.EASY_PAY_CONFIG_PREF_KEY, new com.google.gson.f().z(fVar2.a()));
                editorEdit2.apply();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            b.a("EXCEPTION", e8);
        }
    }
}
