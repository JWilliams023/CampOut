package com.projects.campout.J.model.api.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(
    indices = @Index(value = "item_key",unique = true),
    foreignKeys = @ForeignKey(entity = Section.class,parentColumns = "section_id",childColumns = "section_id",onDelete = ForeignKey.CASCADE)
)
public class Item {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "item_id")
  private long id;

   @SerializedName("sectionId")
  @ColumnInfo(name = "section_id",index = true)
  private long sectionId;


  @SerializedName("itemKey")
  @ColumnInfo(name = "item_key")
  private String itemKey;


  @SerializedName("name")
  @ColumnInfo(index = true)
  private String name;

  @SerializedName("description")
  private String description;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSectionId() {
    return sectionId;
  }

  public void setSectionId(long sectionId) {
    this.sectionId = sectionId;
  }

  public String getItemKey() {
    return itemKey;
  }

  public void setItemKey(String itemKey) {
    this.itemKey = itemKey;
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

  @Override
  public String toString() {
    return name;
  }
}
