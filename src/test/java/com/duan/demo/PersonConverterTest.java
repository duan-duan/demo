package com.duan.demo;

import com.duan.demo.mapstruct.Person;
import com.duan.demo.mapstruct.PersonConverter;
import com.duan.demo.mapstruct.PersonDTO;
import com.duan.demo.mapstruct.User;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Description: This is Description
 * @author: wangruirui
 * @date: 2019/08/16
 */
public class PersonConverterTest extends DemoApplicationTests{

    @Autowired
    private PersonConverter personConverter;
    @Test
    public void test() {
        Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1));
        PersonDTO personDTO = personConverter.domain2dto(person);
        assertNotNull(personDTO);
        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirth(), person.getBirthday());
        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
        assertEquals(personDTO.getBirthDateFormat(),format);
        assertEquals(personDTO.getBirthExpressionFormat(),format);

        List<Person> people = new ArrayList<>();
        people.add(person);
        List<PersonDTO> personDTOs = personConverter.domain2dto(people);
        assertNotNull(personDTOs);
    }

}
