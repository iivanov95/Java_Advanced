package Lecture6_DefiningClassesExercise.CatLady;

public class Extraordinaire extends Cat {
    private double decibelsOfMews;

    public Extraordinaire(String name, String type, double decibelsOfMews) {
        super(name, type);
        this.decibelsOfMews = decibelsOfMews;
    }
    @Override
    public String toString (){
        return String.format("%s %.2f", super.toString(), this.decibelsOfMews);
    }
}
