package com.springrest.springrest.dao;

import com.springrest.springrest.entities.SmartPhone;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class SmartPhoneDaoImp implements SmartPhoneDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SmartPhone> getAllSmartPhones() {
        return entityManager.createQuery("SELECT c FROM SmartPhone c", SmartPhone.class).getResultList();
    }

    @Override
    public SmartPhone getSmartPhoneById(Long id) {
        return entityManager.find(SmartPhone.class, id);
    }

    @Override
    public SmartPhone saveSmartPhone(SmartPhone phone) {
        entityManager.persist(phone);
        return phone;
    }

    @Override
    public SmartPhone updateSmartPhone(SmartPhone phone) {
        return entityManager.merge(phone);
    }

    @Override
    public void deleteSmartPhone(Long id) {
        SmartPhone phone = entityManager.find(SmartPhone.class, id);
        if (phone != null) {
            entityManager.remove(phone);
        }
    }
}
