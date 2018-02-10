package com.masum.alphabetindexer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.masum.alphabetindexer.model.ListItem;
import com.masum.atoz.indexer.OnSelectLetter;
import com.masum.atoz.indexer.SimpleAlphabetIndexerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListItem> listItems = new ArrayList<>();
    private ListAdapter mAdapter;

    private  SimpleAlphabetIndexerView simpleAlphabetIndexerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ListAdapter(listItems);
        listItems.addAll(DataSet.getData());

        simpleAlphabetIndexerView = (SimpleAlphabetIndexerView) findViewById(R.id.alphabetIndexerView);
        simpleAlphabetIndexerView.setAdapter(mAdapter);
        simpleAlphabetIndexerView.addListener(new OnSelectLetter() {
            @Override
            public void onSelectLetter(String letter) {
                Toast.makeText(MainActivity.this, letter, Toast.LENGTH_SHORT).show();
                scrollToPosition(letter);
                //filterResult(letter);
            }
        });


    }

    //If you move only to selected letter's data
    private void scrollToPosition(String letter) {
        for (int i = 0; i < listItems.size(); i++) {
            if (String.valueOf(listItems.get(i).getTitle().charAt(0)).equalsIgnoreCase(letter)) {
                simpleAlphabetIndexerView.scrollToPosition(true, i);
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

        mAdapter = new ListAdapter(filteredList);
        simpleAlphabetIndexerView.setAdapter(mAdapter);

        return filteredList;
    }




}
