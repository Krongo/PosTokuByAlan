
package com.example.Postoko.storeapp.data.local.contracts;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class SalesContract implements StoreContract {

    //Identifier for the table 'item_supplier_info' associated with the Base URI
    public static final String PATH_ITEM_SUPPLIER_INFO = "salesinfo";

    //Identifier for the table 'item_supplier_inventory' associated with the Base URI
    public static final String PATH_ITEM_SUPPLIER_INVENTORY = "salesinventory";

    private SalesContract() {
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No " + this.getClass().getCanonicalName() + " instances for you!");
    }

    public interface ProductSupplierColumns extends BaseColumns {
        String COLUMN_ITEM_ID = "item_id";
        String COLUMN_SUPPLIER_ID = "supplier_id";
    }

    public static final class ProductSupplierInfo implements ProductSupplierColumns {

        //The Content URI to access the 'item_supplier_info' Table data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ITEM_SUPPLIER_INFO);
        public static final String CONTENT_LIST_TYPE
                = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_ITEM_SUPPLIER_INFO;

        public static final String CONTENT_ITEM_TYPE
                = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_ITEM_SUPPLIER_INFO;


        //The Content URI to access the 'item' relationship data from 'item_supplier_info' Table
        //for a given supplier in the provider
        public static final Uri CONTENT_URI_SUPPLIER_ITEMS = Uri.withAppendedPath(CONTENT_URI, SupplierContract.PATH_SUPPLIER);
        public static final String CONTENT_LIST_TYPE_SUPPLIER_ITEMS
                = CONTENT_LIST_TYPE + "." + SupplierContract.PATH_SUPPLIER;

        //The Content URI to access the 'supplier' relationship data from 'item_supplier_info' Table
        //for a given item in the provider
        public static final Uri CONTENT_URI_ITEM_SUPPLIERS = Uri.withAppendedPath(CONTENT_URI, ProductContract.PATH_ITEM);
        public static final String CONTENT_LIST_TYPE_ITEM_SUPPLIERS
                = CONTENT_LIST_TYPE + "." + ProductContract.PATH_ITEM;
        public static final String TABLE_NAME = "item_supplier_info";
        public static final String COLUMN_ITEM_UNIT_PRICE = "unit_price";
        public static final float DEFAULT_ITEM_UNIT_PRICE = 0.0f;

        @NonNull
        public static String getQualifiedColumnName(String columnNameStr) {
            return TextUtils.concat(TABLE_NAME, ".", columnNameStr).toString();
        }
    }

    public static final class ProductSupplierInventory implements ProductSupplierColumns {

        //The Content URI to access the 'item_supplier_inventory' Table data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ITEM_SUPPLIER_INVENTORY);
        public static final String CONTENT_LIST_TYPE
                = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_ITEM_SUPPLIER_INVENTORY;
        public static final String CONTENT_ITEM_TYPE
                = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_ITEM_SUPPLIER_INVENTORY;

        //The Content URI to access the 'item' relationship data from 'item_supplier_inventory' Table
        //for a given supplier in the provider
        public static final Uri CONTENT_URI_INV_SUPPLIER = Uri.withAppendedPath(CONTENT_URI, SupplierContract.PATH_SUPPLIER);
        public static final String CONTENT_LIST_TYPE_INV_SUPPLIER
                = CONTENT_LIST_TYPE + "." + SupplierContract.PATH_SUPPLIER;

        //The Content URI to access the 'supplier' relationship data from 'item_supplier_inventory' Table
        //for a given item in the provider
        public static final Uri CONTENT_URI_INV_ITEM = Uri.withAppendedPath(CONTENT_URI, ProductContract.PATH_ITEM);
        public static final String CONTENT_LIST_TYPE_INV_ITEM
                = CONTENT_LIST_TYPE + "." + ProductContract.PATH_ITEM;

        //Identifier for Short information that retrieves the relationship data for the 'item_supplier_inventory'
        public static final String PATH_SHORT_INFO = "short";

        //The Content URI to access the short relationship data from 'item_supplier_inventory' Table in the provider
        public static final Uri CONTENT_URI_SHORT_INFO = Uri.withAppendedPath(CONTENT_URI, PATH_SHORT_INFO);
        public static final String CONTENT_LIST_TYPE_SHORT_INFO
                = CONTENT_LIST_TYPE + "." + PATH_SHORT_INFO;
        public static final String TABLE_NAME = "item_supplier_inventory";

        public static final String COLUMN_ITEM_AVAIL_QUANTITY = "available_quantity";

        public static final int DEFAULT_ITEM_AVAIL_QUANTITY = 0;

        @NonNull
        public static String getQualifiedColumnName(String columnNameStr) {
            return TextUtils.concat(TABLE_NAME, ".", columnNameStr).toString();
        }
    }
}
