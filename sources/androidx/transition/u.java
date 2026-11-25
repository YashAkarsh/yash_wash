package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f10776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f10777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f10778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f10779f;

    public u(@c.m0 ViewGroup viewGroup) {
        this.f10775b = -1;
        this.f10776c = viewGroup;
    }

    @c.o0
    public static u c(@c.m0 ViewGroup viewGroup) {
        return (u) viewGroup.getTag(R.id.transition_current_scene);
    }

    @c.m0
    public static u d(@c.m0 ViewGroup viewGroup, @c.h0 int i7, @c.m0 Context context) {
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(R.id.transition_scene_layoutid_cache);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(R.id.transition_scene_layoutid_cache, sparseArray);
        }
        u uVar = (u) sparseArray.get(i7);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(viewGroup, i7, context);
        sparseArray.put(i7, uVar2);
        return uVar2;
    }

    static void g(@c.m0 ViewGroup viewGroup, @c.o0 u uVar) {
        viewGroup.setTag(R.id.transition_current_scene, uVar);
    }

    public void a() {
        if (this.f10775b > 0 || this.f10777d != null) {
            e().removeAllViews();
            if (this.f10775b > 0) {
                LayoutInflater.from(this.f10774a).inflate(this.f10775b, this.f10776c);
            } else {
                this.f10776c.addView(this.f10777d);
            }
        }
        Runnable runnable = this.f10778e;
        if (runnable != null) {
            runnable.run();
        }
        g(this.f10776c, this);
    }

    public void b() {
        Runnable runnable;
        if (c(this.f10776c) != this || (runnable = this.f10779f) == null) {
            return;
        }
        runnable.run();
    }

    @c.m0
    public ViewGroup e() {
        return this.f10776c;
    }

    boolean f() {
        return this.f10775b > 0;
    }

    public void h(@c.o0 Runnable runnable) {
        this.f10778e = runnable;
    }

    public void i(@c.o0 Runnable runnable) {
        this.f10779f = runnable;
    }

    private u(ViewGroup viewGroup, int i7, Context context) {
        this.f10774a = context;
        this.f10776c = viewGroup;
        this.f10775b = i7;
    }

    public u(@c.m0 ViewGroup viewGroup, @c.m0 View view) {
        this.f10775b = -1;
        this.f10776c = viewGroup;
        this.f10777d = view;
    }
}
