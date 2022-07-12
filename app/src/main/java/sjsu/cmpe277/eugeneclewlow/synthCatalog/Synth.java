package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import java.util.UUID;

public class Synth {
    private UUID mId;
    private int mTitleResId;
    private int mDescResId;
    private int mImageResId;

    public Synth(int titleResId, int descResId, int imageResId) {
        mId = UUID.randomUUID();
        mTitleResId = titleResId;
        mDescResId = descResId;
        mImageResId = imageResId;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public void setTitleResId(int titleResId) {
        mTitleResId = titleResId;
    }

    public int getDescResId() {
        return mDescResId;
    }

    public void setDescResId(int descResId) {
        mDescResId = descResId;
    }

    public int getImageResId() {
        return mImageResId;
    }

    public void setImageResId(int imageResId) {
        mImageResId = imageResId;
    }
}
