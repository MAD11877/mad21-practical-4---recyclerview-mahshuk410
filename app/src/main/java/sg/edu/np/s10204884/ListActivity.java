package sg.edu.np.s10204884;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // Codeblock for android icon ImageView in practical 3
//        ImageView icon = findViewById(R.id.androidImg);
//        icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               Intent in = new Intent(ListActivity.this,MainActivity.class);
//               startActivity(in);
//               Intent openDialog = getIntent();
//            }
//        });
        ArrayList<User> userList = new ArrayList<User>();
        for (int i = 0;i < 20;i++){
            Random rand = new Random();
            int num = 1000000001 + rand.nextInt(1000000000);
            User u = new User();
            u.setName("Name"+num);

            Random rand2 = new Random();
            int descNum = 1000000001 + rand2.nextInt(1000000000);
            u.setDescription("Description"+ descNum);
            u.setFollowed(false);
            userList.add(u);


        }
        RecyclerView rv = findViewById(R.id.rv);
        UsersAdapter adapter = new UsersAdapter(this,userList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

    }
}