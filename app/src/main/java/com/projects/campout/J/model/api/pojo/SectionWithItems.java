package com.projects.campout.J.model.api.pojo;

import androidx.room.Relation;
import com.projects.campout.J.model.api.entity.Item;
import com.projects.campout.J.model.api.entity.Section;
import java.util.List;

public class SectionWithItems extends Section
{

  @Relation(entity = Item.class,parentColumn = "section_id",entityColumn = "section_id")
  private List<Item> items;

  @Override
  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
