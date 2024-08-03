package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.datos;

public class datosServicios {
    private final String tabla = "estudiantes";
   public void guardar(Connection conexion, datos datos) throws SQLException{
      try{
         PreparedStatement consulta;
         if(datos.getId() == null){
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, estatus, municipio, estado, documentos) VALUES(?, ?, ?, ?, ?)");
            consulta.setString(1, datos.getNombre());
            consulta.setString(2, datos.getEstatus());
            consulta.setString(3, datos.getMunicipio());
            consulta.setString(4, datos.getEstado());
            consulta.setString(5, datos.getDocumentos());
         }else{
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, estatus = ?, municipio = ?, estado = ?, documentos = ? WHERE id = ?");
            consulta.setString(1, datos.getNombre());
            consulta.setString(2, datos.getEstado());
            consulta.setString(3, datos.getMunicipio());
            consulta.setString(4, datos.getEstado());
            consulta.setString(5, datos.getDocumentos());
            consulta.setInt(6, datos.getId());
         }
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public datos recuperarPorId(Connection conexion, int id) throws SQLException {
      datos datos = null;
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT nombre, estatus, municipio, estado, documentos FROM " + this.tabla + " WHERE id = ?" );
         consulta.setInt(1, id);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            datos = new datos(resultado.getInt(id), resultado.getString("nombre"), resultado.getString("estatus"),
            resultado.getString("municipio"), resultado.getString("estado"), resultado.getString("documentos"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return datos;
   }
   public void eliminar(Connection conexion, datos datos) throws SQLException{
      try{
         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id = ?");
         consulta.setInt(1, datos.getId());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public List<datos> list_recuperar(Connection conexion) throws SQLException{
      List<datos> list_datos = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT id, nombre, estatus, municipio, estado, documentos FROM " + this.tabla + " ORDER BY estado");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            list_datos.add(new datos(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("estatus"), resultado.getString("municipio"),
            resultado.getString("estado"), resultado.getString("documentos")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return list_datos;
   }
}
