package au.com.softclient.myshoppinglist.ViewModel;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<List<String>> shoppingList;
    private List<String> shoppingListSample = new ArrayList<>();



    public LiveData<List<String>> getShoppingList() {
        if (shoppingList == null) {
            shoppingList = new MutableLiveData<>();
            loadShoppingList();
        }
        return shoppingList;
    }

    public void removeList(){
        int lastIndex = shoppingListSample.size() - 1;
        if (lastIndex >= 0) {
            String removedItem = shoppingListSample.remove(lastIndex);
            Log.d("Fun1", "RemoveList called!");
            Log.d("List", shoppingListSample.toString());
            shoppingList.setValue(shoppingListSample);
            //showToast("Removed: " + removedItem);
        }
    }
//    public void removeList(){
//
//        int lastIndex = shoppingListSample.size() - 1;
//        if (lastIndex >= 0) {
//            shoppingListSample.remove(lastIndex);
//            Log.d("Fun1", "RemoveList called!");
//            Log.d("List", shoppingListSample.toString());
//            shoppingList.setValue(shoppingListSample);
//            showToast("Removed: " + removedItem);
//
//
//        }

//        shoppingListSample.remove();
//        Log.d("Fun1","RemoveList called!");
//        Log.d("List",shoppingListSample.toString());
//        shoppingList.setValue(shoppingListSample);
 //   }
    //To Add The List
    public void addToList(String itemToAdd) {
        shoppingListSample.add(itemToAdd);
        Log.d("Fun2", "AddToList called!");
        Log.d("List", shoppingListSample.toString());
        shoppingList.setValue(shoppingListSample);
    }

    private void loadShoppingList() {
        //Handler handler = new Handler(Looper.getMainLooper());
        //handler.postDelayed(() -> {
        android.os.Handler handler = new android.os.Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            //List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("Bread");
            shoppingListSample.add("Bananas");
            shoppingListSample.add("Peanut Butter");
            shoppingListSample.add("Eggs");
            shoppingListSample.add("Chicken breasts");
            shoppingListSample.add("Apples");
            shoppingListSample.add("Cheese");
            shoppingListSample.add("Yogurt");
            shoppingListSample.add("Tomatoes");
            shoppingListSample.add("Pasta");

            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));

            shoppingList.setValue(shoppingListSample);
        }, 5000); // Delayed for 5 seconds
    }
}


/*
public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<String>> shoppingList;

    public LiveData<List<String>> getShoppingList() {
        if (shoppingList == null) {
            shoppingList = new MutableLiveData<>();
            loadShoppingList();
        }
        return shoppingList;
    }

    private void loadShoppingList() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("Bread");
            shoppingListSample.add("Bananas");
            shoppingListSample.add("Peanut Butter");
            shoppingListSample.add("Eggs");
            shoppingListSample.add("Chicken breasts");

            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));

            shoppingList.setValue(shoppingListSample);
        }, 5000); // Delayed for 5 seconds
    }
}
*/

/*
public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<String>> shoppingList;

    public LiveData<List<String>> getShoppingList() {
        if (shoppingList == null) {
            shoppingList = new MutableLiveData<>();
            loadShoppingList();
        }
        return shoppingList;
    }

    private void loadShoppingList() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("Bread");
            shoppingListSample.add("Bananas");
            shoppingListSample.add("Peanut Butter");
            shoppingListSample.add("Eggs");
            shoppingListSample.add("Chicken breasts");

            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));

            shoppingList.setValue(shoppingListSample);
        }, 5000); // Delayed for 5 seconds
    }
}
*/

/*
public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<String>> shoppingList;

    public LiveData<List<String>> getShoppingList(){
        if()

    }

    private void loadShoppingList(){
        Handler myHandler = new Handler();
        myHandler.postDelayed(()-> {
            List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("Bread");
            shoppingListSample.add("Bananas");
            shoppingListSample.add("Peanut Butter");
            shoppingListSample.add("Eggs");
            shoppingListSample.add("Chiken breasts");

            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));

            shoppingList.setValue(shoppingListSample);
        },500);
        //myHandler.postDelayed
    }
}
*/