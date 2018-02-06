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

        item = new ListItem("chlorinate");
        listItems.add(item);
        item = new ListItem("chlorinated");
        listItems.add(item);
        item = new ListItem("chlorinates");
        listItems.add(item);


        item = new ListItem("Diamox");
        listItems.add(item);

        item = new ListItem("Dian");
        listItems.add(item);


        item = new ListItem("Emyle");
        listItems.add(item);

        item = new ListItem("Emilee");
        listItems.add(item);

        item = new ListItem("Emylee");
        listItems.add(item);

        item = new ListItem("Fresnel");
        listItems.add(item);

        item = new ListItem("Fress");
        listItems.add(item);


        item = new ListItem("Goldi");
        listItems.add(item);

        item = new ListItem("Goldy");
        listItems.add(item);

        item = new ListItem("Goldia");
        listItems.add(item);

        item = new ListItem("Goldic");
        listItems.add(item);

        item = new ListItem("Goldie");
        listItems.add(item);

        item = new ListItem("gold-yellow");
        listItems.add(item);

        item = new ListItem("goldilocks");
        listItems.add(item);

        item = new ListItem("goldylocks");
        listItems.add(item);

        item = new ListItem("hirpled");
        listItems.add(item);

        item = new ListItem("hirples");
        listItems.add(item);

        item = new ListItem("hirpling");
        listItems.add(item);

        item = new ListItem("hirrient");
        listItems.add(item);

        item = new ListItem("intrudes");
        listItems.add(item);

        item = new ListItem("intruding");
        listItems.add(item);

        item = new ListItem("intrudingly");
        listItems.add(item);

        item = new ListItem("intrudress");
        listItems.add(item);

        item = new ListItem("intrunk");
        listItems.add(item);

        item = new ListItem("joineries");
        listItems.add(item);

        item = new ListItem("joinering");
        listItems.add(item);

        item = new ListItem("joiners");
        listItems.add(item);
        item = new ListItem("Joinerville");
        listItems.add(item);

        item = new ListItem("joinhand");
        listItems.add(item);

        item = new ListItem("katachromasis");
        listItems.add(item);
        item = new ListItem("katacrotic");
        listItems.add(item);

        item = new ListItem("katacrotism");
        listItems.add(item);

        item = new ListItem("katagelophobia");
        listItems.add(item);
        item = new ListItem("katagenesis");
        listItems.add(item);

        item = new ListItem("Lasser");
        listItems.add(item);

        item = new ListItem("lasses");
        listItems.add(item);
        item = new ListItem("lasset");
        listItems.add(item);

        item = new ListItem("Lassie");
        listItems.add(item);

        item = new ListItem("Malca");
        listItems.add(item);
        item = new ListItem("Malcah");
        listItems.add(item);

        item = new ListItem("Malchy");
        listItems.add(item);

        item = new ListItem("malchite");
        listItems.add(item);
        item = new ListItem("Malchus");
        listItems.add(item);

        item = new ListItem("Nigritian");
        listItems.add(item);

        item = new ListItem("nigrities");
        listItems.add(item);
        item = new ListItem("nigritude");
        listItems.add(item);

        item = new ListItem("nigritudinous");
        listItems.add(item);

        item = new ListItem("nigromancer");
        listItems.add(item);
        item = new ListItem("Oak-clad");
        listItems.add(item);

        item = new ListItem("Oak-covered");
        listItems.add(item);

        item = new ListItem("Oak-crested");
        listItems.add(item);
        item = new ListItem("Oak-crowned");
        listItems.add(item);

        item = new ListItem("Oakdale");
        listItems.add(item);

        item = new ListItem("Peribursal");
        listItems.add(item);
        item = new ListItem("Pericaecal");
        listItems.add(item);

        item = new ListItem("Pericaecitis");
        listItems.add(item);

        item = new ListItem("Pericanalicular");
        listItems.add(item);
        item = new ListItem("Pericapsular");
        listItems.add(item);

        item = new ListItem("quackster");
        listItems.add(item);

        item = new ListItem("quad");
        listItems.add(item);
        item = new ListItem("quad.");
        listItems.add(item);

        item = new ListItem("quadded");
        listItems.add(item);

        item = new ListItem("reachers");
        listItems.add(item);
        item = new ListItem("reaches");
        listItems.add(item);

        item = new ListItem("reachy");
        listItems.add(item);

        item = new ListItem("reachieve");
        listItems.add(item);
        item = new ListItem("reachieved");
        listItems.add(item);

        item = new ListItem("scuffle");
        listItems.add(item);

        item = new ListItem("scuffled");
        listItems.add(item);
        item = new ListItem("scuffler");
        listItems.add(item);

        item = new ListItem("scufflers");
        listItems.add(item);
        item = new ListItem("scuffles");
        listItems.add(item);

        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);
        item = new ListItem("a");
        listItems.add(item);

        mAdapter.notifyDataSetChanged();

    }


    @Override
    public void onSelectLetter(String letter) {

        Toast.makeText(getApplicationContext(), "" + letter, Toast.LENGTH_SHORT).show();

        mAdapter = new ListAdapter(filterResult(letter));
        recyclerView.setAdapter(mAdapter);


    }

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
