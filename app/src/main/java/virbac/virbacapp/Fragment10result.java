package virbac.virbacapp;

/**
 * Created by omar on 27/09/15.
 */

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by omar on 27/09/15.
 */

public class Fragment10result extends Fragment {    // this Fragment will be called from MainActivity
    private RadarChart mChart;
    private Typeface tf;
    public Fragment10result(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        mChart = (RadarChart) rootView.findViewById(R.id.chart);

        tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        mChart.setDescription("");
        mChart.setWebLineWidth(1.5f);
        mChart.setWebLineWidthInner(0.75f);
        mChart.setWebAlpha(100);
// create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);

        // set the marker to the chart
        mChart.setMarkerView(mv);

        setData();

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(tf);
        xAxis.setTextSize(14f);

        YAxis yAxis = mChart.getYAxis();
        yAxis.setTypeface(tf);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setStartAtZero(true);

        Legend l = mChart.getLegend();
        l.setTextSize(12f);
        l.setFormToTextSpace(19F);
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setTypeface(tf);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        return rootView;
    }
/*
    private String[] mParties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I"
    };*/


    public void setData() {

        float mult = 150;
        int cnt = 9;

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
     /*   for (int i = 0; i < cnt; i++) {
            yVals1.add(new Entry((float) (Math.random() * mult) + mult / 2, i));
        }*/


        Entry house, pen, sow, nutrution, husbandry, managemnet, health, piglet, COLOSTRUM_INTAKE;

        house = new Entry((float) Main.results[0], 0);

        pen = new Entry((float) Main.results[1], 1);
        sow = new Entry((float) Main.results[2], 2);


        nutrution = new Entry((float) Main.results[3], 3);
        husbandry = new Entry((float) Main.results[4], 4);

        managemnet = new Entry((float) Main.results[5], 5);
        health = new Entry((float) Main.results[6], 6);
        piglet = new Entry((float) Main.results[7], 7);


        COLOSTRUM_INTAKE = new Entry((float) Main.results[8], 8);

        yVals1.add(house);

        yVals1.add(husbandry);

        yVals1.add(piglet);

        yVals1.add(managemnet);
        yVals1.add(pen);
        yVals1.add(health);
        yVals1.add(sow);
        yVals1.add(nutrution);

        yVals1.add(COLOSTRUM_INTAKE);

        /*for (int i = 0; i < cnt; i++) {
            yVals2.add(new Entry((float) (Math.random() * mult) + mult / 2, i));
        }*/

        ArrayList<String> xVals = new ArrayList<String>();

/*        for (int i = 0; i < cnt; i++)
            xVals.add(mParties[i % mParties.length]);*/

        xVals = new ArrayList<String>();

        xVals.add("house");

        xVals.add("husbandry");

        xVals.add("piglet");

        xVals.add("managemnet");
        xVals.add("pen");

        xVals.add("health");
        xVals.add("sow");
        xVals.add("nutrition");
        xVals.add("colostrum intake");

        RadarDataSet set1 = new RadarDataSet(yVals1, "Sondage");
        set1.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        set1.setDrawFilled(true);
        set1.setLineWidth(2f);

/*        RadarDataSet set2 = new RadarDataSet(yVals2, "Set 2");
        set2.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
        set2.setDrawFilled(true);
        set2.setLineWidth(2f);*/

        ArrayList<RadarDataSet> sets = new ArrayList<RadarDataSet>();
        sets.add(set1);
/*        sets.add(set2);*/

        RadarData data = new RadarData(xVals, sets);
        data.setValueTypeface(tf);
        data.setValueTextSize(8f);
        data.setDrawValues(false);

        mChart.setData(data);

        mChart.invalidate();
    }



    /*


        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.

        Entry house, pen,sow,nutrution, husbandry,  managemnet,health,piglet,COLOSTRUM_INTAKE;

        house  = new Entry((float) 6.00f, 0);

        husbandry  = new Entry((float) 0.00f, 1);

        piglet  = new Entry((float) 7.00f, 2);
        managemnet  = new Entry((float) 0.00f, 3);

        pen  = new Entry((float) 4.00f, 4);
        health  = new Entry((float) 5.00f, 5);

        sow  = new Entry((float) 3.00f, 6);

        nutrution  = new Entry((float) 1.00f, 7);
        COLOSTRUM_INTAKE = new Entry((float) 2.00f, 8);

        yVals1.add(house);

        yVals1.add(husbandry);

        yVals1.add(piglet);

        yVals1.add(managemnet);
        yVals1.add(pen);
        yVals1.add(health);
        yVals1.add(sow);
        yVals1.add(nutrution);

        yVals1.add(COLOSTRUM_INTAKE);

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("house");

        xVals.add("husbandry");

        xVals.add("piglet");

        xVals.add("managemnet");
        xVals.add("pen");

        xVals.add("health");
        xVals.add("sow");
        xVals.add("nutrition");
        xVals.add("colostrum intake");
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.radar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionToggleValues: {
                for (DataSet<?> set : mChart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleHighlight: {
                if (mChart.isHighlightEnabled())
                    mChart.setHighlightEnabled(false);
                else
                    mChart.setHighlightEnabled(true);
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleRotate: {
                if (mChart.isRotationEnabled())
                    mChart.setRotationEnabled(false);
                else
                    mChart.setRotationEnabled(true);
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleFilled: {

                ArrayList<RadarDataSet> sets = (ArrayList<RadarDataSet>) mChart.getData()
                        .getDataSets();

                for (RadarDataSet set : sets) {
                    if (set.isDrawFilledEnabled())
                        set.setDrawFilled(false);
                    else
                        set.setDrawFilled(true);
                }
                mChart.invalidate();
                break;
            }
            case R.id.actionSave: {
                if (mChart.saveToPath("title" + System.currentTimeMillis(), "")) {
                    Toast.makeText(getActivity(), "Saving SUCCESSFUL!",
                            Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "Saving FAILED!", Toast.LENGTH_SHORT)
                            .show();
                break;
            }
            case R.id.actionToggleXLabels: {
                mChart.getXAxis().setEnabled(!mChart.getXAxis().isEnabled());
                mChart.notifyDataSetChanged();
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleYLabels: {

                mChart.getYAxis().setEnabled(!mChart.getYAxis().isEnabled());
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleSpin: {
                mChart.spin(2000, mChart.getRotationAngle(), mChart.getRotationAngle() + 360, Easing.EasingOption.EaseInCubic);
                break;
            }
        }
        return true;
    }

}
