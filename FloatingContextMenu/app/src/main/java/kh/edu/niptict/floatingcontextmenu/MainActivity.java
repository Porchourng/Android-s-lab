package kh.edu.niptict.floatingcontextmenu;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.article);
        EditText editText = findViewById(R.id.editText);

        /*
            Register a view to the context menu by calling
            It can register any view like editText, textView, etc.
            Multiple views can be registered to the same context menu. If you want each item in a ListView or GridView to
            provide the same context menu, register all items for a context menu by passing the ListView or GridView to
            registerForContextMenu().
        */
        registerForContextMenu(editText);


    }

    /*
    The menu parameter for onCreateContextMenu() is the context menu to be built.
    The v parameter is the view registered for the context menu.
    The menuInfo parameter is extra information about the view registered for the context menu.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_id:
                Toast.makeText(getApplicationContext(), "EditText", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_id:
                Toast.makeText(getApplicationContext(), "Delete Text", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add_id:
                Toast.makeText(getApplicationContext(), "Add Text", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
