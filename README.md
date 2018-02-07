# SimpleAlphabetIndexer
SimpleAlphabetIndexer is simple alphate indexer library. It can be used with vertical list view and recycler view to sort the list by using letter click.

#XML
```
<RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <android.support.v7.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_alignParentLeft="true"
            android:layout_toLeftOf="@+id/alphabetIndexView" />

        <com.masum.atoz.indexer.SimpleAlphabetIndexer
            android:id="@+id/alphabetIndexView"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_alignParentRight="true" />


    </RelativeLayout>
```

#JAVA
```
public class MainActivity extends AppCompatActivity implements OnSelectLetter {

    private List<ListItem> listItems = new ArrayList<>();
    private ListAdapter mAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleAlphabetIndexer simpleAlphabetIndexer = (SimpleAlphabetIndexer) findViewById(R.id.alphabetIndexView);
        simpleAlphabetIndexer.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        simpleAlphabetIndexer.setHolderBackgroundColor(getResources().getColor(R.color.white));
        simpleAlphabetIndexer.addListener(this);

    }
    
     @Override
    public void onSelectLetter(String letter) {
        Toast.makeText(getApplicationContext(), "" + letter, Toast.LENGTH_SHORT).show();
    }
    
}
```
