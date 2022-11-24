/*
 * Copyright 2018 Kaushik N. Sanji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.Postoko.storeapp.data.local.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Product implements Parcelable {
    public static final Creator<Product> CREATOR = new Creator<Product>() {

        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    //The Primary Key/ID of the Product
    private final int mId;
    //The Name of the Product
    private String mName;
    //The Unique SKU of the Product
    private String mSku;
    //The Description of the Product
    private String mDescription;
    //The Category of the Product
    private String mCategory;
    //List of Product Images
    private ArrayList<ProductImage> mProductImages;
    //List of Additional Attributes of the Product
    private ArrayList<ProductAttribute> mProductAttributes;

    private Product(int id, String name, String sku, String description, String category,
                    ArrayList<ProductImage> productImages,
                    ArrayList<ProductAttribute> productAttributes) {
        mId = id;
        mName = name;
        mSku = sku;
        mDescription = description;
        mCategory = category;
        mProductImages = productImages;
        mProductAttributes = productAttributes;
    }

    protected Product(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mSku = in.readString();
        mDescription = in.readString();
        mCategory = in.readString();
        mProductImages = in.createTypedArrayList(ProductImage.CREATOR);
        mProductAttributes = in.createTypedArrayList(ProductAttribute.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mSku);
        dest.writeString(mDescription);
        dest.writeString(mCategory);
        dest.writeTypedList(mProductImages);
        dest.writeTypedList(mProductAttributes);
    }

    @Override
    public int describeContents() {
        return 0; //Indicating with no mask
    }
    public int getId() {
        return mId;
    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public String getSku() {
        return mSku;
    }
    public void setSku(String sku) {
        mSku = sku;
    }
    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description) {
        mDescription = description;
    }
    public String getCategory() {
        return mCategory;
    }
    public void setCategory(String category) {
        mCategory = category;
    }
    public ArrayList<ProductImage> getProductImages() {
        return mProductImages;
    }
    public void setProductImages(ArrayList<ProductImage> productImages) {
        mProductImages = productImages;
    }

    public ArrayList<ProductAttribute> getProductAttributes() {
        return mProductAttributes;
    }
    public void setProductAttributes(ArrayList<ProductAttribute> productAttributes) {
        mProductAttributes = productAttributes;
    }
    public static class Builder {
        private int mId;
        private String mName;
        private String mSku;
        private String mDescription;
        private String mCategory;
        private ArrayList<ProductImage> mProductImages;
        private ArrayList<ProductAttribute> mProductAttributes;
        public Builder setId(int id) {
            mId = id;
            return this;
        }

        public Builder setName(String name) {
            mName = name;
            return this;
        }

        public Builder setSku(String sku) {
            mSku = sku;
            return this;
        }

        public Builder setDescription(String description) {
            mDescription = description;
            return this;
        }

        public Builder setCategory(String category) {
            mCategory = category;
            return this;
        }

        public Builder setProductImages(ArrayList<ProductImage> productImages) {
            mProductImages = productImages;
            return this;
        }

        public Builder setProductAttributes(ArrayList<ProductAttribute> productAttributes) {
            mProductAttributes = productAttributes;
            return this;
        }

        public Product createProduct() {
            //Initializing Product Images List of not initialized
            if (mProductImages == null) mProductImages = new ArrayList<>();
            //Initializing Product Attributes List of not initialized
            if (mProductAttributes == null) mProductAttributes = new ArrayList<>();
            //Returning the instance built
            return new Product(mId, mName, mSku, mDescription, mCategory, mProductImages, mProductAttributes);
        }
    }
}
