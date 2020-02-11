package sv.edu.udb.utils;

public enum OpcionMenu {
    AGREGAR("Agregar material"),
    MODIFICAR("Modificar material"),
    LISTAR("Listar materiales disponibles"),
    BORRAR("Borrar material"),
    BUSCAR("Buscar material"),
    SALIR("Salir"),
    CERRAR("Cerrar");

    private final String descripcion;

    private OpcionMenu(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public OpcionMenu getOption(String desc) {
        if (desc.equals(AGREGAR.getDescripcion())) {
            return AGREGAR;
        } else {
            return BORRAR;
        }
    }

}
