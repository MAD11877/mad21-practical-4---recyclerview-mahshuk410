package sg.edu.np.s10204884;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {
    Context context;
    ArrayList<User>userList;
    public UsersAdapter(Context c, ArrayList<User>data){
        context = c;
        userList = data;

    }
    @Override
    public UserViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 0){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user_7,parent,false);

        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user,parent,false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder( UserViewHolder holder, int position) {
        User u = userList.get(position);
        holder.Name.setText(u.getName());
        holder.Description.setText(u.getDescription());
        holder.AndroidImg.setOnClickListener(v -> createDialog(context,u));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
    public int getItemViewType(int position){
        if(userList.get(position).getName().endsWith("7")){
            System.out.println("Hello");
            return 0;
        }
        return 1;
    }
    public void createDialog(Context c,User u){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Profile");
        builder.setMessage(u.getName());
        builder.setCancelable(true);
        builder.setPositiveButton("View",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){

                Intent i = new Intent(context,MainActivity.class);
                i.putExtra("UserName",u.getName());
                i.putExtra("UserDesc",u.getDescription());
                context.startActivity(i);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
