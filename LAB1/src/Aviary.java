public interface Aviary {
    // 在初始化的时候决定这个aviary的type还是取决于第一只鸟
    void putNewBird(Bird newBird);
    int getSize();
    AVIARYTYPE getAviaryType();//
    void setAviaryType(AVIARYTYPE type);
    LOCATION getLocation();


}
