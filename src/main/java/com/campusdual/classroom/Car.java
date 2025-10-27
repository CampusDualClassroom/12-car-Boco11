package com.campusdual.classroom;

import java.util.jar.JarOutputStream;

public class Car {
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120;
    public String fuel;
    public int speedometer;
    public int tachometer;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;

    public Car (String brand, String model, String fuel){
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car(){
        this.brand = "Citroën";
        this.model = "Xsara";
        this.fuel = "Diesel";
    }

    public void start() {
        if (this.tachometer == 0){
            this.tachometer = 1000;
            System.out.println("Vehículo encendido");
        }else{
            System.out.println("Vehículo ya está encendido");
        }
    }

    public void stop() {
        if (this.speedometer == 0){
            this.tachometer = 0;
            System.out.println("Vehículo apagado");
        }else{
            System.out.println("No se puede apagar el vehículo. Primero tiene que estar detenido");
        }
    }
    public void accelerate(){
            if (speedometer < MAX_SPEED) {
                speedometer += 10; // incremento por ejemplo
                if (speedometer > MAX_SPEED) {
                    speedometer = MAX_SPEED;
                }
            }
        }

    public void brake(){
        if (speedometer > 0) {
            speedometer -= 10; // frenada por ejemplo
            if (speedometer < 0) {
                speedometer = 0; // no puede ser negativo
            }
        }
    }

    public void turnAngleOfWheels(int angle){
        int nuevoAngulo = this.wheelsAngle + angle;
        if (nuevoAngulo > 45) {
            wheelsAngle = 45;
            System.out.println("Ángulo máximo alcanzado: 45 grados");
        } else if (nuevoAngulo < -45) {
            wheelsAngle = -45;
            System.out.println("Ángulo mínimo alcanzado: -45 grados");
        } else {
            wheelsAngle = nuevoAngulo;
            System.out.println("Ángulo actual del volante: " + wheelsAngle + " grados.");
        }
    }

    public String showSteeringWheelDetail(){
        if (wheelsAngle > 0) {
            return "Volante girado " + wheelsAngle + " grados a la derecha";
        } else if (wheelsAngle < 0) {
            return "Volante girado " + Math.abs(wheelsAngle) + " grados a la izquierda";
        } else { // wheelsAngle == 0
            return "Volante recto";
        }
    }

    public boolean isReverse(){

        return false;
    }

    public void setReverse(boolean reverse) {
        if (speedometer == 0) {
            this.reverse = reverse;
            if (reverse) {
                gear = "R"; // marcha atrás
                System.out.println("Marcha atrás activada");
            } else {
                gear = "N"; // marcha neutra
                System.out.println("Marcha atrás desactivada");
            }
        }

        if (speedometer > 0) {
            if (reverse) {
                System.out.println("No puedes poner marcha atrás mientras el coche está en movimiento");
            } else {
                System.out.println("No puedes quitar la marcha atrás mientras el coche está en movimiento");
            }
        }
    }

    public void showDetails(){
            System.out.println("Marca: " + brand);
            System.out.println("Modelo: " + model);
            System.out.println("Combustible: " + fuel);
            System.out.println("Velocidad: " + speedometer);
            System.out.println("Tacómetro: " + tachometer);
            System.out.println("Marcha: " + (reverse ? "Marcha atrás" : "Marcha normal"));
            System.out.println("Volante: " + showSteeringWheelDetail());
        }



    public boolean isTachometerGreaterThanZero() {

        return tachometer > 0;
    }

    public boolean isTachometerEqualToZero() {

        return tachometer == 0;
    }

    public static void main(String[] args) {
            //  Crear coche
            Car miCoche = new Car("Toyota", "Corolla", "Gasolina");

            // Estado inicial
            System.out.println("Estado inicial:");
            miCoche.showDetails();
            System.out.println();

            //  Arrancar coche
            System.out.println("Arrancando coche...");
            miCoche.start();
            miCoche.showDetails();
            System.out.println();

            //  Acelerar hasta velocidad máxima
            System.out.println("Acelerando hasta velocidad máxima...");
            while (miCoche.speedometer < Car.MAX_SPEED) {
                miCoche.accelerate();
            }
            System.out.println("Velocidad final tras acelerar: " + miCoche.speedometer);
            miCoche.showDetails();
            System.out.println();

            //  Girar volante
            System.out.println("Girando volante...");
            miCoche.turnAngleOfWheels(20);  // permitido
            miCoche.turnAngleOfWheels(30);  // excede límite → se ajusta a 45
            System.out.println(miCoche.showSteeringWheelDetail());
            System.out.println();

            //  Poner marcha atrás con coche detenido
            System.out.println("Poniendo marcha atrás con coche detenido...");
            miCoche.speedometer = 0;   // aseguramos que está parado
            miCoche.setReverse(true);
            miCoche.showDetails();
            System.out.println();

            //  Intentar poner marcha atrás con coche en movimiento
            System.out.println("Intentando poner marcha atrás con coche en movimiento...");
            miCoche.speedometer = 50;  // coche en movimiento
            miCoche.setReverse(true);  // no permite
            miCoche.setReverse(false); // no permite
            miCoche.showDetails();
            System.out.println();

            // Apagar coche
            System.out.println("Apagando coche...");
            miCoche.speedometer = 0;  // coche detenido
            miCoche.stop();
            miCoche.showDetails();
        }
    }
