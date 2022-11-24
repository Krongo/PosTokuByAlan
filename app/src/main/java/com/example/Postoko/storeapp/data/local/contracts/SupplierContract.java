package com.example.Postoko.storeapp.data.local.contracts;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class SupplierContract implements StoreContract {

    //Identifier for the table 'supplier' associated with the Base URI
    public static final String PATH_SUPPLIER = "supplier";

    //Identifier for the table 'contact_type' associated with the Base URI
    public static final String PATH_CONTACT_TYPE = "contacttype";

    //Identifier for the table 'supplier_contact' associated with the Base URI
    public static final String PATH_SUPPLIER_CONTACT = "contact";

    private SupplierContract() {
        //Suppressing with an error to enforce noninstantiability
        throw new AssertionError("No " + this.getClass().getCanonicalName() + " instances for you!");
    }

    public static final class Supplier implements BaseColumns {

        //The Content URI to access the 'supplier' Table data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_SUPPLIER);

        public static final String CONTENT_LIST_TYPE
                = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_SUPPLIER;

        public static final String CONTENT_ITEM_TYPE
                = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_SUPPLIER;


        //Identifier for Short information that retrieves the relationship data for the 'supplier'
        public static final String PATH_SHORT_INFO = "short";

        //The Content URI to access the short relationship data from 'supplier' Table in the provider
        public static final Uri CONTENT_URI_SHORT_INFO = Uri.withAppendedPath(CONTENT_URI, PATH_SHORT_INFO);

        public static final String CONTENT_LIST_TYPE_SHORT_INFO
                = CONTENT_LIST_TYPE + "." + PATH_SHORT_INFO;
        //Identifier for retrieving a supplier from 'supplier' table based on the Supplier Code
        public static final String PATH_SUPPLIER_CODE = "code";
        //The Content URI to access the 'supplier' Table data using the Supplier Code in the provider
        public static final Uri CONTENT_URI_SUPPLIER_CODE = Uri.withAppendedPath(CONTENT_URI, PATH_SUPPLIER_CODE);
        public static final String CONTENT_ITEM_TYPE_SUPPLIER_CODE
                = CONTENT_ITEM_TYPE + "." + PATH_SUPPLIER_CODE;
        public static final String TABLE_NAME = "supplier";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_CODE = "supplier_code";
        public static Uri buildSupplierCodeUri(String supplierCode) {
            return CONTENT_URI_SUPPLIER_CODE.buildUpon().appendPath(supplierCode).build();
        }

        @NonNull
        public static String getQualifiedColumnName(String columnNameStr) {
            return TextUtils.concat(TABLE_NAME, ".", columnNameStr).toString();
        }
    }

    public static final class SupplierContactType implements BaseColumns {

        //The Content URI to access the 'contact_type' Table data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_CONTACT_TYPE);
        public static final String CONTENT_LIST_TYPE
                = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_CONTACT_TYPE;
        public static final String CONTENT_ITEM_TYPE
                = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_CONTACT_TYPE;

        public static final String TABLE_NAME = "contact_type";
        public static final String COLUMN_CONTACT_TYPE_NAME = "type_name";
        public static final String CONTACT_TYPE_PHONE = "Phone";
        public static final int CONTACT_TYPE_ID_PHONE = 0;
        public static final String CONTACT_TYPE_EMAIL = "Email";
        public static final int CONTACT_TYPE_ID_EMAIL = 1;

        //Array of Contact Types that will be loaded on the initial launch of the app
        private static final String[] PRELOADED_CONTACT_TYPES = new String[]{
                CONTACT_TYPE_PHONE,
                CONTACT_TYPE_EMAIL
        };

        @NonNull
        public static String getQualifiedColumnName(String columnNameStr) {
            return TextUtils.concat(TABLE_NAME, ".", columnNameStr).toString();
        }
        public static String[] getPreloadedContactTypes() {
            return PRELOADED_CONTACT_TYPES;
        }
    }

    public static final class SupplierContact implements BaseColumns {

        //The Content URI to access the 'supplier_contact' Table data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(Supplier.CONTENT_URI, PATH_SUPPLIER_CONTACT);
        public static final String CONTENT_LIST_TYPE
                = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "." + PATH_SUPPLIER + "." + PATH_SUPPLIER_CONTACT;
        public static final String CONTENT_ITEM_TYPE
                = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "." + PATH_SUPPLIER + "." + PATH_SUPPLIER_CONTACT;

        public static final String TABLE_NAME = "supplier_contact";
        public static final String COLUMN_SUPPLIER_CONTACT_TYPE_ID = "contact_type_id";
        public static final String COLUMN_SUPPLIER_CONTACT_VALUE = "contact_value";
        public static final String COLUMN_SUPPLIER_CONTACT_DEFAULT = "is_default";
        public static final String COLUMN_SUPPLIER_ID = "supplier_id";
        public static final int SUPPLIER_CONTACT_DEFAULT = 1;
        public static final int SUPPLIER_CONTACT_NON_DEFAULT = 0;

        @NonNull
        public static String getQualifiedColumnName(String columnNameStr) {
            return TextUtils.concat(TABLE_NAME, ".", columnNameStr).toString();
        }
    }

}
