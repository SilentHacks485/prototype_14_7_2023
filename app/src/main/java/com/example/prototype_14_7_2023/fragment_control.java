package com.example.prototype_14_7_2023;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_control#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_control extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_control() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_control.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_control newInstance(String param1, String param2) {
        fragment_control fragment = new fragment_control();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){



        String url = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_native_4k;

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_control, container, false);

        VideoView simple_video = v.findViewById(R.id.videoView);

        Uri path = Uri.parse(url);

        simple_video.setVideoURI(path);


        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(simple_video);
        mediaController.setMediaPlayer(simple_video);

        simple_video.setMediaController(mediaController);

        simple_video.start();

        return v;



    }
}