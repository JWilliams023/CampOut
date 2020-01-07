package com.projects.campout.J.model.api.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity()
public class Menu {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "menu_id")
  private long id;
  private String name;
  private String description;

  @Ignore
  private SectionEntries entries;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SectionEntries getEntries() {
    return entries;
  }

  public void setEntries(SectionEntries entries) {
    this.entries = entries;
  }

  public List<Section> getSections() {
    return entries.getItems();
  }


  public static class SectionEntries {

    private List<Section> items;


    public List<Section> getItems() {
      return items;
    }

    public void setItems(List<Section> items) {
      this.items = items;
    }
  }
}
