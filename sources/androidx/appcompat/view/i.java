package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import c.t;
import c.t0;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class i implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Window.Callback f1079a;

    @t0(23)
    static class a {
        private a() {
        }

        @t
        static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        @t
        static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i7) {
            return callback.onWindowStartingActionMode(callback2, i7);
        }
    }

    @t0(24)
    static class b {
        private b() {
        }

        @t
        static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i7) {
            callback.onProvideKeyboardShortcuts(list, menu, i7);
        }
    }

    @t0(26)
    static class c {
        private c() {
        }

        @t
        static void a(Window.Callback callback, boolean z7) {
            callback.onPointerCaptureChanged(z7);
        }
    }

    public i(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f1079a = callback;
    }

    public final Window.Callback a() {
        return this.f1079a;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f1079a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1079a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f1079a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f1079a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f1079a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f1079a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f1079a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f1079a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f1079a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f1079a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i7, Menu menu) {
        return this.f1079a.onCreatePanelMenu(i7, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i7) {
        return this.f1079a.onCreatePanelView(i7);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f1079a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i7, MenuItem menuItem) {
        return this.f1079a.onMenuItemSelected(i7, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i7, Menu menu) {
        return this.f1079a.onMenuOpened(i7, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i7, Menu menu) {
        this.f1079a.onPanelClosed(i7, menu);
    }

    @Override // android.view.Window.Callback
    @t0(26)
    public void onPointerCaptureChanged(boolean z7) {
        c.a(this.f1079a, z7);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i7, View view, Menu menu) {
        return this.f1079a.onPreparePanel(i7, view, menu);
    }

    @Override // android.view.Window.Callback
    @t0(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i7) {
        b.a(this.f1079a, list, menu, i7);
    }

    @Override // android.view.Window.Callback
    @t0(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f1079a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f1079a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z7) {
        this.f1079a.onWindowFocusChanged(z7);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1079a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f1079a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    @t0(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i7) {
        return a.b(this.f1079a, callback, i7);
    }
}
