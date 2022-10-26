package dato;

public class Dato {
private String cedula;
private String nombre;
private String contrasenia;
private String tipoFuncionario;
private String Estado;

public String getCedula() {
return cedula;
}
public void setCedula(String cedula) {
this.cedula = cedula;
}
public String getNombre() {
return nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public String getContrasenia() {
return contrasenia;
}
public void setContrasenia(String contrasenia) {
this.contrasenia = contrasenia;
}
public String getTipoFuncionario() {
return tipoFuncionario;
}
public void setTipoFuncionario(String tipoFuncionario) {
this.tipoFuncionario = tipoFuncionario;
}
public String   getEstado() {
return Estado;
}
public void setEstado(String Estado) {
this.Estado = Estado;
}
public Dato() {
super();
}
}