package com.projects.campout.J.model.api.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity(
    indices = @Index(value = "section_key",unique = true),
    foreignKeys = @ForeignKey(entity = Menu.class,parentColumns = "menu_id",childColumns = "menu_id",onDelete = ForeignKey.CASCADE)
)
public class Section {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "section_id")
  private long id;

  @ColumnInfo(name = "menu_id",index = true)
  private long menuId;


  @ColumnInfo(name = "section_key")
  private String sectionKey;

  @ColumnInfo(index = true)
  private String name;

  @Ignore
  private SectionEntries entries;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }

  public String getSectionKey() {
    return sectionKey;
  }

  public void setSectionKey(String sectionKey) {
    this.sectionKey = sectionKey;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SectionEntries getEntries() {
    return entries;
  }

  public void setEntries(SectionEntries entries) {
    this.entries = entries;
  }



  public List<Item> getItems(){
    return entries.getItems();

  }

  @Override
  public String toString() {
    return name;
  }

  public static class SectionEntries{
    private List<Item> items;

    public List<Item> getItems() {
      return items;
    }

    public void setItems(List<Item> items) {
      this.items = items;
    }


  }

}
