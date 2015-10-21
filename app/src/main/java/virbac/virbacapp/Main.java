package virbac.virbacapp;

/**
 * Created by omar on 27/09/15.
 */

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialSectionListener;


public class Main extends MaterialNavigationDrawer {


    //  static int[] persontage  = new int[8];
    public static String[] tagTitles;
    static int[] results = new int[9];
    MaterialAccount account;
    Bundle b;

    String nom, email, pasword, id;
    MaterialSection section1;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    /* Método auxiliar para setear el titulo de la action bar */
    @Override
    public void setTitle(CharSequence title) {
        itemTitle = title;
        getSupportActionBar().setTitle(itemTitle);
    }


    @Override
    public void init(Bundle bundle) {

        itemTitle = activityTitle = getTitle();
        b = getIntent().getExtras();
        id = b.getString("id");
        nom = b.getString("name");
        email = b.getString("email");
        pasword = b.getString("password");
        Log.i("id", id);
        Log.i("nom", nom);
        Log.i("password", pasword);
        tagTitles = getResources().getStringArray(R.array.Tags);
        setTitle(tagTitles[0]);
        this.disableLearningPattern();
        setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
        account = new MaterialAccount(this.getResources(), nom, email, R.drawable.image, null);


        //enableToolbarElevation();
        this.addAccount(account);
        this.addSubheader("Sections :");

        section1 = newSection("Sondage", new Fragment1House());
        section1.setBackgroundColor(Color.BLACK);

        addSection(section1);
        section1.setSectionColor(Color.GRAY, 15);

        MaterialSection help = newSection("About us ", new About());

        addBottomSection(help);
        help.setSectionColor(Color.GRAY, 15);

        this.setAccountListener(new MaterialAccountListener() {
            @Override
            public void onAccountOpening(MaterialAccount materialAccount) {
                Fragment fragment = new Fragmentubdate();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                setTitle(tagTitles[10]);
            }

            @Override
            public void onChangeAccount(MaterialAccount materialAccount) {

            }
        });

        section1.setOnClickListener(new MaterialSectionListener() {
            @Override
            public void onClick(MaterialSection materialSection) {
                Fragment fragment = new Fragment1House();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                setTitle(tagTitles[0]);
            }
        });
        enableToolbarElevation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.deconnexion) {

            startActivity(new Intent(this, LoginActivity.class));
            finish();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

