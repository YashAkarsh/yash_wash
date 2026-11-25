package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LegacyNativeDialogParameters {
    private static Bundle create(ShareVideoContent shareVideoContent, boolean z7) {
        return null;
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z7) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z7);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList<>(peopleIds));
        }
        return bundle;
    }

    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z7) {
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return create((ShareLinkContent) shareContent, z7);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z7);
        }
        if (shareContent instanceof ShareVideoContent) {
            return create((ShareVideoContent) shareContent, z7);
        }
        if (!(shareContent instanceof ShareOpenGraphContent)) {
            return null;
        }
        ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
        try {
            return create(shareOpenGraphContent, ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), z7);
        } catch (JSONException e8) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e8.getMessage());
        }
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareLinkContent, z7);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.LEGACY_TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.LEGACY_DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(bundleCreateBaseParameters, ShareConstants.LEGACY_IMAGE, shareLinkContent.getImageUrl());
        return bundleCreateBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(sharePhotoContent, z7);
        bundleCreateBaseParameters.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList<>(list));
        return bundleCreateBaseParameters;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareOpenGraphContent, z7);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.LEGACY_PREVIEW_PROPERTY_NAME, shareOpenGraphContent.getPreviewPropertyName());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.LEGACY_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.LEGACY_ACTION, jSONObject.toString());
        return bundleCreateBaseParameters;
    }
}
