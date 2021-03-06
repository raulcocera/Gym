package general;
import javax.swing.*;



public class Membresia extends Cliente{
    
    //variables o propiedades de mi obejeto
    
    private int id_tipo_membresia;
    private String fecha_inicio;
    private String fecha_fin;
    private int asistencias;
    private int dias_total;
    
    //contructor de la clase 
    public Membresia(){
    id_tipo_membresia=0;
    fecha_inicio ="";
    fecha_fin="";
    asistencias=0;
    dias_total=0;
    

    }
    
    
 /*---------------------------------------------------------------------------------------------------------------------------------------
        Metodos setter de membresia
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    public void setIdTipoMembresia(int id_tipo){
       this.id_tipo_membresia = id_tipo;
    }
 
    public void setFechaInicio(String fecha_inicio){
       this.fecha_inicio = fecha_inicio;
       
    }
    
    public void setFechaFin(String fecha_fin){
       this.fecha_fin = fecha_fin;
           
    }
    
    public void setAsistencias(int asistencias){
       this.asistencias = asistencias;
    }
    
    public void setDiasTotal(int dias_total){
        
       this.dias_total = dias_total;
    }
  
    
/*---------------------------------------------------------------------------------------------------------------------------------------
        Metodos getter de membresia
 ------------------------------------------------------------------------------------------------------------------------------------------*/
  public int getIdTipoMembresia(){
       return id_tipo_membresia;
    }
 
    public String getFechaInicio(){
       return fecha_inicio;
       
    }
    
    public String getFechaFin(){
       return fecha_fin;
           
    }
    
    public int getAsistencias(){
       return asistencias;
    }
    
    public int getDiasTotal(){
        
      return dias_total;
    }
    
    
    
    
    
    
/*---------------------------------------------------------------------------------------------------------------------------------------
        insertar membresia
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    public boolean setMembresia(int cedula){
            
        try{
               
            sql = "insert into membresia(cedula, id_tipo, date_ini, date_end, numero_asistencias ,dias_total)"
                    + "values(?,?,?,?,?,?)";

                    //vector para gurdar registros de la tabla

                      ps = conexion.prepareStatement(sql);
                        //mandamos los valores a ejecutar
                        ps.setInt(1,cedula);
                        ps.setInt(2, this.getIdTipoMembresia());
                        ps.setString(3, this.getFechaInicio());
                        ps.setString(4, this.getFechaFin());
                        ps.setInt(5, this.getAsistencias());
                        ps.setInt(6, this.getDiasTotal());
                                       

                        int n = ps.executeUpdate();
                        
                        if(n > 0){
                             return true;   
                        }else{
                             return false;
                        }

          }catch(Exception ex){
              
             JOptionPane.showMessageDialog(null, ex.getMessage());
             return false;
          }  
    
    }
    
    
    
    
    /*---------------------------------------------------------------------------------------------------------------------------------------
        cargar membresia su 
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    
    public String[] buscarMembresia(int id){    
    
            String[] registros = new String[3];

           try{  
              
               sql="select * from  tipo where id_tipo = "+id+"";
               ps =  conexion.prepareStatement(sql);
               rs = ps.executeQuery();
              
               
                       if(rs.next()){

                          registros[0]  = rs.getString(2);
                          registros[1]  = String.valueOf(rs.getFloat(3));
                          
                          JOptionPane.showMessageDialog(null,  "Membresia Encontrada");
                          return registros;
                       }                                  

           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex.getMessage()+ "hola");
           } 
           JOptionPane.showMessageDialog(null, "Membresia con el id "+id+" no existe");
           return registros; 
    
        }
    
    
    
    
/*---------------------------------------------------------------------------------------------------------------------------------------
        Metodo para eliminar
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    
    public void updaterMemebresia(int id,double costo){
        
       try{  
              
               sql="update tipo  set costo = "+costo+" where id_tipo = "+id+"";
               ps =  conexion.prepareStatement(sql);
               int a = ps.executeUpdate();
               if(a > 0){
                   
                   JOptionPane.showMessageDialog(null,"Precio Acualizado");               
               }else{
                       JOptionPane.showMessageDialog(null,"El precio no se pudo actualizar");               
               }
               
               
               
              
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex.getMessage()+ "hola");
           } 
        
    }
    
    
    
    
    
}
