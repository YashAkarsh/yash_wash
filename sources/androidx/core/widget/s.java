package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import c.m0;
import c.t0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7046a = "PopupWindowCompatApi21";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f7047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f7049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Field f7051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f7052g;

    @t0(19)
    static class a {
        private a() {
        }

        @c.t
        static void a(PopupWindow popupWindow, View view, int i7, int i8, int i9) {
            popupWindow.showAsDropDown(view, i7, i8, i9);
        }
    }

    @t0(23)
    static class b {
        private b() {
        }

        @c.t
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @c.t
        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @c.t
        static void c(PopupWindow popupWindow, boolean z7) {
            popupWindow.setOverlapAnchor(z7);
        }

        @c.t
        static void d(PopupWindow popupWindow, int i7) {
            popupWindow.setWindowLayoutType(i7);
        }
    }

    private s() {
    }

    public static boolean a(@m0 PopupWindow popupWindow) {
        return b.a(popupWindow);
    }

    public static int b(@m0 PopupWindow popupWindow) {
        return b.b(popupWindow);
    }

    public static void c(@m0 PopupWindow popupWindow, boolean z7) {
        b.c(popupWindow, z7);
    }

    public static void d(@m0 PopupWindow popupWindow, int i7) {
        b.d(popupWindow, i7);
    }

    public static void e(@m0 PopupWindow popupWindow, @m0 View view, int i7, int i8, int i9) {
        a.a(popupWindow, view, i7, i8, i9);
    }
}
