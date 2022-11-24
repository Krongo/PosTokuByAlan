
package com.example.Postoko.storeapp.data.local.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringDef;

import com.example.Postoko.storeapp.data.local.contracts.SupplierContract;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SupplierContact implements Parcelable, Cloneable {

    public static final Creator<SupplierContact> CREATOR = new Creator<SupplierContact>() {

        @Override
        public SupplierContact createFromParcel(Parcel in) {
            return new SupplierContact(in);
        }

        @Override
        public SupplierContact[] newArray(int size) {
            return new SupplierContact[size];
        }
    };
    //The Type of the Supplier Contact
    private final String mType;
    //Value of the Contact
    private String mValue;
    //Denotes whether the Contact is the default contact for the Supplier or not
    private boolean mIsDefault;

    private SupplierContact(@SupplierContactTypeDef String type, String value, boolean isDefault) {
        mType = type;
        mValue = value;
        mIsDefault = isDefault;
    }

    protected SupplierContact(Parcel in) {
        mType = in.readString();
        mValue = in.readString();
        mIsDefault = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mType);
        dest.writeString(mValue);
        dest.writeByte((byte) (mIsDefault ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0; //Indicating with no mask
    }

    public String getType() {
        return mType;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

    public boolean isDefault() {
        return mIsDefault;
    }

    public void setDefault(boolean isDefault) {
        mIsDefault = isDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierContact that = (SupplierContact) o;

        if (mIsDefault != that.mIsDefault) return false;
        if (!mType.equals(that.mType)) return false;
        return mValue != null ? mValue.equals(that.mValue) : that.mValue == null;
    }

    @Override
    public int hashCode() {
        int result = mType.hashCode();
        result = 31 * result + (mValue != null ? mValue.hashCode() : 0);
        result = 31 * result + (mIsDefault ? 1 : 0);
        return result;
    }

    @Override
    public final Object clone() {
        //Returning a new instance of SupplierContact constructed using the Builder
        return new Builder()
                .setType(this.mType)
                .setIsDefault(this.mIsDefault)
                .setValue(this.mValue)
                .createSupplierContact();
    }


    @Override
    public String toString() {
        return "SupplierContact{" +
                "mType='" + mType + '\'' +
                ", mValue='" + mValue + '\'' +
                ", mIsDefault=" + mIsDefault +
                '}';
    }

    //Defining Annotation interface for valid Supplier Contact Types
    //Enumerating Annotation with valid Supplier Contact Types
    @StringDef({SupplierContract.SupplierContactType.CONTACT_TYPE_PHONE,
            SupplierContract.SupplierContactType.CONTACT_TYPE_EMAIL})
    //Retaining Annotation till Compile Time
    @Retention(RetentionPolicy.SOURCE)
    public @interface SupplierContactTypeDef {
    }

    public static class Builder {

        private String mType;
        private String mValue;
        private boolean mIsDefault = false;

        public Builder setType(@SupplierContactTypeDef String type) {
            mType = type;
            return this;
        }

        public Builder setValue(String value) {
            mValue = value;
            return this;
        }

        public Builder setIsDefault(boolean isDefault) {
            mIsDefault = isDefault;
            return this;
        }

        public SupplierContact createSupplierContact() {
            return new SupplierContact(mType, mValue, mIsDefault);
        }
    }
}
