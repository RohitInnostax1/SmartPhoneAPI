package com.springrest.springrest.dao;

import com.springrest.springrest.entities.SmartPhone;
import java.util.List;

public interface SmartPhoneDao {
    List<SmartPhone> getAllSmartPhones();   
    SmartPhone getSmartPhoneById(Long id);  
    SmartPhone saveSmartPhone(SmartPhone phone); 
    SmartPhone updateSmartPhone(SmartPhone phone); 
    void deleteSmartPhone(Long id);  
}
