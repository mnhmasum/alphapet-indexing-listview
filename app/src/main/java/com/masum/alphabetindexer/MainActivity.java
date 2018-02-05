package com.masum.alphabetindexer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.masum.atoz.indexer.OnSelectLetter;
import com.masum.atoz.indexer.SimpleAlphabetIndexer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSelectLetter {

    List<ListItem> listItems = new ArrayList<>();
    ListAdapter mAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new ListAdapter(listItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        SimpleAlphabetIndexer simpleAlphabetIndexer = (SimpleAlphabetIndexer) findViewById(R.id.alphabetIndexView);
        simpleAlphabetIndexer.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        simpleAlphabetIndexer.setHolderBackgroundColor(getResources().getColor(R.color.white));
        simpleAlphabetIndexer.addListener(this);

        loadData();

    }

    private void loadData() {
        ListItem item = new ListItem("abac");
        listItems.add(item);

        item = new ListItem("abaca");
        listItems.add(item);

        item = new ListItem("abacay");
        listItems.add(item);
        item = new ListItem("abacas");
        listItems.add(item);
        item = new ListItem("abacate");
        listItems.add(item);
        item = new ListItem("abacaxi");
        listItems.add(item);
        item = new ListItem("abaci");
        listItems.add(item);
        item = new ListItem("abacinate");
        listItems.add(item);
        item = new ListItem("abacination");
        listItems.add(item);
        item = new ListItem("abacisci");
        listItems.add(item);
        item = new ListItem("abaciscus");
        listItems.add(item);
        item = new ListItem("abacist");
        listItems.add(item);
        item = new ListItem("aback");
        listItems.add(item);
        item = new ListItem("abacli");
        listItems.add(item);
        item = new ListItem("Abaco");
        listItems.add(item);
        item = new ListItem("abacot");
        listItems.add(item);
        item = new ListItem("abacterial");
        listItems.add(item);
        item = new ListItem("abactinal");
        listItems.add(item);
        item = new ListItem("abactinally");
        listItems.add(item);

        item = new ListItem("boyship");
        listItems.add(item);

        item = new ListItem("Bois-le-Duc");
        listItems.add(item);

        item = new ListItem("boisseau");
        listItems.add(item);

        item = new ListItem("boisseaux");
        listItems.add(item);

        item = new ListItem("Boissevain");
        listItems.add(item);

        item = new ListItem("boist");
        listItems.add(item);


        item = new ListItem("boisterous");
        listItems.add(item);


        item = new ListItem("boisterously");
        listItems.add(item);


        item = new ListItem("boisterousness");
        listItems.add(item);


        item = new ListItem("chayaroot");
        listItems.add(item);


        item = new ListItem("Chayefsky");
        listItems.add(item);


        item = new ListItem("Chaiken");
        listItems.add(item);


        item = new ListItem("Chaikovski");
        listItems.add(item);


        item = new ListItem("Chaille");
        listItems.add(item);


        item = new ListItem("Daveta");
        listItems.add(item);


        item = new ListItem("Davy");
        listItems.add(item);


        item = new ListItem("David");
        listItems.add(item);


        item = new ListItem("Davida");
        listItems.add(item);


        item = new ListItem("echinoids");
        listItems.add(item);

        item = new ListItem("echinology");
        listItems.add(item);

        item = new ListItem("b");
        listItems.add(item);

        mAdapter.notifyDataSetChanged();

    }


    @Override
    public void onSelectLetter(String letter) {

        Toast.makeText(getApplicationContext(), "" + letter, Toast.LENGTH_SHORT).show();

        mAdapter = new ListAdapter(filter(letter));
        recyclerView.setAdapter(mAdapter);


    }

    private ArrayList<ListItem> filter(String letter) {
        ArrayList<ListItem> filteredList = new ArrayList<>();
        for (ListItem title : listItems) {
            if (String.valueOf(title.getTitle().charAt(0)).equalsIgnoreCase(String.valueOf(letter.charAt(0)))) {
                filteredList.add(title);
            }
        }

        return filteredList;
    }
}
