package Builders;

public interface CardBuilder {
    public void reset();
    public void setName(String name);
    public void setNationality(String nationality);
    public void setFeatures(int[] features);
}
