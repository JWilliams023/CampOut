package com.projects.campout.J.model.api.entity;

import java.util.List;

public class MenuWrapper {

  private Provider provider;

  private MenuEntries menus;


  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public MenuEntries getMenus() {
    return menus;
  }

  public void setMenus(MenuEntries menus) {
    this.menus = menus;
  }

  public static class MenuEntries{

    private List<Menu> items;


    public List<Menu> getItems() {
      return items;
    }

    public void setItems(List<Menu> items) {
      this.items = items;
    }
  }
}
