package controlBD;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class DAOUniversalHibernate {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    public DAOUniversalHibernate() {
    }

    public FillTableModel retornaModelo(String nombreTabla, String consulta) {
        //Creo el modelo para cargarlo en el Grid
        FillTableModel tableModel = new FillTableModel(nombreTabla, select(consulta));
        return tableModel;
    }


    public List select(String HQL) {
        List listaObjetos;
        try {
            iniciaSF();
            listaObjetos = session.createQuery(HQL).list();
            return listaObjetos;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e, "Ha ocurrido un error", 0);
        } finally {
            cierraSF();
        }
        return null;
    }

    public int rowCount(String HQL) {
        int count = 0;
        try {
            iniciaSF();
            if (session.createQuery(HQL).uniqueResult() != null) {
                count = ((Long) session.createQuery(HQL).uniqueResult()).intValue();
            } else {
                count = 0;
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e, "Ha ocurrido un error", 0);
        } finally {
            cierraSF();
        }
        return count;
    }

    public double sumRows(String HQL) {
        double suma = 0;
        try {
            iniciaSF();
            if (session.createQuery(HQL).list().get(0) != null) {
                suma = ((Double) session.createQuery(HQL).uniqueResult());
            } else {
                suma = 0;
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e, "Ha ocurrido un error", 0);
        } finally {
            cierraSF();
        }
        return suma;
    }

    public boolean add(Object objeto) {
        try {
            iniciaSF();
            session.save(objeto);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: " + e, "Ha ocurrido un error", 0);
            return false;
        } finally {
            cierraSF();
        }
    }

    public void Update(Object objeto) {
        try {
            iniciaSF();
            session.update(objeto);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e, "Ha ocurrido un error", 0);
        } finally {
            cierraSF();
        }
    }

    public void delete(Object objeto) {
        try {
            iniciaSF();
            session.delete(objeto);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e, "Ha ocurrido un error", 0);
        } finally {
            cierraSF();
        }

    }

    public void iniciaSF() {
        try {
            session = null;
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e + "\n"
                    + "En el controlador de producto.", "Error al iniciar Session",
                    0);
        }

    }

    public void cierraSF() {
        try {
            transaction.commit();
            session.flush();
            session.close();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "error: " + e + "\n"
                    + "En el controlador de producto.", "Error al cerrar Session",
                    0);
        }
    }
}
