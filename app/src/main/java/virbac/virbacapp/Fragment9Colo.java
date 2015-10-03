package virbac.virbacapp;

/**
 * Created by omar on 27/09/15.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;
import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by omar on 27/09/15.
 */

public class Fragment9Colo extends Fragment {
    ButtonFloat precedMaterialBtn;
    ButtonRectangle showStats;

    // this Fragment will be called from MainActivity
    public Fragment9Colo(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_colo, container, false);
        precedMaterialBtn = (ButtonFloat) rootView.findViewById(R.id.precedColo);
        precedMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "return to Piglet category ...", Toast.LENGTH_LONG).show();
                Fragment fragment = null;

                fragment = new Fragment3Piglet();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

                getActivity().setTitle(Main.tagTitles[2]);
                /*Main.drawerList.setItemChecked(1, true);
                Main.drawerList.setSelection(1);
                Main.drawerLayout.closeDrawer(Main.drawerList);*/
            }
        });

        showStats = (ButtonRectangle) rootView.findViewById(R.id.showStats);
        showStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Show statistics of your choices ...", Toast.LENGTH_LONG).show();
                Fragment fragment = null;

                fragment = new Fragment10result();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

                getActivity().setTitle(Main.tagTitles[9]);
                /*Main.drawerList.setItemChecked(1, true);
                Main.drawerList.setSelection(1);
                Main.drawerLayout.closeDrawer(Main.drawerList);*/
            }
        });
        return rootView;
    }
}
