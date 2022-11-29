

package com.example.Postoko.storeapp.ui.inventory.config;
import com.example.Postoko.storeapp.data.local.models.ProductSupplierSales;


public interface ProductSuppliersUserActionsListener {

    /**
     * Callback Method of {@link ProductSuppliersUserActionsListener} invoked when
     * the user clicks on the "Edit" button. This should launch the
     * {@link com.example.Postoko.storeapp.ui.suppliers.config.SupplierConfigActivity}
     * for the Supplier to be edited.
     *
     * @param itemPosition         The adapter position of the Item clicked.
     * @param productSupplierSales The {@link ProductSupplierSales} associated with the Item clicked.
     */
    void onEditSupplier(final int itemPosition, ProductSupplierSales productSupplierSales);

    /**
     * Callback Method of {@link ProductSuppliersUserActionsListener} invoked when
     * the user swipes the Item View to remove the Product-Supplier link.
     *
     * @param itemPosition         The adapter position of the Item clicked.
     * @param productSupplierSales The {@link ProductSupplierSales} associated with the Item swiped.
     */
    void onSwiped(final int itemPosition, ProductSupplierSales productSupplierSales);

    /**
     * Callback Method of {@link ProductSuppliersUserActionsListener} invoked when
     * the user clicks on the "Procure" button. This should launch the
     * {@link com.example.Postoko.storeapp.ui.inventory.procure.SalesProcurementActivity}
     * for the User to place procurement for the Product.
     *
     * @param itemPosition         The adapter position of the Item clicked.
     * @param productSupplierSales The {@link ProductSupplierSales} associated with the Item clicked.
     */
    void onProcure(final int itemPosition, ProductSupplierSales productSupplierSales);

    /**
     * Callback Method of {@link ProductSuppliersUserActionsListener} invoked when
     * the total available quantity of the Product has been recalculated.
     *
     * @param totalAvailableQuantity Integer value of the Total Available quantity of the Product.
     */
    void onUpdatedAvailability(final int totalAvailableQuantity);

    /**
     * Callback Method of {@link ProductSuppliersUserActionsListener} invoked when
     * there is a change to the total available quantity of the Product.
     *
     * @param changeInAvailableQuantity Integer value of the change in the Total Available
     *                                  quantity of the Product with respect to the last
     *                                  Updated Availability. Can be negative to indicate
     *                                  the decrease in Available Quantity.
     */
    void onChangeInAvailability(final int changeInAvailableQuantity);
}
