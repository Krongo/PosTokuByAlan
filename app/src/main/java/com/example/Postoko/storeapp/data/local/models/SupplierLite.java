
package com.example.Postoko.storeapp.data.local.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.example.Postoko.storeapp.data.local.utils.QueryArgsUtility;

public class SupplierLite implements Parcelable {

    public static final Creator<SupplierLite> CREATOR = new Creator<SupplierLite>() {

        @Override
        public SupplierLite createFromParcel(Parcel in) {
            return new SupplierLite(in);
        }

        @Override
        public SupplierLite[] newArray(int size) {
            return new SupplierLite[size];
        }
    };
    //The Primary Key/ID of the Supplier
    private final int mId;
    //The Name of the Supplier
    @NonNull
    private final String mName;
    //The Unique Code of the Supplier
    @NonNull
    private final String mCode;
    //The Default Phone Contact of the Supplier
    private final String mDefaultPhone;
    //The Default Email Contact of the Supplier
    private final String mDefaultEmail;
    //The Number of Products sold by the Supplier
    private final int mItemCount;

    private SupplierLite(int id, @NonNull String name, @NonNull String code, String defaultPhone, String defaultEmail, int itemCount) {
        mId = id;
        mName = name;
        mCode = code;
        mDefaultPhone = defaultPhone;
        mDefaultEmail = defaultEmail;
        mItemCount = itemCount;
    }

    protected SupplierLite(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mCode = in.readString();
        mDefaultPhone = in.readString();
        mDefaultEmail = in.readString();
        mItemCount = in.readInt();
    }

    public static SupplierLite from(Cursor cursor) {
        return new SupplierLite(
                cursor.getInt(QueryArgsUtility.SuppliersShortInfoQuery.COLUMN_SUPPLIER_ID_INDEX),
                cursor.getString(QueryArgsUtility.SuppliersShortInfoQuery.COLUMN_SUPPLIER_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SuppliersShortInfoQuery.COLUMN_SUPPLIER_CODE_INDEX),
                cursor.getString(QueryArgsUtility.SuppliersShortInfoQuery.COLUMN_SUPPLIER_DEFAULT_PHONE_INDEX),
                cursor.getString(QueryArgsUtility.SuppliersShortInfoQuery.COLUMN_SUPPLIER_DEFAULT_EMAIL_INDEX),
                cursor.getInt(QueryArgsUtility.SuppliersShortInfoQuery.COLUMN_SUPPLIER_ITEM_COUNT_INDEX)
        );
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mCode);
        dest.writeString(mDefaultPhone);
        dest.writeString(mDefaultEmail);
        dest.writeInt(mItemCount);
    }

    @Override
    public int describeContents() {
        return 0; //Indicating with no mask
    }

    public int getId() {
        return mId;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getCode() {
        return mCode;
    }

    public String getDefaultPhone() {
        return mDefaultPhone;
    }

    public String getDefaultEmail() {
        return mDefaultEmail;
    }

    public int getItemCount() {
        return mItemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierLite that = (SupplierLite) o;

        if (mId != that.mId) return false;
        if (mItemCount != that.mItemCount) return false;
        if (!mName.equals(that.mName)) return false;
        if (!mCode.equals(that.mCode)) return false;
        if (mDefaultPhone != null ? !mDefaultPhone.equals(that.mDefaultPhone) : that.mDefaultPhone != null)
            return false;
        return mDefaultEmail != null ? mDefaultEmail.equals(that.mDefaultEmail) : that.mDefaultEmail == null;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + mName.hashCode();
        result = 31 * result + mCode.hashCode();
        result = 31 * result + (mDefaultPhone != null ? mDefaultPhone.hashCode() : 0);
        result = 31 * result + (mDefaultEmail != null ? mDefaultEmail.hashCode() : 0);
        result = 31 * result + mItemCount;
        return result;
    }
}
