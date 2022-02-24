package com.skf.labs.xxe;


public class Item {
    private String item;

    public Item(String item) {
        this.item = item;
    }

  public String getItem(){
      return item;
  }
  public void setItem(String item){
    this.item =  item;
    } 

    @Override
    public String toString(){
        return "Item::["+this.item+"]";
    }
}   


//<items><item name="item1"> item1 </item><item name="item2"> item2 </item><item name="item3"> item3 </item><item name="item4"> item4 </item></items>