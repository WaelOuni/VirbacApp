package virbac.virbacapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by omar on 27/09/15.
 */
public class Fragment1House extends Fragment {
    // this Fragment will be called from MainActivity
    public Fragment1House(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_house, container, false);

        return rootView;
    }
}