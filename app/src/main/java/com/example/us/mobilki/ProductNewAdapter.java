package com.example.us.mobilki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductNewAdapter extends ProductAdapter {

    public ProductNewAdapter(List<Product> list, LayoutInflater inflater, boolean showQuantity) {
        mProductList = list;
        mInflater = inflater;
        mShowQuantity = showQuantity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_item, null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView
                    .findViewById(R.id.ImageViewItem);

            item.productTitle = (TextView) convertView
                    .findViewById(R.id.TextViewItem);

            item.productQuantity = (TextView) convertView
                    .findViewById(R.id.textViewQuantity);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Product curProduct = mProductList.get(position);

        item.productImageView.setImageDrawable(curProduct.productImage);
        item.productTitle.setText(curProduct.title);

        // Show the quantity in the cart or not
        if (mShowQuantity) {
            item.productQuantity.setText("Ilość w koszyku "
                    + ProductListNew.getProductQuantity(curProduct));
        } else {
            // Hid the view
            item.productQuantity.setVisibility(View.GONE);
        }

        return convertView;
    }

}