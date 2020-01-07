package com.projects.campout.J.model.api.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.projects.campout.J.model.api.entity.Menu;
import com.projects.campout.J.model.api.entity.Section;
import java.util.Collection;
import java.util.List;

@Dao
public interface MenuDao{
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Menu menu);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long [] insert(Menu... menus);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Collection<Menu> menus);

  @Delete
  int  delete(Menu... menus);

  @Delete
  int delete(Collection<Menu> menus);

  @Query("SELECT * FROM Menu ORDER BY name")
  LiveData<List<Menu>> all();

  @Query("SELECT * FROM Menu WHERE menu_id = :menuId")
  LiveData<Menu> single(long menuId);

}