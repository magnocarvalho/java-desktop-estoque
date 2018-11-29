/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.controleestoque.conexao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import utfpr.edu.br.controleestoque.vo.Categoria;
import utfpr.edu.br.controleestoque.vo.Compra;
import utfpr.edu.br.controleestoque.vo.Fornecedor;
import utfpr.edu.br.controleestoque.vo.Funcionario;
import utfpr.edu.br.controleestoque.vo.Itemcompra;
import utfpr.edu.br.controleestoque.vo.Itemvenda;
import utfpr.edu.br.controleestoque.vo.Pagamento;
import utfpr.edu.br.controleestoque.vo.Produto;
import utfpr.edu.br.controleestoque.vo.Recebimento;
import utfpr.edu.br.controleestoque.vo.Venda;

/**
 *
 * @author magno carvalho
 */
public class HibernateUtil {
    private static AnnotationConfiguration cfg;
    private static SessionFactory sessionFactory;
    private static String pass = null;
    private static String user = null;

    public static Session openConnect() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver", "org.postgresql.Driver");
            cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/dbloja");
            cfg.setProperty("hibernate.connection.username", user);
            cfg.setProperty("hibernate.connection.password", pass);
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");
            cfg.addAnnotatedClass(Fornecedor.class);
            cfg.addAnnotatedClass(Compra.class);
            cfg.addAnnotatedClass(Itemcompra.class);
            cfg.addAnnotatedClass(Funcionario.class);
            cfg.addAnnotatedClass(Itemvenda.class);
            cfg.addAnnotatedClass(Pagamento.class);
            cfg.addAnnotatedClass(Venda.class);
            cfg.addAnnotatedClass(Produto.class);
            cfg.addAnnotatedClass(Recebimento.class);
            cfg.addAnnotatedClass(Categoria.class);
            
            
              
               
            sessionFactory = cfg.buildSessionFactory();
            
        }
        return sessionFactory.openSession();
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        HibernateUtil.pass = pass;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        HibernateUtil.user = user;
    }

    public static void criarSchema() {
        openConnect().close();
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(cfg);
        schemaEx.create(true, true);
    }
}
