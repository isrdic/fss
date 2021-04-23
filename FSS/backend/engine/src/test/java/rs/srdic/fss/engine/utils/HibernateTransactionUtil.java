package rs.srdic.fss.engine.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Component
public class HibernateTransactionUtil {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public <T> T doInTransaction(TransactionCallable<T> callable) {
        return transactionTemplate.execute(status -> {
            try {
                return callable.execute(entityManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public void doInTransaction(TransactionVoidCallable callable) {
        transactionTemplate.execute(status -> {
            try {
                callable.execute(entityManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @FunctionalInterface
    public interface TransactionCallable<T> extends EntityManagerCallable<T> {
    }

    @FunctionalInterface
    public interface EntityManagerCallable<T> {
        @SuppressWarnings("RedundantThrows")
        T execute(EntityManager entityManager) throws Exception;
    }

    @FunctionalInterface
    public interface TransactionVoidCallable extends EntityManagerVoidCallable {
    }

    @SuppressWarnings("RedundantThrows")
    @FunctionalInterface
    public interface EntityManagerVoidCallable {
        void execute(EntityManager entityManager) throws Exception;
    }

}
