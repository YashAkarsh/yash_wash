package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
class p implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActionBar.d f840a;

    public p(ActionBar.d dVar) {
        this.f840a = dVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j7) {
        ActionBar.d dVar = this.f840a;
        if (dVar != null) {
            dVar.a(i7, j7);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
