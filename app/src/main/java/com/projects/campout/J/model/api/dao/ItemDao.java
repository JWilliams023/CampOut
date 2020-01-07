package com.projects.campout.J.model.api.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.projects.campout.J.model.api.entity.Item;
import com.projects.campout.J.model.api.entity.Section;
import java.util.Collection;
import java.util.List;

@Dao
public interface ItemDao{

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Item item);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long [] insert(Item... items);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Collection<Item> items);

  @Delete
  int  delete(Item... items);

  @Delete
  int delete(Collection<Item> items);

  @Query("SELECT * FROM Item ORDER BY name")
  LiveData<List<Item>> all();

  @Query("SELECT * FROM Item WHERE section_id = :sectionId ORDER BY name")
  LiveData<List<Item>> allInSection(long sectionId);

  @Query("SELECT * FROM Item WHERE item_id = :itemId")
  LiveData<Item> single(long itemId);

}