package misao.edu.hinduquiz;

/**
 * Created by masashihamano on 2018/02/24.
 */

public class StateModel {

    String name;
    int image;

    public StateModel(String name, int image){
        this.name = name;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }
}
