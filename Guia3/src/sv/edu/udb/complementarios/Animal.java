/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

/**
 *
 * @author rickc
 */
public class Animal {

    private String nombre;
    private int edad;
    private String alimento;

    public Animal() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public static void main(String[] args) {
        Gallo gallito = new Gallo("Gallo A", 5, "Concentrado 1000mm", "Moradas");
        Gallo gallito2 = new Gallo("Gallo B", 1, "Comida Vitaminada", "Amarillas");

        Perro perrito = new Perro("Perro X", 5, "Pedigree Adulto", "Cafe");
        Perro perrito2 = new Perro("Perro Y", 1, "Rambocan", "Blanco");

        Gato gatito = new Gato("Gato 1", 5, "Whiskas Adulto", "Azules");
        Gato gatito2 = new Gato("Gato 2", 1, "Whiskas lata cachorro", "Verdes");

        Hamster hamster = new Hamster("Hamster 1", 5, "Semillas de Girasol", 10);
        Hamster hamster2 = new Hamster("Hamster 2", 1, "Alpiste", 5);

        // Imprimiento todos los objetos
        System.out.println(gallito.toString());
        System.out.println(gallito2.toString());
        System.out.println(perrito.toString());
        System.out.println(perrito2.toString());
        System.out.println(gatito.toString());
        System.out.println(gatito2.toString());
        System.out.println(hamster.toString());
        System.out.println(hamster2.toString());
    }

}

class Gallo extends Animal {

    private String colorPlumas;

    public Gallo(String nombre, int edad, String alimento, String colorPlumas) {
        System.out.println("Nuevo instancia de tipo " + Gallo.class + "  siendo creada...");
        super.setNombre(nombre);
        super.setEdad(edad);
        super.setAlimento(alimento);
        this.colorPlumas = colorPlumas;
    }

    public String getColorPlumas() {
        return colorPlumas;
    }

    public void setColorPlumas(String colorPlumas) {
        this.colorPlumas = colorPlumas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gallo {");
        sb.append("\n\t\tnombre = ").append(super.getNombre());
        sb.append("\n\t\tedad = ").append(super.getEdad());
        sb.append("\n\t\talimento = ").append(super.getAlimento());

        sb.append("\n\t\tcolor plumas = ").append(this.getColorPlumas());
        sb.append("\n\t}");
        return sb.toString();
    }

}

class Perro extends Animal {

    private String colorPelaje;

    public Perro(String nombre, int edad, String alimento, String colorPelaje) {
        System.out.println("Nuevo instancia de tipo " + Perro.class + "  siendo creada...");
        super.setNombre(nombre);
        super.setEdad(edad);
        super.setAlimento(alimento);
        this.colorPelaje = colorPelaje;
    }

    public String getColorPelaje() {
        return colorPelaje;
    }

    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Perro {");
        sb.append("\n\t\tnombre = ").append(super.getNombre());
        sb.append("\n\t\tedad = ").append(super.getEdad());
        sb.append("\n\t\talimento = ").append(super.getAlimento());

        sb.append("\n\t\tcolor pelaje = ").append(this.getColorPelaje());
        sb.append("\n\t}");
        return sb.toString();
    }

}

class Gato extends Animal {

    private String colorOjos;

    public Gato(String nombre, int edad, String alimento, String colorOjos) {
        System.out.println("Nuevo instancia de tipo " + Gato.class + " siendo creada...");
        super.setNombre(nombre);
        super.setEdad(edad);
        super.setAlimento(alimento);
        this.colorOjos = colorOjos;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gato {");
        sb.append("\n\t\tnombre = ").append(super.getNombre());
        sb.append("\n\t\tedad = ").append(super.getEdad());
        sb.append("\n\t\talimento = ").append(super.getAlimento());

        sb.append("\n\t\tcolor ojos = ").append(this.getColorOjos());
        sb.append("\n\t}");
        return sb.toString();
    }

}

class Hamster extends Animal {

    private int cantidadPulgas;

    public Hamster(String nombre, int edad, String alimento, int cantidadPulgas) {
        System.out.println("Nuevo instancia de tipo " + Hamster.class + "  siendo creada...");
        super.setNombre(nombre);
        super.setEdad(edad);
        super.setAlimento(alimento);
        this.cantidadPulgas = cantidadPulgas;
    }

    public int getCantidadPulgas() {
        return cantidadPulgas;
    }

    public void setCantidadPulgas(int cantidadPulgas) {
        this.cantidadPulgas = cantidadPulgas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hamster {");
        sb.append("\n\t\tnombre = ").append(super.getNombre());
        sb.append("\n\t\tedad = ").append(super.getEdad());
        sb.append("\n\t\talimento = ").append(super.getAlimento());

        sb.append("\n\t\tcantidad pulgas = ").append(this.getCantidadPulgas());
        sb.append("\n\t}");
        return sb.toString();
    }

}
