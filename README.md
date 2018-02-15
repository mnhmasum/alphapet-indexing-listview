# Simple Alphabet Indexer Recycler view
Simple Alphabet Index Recycler view is a library for indexing the list by selecting a letter. It support almost all screen resolution of android. It gives you back the selected letter from the alphabet view then developer can implement their own logic. We have given an example how to implement on the project. Please follow the below instruction or download the repository project.

![](https://media.giphy.com/media/3o7WIKTVGEXAwBpi6Y/giphy.gif)


### Dependencies
Add it in your root build.gradle at the end of repositories:
```Java
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency in your application build.gradle file
```Java
dependencies {
    compile 'com.github.mnhmasum:SimpleAlphabetIndexer:1.2'
}

```

### XML
```XML
<com.masum.atoz.indexer.SimpleAlphabetIndexerView
    android:id="@+id/alphabetIndexerView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>

```

### JAVA
```Java
SimpleAlphabetIndexerView simpleAlphabetIndexerView = (SimpleAlphabetIndexerView) findViewById(R.id.alphabetIndexerView);
        simpleAlphabetIndexerView.setAdapter(mAdapter);
        simpleAlphabetIndexerView.addListener(new OnSelectLetter() {
            @Override
            public void onSelectLetter(String letter) {
                Toast.makeText(MainActivity.this, letter, Toast.LENGTH_SHORT).show();
                // do something with the selected letter
            }
        });

```
### Background color
```Java
simpleAlphabetIndexerView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
```
### Font color of Alphabet holder
```Java
simpleAlphabetIndexerView.setLetterFontColor(getResources().getColor(R.color.white))
```



