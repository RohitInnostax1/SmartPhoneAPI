package com.springrest.springrest.services;

import com.springrest.springrest.dao.SmartPhoneDao;
import com.springrest.springrest.entities.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneServiceImp implements SmartPhoneService {

    @Autowired
    private SmartPhoneDao smartPhoneDao;

    @Override
    public List<SmartPhone> getAllSmartPhones() {
        return smartPhoneDao.getAllSmartPhones();
    }

    @Override
    public SmartPhone getSmartPhoneById(Long id) {
        return smartPhoneDao.getSmartPhoneById(id);
    }

    @Override
    public SmartPhone saveSmartPhone(SmartPhone phone) {
        return smartPhoneDao.saveSmartPhone(phone);
    }

    @Override
    public SmartPhone updateSmartPhone(SmartPhone phone) {
        return smartPhoneDao.updateSmartPhone(phone);  // `save()` updates if ID exists
    }

    @Override
    public void deleteSmartPhone(Long id) {
        smartPhoneDao.deleteSmartPhone(id);
    }
}
