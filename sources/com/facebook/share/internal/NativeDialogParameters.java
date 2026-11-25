package com.facebook.share.internal;

import android.os.Bundle;
import c.o0;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeDialogParameters {
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
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, uuid), z7);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return create(shareOpenGraphContent, ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), false), z7);
            } catch (JSONException e8) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e8.getMessage());
            }
        }
        if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            return create(shareMediaContent, ShareInternalUtility.getMediaInfos(shareMediaContent, uuid), z7);
        }
        if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid), z7);
        }
        if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            return create((ShareMessengerGenericTemplateContent) shareContent, z7);
        }
        if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            return create((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z7);
        }
        if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            return create((ShareMessengerMediaTemplateContent) shareContent, z7);
        }
        if (!(shareContent instanceof ShareStoryContent)) {
            return null;
        }
        ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
        return create(shareStoryContent, ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid), ShareInternalUtility.getStickerUrl(shareStoryContent, uuid), z7);
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z7) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, "LINK", shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z7);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList<>(peopleIds));
        }
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareHashtag.getHashtag());
        }
        return bundle;
    }

    private static Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareCameraEffectContent, z7);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            bundleCreateBaseParameters.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            JSONObject jSONObjectConvertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (jSONObjectConvertToJSON != null) {
                Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.EFFECT_ARGS, jSONObjectConvertToJSON.toString());
            }
            return bundleCreateBaseParameters;
        } catch (JSONException e8) {
            throw new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + e8.getMessage());
        }
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareLinkContent, z7);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(bundleCreateBaseParameters, ShareConstants.IMAGE_URL, shareLinkContent.getImageUrl());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility.putUri(bundleCreateBaseParameters, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility.putUri(bundleCreateBaseParameters, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        return bundleCreateBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(sharePhotoContent, z7);
        bundleCreateBaseParameters.putStringArrayList(ShareConstants.PHOTOS, new ArrayList<>(list));
        return bundleCreateBaseParameters;
    }

    private static Bundle create(ShareVideoContent shareVideoContent, String str, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareVideoContent, z7);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.VIDEO_URL, str);
        return bundleCreateBaseParameters;
    }

    private static Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareMediaContent, z7);
        bundleCreateBaseParameters.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList<>(list));
        return bundleCreateBaseParameters;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareOpenGraphContent, z7);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.PREVIEW_PROPERTY_NAME, (String) ShareInternalUtility.getFieldNameAndNamespaceFromFullName(shareOpenGraphContent.getPreviewPropertyName()).second);
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.ACTION, jSONObject.toString());
        return bundleCreateBaseParameters;
    }

    private static Bundle create(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareMessengerGenericTemplateContent, z7);
        try {
            MessengerShareContentUtility.addGenericTemplateContent(bundleCreateBaseParameters, shareMessengerGenericTemplateContent);
            return bundleCreateBaseParameters;
        } catch (JSONException e8) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + e8.getMessage());
        }
    }

    private static Bundle create(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareMessengerOpenGraphMusicTemplateContent, z7);
        try {
            MessengerShareContentUtility.addOpenGraphMusicTemplateContent(bundleCreateBaseParameters, shareMessengerOpenGraphMusicTemplateContent);
            return bundleCreateBaseParameters;
        } catch (JSONException e8) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + e8.getMessage());
        }
    }

    private static Bundle create(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareMessengerMediaTemplateContent, z7);
        try {
            MessengerShareContentUtility.addMediaTemplateContent(bundleCreateBaseParameters, shareMessengerMediaTemplateContent);
            return bundleCreateBaseParameters;
        } catch (JSONException e8) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + e8.getMessage());
        }
    }

    private static Bundle create(ShareStoryContent shareStoryContent, @o0 Bundle bundle, @o0 Bundle bundle2, boolean z7) {
        Bundle bundleCreateBaseParameters = createBaseParameters(shareStoryContent, z7);
        if (bundle != null) {
            bundleCreateBaseParameters.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            bundleCreateBaseParameters.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        List<String> backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (!Utility.isNullOrEmpty(backgroundColorList)) {
            bundleCreateBaseParameters.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList<>(backgroundColorList));
        }
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        return bundleCreateBaseParameters;
    }
}
