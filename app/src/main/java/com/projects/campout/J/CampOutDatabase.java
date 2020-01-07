package com.projects.campout.J;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.projects.campout.J.model.api.dao.ItemDao;
import com.projects.campout.J.model.api.dao.MenuDao;
import com.projects.campout.J.model.api.dao.SectionDao;
import com.projects.campout.J.model.api.entity.Item;
import com.projects.campout.J.model.api.entity.Menu;
import com.projects.campout.J.model.api.entity.Section;

@Database(entities = {Item.class, Section.class, Menu.class},version = 1, exportSchema = false)


public abstract class CampOutDatabase extends RoomDatabase {

  protected CampOutDatabase() {
  }


  private static Application applicationContext;


  public static void setApplicationContext(Application applicationContext) {
    CampOutDatabase.applicationContext = applicationContext;
  }

  public static CampOutDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract ItemDao getItemDao();

  public abstract MenuDao getMenuDao();

  public abstract SectionDao getSectionDao();







  private static class InstanceHolder {

    private static final CampOutDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, CampOutDatabase.class, "campout_db").build();
    }

  }
}

