package teamx.ideahacks.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import teamx.ideahacks.Adapters.PostAdapter;
import teamx.ideahacks.Models.PostModel;
import teamx.ideahacks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    ProgressBar progressBar ;


    RecyclerView recyclerView;

    List<PostModel>postModelList=new ArrayList<>();
    private PostAdapter adapter;

    private CollectionReference reference;
    private Query query1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recypostID);
        progressBar = view.findViewById(R.id.recyprogragbarId);


        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        reference = firestore.collection("Ideas");

        query1 = reference.orderBy("create_at", Query.Direction.DESCENDING);


        progressBar.setVisibility(View.VISIBLE);
        query1.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()){

                    postModelList.clear();
                    for (DocumentSnapshot doc : task.getResult()){
                        PostModel post = doc.toObject(PostModel.class);
                        postModelList.add(post);
                    }
                    adapter = new PostAdapter(getActivity(),postModelList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);


                    progressBar.setVisibility(View.GONE);

                    recyclerView.setAdapter(adapter);


                }

            }
        });






        return view;
    }

}
