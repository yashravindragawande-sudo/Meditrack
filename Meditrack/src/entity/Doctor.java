package entity;

import enums.Specialization;

public class Doctor extends Person {

    private Specialization specialization;
    private double consultationFee;

    public Doctor(int id, String name, int age,
                  Specialization specialization, double fee) {

        super(id, name, age);
        this.specialization = specialization;
        this.consultationFee = fee;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor: " + name +
                " Specialization: " + specialization +
                " Fee: " + consultationFee);
    }
}
