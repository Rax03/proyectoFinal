package org.example.View;

public enum Scenes {
    ROOT("view/layout.fxml"),
    MAIN("view/main.fxml");


    private String url;
    Scenes(String url){
        this.url=url;
    }
    public String getURL(){
        return url;
    }

}
