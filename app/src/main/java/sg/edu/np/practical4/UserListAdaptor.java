package sg.edu.np.practical4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static sg.edu.np.practical4.ListActivity.profileView;

public class UserListAdaptor extends RecyclerView.Adapter<UserListViewHolder> {
    ArrayList<User> data = new ArrayList<>();
    private static Context mContext;

    public UserListAdaptor(ArrayList<User> input){
        data = input;
    }

    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item;
        User currentUser = data.get(viewType);
        if ((currentUser.getName()).charAt(currentUser.getName().length()-1) == '7'){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_layout2, parent, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_layout, parent, false);
        }
        item.findViewById(R.id.users_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileView(currentUser);
            }
        });
        return new UserListViewHolder(item);
    }

    public void onBindViewHolder(UserListViewHolder holder, int position){
        User user = data.get(position);
        holder.username.setText(user.getName());
        holder.description.setText(user.getDescription());
    }

    public int getItemCount(){
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}
