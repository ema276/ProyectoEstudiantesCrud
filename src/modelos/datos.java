package modelos;

public class datos {

    private final Integer id;
    private String nombre;
    private String estatus;
    private String municipio;
    private String estado;
    private String documentos;

    public datos(Integer id, String nombre, String estatus, String municipio, String estado, String documentos) {
        this.id = id;
        this.nombre = nombre;
        this.estatus = estatus;
        this.municipio = municipio;
        this.estado = estado;
        this.documentos = documentos;
    }

    public datos() {
        this.id = null;
        this.nombre = null;
        this.estatus = null;
        this.municipio = null;
        this.estado = null;
        this.documentos = null;
        
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "datos{" + "id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", municipio=" + municipio + ", estado=" + estado + ", documentos=" + documentos + '}';
    }
}
    
    
