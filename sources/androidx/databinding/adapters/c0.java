package androidx.databinding.adapters;

import android.widget.TabHost;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class c0 {

    static class a implements TabHost.OnTabChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabHost.OnTabChangeListener f7211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7212b;

        a(TabHost.OnTabChangeListener onTabChangeListener, androidx.databinding.m mVar) {
            this.f7211a = onTabChangeListener;
            this.f7212b = mVar;
        }

        @Override // android.widget.TabHost.OnTabChangeListener
        public void onTabChanged(String str) {
            TabHost.OnTabChangeListener onTabChangeListener = this.f7211a;
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChanged(str);
            }
            this.f7212b.a();
        }
    }

    @androidx.databinding.l(attribute = "android:currentTab")
    public static int a(TabHost tabHost) {
        return tabHost.getCurrentTab();
    }

    @androidx.databinding.l(attribute = "android:currentTab")
    public static String b(TabHost tabHost) {
        return tabHost.getCurrentTabTag();
    }

    @androidx.databinding.d({"android:currentTab"})
    public static void c(TabHost tabHost, int i7) {
        if (tabHost.getCurrentTab() != i7) {
            tabHost.setCurrentTab(i7);
        }
    }

    @androidx.databinding.d({"android:currentTab"})
    public static void d(TabHost tabHost, String str) {
        String currentTabTag = tabHost.getCurrentTabTag();
        if ((currentTabTag == null || currentTabTag.equals(str)) && (currentTabTag != null || str == null)) {
            return;
        }
        tabHost.setCurrentTabByTag(str);
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onTabChanged", "android:currentTabAttrChanged"})
    public static void e(TabHost tabHost, TabHost.OnTabChangeListener onTabChangeListener, androidx.databinding.m mVar) {
        if (mVar == null) {
            tabHost.setOnTabChangedListener(onTabChangeListener);
        } else {
            tabHost.setOnTabChangedListener(new a(onTabChangeListener, mVar));
        }
    }
}
