package m4;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Toast f37468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f37469c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f37470a;

    public e(Context context) {
        this.f37470a = context;
    }

    public static e b() {
        return f37469c;
    }

    public static void c(Context context) {
        f37469c = new e(context.getApplicationContext());
    }

    public void a() {
        Toast toast = f37468b;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void d(int i7) {
        Toast toast = f37468b;
        if (toast == null) {
            f37468b = Toast.makeText(this.f37470a, i7, 0);
        } else {
            toast.setText(i7);
        }
        f37468b.show();
    }

    public void e(CharSequence charSequence) {
        Toast toast = f37468b;
        if (toast == null) {
            f37468b = Toast.makeText(this.f37470a, charSequence, 0);
        } else {
            toast.setText(charSequence);
        }
        f37468b.show();
    }

    public void f(String str) {
        Toast toast = f37468b;
        if (toast == null) {
            f37468b = Toast.makeText(this.f37470a, str, 0);
        } else {
            toast.setText(str);
        }
        f37468b.show();
    }
}
