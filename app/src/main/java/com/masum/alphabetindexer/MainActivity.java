package com.masum.alphabetindexer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.masum.alphabetindexer.model.ListItem;
import com.masum.atoz.indexer.OnSelectLetter;
import com.masum.atoz.indexer.SimpleAlphabetIndexer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListItem> listItems = new ArrayList<>();
    private ListAdapter mAdapter;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ListAdapter(listItems);
        listItems.addAll(DataSet.getData());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new SmoothScrollerLinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        SimpleAlphabetIndexer simpleAlphabetIndexer = (SimpleAlphabetIndexer) findViewById(R.id.alphabetIndexView);
        simpleAlphabetIndexer.setLetterFontColor(getResources().getColor(R.color.colorPrimaryDark));
        simpleAlphabetIndexer.setBackgroundColor(getResources().getColor(R.color.white));
        simpleAlphabetIndexer.addListener(new OnSelectLetter() {
            @Override
            public void onSelectLetter(String letter) {
                Toast.makeText(getApplicationContext(), "" + letter, Toast.LENGTH_SHORT).show();
                //If you want to move on selected letter with smooth scrolling
                scrollToPosition(letter);

                //If you want to load data only respected alphabet then use this code
               /* mAdapter = new ListAdapter(filterResult(letter));
                recyclerView.setAdapter(mAdapter);*/
            }
        });

    }

    //If you move only to selected letter's data
    private void scrollToPosition(String letter) {
        for (int i = 0; i < listItems.size(); i++) {
            if (String.valueOf(listItems.get(i).getTitle().charAt(0)).equalsIgnoreCase(letter)) {
                recyclerView.smoothScrollToPosition(i);
                break;
            }
        }

    }

    //If you show only selected letter's data
    private ArrayList<ListItem> filterResult(String letter) {
        ArrayList<ListItem> filteredList = new ArrayList<>();

        for (ListItem title : listItems) {
            if (String.valueOf(title.getTitle().charAt(0)).equalsIgnoreCase(letter)) {
                filteredList.add(title);
            }
        }

        return filteredList;
    }




}
