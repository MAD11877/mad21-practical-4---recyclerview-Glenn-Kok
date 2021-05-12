package sg.edu.np.practical4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    final private static String TAG = "Main Activity";
    private TextView name;
    private TextView description;
    private Button follow;
    private User user;

    private void followStat(){
        if (user.isFollow()){
            follow.setText(new String("Unfollow"));
        }
        else{
            follow.setText(new String("Follow"));
        }
    }

    private void showToastMsg(){
        HashMap <Boolean, String> stat = new HashMap<Boolean, String>();
        stat.put(true, "Followed");
        stat.put(false, "Unfollowed");
        Toast.makeText(getApplicationContext(), stat.get(user.isFollow()), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Main Activity - onCreate");

        name = findViewById(R.id.nameView);
        description = findViewById(R.id.descriptionView);
        follow = findViewById(R.id.followBtn);
        Intent receivedData = getIntent();
        user = new User(receivedData.getStringExtra("username"),  receivedData.getStringExtra("description"), receivedData.getIntExtra("id", 0), receivedData.getBooleanExtra("follow", false));

        name.setText(user.getName());
        description.setText(user.getDescription());
        followStat();

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFollow(!user.isFollow());
                followStat();
                showToastMsg();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "Main Activity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Main Activity - onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Main Activity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Main Activity - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Main Activity - onDestroy");
    }
}