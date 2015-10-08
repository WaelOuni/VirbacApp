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
        //   thread.start();
    }

/*
    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    removeAccount(account);
//                    notifyAccountDataChanged();
//                    removeSection(target);
                    setSection(target);
                }
            });
        }
    });*/

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

/*


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemTitle = activityTitle = getTitle();

        tagTitles = getResources().getStringArray(R.array.Tags);
        /*
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        // Setear una sombra sobre el contenido principal cuando el drawer se despliegue
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);*/

//Crear elementos de la lista
        /*
        ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();
        items.add(new DrawerItem(tagTitles[0], R.drawable.house));
        items.add(new DrawerItem(tagTitles[1], R.drawable.husbandry2));
        items.add(new DrawerItem(tagTitles[2], R.drawable.piglet));
        items.add(new DrawerItem(tagTitles[3], R.drawable.management));
        items.add(new DrawerItem(tagTitles[4], R.drawable.pen));
        items.add(new DrawerItem(tagTitles[5], R.drawable.health));
        items.add(new DrawerItem(tagTitles[6], R.drawable.sow));
        items.add(new DrawerItem(tagTitles[7], R.drawable.nutrition));
        items.add(new DrawerItem(tagTitles[8], R.drawable.imag));
        items.add(new DrawerItem(tagTitles[9], R.drawable.sondage));



        // Relacionar el adaptador y la escucha de la lista del drawer
        drawerList.setAdapter(new DrawerListAdapter(this, items));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Habilitar el icono de la app por si hay algún estilo que lo deshabilitó
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Crear ActionBarDrawerToggle para la apertura y cierre
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(itemTitle);

                *//*Usa este método si vas a modificar la action bar
                con cada fragmento
                 *//*
                //invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(activityTitle);

                *//*Usa este método si vas a modificar la action bar
                con cada fragmento
                 *//*
                //invalidateOptionsMenu();
            }
        };


        //Seteamos la escucha
        drawerLayout.setDrawerListener(drawerToggle);


if (savedInstanceState == null) {
        selectItem(0);
        }
        }



private void selectItem(int position) {
        Fragment fragment = new Fragment1House();

        //Fragment fragment = new Fragment10result();
        /*switch (position) {
            case 0:
                fragment = new Fragment1House();
                break;
            case 1:
                fragment = new Fragment2Husbandry();
                break;
            case 2:
                fragment = new Fragment3Piglet();
                break;
            case 3:
                fragment = new Fragment4Manag();
                break;
            case 4:
                fragment = new Fragment5Pen();
                break;
            case 5:
                fragment = new Fragment6Heal();
                break;
            case 6:
                fragment = new Fragment7Sow();
                break;
            case 7:
                fragment = new Fragment8Nut();
                break;
            case 8:
                fragment = new Fragment9Colo();
                break;
            case 9:
                fragment = new Fragment10result();
                break;


            default:
                break;
        }

        if (fragment != null) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        setTitle(tagTitles[0]);
        /*    drawerList.setItemChecked(position, true);
            drawerList.setSelection(position);
            setTitle(tagTitles[position]);
            drawerLayout.closeDrawer(drawerList);
        */
        /*
        } else {

        Log.e("this is mainActivity", "Error in else case");
        }

        }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sincronizar el estado del drawer
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cambiar las configuraciones del drawer si hubo modificaciones
        drawerToggle.onConfigurationChanged(newConfig);
    }

    *//* La escucha del ListView en el Drawer *//*
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }*/

