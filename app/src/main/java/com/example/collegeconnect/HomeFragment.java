package com.example.collegeconnect;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class HomeFragment extends AppCompatActivity {
//    RecyclerView recyclerView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home);
//
//    recyclerView = findViewById(R.id.recyclerview);
//    recyclerView.setHasFixedSize(true);
//    recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//    HomeData[] homeData = new HomeData[]{
//      new HomeData("Sample1","description1",R.drawable.img1),
//      new HomeData("Sample2","description2",R.drawable.img1)    };
//
//    DataAdapter dataAdapter = new DataAdapter(homeData,HomeFragment.this);
//    recyclerView.setAdapter(dataAdapter);
//    }
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
////    public HomeFragment() {
////        // Required empty public constructor
////    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
////    public static HomeFragment newInstance(String param1, String param2) {
////        HomeFragment fragment = new HomeFragment();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
////        fragment.setArguments(args);
////        return fragment;
////    }
//
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
////    }
////
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_home, container, false);
////    }
//}

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();



        recyclerView.setAdapter(new DataAdapter(initData(), getContext()));



        return view;
    }

    private HomeData[] initData() {
        HomeData[] homeData = new HomeData[]{
                new HomeData("Innovators hub recruitment","Mech and ECE recruitments",R.drawable.ih),
                new HomeData("Cosmos Recruitment","Only for first year",R.drawable.cosmos) ,
                new HomeData("Numerates Recruitment","For second an third year",R.drawable.numerates),
                new HomeData("HackX seminar","Seminar on ethical hacking",R.drawable.hackx),
                new HomeData("Innovators Hub","Webinar on Git/Github",R.drawable.ih)
        };
        return homeData;
    }


}