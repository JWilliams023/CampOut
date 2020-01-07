package com.projects.campout.J.model.api.entity;

import java.util.List;

public class ResponseWrapper {


  private Response response;

  public Response getResponse() {
    return response;
  }

  public List<Menu> getMenus(){
    return response.getMenu().getMenus().getItems();
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public static class Response{
    private MenuWrapper menu;

    public MenuWrapper getMenu() {
      return menu;
    }

    public void setMenu(MenuWrapper menu) {
      this.menu = menu;
    }
  }

}
