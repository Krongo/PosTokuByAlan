
package com.example.Postoko.storeapp.data.local.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.Postoko.storeapp.data.local.contracts.SalesContract;

public class ProductSupplierSales implements Parcelable, Cloneable {

    public static final Creator<ProductSupplierSales> CREATOR = new Creator<ProductSupplierSales>() {

        @Override
        public ProductSupplierSales createFromParcel(Parcel in) {
            return new ProductSupplierSales(in);
        }


        @Override
        public ProductSupplierSales[] newArray(int size) {
            return new ProductSupplierSales[size];
        }
    };
    //The Primary Key/ID of the Product
    private final int mItemId;
    //The Primary Key/ID of the Supplier
    private final int mSupplierId;
    //The Name of the Supplier
    private final String mSupplierName;
    //The Unique Code of the Supplier
    private final String mSupplierCode;
    //The Selling Price of the Product by the Supplier
    private final float mUnitPrice;
    //The Available Quantity to Sell at the Supplier
    private int mAvailableQuantity;

    private ProductSupplierSales(int itemId, int supplierId, String supplierName, String supplierCode, float unitPrice, int availableQuantity) {
        mItemId = itemId;
        mSupplierId = supplierId;
        mSupplierName = supplierName;
        mSupplierCode = supplierCode;
        mUnitPrice = unitPrice;
        mAvailableQuantity = availableQuantity;
    }

    protected ProductSupplierSales(Parcel in) {
        mItemId = in.readInt();
        mSupplierId = in.readInt();
        mSupplierName = in.readString();
        mSupplierCode = in.readString();
        mUnitPrice = in.readFloat();
        mAvailableQuantity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mItemId);
        dest.writeInt(mSupplierId);
        dest.writeString(mSupplierName);
        dest.writeString(mSupplierCode);
        dest.writeFloat(mUnitPrice);
        dest.writeInt(mAvailableQuantity);
    }

    @Override
    public int describeContents() {
        return 0; //Indicating with no mask
    }
    public int getItemId() {
        return mItemId;
    }
    public int getSupplierId() {
        return mSupplierId;
    }
    public String getSupplierName() {
        return mSupplierName;
    }
    public String getSupplierCode() {
        return mSupplierCode;
    }
    public float getUnitPrice() {
        return mUnitPrice;
    }
    public int getAvailableQuantity() {
        return mAvailableQuantity;
    }
    public void setAvailableQuantity(int availableQuantity) {
        mAvailableQuantity = availableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSupplierSales that = (ProductSupplierSales) o;

        if (mItemId != that.mItemId) return false;
        if (mSupplierId != that.mSupplierId) return false;
        if (Float.compare(that.mUnitPrice, mUnitPrice) != 0) return false;
        if (mAvailableQuantity != that.mAvailableQuantity) return false;
        if (!mSupplierName.equals(that.mSupplierName)) return false;
        return mSupplierCode.equals(that.mSupplierCode);
    }

    @Override
    public int hashCode() {
        int result = mItemId;
        result = 31 * result + mSupplierId;
        result = 31 * result + mSupplierName.hashCode();
        result = 31 * result + mSupplierCode.hashCode();
        result = 31 * result + (mUnitPrice != +0.0f ? Float.floatToIntBits(mUnitPrice) : 0);
        result = 31 * result + mAvailableQuantity;
        return result;
    }

    @Override
    public final Object clone() {
        //Returning a new instance of ProductSupplierSales constructed using the Builder
        return new Builder()
                .setItemId(this.mItemId)
                .setSupplierId(this.mSupplierId)
                .setSupplierName(this.mSupplierName)
                .setSupplierCode(this.mSupplierCode)
                .setUnitPrice(this.mUnitPrice)
                .setAvailableQuantity(this.mAvailableQuantity)
                .createProductSupplierSales();
    }

    @Override
    public String toString() {
        return "ProductSupplierSales{" +
                "mItemId=" + mItemId +
                ", mSupplierId=" + mSupplierId +
                ", mSupplierName='" + mSupplierName + '\'' +
                ", mSupplierCode='" + mSupplierCode + '\'' +
                ", mUnitPrice=" + mUnitPrice +
                ", mAvailableQuantity=" + mAvailableQuantity +
                '}';
    }

    public static class Builder {

        private int mItemId;
        private int mSupplierId;
        private String mSupplierName;
        private String mSupplierCode;
        private float mUnitPrice = SalesContract.ProductSupplierInfo.DEFAULT_ITEM_UNIT_PRICE;
        private int mAvailableQuantity = SalesContract.ProductSupplierInventory.DEFAULT_ITEM_AVAIL_QUANTITY;
        public Builder setItemId(int itemId) {
            mItemId = itemId;
            return this;
        }
        public Builder setSupplierId(int supplierId) {
            mSupplierId = supplierId;
            return this;
        }
        public Builder setSupplierName(String supplierName) {
            mSupplierName = supplierName;
            return this;
        }
        public Builder setSupplierCode(String supplierCode) {
            mSupplierCode = supplierCode;
            return this;
        }
        public Builder setUnitPrice(float unitPrice) {
            mUnitPrice = unitPrice;
            return this;
        }
        public Builder setAvailableQuantity(int availableQuantity) {
            mAvailableQuantity = availableQuantity;
            return this;
        }
        public ProductSupplierSales createProductSupplierSales() {
            return new ProductSupplierSales(mItemId, mSupplierId, mSupplierName, mSupplierCode, mUnitPrice, mAvailableQuantity);
        }
    }
}
