package au.com.softclient.myshoppinglist.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import au.com.softclient.myshoppinglist.R;
import au.com.softclient.myshoppinglist.ViewModel.MainActivityViewModel;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private ProgressBar progressBar;
    private ListView listView;
    private EditText editText;
    private Button addButton;

    Button btn;

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        _viewModel = new ViewModelProvider(requireActivity()).get(OrderPickingViewModel.class);
//        _binding.setModel(_viewModel);
//        _binding.setLifecycleOwner(getViewLifecycleOwner());

        // Initialize UI components
        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);
        btn = (Button)findViewById(R.id.button);

        // Initialize UI components
//        progressBar = findViewById(R.id.progressBar);
//        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);

        //remove new item
        btn.setOnClickListener(v->{
            viewModel.removeList();
            Log.d("Fun2","RemoveList called!");
            showToast("one item Removed: ");
        });

        // Handle the button click to add items to the list
        addButton.setOnClickListener(v -> {
            String newItem = editText.getText().toString().trim();
            if (!newItem.isEmpty()) {
                viewModel.addToList(newItem);
                editText.setText(""); // Clear the input field
                showToast("Added: " + newItem);
            }
        });

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Observe changes in the shopping list LiveData
        viewModel.getShoppingList().observe(this, shoppingList -> {
            if (shoppingList != null) {
                progressBar.setVisibility(View.GONE);
                // Create an adapter and set it to the ListView
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
                listView.setAdapter(adapter);
                listView.setVisibility(View.VISIBLE);
            }
        });
    }
}


/*
public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private ProgressBar progressBar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        progressBar = findViewById(R.id.progressBar1);
        listView = findViewById(R.id.listView1);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Observe changes in the shopping list LiveData
        viewModel.getShoppingList().observe(this, shoppingList -> {
            if (shoppingList != null) {
                progressBar.setVisibility(View.GONE);
                // Create an adapter and set it to the ListView
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
                listView.setAdapter(adapter);
            }
        });
    }
}
*/

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/