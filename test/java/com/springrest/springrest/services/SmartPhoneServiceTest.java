package com.springrest.springrest.services;

import com.springrest.springrest.SpringrestApplication;
import com.springrest.springrest.dao.SmartPhoneDao;
import com.springrest.springrest.entities.SmartPhone;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SmartPhoneServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(SpringrestApplication.class);

//   @Mock
//    SmartPhoneDao smartPhoneDao;

    SmartPhoneDao smartPhoneDao=Mockito.mock(SmartPhoneDao.class);

    @InjectMocks
    SmartPhoneServiceImp phoneService;

//    @InjectMocks
//    SmartPhoneDao smartPhoneDao;


@BeforeAll
public static void init() {
    logger.info("Starting SmartPhoneServiceTest");
}

@BeforeEach
public void initBeforeEachTest() {
    logger.info("Before Each Test Case");
}

    @Test
    void myFirstTest(){
        logger.info("myFirstTest");
    }

    @AfterAll
    public static void Destroy() {
    logger.info("After All Test Cases");
    }

    @AfterEach
    public void cleanUp() {
    logger.info("cleanUp operation after Each Test Case");
    }

    @Test
    void deleteSmartPhone() {
    logger.info("deleteSmartPhone");
    smartPhoneDao.deleteSmartPhone(1L);
    Mockito.verify(smartPhoneDao,Mockito.times(1)).deleteSmartPhone(1L);
    }

    @Test
    void saveSmartPhoneTest() {
        logger.info("saveSmartPhone");
        SmartPhone phone = new SmartPhone();
//        phone.setId();
        phone.setId(1L);

        phone.setName("October");
        phone.setIphone(8000L);
        phone.setSamsung(5000L);

        Mockito.when(smartPhoneDao.saveSmartPhone(phone)).thenReturn(phone);  // this function will mock and give us product which is we are giving here. and this is how we can Mock DB calls

        SmartPhone addedPhone = phoneService.saveSmartPhone(phone);
        //test phone=matched phone

        //assertion means .we need to test something like that
        //Assertions.assertEquals(phone, addedPhone);
        assertNotNull(addedPhone);
        assertEquals(phone.getName(), addedPhone.getName());
        assertEquals(phone, addedPhone);
//        assertTrue(phone.getId() == addedPhone.getId());
//        assertEquals(phone.getIphone(), 7000L);
//        assertTrue(phone.getId() == 2L);
//        assertTrue(phone.getName().equals("February"));

    }
}