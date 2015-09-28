package virbac.virbacapp;

/**
 * Created by omar on 27/09/15.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by omar on 27/09/15.
 */

public class Fragment4Manag extends Fragment {
    // this Fragment will be called from MainActivity
    public Fragment4Manag(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_manag, container, false);

        return rootView;
    }
}
