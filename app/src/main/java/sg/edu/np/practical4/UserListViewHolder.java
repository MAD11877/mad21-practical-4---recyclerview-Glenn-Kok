package sg.edu.np.practical4;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserListViewHolder extends RecyclerView.ViewHolder {
    TextView username;
    TextView description;

    public UserListViewHolder(View itemView){
        super(itemView);
        username = itemView.findViewById(R.id.users_name);
        description = itemView.findViewById(R.id.users_des);

    }

}
