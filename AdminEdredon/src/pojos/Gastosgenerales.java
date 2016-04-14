package pojos;
// Generated 14/04/2016 03:19:14 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Gastosgenerales generated by hbm2java
 */
@Entity
@Table(name="gastosgenerales"
    ,catalog="adminedredon"
)
public class Gastosgenerales  implements java.io.Serializable {


     private Integer idGastosGenerales;
     private Integer idTienda;
     private Date fecha;
     private String tienda;
     private String concepto;
     private String subconcepto;
     private String comentario;
     private Double importe;

    public Gastosgenerales() {
    }

    public Gastosgenerales(Integer idTienda, Date fecha, String tienda, String concepto, String subconcepto, String comentario, Double importe) {
       this.idTienda = idTienda;
       this.fecha = fecha;
       this.tienda = tienda;
       this.concepto = concepto;
       this.subconcepto = subconcepto;
       this.comentario = comentario;
       this.importe = importe;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idGastosGenerales", unique=true, nullable=false)
    public Integer getIdGastosGenerales() {
        return this.idGastosGenerales;
    }
    
    public void setIdGastosGenerales(Integer idGastosGenerales) {
        this.idGastosGenerales = idGastosGenerales;
    }

    
    @Column(name="idTienda")
    public Integer getIdTienda() {
        return this.idTienda;
    }
    
    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="tienda", length=45)
    public String getTienda() {
        return this.tienda;
    }
    
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    
    @Column(name="concepto", length=45)
    public String getConcepto() {
        return this.concepto;
    }
    
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    
    @Column(name="subconcepto", length=45)
    public String getSubconcepto() {
        return this.subconcepto;
    }
    
    public void setSubconcepto(String subconcepto) {
        this.subconcepto = subconcepto;
    }

    
    @Column(name="comentario", length=100)
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    @Column(name="importe", precision=22, scale=0)
    public Double getImporte() {
        return this.importe;
    }
    
    public void setImporte(Double importe) {
        this.importe = importe;
    }




}

