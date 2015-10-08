package virbac.virbacapp;

/**
 * Created by omar on 27/09/15.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;
import com.gc.materialdesign.views.Switch;

import data.DataListSingleton;

/**
 * Created by omar on 27/09/15.
 */

public class Fragment7Sow extends Fragment {
    ButtonFloat suivMaterialBtn;
    ButtonFloat precedMaterialBtn;
    Switch s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    int sv1 = 1, sv2 = 1, sv3 = 1, sv4 = 1, sv5 = 1, sv6 = 1, sv7 = 1, sv8 = 1, sv9 = 1, sv10 = 1, result = 0, per = 0;


    DataListSingleton data = DataListSingleton.getInstance();
    // this Fragment will be called from MainActivity
    public Fragment7Sow(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sow, container, false);

        s1 = (Switch) rootView.findViewById(R.id.switcher);
        s2 = (Switch) rootView.findViewById(R.id.switcher2);
        s3 = (Switch) rootView.findViewById(R.id.switcher3);
        s4 = (Switch) rootView.findViewById(R.id.switcher4);
        s5 = (Switch) rootView.findViewById(R.id.switcher5);
        s6 = (Switch) rootView.findViewById(R.id.switcher6);
        s7 = (Switch) rootView.findViewById(R.id.switcher7);
        s8 = (Switch) rootView.findViewById(R.id.switcher8);
        s9 = (Switch) rootView.findViewById(R.id.switcher9);
        s10 = (Switch) rootView.findViewById(R.id.switcher10);

        s1.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s1.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv1 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv1 = 1;
                }
            }
        });


        s2.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s2.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv2 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv2 = 1;
                }
            }
        });
        s3.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s3.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv3 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv3 = 1;
                }
            }
        });
        s4.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s4.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv4 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv4 = 1;
                }
            }
        });
        s5.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s5.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv5 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv5 = 1;
                }
            }
        });
        s6.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s6.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv6 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv6 = 1;
                }
            }
        });
        s7.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s7.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv7 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv7 = 1;
                }
            }
        });
        s8.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s8.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv8 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv8 = 1;
                }
            }
        });
        s9.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s9.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv9 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv9 = 1;
                }
            }
        });
        s10.setOncheckListener(new com.gc.materialdesign.views.Switch.OnCheckListener() {
            @Override
            public void onCheck(com.gc.materialdesign.views.Switch aSwitch, boolean b) {
                if (s10.isCheck()) {
                    Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
                    sv10 = 0;

                } else {
                    Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                    sv10 = 1;
                }
            }
        });

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
                result = sv1 + sv2 + sv3 + sv4 + sv5 + sv6 + sv7 + sv8 + sv9 + sv10;
                data.add(2, result);
                Log.i("results", "" + data.getItem(2));


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

                getActivity().setTitle(Main.tagTitles[4]);
                /*Main.drawerList.setItemChecked(1, true);
                Main.drawerList.setSelection(1);
                Main.drawerLayout.closeDrawer(Main.drawerList);*/
            }
        });
        return rootView;
    }
}
