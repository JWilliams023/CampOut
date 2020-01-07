package com.projects.campout.J.model.api.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import com.projects.campout.J.model.api.entity.Item;
import com.projects.campout.J.model.api.entity.Section;
import com.projects.campout.J.model.api.pojo.SectionWithItems;
import java.util.Collection;
import java.util.List;

@Dao
public interface SectionDao{

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Section section);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long [] insert(Section... sections);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Collection<Section> sections);

  @Delete
  int  delete(Section... sections);

  @Delete
  int delete(Collection<Section> sections);

  @Query("SELECT * FROM Section ORDER BY name")
  LiveData<List<Section>> all();

  @Transaction
  @Query("SELECT * FROM Section ORDER BY name")
  LiveData<List<SectionWithItems>> allExpanded();

  @Query("SELECT * FROM Section WHERE section_id = :sectionId")
  LiveData<Section> single(long sectionId);

}