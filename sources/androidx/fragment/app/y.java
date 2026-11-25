package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.c2;
import androidx.core.view.i4;
import androidx.core.view.n2;
import c.m0;
import c.x0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
@SuppressLint({"UnknownNullness"})
public abstract class y {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f8159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f8160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f8161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f8162e;

        a(int i7, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f8158a = i7;
            this.f8159b = arrayList;
            this.f8160c = arrayList2;
            this.f8161d = arrayList3;
            this.f8162e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i7 = 0; i7 < this.f8158a; i7++) {
                n2.t2((View) this.f8159b.get(i7), (String) this.f8160c.get(i7));
                n2.t2((View) this.f8161d.get(i7), (String) this.f8162e.get(i7));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f8164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f8165b;

        b(ArrayList arrayList, Map map) {
            this.f8164a = arrayList;
            this.f8165b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f8164a.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = (View) this.f8164a.get(i7);
                String strX0 = n2.x0(view);
                if (strX0 != null) {
                    n2.t2(view, y.i(this.f8165b, strX0));
                }
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f8167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f8168b;

        c(ArrayList arrayList, Map map) {
            this.f8167a = arrayList;
            this.f8168b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f8167a.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = (View) this.f8167a.get(i7);
                n2.t2(view, (String) this.f8168b.get(n2.x0(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (n2.x0(view) != null) {
            list.add(view);
        }
        for (int i7 = size; i7 < list.size(); i7++) {
            View view2 = list.get(i7);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = viewGroup.getChildAt(i8);
                    if (!h(list, childAt, size) && n2.x0(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (list.get(i8) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (i4.c(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                f(arrayList, viewGroup.getChildAt(i7));
            }
        }
    }

    public abstract Object g(Object obj);

    void j(Map<String, View> map, @m0 View view) {
        if (view.getVisibility() == 0) {
            String strX0 = n2.x0(view);
            if (strX0 != null) {
                map.put(strX0, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    j(map, viewGroup.getChildAt(i7));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        if (n2.O0(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = arrayList.get(i7);
            arrayList2.add(n2.x0(view));
            n2.t2(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        c2.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(@m0 Fragment fragment, @m0 Object obj, @m0 androidx.core.os.e eVar, @m0 Runnable runnable) {
        runnable.run();
    }

    void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        c2.a(view, new b(arrayList, map));
    }

    void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = arrayList.get(i7);
            String strX0 = n2.x0(view2);
            arrayList4.add(strX0);
            if (strX0 != null) {
                n2.t2(view2, null);
                String str = map.get(strX0);
                for (int i8 = 0; i8 < size; i8++) {
                    if (str.equals(arrayList3.get(i8))) {
                        n2.t2(arrayList2.get(i8), strX0);
                        break;
                    }
                }
            }
        }
        c2.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
