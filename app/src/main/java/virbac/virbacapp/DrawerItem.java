package virbac.virbacapp;


public class DrawerItem {
    private String name;
    private int iconId;
    private String count = "0";

    private boolean isCounterVisible = false;

    public DrawerItem(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public DrawerItem(String title, int icon, boolean isCounterVisible, String count){
        this.name = title;
        this.iconId = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle(){
        return this.name;
    }

    public int getIcon(){
        return this.iconId;
    }

    public String getCount(){
        return this.count;
    }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.name = title;
    }

    public void setIcon(int icon){
        this.iconId = icon;
    }

    public void setCount(String count){
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
}
