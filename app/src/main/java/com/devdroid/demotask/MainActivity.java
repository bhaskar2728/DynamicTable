package com.devdroid.demotask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.devdroid.dynamic_table.DynamicTable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TableLayout tableLayout;

    HorizontalScrollView horizontalScrollView;
    ScrollView scrollView;

    int k1,k;

    EditText edtPlus;
    EditText edtPlusCol;


    FirebaseDatabase database = FirebaseDatabase.getInstance();


    int tableRowCount = 8;
    int tableColCount = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scrollView = findViewById(R.id.scrollView);
        horizontalScrollView = findViewById(R.id.horizontalScrollView);


        tableLayout = findViewById(R.id.tableLayout);
        edtPlus = findViewById(R.id.edtPlus);
        edtPlusCol = findViewById(R.id.edtPlusCol);

        edtPlusCol.setFocusable(false);
        edtPlus.setFocusable(false);

        final DynamicTable dynamicTable = new DynamicTable(tableLayout,scrollView,horizontalScrollView,
                this,tableRowCount,tableColCount,200,400);

        dynamicTable.initTable();


        /*TableRow tr0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText(" ");
        tv0.setWidth(100);
        tv0.setHeight(110);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackground(getResources().getDrawable(R.drawable.border_with_green_color));
        tv0.setTextColor(Color.BLACK);
        tr0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("Column 0");
        tv1.setHeight(110);
        tv1.setWidth(300);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackground(getResources().getDrawable(R.drawable.border_with_green_color));
        tv1.setTextColor(Color.BLACK);
        tr0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Column 1");
        tv2.setHeight(110);
        tv2.setWidth(300);
        tv2.setGravity(Gravity.CENTER);
        tv2.setBackground(getResources().getDrawable(R.drawable.border_with_green_color));
        tv2.setTextColor(Color.BLACK);
        tr0.addView(tv2);

        tableLayout.addView(tr0);

        for(k1=0;k1<tableRowCount;k1++){

            TableRow tableRow0 = new TableRow(this);

            final int row = k1;

            EditText tvv0 = new EditText(this);
            tvv0.setText("" + k1);
            tvv0.setWidth(100);
            tvv0.setHeight(110);
            tvv0.setEnabled(false);
            tvv0.setBackground(getResources().getDrawable(R.drawable.border_with_green_color));
            tvv0.setGravity(Gravity.CENTER);
            tvv0.setTextColor(Color.BLACK);
            tableRow0.addView(tvv0);

            EditText edt1 = new EditText(this);
            edt1.setHeight(110);
            edt1.setWidth(300);
            edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(b){
                        Change_Background(view);
                    }
                    else{
                        Restore_Background(view);
                    }
                }
            });
            edt1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                    reference.child("Col " + 0).child("Row "+ row).setValue(charSequence.toString());

                }

                @Override
                public void afterTextChanged(Editable editable) {


                }
            });
            edt1.setBackground(getResources().getDrawable(R.drawable.border));
            edt1.setTextColor(Color.BLACK);
            tableRow0.addView(edt1);

            EditText edt2 = new EditText(this);
            edt2.setHeight(110);
            edt2.setWidth(300);
            edt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(b){
                        Change_Background(view);
                    }
                    else{
                        Restore_Background(view);
                    }
                }
            });

            edt2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                    reference.child("Col " + 1).child("Row "+ row).setValue(charSequence.toString());


                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            edt2.setBackground(getResources().getDrawable(R.drawable.border));
            edt2.setTextColor(Color.BLACK);
            tableRow0.addView(edt2);

            tableLayout.addView(tableRow0);
        }*/


        edtPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dynamicTable.addRow();

                /*TableRow tableRow0 = new TableRow(MainActivity.this);


                EditText tvv0 = new EditText(MainActivity.this);
                tvv0.setText("" + tableRowCount);
                tvv0.setWidth(100);
                tvv0.setHeight(110);
                tvv0.setEnabled(false);
                tvv0.setBackground(getResources().getDrawable(R.drawable.border_with_green_color));
                tvv0.setGravity(Gravity.CENTER);
                tvv0.setTextColor(Color.BLACK);
                tableRow0.addView(tvv0);

               for(k = 0;k<tableColCount;k++){

                   final int col = k;
                   final int row = tableRowCount;

                   EditText edt1 = new EditText(MainActivity.this);
                   edt1.setHeight(110);
                   edt1.setWidth(300);
                   edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                       @Override
                       public void onFocusChange(View view, boolean b) {
                           if(b){
                               Change_Background(view);
                           }
                           else{
                               Restore_Background(view);
                           }
                       }
                   });
                   edt1.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



                           DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                           reference.child("Col " + col).child("Row "+ row).setValue(charSequence.toString());


                       }

                       @Override
                       public void afterTextChanged(Editable editable) {

                       }
                   });
                   edt1.setBackground(getResources().getDrawable(R.drawable.border));
                   edt1.setTextColor(Color.BLACK);
                   tableRow0.addView(edt1);

               }

                tableLayout.addView(tableRow0);

                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(HorizontalScrollView.FOCUS_DOWN);
                    }
                };
                scrollView.post(runnable);

                tableRowCount++;

*/
            }
        });

        edtPlusCol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dynamicTable.addCol();

                /*int i=0;
                int j=tableRowCount;

                TableRow tableRowAdd = (TableRow) tableLayout.getChildAt(0);
                TableRow tableRow = new TableRow(getApplicationContext());

                TextView txt1 = new TextView(MainActivity.this);
                txt1.setHeight(110);
                txt1.setWidth(300);
                txt1.setGravity(Gravity.CENTER);
                txt1.setText("Column " + tableColCount);
                txt1.setBackground(getResources().getDrawable(R.drawable.border_with_green_color));
                txt1.setTextColor(Color.BLACK);

                tableRow.setTag(txt1);
                tableRow.addView(txt1);
                tableRowAdd.addView(tableRow);

                for(int k=i+1; k<=j; k++){
                    addColumnToTable(k,"");
                }
                tableColCount++;*/

            }
        });


    }

    /*private void Restore_Background(View view) {

        EditText edtSel = (EditText) view;
        edtSel.setBackground(getResources().getDrawable(R.drawable.border));
    }

    private void Change_Background(View view) {

        EditText edtSel = (EditText) view;
        edtSel.setBackground(getResources().getDrawable(R.drawable.border_black));
    }*/

    /*private void addColumnToTable(final int rowPos, String text) {

        final int row = rowPos - 1;
        final int col = tableColCount;

        TableRow tableRowAdd = (TableRow) this.tableLayout.getChildAt(rowPos);
        TableRow tableRow = new TableRow(getApplicationContext());
        //TableRow.LayoutParams layoutParamsTableRow= new TableRow.LayoutParams(SCREEN_WIDTH/5, SCREEN_HEIGHT/20);
        //tableRow.setPadding(3,3,3,4);
        //tableRow.setBackground(getResources().getDrawable(R.drawable.cell_bacground));
        //tableRow.setLayoutParams(layoutParamsTableRow);

        EditText edt1 = new EditText(MainActivity.this);
        edt1.setHeight(110);
        edt1.setWidth(300);
        edt1.setBackground(getResources().getDrawable(R.drawable.border));
        edt1.setTextColor(Color.BLACK);
        edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    Change_Background(view);
                }
                else{
                    Restore_Background(view);
                }
            }
        });

        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                reference.child("Col " + col).child("Row "+ row).setValue(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tableRow.setTag(edt1);
        tableRow.addView(edt1);
        tableRowAdd.addView(tableRow);

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        };
        horizontalScrollView.post(runnable);

    }*/
}