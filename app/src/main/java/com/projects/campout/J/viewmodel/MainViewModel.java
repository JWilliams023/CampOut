package com.projects.campout.J.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.projects.campout.J.CampOutDatabase;
import com.projects.campout.J.BuildConfig;
import com.projects.campout.J.model.api.entity.Item;
import com.projects.campout.J.model.api.entity.Menu;
import com.projects.campout.J.model.api.entity.Section;
import com.projects.campout.J.model.api.pojo.SectionWithItems;
import com.projects.campout.J.service.CampOutService;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

  private static final String VENUE = "4ab530c2f964a5201f7320e3";
  private CampOutDatabase database;


  public MainViewModel(@NonNull Application application) {
    super(application);
    database = CampOutDatabase.getInstance();
  }

  public LiveData<List<SectionWithItems>> getSections() {
    return database.getSectionDao().allExpanded();
  }

  public void refresh() {

    CampOutService.getInstance()
        .getMenu(VENUE, BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, "20191115", "40.5,-80")
        .subscribeOn(Schedulers.io())
        .subscribe((wrapper) -> {
              database.runInTransaction(() -> {
                for (Menu menu : wrapper.getMenus()) {
                  long menuId = database.getMenuDao().insert(menu);
                  for (Section section : menu.getSections()) {
                    Log.d(getClass().getSimpleName(), section.getName());
                    section.setMenuId(menuId);
                    long sectionId = database.getSectionDao().insert(section);
                    for (Item item : section.getItems()) {
                      item.setSectionId(sectionId);
                      database.getItemDao().insert(item);
                    }
                  }
                }
              });
            },
            (ex) -> {
              Log.e(ex.getClass().getSimpleName(),ex.getMessage(),ex);
            });
  }
}
