/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.gbax.simplegroup.test.service;

import org.codehaus.jackson.map.ObjectMapper;
import ru.gbax.simplegroup.test.model.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Сервис для работы с данными человека
 * Created by GBAX on 04.07.2015.
 */
@Stateful
@LocalBean
public class PersonService {

    private Person person = null;

    /**
     * Инициализация данных
     */
    @PostConstruct
    public void init(){
        person = new Person();
        person.setFirstName("Иван");
        person.setSecondName("Иванов");
        person.setMiddleName("Иванович");
        try {
            final Date date = new SimpleDateFormat("dd.MM.yyyy").parse("11.11.1980");
            person.setBirthDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращяет данные по человеку
     * @return
     */
    public Person getPerson() {
        return person.copy();
    }

    /**
     * Возвращяет данные по человеку в виде JSON
     * @return
     */
    public String getPersonAsJSON() {
        ObjectMapper mapper = new ObjectMapper();
        String entity = "";
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            mapper.setDateFormat(df);
            entity = mapper.writeValueAsString(getPerson());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * Сохраняет данные по человеку
     * @param updatedPerson
     */
    public void setPerson(final Person updatedPerson) {
        person.setBirthDate(updatedPerson.getBirthDate());
        person.setFirstName(updatedPerson.getFirstName());
        person.setMiddleName(updatedPerson.getMiddleName());
        person.setSecondName(updatedPerson.getSecondName());
        System.out.println(String.format("Сохранено: %s", getPerson()));
    }
}
