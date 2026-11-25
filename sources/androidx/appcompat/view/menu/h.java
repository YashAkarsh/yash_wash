package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.appcompat.app.c f1216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f1217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n.a f1218d;

    public h(g gVar) {
        this.f1215a = gVar;
    }

    public void a() {
        androidx.appcompat.app.c cVar = this.f1216b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void b(n.a aVar) {
        this.f1218d = aVar;
    }

    public void c(IBinder iBinder) {
        g gVar = this.f1215a;
        androidx.appcompat.app.c.a aVar = new androidx.appcompat.app.c.a(gVar.x());
        e eVar = new e(aVar.b(), R.layout.abc_list_menu_item_layout);
        this.f1217c = eVar;
        eVar.i(this);
        this.f1215a.b(this.f1217c);
        aVar.c(this.f1217c.b(), this);
        View viewB = gVar.B();
        if (viewB != null) {
            aVar.f(viewB);
        } else {
            aVar.h(gVar.z()).K(gVar.A());
        }
        aVar.A(this);
        androidx.appcompat.app.c cVarA = aVar.a();
        this.f1216b = cVarA;
        cVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1216b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1216b.show();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void d(@m0 g gVar, boolean z7) {
        if (z7 || gVar == this.f1215a) {
            a();
        }
        n.a aVar = this.f1218d;
        if (aVar != null) {
            aVar.d(gVar, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean e(@m0 g gVar) {
        n.a aVar = this.f1218d;
        if (aVar != null) {
            return aVar.e(gVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i7) {
        this.f1215a.O((j) this.f1217c.b().getItem(i7), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1217c.d(this.f1215a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i7, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i7 == 82 || i7 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1216b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1216b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1215a.f(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1215a.performShortcut(i7, keyEvent, 0);
    }
}
