package com.example.us.mobilki;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by us on 16.01.2017.
 */

public class OrderFinishActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private Button btnNext;
    private List<Product> mCartList, mCartListW,mCartListM;
    private ProductNewAdapter mProductAdapter;
    private ProductWomenAdapter mProductAdapterW;
    private ProductMenAdapter mProductAdapterM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finish);

        btnNext= (Button)findViewById(R.id.buttonOrder);
        btnNext.setOnClickListener(this);

        mCartList = ProductListNew.getCartList();
        mCartListW = ProductListWomen.getCartList();
        mCartListM = ProductListMen.getCartList();

        // Make sure to clear the selections
        for (int i = 0; i < mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        for (int i = 0; i < mCartListW.size(); i++) {
            mCartListW.get(i).selected = false;
        }

        for (int i = 0; i < mCartListM.size(); i++) {
            mCartListM.get(i).selected = false;
        }

// Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductNewAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductNewDetails.class);
                productDetailsIntent.putExtra(ProductListNew.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        final ListView listViewCatalogWomen = (ListView) findViewById(R.id.ListViewCatalogWomen);
        mProductAdapterW = new ProductWomenAdapter(mCartListW, getLayoutInflater(), true);
        listViewCatalogWomen.setAdapter(mProductAdapterW);
        listViewCatalogWomen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductWomenDetails.class);
                productDetailsIntent.putExtra(ProductListWomen.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        final ListView listViewCatalogMen = (ListView) findViewById(R.id.ListViewCatalogMen);
        mProductAdapterM = new ProductMenAdapter(mCartListM, getLayoutInflater(), true);
        listViewCatalogMen.setAdapter(mProductAdapterM);
        listViewCatalogMen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductMenDetails.class);
                productDetailsIntent.putExtra(ProductListMen.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if (mProductAdapter != null ||mProductAdapterW != null || mProductAdapterM != null) {
            mProductAdapter.notifyDataSetChanged();
            mProductAdapterW.notifyDataSetChanged();
            mProductAdapterM.notifyDataSetChanged();
        }

        double subTotal = 0;
        for (Product p : mCartList) {
            int quantity = ProductListNew.getProductQuantity(p);
            subTotal += p.price * quantity;
        }
        for (Product p : mCartListW) {
            int quantity = ProductListWomen.getProductQuantity(p);
            subTotal += p.price * quantity;
        }
        for (Product p : mCartListM) {
            int quantity = ProductListMen.getProductQuantity(p);
            subTotal += p.price * quantity;
        }

        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
        productPriceTextView.setText("Do zapłaty:" + subTotal +" zł");

    }

    public void order()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(OrderFinishActivity.this);

        alertDialog.setTitle("Zamówienie zostało przyjęte"); // Sets title for your alertbox

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(OrderFinishActivity.this, OrderFinishActivity.class));
                finish();
            }
        });


        alertDialog.show();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonOrder:
                order();
                break;
            default:
        }

    }

}

