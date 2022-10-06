import java.util.ArrayList;

// TODO: Allow you to rescue new birds and bring them into your conservatory
// TODO: 要不要把array长度加进去
// do we need to set different food quantities for each bird?
public class Aviaries implements Aviary{
    private ArrayList<Bird> birdArrayList;
    private AVIARYTYPE aviaryType;
    private LOCATION myLocation;

    public Aviaries(AVIARYTYPE aviaryType) {
        this.aviaryType = aviaryType;
    }

    public Aviaries(LOCATION myLocation) {
        this.myLocation = myLocation;
        this.birdArrayList = new ArrayList<>();
    }

    public Aviaries() {
        this.birdArrayList = new ArrayList<>();
    }
    /**
    public ArrayList<Bird> getBirdArrayList() {
        return birdArrayList;
    }

    public void setBirdArrayList(ArrayList<Bird> birdArrayList) {
        this.birdArrayList = birdArrayList;
    }
     **/

    @Override
    public AVIARYTYPE getAviaryType() {
        return aviaryType;
    }

    @Override
    public void setAviaryType(AVIARYTYPE aviaryType) {
        this.aviaryType = aviaryType;
    }

    @Override
    public LOCATION getLocation() {
        return this.myLocation;
    }


    // 在初始化的时候决定这个aviary的type还是取决于第一只鸟
   @Override
    public void putNewBird(Bird newBird){
       birdArrayList.add(newBird);
   }

    @Override
    public int getSize() {
        return this.birdArrayList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aviary: ").append(this.getLocation()).append("\n");
        for(Bird bird: this.birdArrayList){
            sb.append(bird).append("\n");
        }
        return sb.toString();
    }
}
