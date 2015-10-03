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

/**
 * Created by omar on 27/09/15.
 */

public class Fragment7Sow extends Fragment {
    ButtonFloat suivMaterialBtn;
    ButtonFloat precedMaterialBtn;

    // this Fragment will be called from MainActivity
    public Fragment7Sow(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sow, container, false);

        suivMaterialBtn = (ButtonFloat) rootView.findViewById(R.id.suivSow);
        suivMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pass to next Nutrition category ...", Toast.LENGTH_LONG).show();
                Fragment fragment = null;

                fragment = new Fragment8Nut();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

                getActivity().setTitle(Main.tagTitles[7]);
                /*Main.drawerList.setItemChecked(1, true);
                Main.drawerList.setSelection(1);
                Main.drawerLayout.closeDrawer(Main.drawerList);*/
            }
        });

        precedMaterialBtn = (ButtonFloat) rootView.findViewById(R.id.precedSow);
        precedMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "return to Pen category ...", Toast.LENGTH_LONG).show();
                Fragment fragment = null;

                fragment = new Fragment5Pen();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

                getActivity().setTitle(Main.tagTitles[5]);
                /*Main.drawerList.setItemChecked(1, true);
                Main.drawerList.setSelection(1);
                Main.drawerLayout.closeDrawer(Main.drawerList);*/
            }
        });
        return rootView;
    }
}
