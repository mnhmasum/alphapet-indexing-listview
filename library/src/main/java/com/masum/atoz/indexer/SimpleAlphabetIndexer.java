package com.masum.atoz.indexer;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SimpleAlphabetIndexer extends LinearLayout {
    private String[] alphabet = {"A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    private int color = getResources().getColor(R.color.white);
    private LinearLayout linearLayoutLetterHolder;

    public OnSelectLetter onSelectLetter;

    public SimpleAlphabetIndexer(Context context) {
        super(context);
        initializeViews(context);
    }

    public SimpleAlphabetIndexer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public SimpleAlphabetIndexer(Context context,
                                 AttributeSet attrs,
                                 int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    /**
     * Inflates the views in the alphabet_list_layout.
     *
     * @param context the current context for the view.
     */
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.alphabet_list_layout, this);
    }

    ArrayList<View> insideViewsOfLetterHolder;
    int height = 0;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // Sets the images for the previous and next buttons. Uses
        // built-in images so you don't need to add images, but in
        // a real application your images should be in the
        // application package so they are always available.

        linearLayoutLetterHolder = (LinearLayout) this.findViewById(R.id.LinearMainHolder);
        insideViewsOfLetterHolder = linearLayoutLetterHolder.getTouchables();

        ViewTreeObserver viewTreeObserver = linearLayoutLetterHolder.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                if (Build.VERSION.SDK_INT < 16) {
                    linearLayoutLetterHolder.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    linearLayoutLetterHolder.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                final int height = linearLayoutLetterHolder.getMeasuredHeight();

                int singleLetterCellHeight = height / 26;
                Log.d(TAG, "Single letter cell height: " + singleLetterCellHeight);

                for (int i = 0; i < 26; i++) {
                    final TextView bt = new TextView(getContext());
                    bt.setText(alphabet[i]);
                    Log.d(TAG, "Font size found: " + (singleLetterCellHeight * 70 / 100));
                    bt.setTextSize(TypedValue.COMPLEX_UNIT_PX, singleLetterCellHeight * 70 / 100);
                    bt.setLayoutParams(new LayoutParams(singleLetterCellHeight, singleLetterCellHeight));
                    bt.setGravity(Gravity.CENTER);
                    bt.setTextColor(getBackgroundColor());
                    bt.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onSelectLetter.onSelectLetter(bt.getText().toString());
                        }
                    });

                    linearLayoutLetterHolder.addView(bt);
                }

                insideViewsOfLetterHolder = linearLayoutLetterHolder.getTouchables();

            }
        });

    }

    public void setLetterFontColor(int color) {
        this.color = color;
        for (View v : insideViewsOfLetterHolder) {
            v.setBackgroundColor(color);
        }
    }

    public void setBackgroundColor(int color) {
        linearLayoutLetterHolder.setBackgroundColor(color);
    }

    public int getBackgroundColor() {
        return this.color;
    }

    public void addListener(OnSelectLetter onSelectLetter) {
        this.onSelectLetter = onSelectLetter;
    }


}