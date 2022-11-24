
package com.example.Postoko.storeapp.data.local.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.Postoko.storeapp.data.local.utils.QueryArgsUtility;

public class SalesLite implements Parcelable {
    public static final Creator<SalesLite> CREATOR = new Creator<SalesLite>() {
        @Override
        public SalesLite createFromParcel(Parcel in) {
            return new SalesLite(in);
        }

        @Override
        public SalesLite[] newArray(int size) {
            return new SalesLite[size];
        }
    };
    //The Primary Key/ID of the Product
    private final int mProductId;
    //The Primary Key/ID of the Top Supplier
    private final int mSupplierId;
    //The Name of the Product
    private final String mProductName;
    //The Unique SKU of the Product
    private final String mProductSku;
    //The Category of the Product
    private final String mCategoryName;
    //The Content URI of the default Image of the Product
    private final String mDefaultImageUri;
    //The Name of the Top Supplier for the Product
    private final String mTopSupplierName;
    //The Unique Code of the Top Supplier for the Product
    private final String mTopSupplierCode;
    //The Selling Price of the Product by the Top Supplier
    private final float mSupplierUnitPrice;
    //The Available Quantity to Sell at the Top Supplier
    private final int mSupplierAvailableQuantity;
    //The Total Available to Sell Quantity of the Product
    private final int mTotalAvailableQuantity;

    private SalesLite(int productId, int supplierId, String productName, String productSku,
                      String categoryName, String defaultImageUri, String topSupplierName,
                      String topSupplierCode, float supplierUnitPrice,
                      int supplierAvailableQuantity, int totalAvailableQuantity) {
        mProductId = productId;
        mSupplierId = supplierId;
        mProductName = productName;
        mProductSku = productSku;
        mCategoryName = categoryName;
        mDefaultImageUri = defaultImageUri;
        mTopSupplierName = topSupplierName;
        mTopSupplierCode = topSupplierCode;
        mSupplierUnitPrice = supplierUnitPrice;
        mSupplierAvailableQuantity = supplierAvailableQuantity;
        mTotalAvailableQuantity = totalAvailableQuantity;
    }

    protected SalesLite(Parcel in) {
        mProductId = in.readInt();
        mSupplierId = in.readInt();
        mProductName = in.readString();
        mProductSku = in.readString();
        mCategoryName = in.readString();
        mDefaultImageUri = in.readString();
        mTopSupplierName = in.readString();
        mTopSupplierCode = in.readString();
        mSupplierUnitPrice = in.readFloat();
        mSupplierAvailableQuantity = in.readInt();
        mTotalAvailableQuantity = in.readInt();
    }

    public static SalesLite from(Cursor cursor) {
        return new SalesLite(
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_ID_INDEX),
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_ID_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_SKU_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_CATEGORY_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_IMAGE_URI_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_NAME_INDEX),
                cursor.getString(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_CODE_INDEX),
                cursor.getFloat(QueryArgsUtility.SalesShortInfoQuery.COLUMN_ITEM_UNIT_PRICE_INDEX),
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_SUPPLIER_AVAIL_QUANTITY_INDEX),
                cursor.getInt(QueryArgsUtility.SalesShortInfoQuery.COLUMN_TOTAL_AVAIL_QUANTITY_INDEX)
        );
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mProductId);
        dest.writeInt(mSupplierId);
        dest.writeString(mProductName);
        dest.writeString(mProductSku);
        dest.writeString(mCategoryName);
        dest.writeString(mDefaultImageUri);
        dest.writeString(mTopSupplierName);
        dest.writeString(mTopSupplierCode);
        dest.writeFloat(mSupplierUnitPrice);
        dest.writeInt(mSupplierAvailableQuantity);
        dest.writeInt(mTotalAvailableQuantity);
    }

    @Override
    public int describeContents() {
        return 0; //Indicating with no mask
    }
    public int getProductId() {
        return mProductId;
    }
    public int getSupplierId() {
        return mSupplierId;
    }
    public String getProductName() {
        return mProductName;
    }
    public String getProductSku() {
        return mProductSku;
    }
    public String getCategoryName() {
        return mCategoryName;
    }
    public String getDefaultImageUri() {
        return mDefaultImageUri;
    }
    public String getTopSupplierName() {
        return mTopSupplierName;
    }
    public String getTopSupplierCode() {
        return mTopSupplierCode;
    }
    public float getSupplierUnitPrice() {
        return mSupplierUnitPrice;
    }
    public int getSupplierAvailableQuantity() {
        return mSupplierAvailableQuantity;
    }
    public int getTotalAvailableQuantity() {
        return mTotalAvailableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesLite salesLite = (SalesLite) o;

        if (mProductId != salesLite.mProductId) return false;
        if (mSupplierId != salesLite.mSupplierId) return false;
        if (Float.compare(salesLite.mSupplierUnitPrice, mSupplierUnitPrice) != 0) return false;
        if (mSupplierAvailableQuantity != salesLite.mSupplierAvailableQuantity) return false;
        if (mTotalAvailableQuantity != salesLite.mTotalAvailableQuantity) return false;
        if (!mProductName.equals(salesLite.mProductName)) return false;
        if (!mProductSku.equals(salesLite.mProductSku)) return false;
        if (!mCategoryName.equals(salesLite.mCategoryName)) return false;
        if (mDefaultImageUri != null ? !mDefaultImageUri.equals(salesLite.mDefaultImageUri) : salesLite.mDefaultImageUri != null)
            return false;
        if (!mTopSupplierName.equals(salesLite.mTopSupplierName)) return false;
        return mTopSupplierCode.equals(salesLite.mTopSupplierCode);
    }

    @Override
    public int hashCode() {
        int result = mProductId;
        result = 31 * result + mSupplierId;
        result = 31 * result + mProductName.hashCode();
        result = 31 * result + mProductSku.hashCode();
        result = 31 * result + mCategoryName.hashCode();
        result = 31 * result + (mDefaultImageUri != null ? mDefaultImageUri.hashCode() : 0);
        result = 31 * result + mTopSupplierName.hashCode();
        result = 31 * result + mTopSupplierCode.hashCode();
        result = 31 * result + (mSupplierUnitPrice != +0.0f ? Float.floatToIntBits(mSupplierUnitPrice) : 0);
        result = 31 * result + mSupplierAvailableQuantity;
        result = 31 * result + mTotalAvailableQuantity;
        return result;
    }
}
