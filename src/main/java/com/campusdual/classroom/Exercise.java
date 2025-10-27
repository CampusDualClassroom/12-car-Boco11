package com.campusdual.classroom;

public class Exercise {
    public static void main(String[] args) {
            // 1️⃣ Crear coche
            Car miCoche = new Car("Toyota", "Corolla", "Gasolina");

            // Estado inicial
            System.out.println("Estado inicial:");
            miCoche.showDetails();
            System.out.println();

            // 2️⃣ Arrancar coche
            System.out.println("Arrancando coche...");
            miCoche.start();
            miCoche.showDetails();
            System.out.println();

            // 3️⃣ Acelerar hasta velocidad máxima
            System.out.println("Acelerando hasta velocidad máxima...");
            while (miCoche.speedometer < Car.MAX_SPEED) {
                miCoche.accelerate();
            }
            System.out.println("Velocidad final tras acelerar: " + miCoche.speedometer);
            miCoche.showDetails();
            System.out.println();

            // 4️⃣ Girar volante
            System.out.println("Girando volante...");
            miCoche.turnAngleOfWheels(20);  // permitido
            miCoche.turnAngleOfWheels(30);  // excede límite → se ajusta a 45
            System.out.println(miCoche.showSteeringWheelDetail());
            System.out.println();

            // 5️⃣ Poner marcha atrás con coche detenido
            System.out.println("Poniendo marcha atrás con coche detenido...");
            miCoche.speedometer = 0;   // aseguramos que está parado
            miCoche.setReverse(true);
            miCoche.showDetails();
            System.out.println();

            // 6️⃣ Intentar poner marcha atrás con coche en movimiento
            System.out.println("Intentando poner marcha atrás con coche en movimiento...");
            miCoche.speedometer = 50;  // coche en movimiento
            miCoche.setReverse(true);  // no permite
            miCoche.setReverse(false); // no permite
            miCoche.showDetails();
            System.out.println();

            // 7️⃣ Apagar coche
            System.out.println("Apagando coche...");
            miCoche.speedometer = 0;  // coche detenido
            miCoche.stop();
            miCoche.showDetails();
        }

}