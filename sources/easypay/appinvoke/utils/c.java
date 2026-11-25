package easypay.appinvoke.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import com.google.common.primitives.h0;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class c implements SharedPreferences {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f33848c = "AES";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f33849d = "AES/CBC/PKCS5PADDING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f33850e = {h0.f22372a, h0.f22372a, h0.f22372a, h0.f22372a, 38, 38, 38, 38, 35, 35, 35, 35, 36, 36, 36, 36};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f33851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f33852b;

    public class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected SharedPreferences.Editor f33853a;

        public a() {
            this.f33853a = c.this.f33851a.edit();
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a clear() {
            this.f33853a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.f33853a.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a putBoolean(String str, boolean z7) {
            this.f33853a.putString(str, c.this.e(Boolean.toString(z7)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a putFloat(String str, float f8) {
            this.f33853a.putString(str, c.this.e(Float.toString(f8)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.f33853a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a putInt(String str, int i7) {
            this.f33853a.putString(str, c.this.e(Integer.toString(i7)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a putLong(String str, long j7) {
            this.f33853a.putString(str, c.this.e(Long.toString(j7)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a putString(String str, String str2) {
            if (str2 != null) {
                this.f33853a.putString(str, c.this.e(str2));
            } else {
                this.f33853a.putString(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a remove(String str) {
            this.f33853a.remove(str);
            this.f33853a.apply();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }
    }

    public c(Context context) {
        if (context != null) {
            this.f33852b = context;
            this.f33851a = context.getSharedPreferences("app_pref", 0);
        }
    }

    private String c(String str) {
        try {
            Cipher cipher = Cipher.getInstance(f33849d);
            cipher.init(2, new SecretKeySpec(f(), f33848c), new IvParameterSpec(f33850e));
            return new String(cipher.doFinal(Base64.decode(str, 2)));
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        try {
            Cipher cipher = Cipher.getInstance(f33849d);
            cipher.init(1, new SecretKeySpec(f(), f33848c), new IvParameterSpec(f33850e));
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 2));
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    private byte[] f() {
        String string = Settings.Secure.getString(this.f33852b.getContentResolver(), "android_id");
        int length = string.length();
        if (length > 16) {
            string = string.substring(0, 16);
        } else if (length < 16) {
            for (int i7 = 16 - length; i7 > 0; i7--) {
                string = "0" + string;
            }
        }
        char[] cArr = {'p', '@', 'y', '!', 'm', 'k', 'e', 'Y', '4', 'o', 'n', 'E', '9', '7', 'p', 'r'};
        char[] charArray = string.toCharArray();
        char[] cArr2 = new char[16];
        for (int i8 = 0; i8 < 16; i8++) {
            cArr2[i8] = (char) (cArr[i8] ^ charArray[i8]);
        }
        return new String(cArr2).getBytes();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f33851a.contains(str);
    }

    @Override // android.content.SharedPreferences
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a edit() {
        return new a();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z7) {
        String strC;
        String string = this.f33851a.getString(str, null);
        return (string == null || string.equalsIgnoreCase("null") || (strC = c(string)) == null) ? z7 : Boolean.parseBoolean(strC);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f8) {
        String strC;
        String string = this.f33851a.getString(str, null);
        return (string == null || string.equalsIgnoreCase("null") || (strC = c(string)) == null) ? f8 : Float.parseFloat(strC);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i7) {
        String strC;
        String string = this.f33851a.getString(str, null);
        return (string == null || string.equalsIgnoreCase("null") || (strC = c(string)) == null) ? i7 : Integer.parseInt(strC);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j7) {
        String strC;
        String string = this.f33851a.getString(str, null);
        return (string == null || string.equalsIgnoreCase("null") || (strC = c(string)) == null) ? j7 : Long.parseLong(strC);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f33851a;
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString(str, null);
        return (string == null || string.equalsIgnoreCase("null")) ? str2 : c(string);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.f33851a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f33851a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f33851a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public c(Context context, String str) {
        if (context != null) {
            this.f33852b = context;
            this.f33851a = context.getSharedPreferences(str, 0);
        }
    }
}
