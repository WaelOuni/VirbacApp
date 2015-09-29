package virbac.virbacapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;

/**
 * Created by omar on 27/09/15.
 */

public class Fragment2Husbandry extends Fragment {
    ButtonFloat suivMaterialBtn;

    // this Fragment will be called from MainActivity
    public Fragment2Husbandry(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_husbandry, container, false);


        suivMaterialBtn = (ButtonFloat) rootView.findViewById(R.id.suivHusbandry);
        suivMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pass to next Piglet category ...", Toast.LENGTH_LONG).show();
                Fragment fragment = null;

                fragment = new Fragment3Piglet();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                Main.drawerList.setItemChecked(2, true);
                Main.drawerList.setSelection(2);
                getActivity().setTitle(Main.tagTitles[2]);
                Main.drawerLayout.closeDrawer(Main.drawerList);
            }
        });

        return rootView;
    }
}