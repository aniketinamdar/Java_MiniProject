package com.example.collegeconnect;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link SearchFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class SearchFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public SearchFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment SearchFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static SearchFragment newInstance(String param1, String param2) {
//        SearchFragment fragment = new SearchFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_search, container, false);
//    }
//}
public class SearchFragment extends Fragment {
    RecyclerView recyclerView;
//    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search, container, false);
//        searchView = view.findViewById(R.id.SeachView);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                filterList(newText);
//                return false;
//            }
//        });
        recyclerView=view.findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();
        recyclerView.setAdapter(new DataAdapter(initData(), getContext()));
        return view;
    }


    HomeData[] homeData = null;
    public HomeData[] initData() {
        homeData = new HomeData[]{
                new HomeData("Innovators Hub","Technical and non technical",R.drawable.img1),
                new HomeData("Texephyr","Managment",R.drawable.img1) ,
                new HomeData("Cosmos","Space related",R.drawable.img1),
                new HomeData("Numerates","Maths",R.drawable.img1)
        };
        return homeData;
    }
//    private void filterList(String newText) {
//        List<HomeData> filteredList = new ArrayList<>();
//        for (HomeData item : homeData)
//        {
//            if (item.getHeading().toLowerCase(Locale.ROOT).contains(newText.toLowerCase()))
//            {
//                filteredList.add(item);
//            }
//            if (filteredList.isEmpty())
//            {
//                Toast.makeText(getContext().getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
//            }
////            else
////            {
////                DataAdapter.setFilteredList(filteredList);
////            }
//        }
//    }
}
