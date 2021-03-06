package data;

import java.util.ArrayList;


public class DataListSingleton {
    private static DataListSingleton mInstance;
    private ArrayList<Integer> mList;

    private DataListSingleton() {
        mList = new ArrayList<Integer>();
    }

    public static synchronized DataListSingleton getInstance() {
        if (mInstance == null)
            mInstance = new DataListSingleton();
        return mInstance;
    }

    public void add(int position, int result) {
        mList.add(position, result);
    }

    public void getList(ArrayList<Integer> list) {
        if (list != null) {
            list.clear();
            for (Integer wrapper : mList) {
                list.add(wrapper);
            }
        }
    }

    public void remove(int position) {
        mList.remove(position);
    }

    public Integer getItem(int position) {
        return mList.get(position);
    }

    public void clearList() {
        mList.clear();
    }

    public int getPositionItem(long id) {
        int i = 0;
        int res = -1;
        boolean exist = false;
        while ((i < mList.size()) && (!exist)) {
            Long a = new Long(mList.get(i));
            Long b = new Long(id);

            if (a.equals(b)) {
                exist = true;
                res = i;

            }
            i++;
        }
        return res;
    }

    public void editWithoutGettingPosition(int position, Integer in) {
        mList.set(position, in);

    }

    public int getSizeList() {
        return mList.size();
    }
}

