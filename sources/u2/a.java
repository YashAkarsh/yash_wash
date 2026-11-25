package u2;

import com.google.gson.f;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.modle.bean.LoginResultBeen;
import com.haier.globalwasher.modle.utils.q;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(String str) {
        return "1".equals(t2.a.a(MyApplication.k(), t2.a.f40363j, str));
    }

    public static String b() {
        return t2.a.a(MyApplication.k(), t2.a.f40362i, t2.a.f40369p);
    }

    public static String c() {
        return t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40355b);
    }

    public static String d() {
        return t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40357d);
    }

    public static void e(String str) {
        q.c("synchronousLogin", "loginInfoJson=" + str);
        LoginResultBeen loginResultBeen = (LoginResultBeen) new f().n(str, LoginResultBeen.class);
        t2.a.b(MyApplication.k(), t2.a.f40354a, t2.a.f40355b, loginResultBeen.getTokenId());
        t2.a.b(MyApplication.k(), t2.a.f40354a, t2.a.f40356c, loginResultBeen.getUserId());
        t2.a.b(MyApplication.k(), t2.a.f40354a, t2.a.f40357d, loginResultBeen.getPhoneNumber());
        t2.a.b(MyApplication.k(), t2.a.f40354a, t2.a.f40359f, loginResultBeen.getUserName());
        if ("".equals(loginResultBeen.getAvatarURL())) {
            return;
        }
        t2.a.b(MyApplication.k(), t2.a.f40354a, t2.a.f40358e, loginResultBeen.getAvatarURL());
    }

    public static void f(String str) {
        t2.a.b(MyApplication.k(), t2.a.f40363j, str, "1");
    }

    public static void g() {
        t2.a.b(MyApplication.k(), t2.a.f40362i, t2.a.f40369p, "1");
    }
}
