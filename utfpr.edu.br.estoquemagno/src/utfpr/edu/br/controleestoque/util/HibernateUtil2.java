package utfpr.edu.br.controleestoque.util;

import static utfpr.edu.br.controleestoque.util.HibernateUtil2.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * @see Classe modelo. Fábrica de sessões. Métodos: getSession(),
 * getSessionFactory(), setSession().
 * @author Bruna Danieli Ribeiro Gonçalves, Márlon Ândrel Coelho Freitas
 */
public class HibernateUtil2 {

    //Declaração de variávies.
    private static Session session;
    private static SessionFactory sessionFactory;

    //Tenta configurar a fábrica de sessões.
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha na criação inicial da Fábrica de Sessões. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * @see Método que recebe uma sessão como parâmetro e define como a sessão
     * atual.
     * @param session
     */
    public static void setSession(Session session) {
        HibernateUtil2.session = session;
    }

    /**
     * @see Método que retorna a fábrica de sessões.
     * @return sessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @see Método que verifica se a sessão está aberta ou não, se não ele
     * inicializa ela como nulo e abre uma nova sessão atravéz da fábrica de
     * sessões(getSessionFactory().openSession()).
     * @return Session.
     */
    public static Session getSession() {
        if (session != null && !session.isOpen()) {
            setSession(null);
        }
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }
}
