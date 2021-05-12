package sg.edu.np.practical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final private static String TAG = "Main Activity";
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mContext = this;
        Log.v(TAG, "List Activity - onStart");
        ArrayList<User> userList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            userList.add(new User("Name"+randNum(), "Description "+randNum(), i+1, randBool()));
        }

        RecyclerView recyclerView = findViewById(R.id.users_recyclerView);
        UserListAdaptor myAdaptor = new UserListAdaptor(userList);

        LinearLayoutManager myLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdaptor);

    }

    public static void profileView(User user){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Profile");
        builder.setMessage(user.getName());
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(mContext, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", user.getName());
                bundle.putString("description", user.getDescription());
                bundle.putInt("id", user.getId());
                bundle.putBoolean("follow", user.isFollow());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private int randNum(){
        Random rand = new Random();
        return rand.nextInt(999999999);
    }

    private boolean randBool(){
        Random rand = new Random();
        return rand.nextBoolean();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "List Activity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "List Activity - onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "List Activity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "List Activity - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "List Activity - onDestroy");
    }
}