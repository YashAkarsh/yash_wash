package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class p extends c implements Menu {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final k.a f1263o;

    public p(Context context, k.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1263o = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return e(this.f1263o.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i7, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f1263o.addIntentOptions(i7, i8, i9, componentName, intentArr, intent, i10, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                menuItemArr[i11] = e(menuItemArr2[i11]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return f(this.f1263o.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        g();
        this.f1263o.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f1263o.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i7) {
        return e(this.f1263o.findItem(i7));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i7) {
        return e(this.f1263o.getItem(i7));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f1263o.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i7, KeyEvent keyEvent) {
        return this.f1263o.isShortcutKey(i7, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i7, int i8) {
        return this.f1263o.performIdentifierAction(i7, i8);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i7, KeyEvent keyEvent, int i8) {
        return this.f1263o.performShortcut(i7, keyEvent, i8);
    }

    @Override // android.view.Menu
    public void removeGroup(int i7) {
        h(i7);
        this.f1263o.removeGroup(i7);
    }

    @Override // android.view.Menu
    public void removeItem(int i7) {
        i(i7);
        this.f1263o.removeItem(i7);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i7, boolean z7, boolean z8) {
        this.f1263o.setGroupCheckable(i7, z7, z8);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i7, boolean z7) {
        this.f1263o.setGroupEnabled(i7, z7);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i7, boolean z7) {
        this.f1263o.setGroupVisible(i7, z7);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f1263o.setQwertyMode(z7);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1263o.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i7) {
        return e(this.f1263o.add(i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7) {
        return f(this.f1263o.addSubMenu(i7));
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, CharSequence charSequence) {
        return e(this.f1263o.add(i7, i8, i9, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        return f(this.f1263o.addSubMenu(i7, i8, i9, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, int i10) {
        return e(this.f1263o.add(i7, i8, i9, i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, int i10) {
        return f(this.f1263o.addSubMenu(i7, i8, i9, i10));
    }
}
