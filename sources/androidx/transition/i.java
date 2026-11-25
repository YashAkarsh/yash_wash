package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class i extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private ViewGroup f10723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10724b;

    i(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f10723a = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        l0.b(this.f10723a).c(this);
        this.f10724b = true;
    }

    static i b(@c.m0 ViewGroup viewGroup) {
        return (i) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private int c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i7 = 0;
        while (i7 <= childCount) {
            int i8 = (i7 + childCount) / 2;
            d(((k) getChildAt(i8)).f10735c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i7 = i8 + 1;
            } else {
                childCount = i8 - 1;
            }
            arrayList2.clear();
        }
        return i7;
    }

    private static void d(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(l0.a(viewGroup, i7));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    private static boolean f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i7 = 1; i7 < iMin; i7++) {
            View view = arrayList.get(i7);
            View view2 = arrayList2.get(i7);
            if (view != view2) {
                return e(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    void a(k kVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        d(kVar.f10735c, arrayList);
        int iC = c(arrayList);
        if (iC < 0 || iC >= getChildCount()) {
            addView(kVar);
        } else {
            addView(kVar, iC);
        }
    }

    void g() {
        if (!this.f10724b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        l0.b(this.f10723a).d(this);
        l0.b(this.f10723a).c(this);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f10724b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f10723a.setTag(R.id.ghost_view_holder, null);
            l0.b(this.f10723a).d(this);
            this.f10724b = false;
        }
    }
}
