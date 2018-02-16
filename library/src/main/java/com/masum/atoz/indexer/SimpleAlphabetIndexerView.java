package com.masum.atoz.indexer;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
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

public class SimpleAlphabetIndexerView extends LinearLayout {
    private String[] alphabet = {"A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    private int color = getResources().getColor(R.color.white);
    private LinearLayout linearLayoutLetterHolder;
    private Context context;
    private RecyclerView recyclerView;
    ArrayList<View> insideViewsOfLetterHolder;

    public OnSelectLetter onSelectLetter;

    public SimpleAlphabetIndexerView(Context context) {
        super(context);
        initializeViews(context);
    }

    public SimpleAlphabetIndexerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public SimpleAlphabetIndexerView(Context context,
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
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.alphabet_indexer_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // Sets the images for the previous and next buttons. Uses
        // built-in images so you don't need to add images, but in
        // a real application your images should be in the
        // application package so they are always available.

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new SmoothScrollerLinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        linearLayoutLetterHolder = (LinearLayout) this.findViewById(R.id.LinearMainHolder);
        insideViewsOfLetterHolder = linearLayoutLetterHolder.getTouchables();

        alphabetHolderHeightCalculation();

    }

    private void alphabetHolderHeightCalculation() {
        ViewTreeObserver viewTreeObserver = recyclerView.getViewTreeObserver();

        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                if (Build.VERSION.SDK_INT < 16) {
                    recyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                final int height = recyclerView.getMeasuredHeight();

                int singleLetterCellHeight = height / 26;
                Log.d(TAG, "Single letter cell height: " + singleLetterCellHeight);
                Log.d(TAG, "Font size found: " + (singleLetterCellHeight * 70 / 100));

                for (int i = 0; i < 26; i++) {
                    final TextView tv = new TextView(getContext());
                    tv.setText(alphabet[i]);
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, singleLetterCellHeight * 70 / 100);
                    tv.setLayoutParams(new LayoutParams(singleLetterCellHeight, singleLetterCellHeight));
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextColor(getBackgroundColor());
                    tv.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onSelectLetter.onSelectLetter(tv.getText().toString());
                        }
                    });

                    linearLayoutLetterHolder.addView(tv);
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

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        getRecyclerView().setAdapter(adapter);
    }

    public void scrollToPosition(boolean isSmoothScroll, int position) {
        if (isSmoothScroll) {
            getRecyclerView().smoothScrollToPosition(position);
        } else {
            getRecyclerView().scrollToPosition(position);
        }
    }

    public void refreshAlphabetView() {
        linearLayoutLetterHolder.removeAllViews();
        alphabetHolderHeightCalculation();


    }

    public int getBackgroundColor() {
        return this.color;
    }

    public void addListener(OnSelectLetter onSelectLetter) {
        this.onSelectLetter = onSelectLetter;
    }

}