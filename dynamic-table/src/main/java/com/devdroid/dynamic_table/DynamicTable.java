package com.devdroid.dynamic_table;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DynamicTable {

    TableLayout tableLayout;
    ScrollView scrollView;
    HorizontalScrollView horizontalScrollView;
    Context context;
    int defaultRowCount;
    int defaultColCount;
    int k1,k;
    int heightPixel;
    int widthPixel;

    public DynamicTable(TableLayout tableLayout, ScrollView scrollView, HorizontalScrollView horizontalScrollView,
                        Context context, int defaultRowCount, int defaultColCount,
                        int heightPixel, int widthPixel) {
        this.tableLayout = tableLayout;
        this.scrollView = scrollView;
        this.horizontalScrollView = horizontalScrollView;
        this.context = context;
        this.defaultRowCount = defaultRowCount;
        this.defaultColCount = defaultColCount;
        this.heightPixel = heightPixel;
        this.widthPixel = widthPixel;
    }

    public void initTable(){
        TableRow tr0 = new TableRow(context);

        TextView tv0 = new TextView(context);
        tv0.setText(" ");
        tv0.setWidth(100);
        tv0.setHeight(110);
        tv0.setBackground(context.getResources().getDrawable(R.drawable.border_with_green_color));
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.BLACK);
        tr0.addView(tv0);

        for(int j = 0; j< defaultColCount; j++){

            TextView tv1 = new TextView(context);
            tv1.setText("Column "+ (j));
            tv1.setHeight(110);
            tv1.setWidth(widthPixel);
            tv1.setBackground(context.getResources().getDrawable(R.drawable.border_with_green_color));
            tv1.setGravity(Gravity.CENTER);
            tv1.setTextColor(Color.BLACK);
            tr0.addView(tv1);

        }

        tableLayout.addView(tr0);

        for(k1=0;k1<defaultRowCount;k1++){

            TableRow tableRow0 = new TableRow(context);

            final int row = k1;

            EditText tvv0 = new EditText(context);
            tvv0.setText("" + k1);
            tvv0.setWidth(100);
            tvv0.setHeight(heightPixel);
            tvv0.setBackground(context.getResources().getDrawable(R.drawable.border_with_green_color));
            tvv0.setEnabled(false);
            tvv0.setGravity(Gravity.CENTER);
            tvv0.setTextColor(Color.BLACK);
            tableRow0.addView(tvv0);

            EditText edt1 = new EditText(context);
            edt1.setHeight(heightPixel);
            edt1.setWidth(widthPixel);
            edt1.setBackground(context.getResources().getDrawable(R.drawable.border));
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
            tableRow0.addView(edt1);

            EditText edt2 = new EditText(context);
            edt2.setHeight(heightPixel);
            edt2.setWidth(widthPixel);
            edt2.setBackground(context.getResources().getDrawable(R.drawable.border));
            edt2.setTextColor(Color.BLACK);
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
            tableRow0.addView(edt2);

            tableLayout.addView(tableRow0);
        }
    }

    public void addRow(){
        TableRow tableRow0 = new TableRow(context);


        EditText tvv0 = new EditText(context);
        tvv0.setText("" + defaultRowCount);
        tvv0.setWidth(100);
        tvv0.setHeight(heightPixel);
        tvv0.setEnabled(false);
        tvv0.setBackground(context.getResources().getDrawable(R.drawable.border_with_green_color));
        tvv0.setGravity(Gravity.CENTER);
        tvv0.setTextColor(Color.BLACK);
        tableRow0.addView(tvv0);

        for(k = 0;k<defaultColCount;k++){

            final int col = k;
            final int row = defaultRowCount;

            EditText edt1 = new EditText(context);
            edt1.setHeight(heightPixel);
            edt1.setWidth(widthPixel);
            edt1.setBackground(context.getResources().getDrawable(R.drawable.border));
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

        defaultRowCount++;
    }

    public void addCol(){
        int i=0;
        int j=defaultRowCount;

        TableRow tableRowAdd = (TableRow) tableLayout.getChildAt(0);
        TableRow tableRow = new TableRow(context);

        TextView txt1 = new TextView(context);
        txt1.setHeight(100);
        txt1.setWidth(widthPixel);
        txt1.setGravity(Gravity.CENTER);
        txt1.setText("Column " + defaultColCount);
        txt1.setBackground(context.getResources().getDrawable(R.drawable.border_with_green_color));
        txt1.setTextColor(Color.BLACK);

        tableRow.setTag(txt1);
        tableRow.addView(txt1);
        tableRowAdd.addView(tableRow);

        for(int k=i+1; k<=j; k++){
            addColumnToTable(k);
        }
        defaultColCount++;
    }

    public void addColumnToTable(final int rowPos) {

        final int row = rowPos - 1;
        final int col = defaultColCount;

        TableRow tableRowAdd = (TableRow) this.tableLayout.getChildAt(rowPos);
        TableRow tableRow = new TableRow(context);

        EditText edt1 = new EditText(context);
        edt1.setHeight(heightPixel);
        edt1.setWidth(widthPixel);
        edt1.setBackground(context.getResources().getDrawable(R.drawable.border));
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

    }

    private void Restore_Background(View view) {

        EditText edtSel = (EditText) view;
        edtSel.setBackground(context.getResources().getDrawable(R.drawable.border));
    }

    private void Change_Background(View view) {

        EditText edtSel = (EditText) view;
        edtSel.setBackground(context.getResources().getDrawable(R.drawable.border_black));
    }
}
