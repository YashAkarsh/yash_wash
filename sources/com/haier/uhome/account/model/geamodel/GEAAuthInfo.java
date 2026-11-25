package com.haier.uhome.account.model.geamodel;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GEAAuthInfo {

    @b(name = "control")
    private Boolean control;

    @b(name = "set")
    private Boolean set;

    @b(name = ViewHierarchyConstants.VIEW_KEY)
    private Boolean view;

    public Boolean getControl() {
        return this.control;
    }

    public Boolean getSet() {
        return this.set;
    }

    public Boolean getView() {
        return this.view;
    }

    public void setControl(Boolean bool) {
        this.control = bool;
    }

    public void setSet(Boolean bool) {
        this.set = bool;
    }

    public void setView(Boolean bool) {
        this.view = bool;
    }
}
